
 package qucoon.mod.SpringServerless.config;
 
 import org.json.JSONObject;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
 import qucoon.mod.SpringServerless.utility.Environment;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;
 import java.util.Arrays;
 
 @Component
 public class CustomFilterConfig implements Filter {
 
     @Autowired
     private Environment environment;
 
 //    @Autowired
 //    private AuditLogService auditLogService;
 
     @Override
     public void init(FilterConfig filterConfig) throws ServletException {
         // Initialization code if needed
     }
 
     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
             throws IOException, ServletException {
         HttpServletRequest httpRequest = (HttpServletRequest) request;
         String uri = httpRequest.getRequestURI();
         // Exclude Swagger endpoints from filtering
         if (uri.contains("swagger") || uri.contains("v2/api-docs") || uri.contains("swagger-resources")) {
             chain.doFilter(request, response);
             return;
         }
 
         HttpServletRequest wrappedRequest = new BufferedRequestWrapper(httpRequest);
         String[] parts = uri.replaceFirst("^/", "").split("/");
         String stage = parts.length > 1 ? parts[1] : "";
         System.out.println(Arrays.toString(parts));
         System.out.println("stagex="+stage);
 
         // Execute first method
         executeFirstMethod(stage);
         environment.ipAddress = httpRequest.getRemoteAddr();
 
         // Wrap response to capture its output
         HttpServletResponseCopier responseCopier = new HttpServletResponseCopier((HttpServletResponse) response);
         try {
             BufferedRequestWrapper bufferedRequestWrapper = (BufferedRequestWrapper) wrappedRequest;
             InputStream capturedInputStream = bufferedRequestWrapper.getCapturedInputStream();
             StringBuilder sb = new StringBuilder();
             BufferedReader reader = new BufferedReader(new InputStreamReader(capturedInputStream));
             String line;
             while ((line = reader.readLine()) != null) {
                 sb.append(line);
             }
             String requestString = sb.toString();
             try {
                 environment.maker = new JSONObject(requestString).optString("maker");
             } catch (Exception s) {
                 // ignore
             }
         } catch (Exception e) {
             // Ignore exception
         }
 
         chain.doFilter(wrappedRequest, responseCopier);
         responseCopier.flushBuffer();
         executeLastMethod(wrappedRequest, response, responseCopier);
     }
 
     @Override
     public void destroy() {
         // Cleanup code if needed
     }
 
     private void executeFirstMethod(String stage) {
         if (!"swagger-ui".equals(stage) && !"swagger-resources".equals(stage) && !"v2".equals(stage)) {
             environment.initialize();
         }
     }
 
     private void executeLastMethod(ServletRequest request, ServletResponse response, HttpServletResponseCopier responseCopier) {
         byte[] copy = responseCopier.getCopy();
         String encoding = response.getCharacterEncoding() != null ? response.getCharacterEncoding() : "UTF-8";
         String responseString = "";
         try{
             responseString = new String(copy, encoding);
         } catch (Exception e) {
 
         }
 
 
         BufferedRequestWrapper bufferedRequestWrapper = (BufferedRequestWrapper) request;
         InputStream capturedInputStream = bufferedRequestWrapper.getCapturedInputStream();
         StringBuilder sb = new StringBuilder();
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(capturedInputStream))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 sb.append(line);
             }
         } catch (IOException e) {
             // Ignore
         }
         String requestString = sb.toString();
         if (environment.getDatabaseUtil() != null && environment.getDatabaseUtil().getSql2oConnection() != null) {
             environment.getDatabaseUtil().getSql2oConnection().close();
         }
     }
 
     // Wrapper to cache the request body.
     private static class BufferedRequestWrapper extends HttpServletRequestWrapper {
 
         private final byte[] buffer;
 
         public BufferedRequestWrapper(HttpServletRequest request) throws IOException {
             super(request);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             InputStream is = request.getInputStream();
             byte[] buf = new byte[1024];
             int bytesRead;
             while ((bytesRead = is.read(buf)) > 0) {
                 baos.write(buf, 0, bytesRead);
             }
             buffer = baos.toByteArray();
         }
 
         @Override
         public ServletInputStream getInputStream() throws IOException {
             return new BufferedServletInputStream(buffer);
         }
 
         public InputStream getCapturedInputStream() {
             return new ByteArrayInputStream(buffer);
         }
     }
 
     // Implementation of ServletInputStream wrapping a ByteArrayInputStream.
     private static class BufferedServletInputStream extends ServletInputStream {
 
         private final ByteArrayInputStream inputStream;
 
         public BufferedServletInputStream(byte[] buffer) {
             this.inputStream = new ByteArrayInputStream(buffer);
         }
 
         @Override
         public int read() throws IOException {
             return inputStream.read();
         }
 
         @Override
         public boolean isFinished() {
             return inputStream.available() == 0;
         }
 
         @Override
         public boolean isReady() {
             return true;
         }
 
         @Override
         public void setReadListener(ReadListener readListener) {
             // Not implemented.
         }
     }
 
     // Response wrapper that copies output to a byte array.
     private static class HttpServletResponseCopier extends HttpServletResponseWrapper {
 
         private final ByteArrayOutputStream copy = new ByteArrayOutputStream();
         private ServletOutputStream outputStream;
         private PrintWriter writer;
 
         public HttpServletResponseCopier(HttpServletResponse response) {
             super(response);
         }
 
         @Override
         public ServletOutputStream getOutputStream() throws IOException {
             if (writer != null) {
                 throw new IllegalStateException("getWriter() has already been called on this response.");
             }
             if (outputStream == null) {
                 outputStream = new ServletOutputStream() {
                     @Override
                     public void write(int b) throws IOException {
                         copy.write(b);
                         getResponse().getOutputStream().write(b);
                     }
                     @Override
                     public boolean isReady() {
                         return true;
                     }
                     @Override
                     public void setWriteListener(WriteListener writeListener) {
                         // Not implemented.
                     }
                 };
             }
             return outputStream;
         }
 
         @Override
         public PrintWriter getWriter() throws IOException {
             if (outputStream != null) {
                 throw new IllegalStateException("getOutputStream() has already been called on this response.");
             }
             if (writer == null) {
                 writer = new PrintWriter(new OutputStreamWriter(copy, getResponse().getCharacterEncoding()), true);
             }
             return writer;
         }
 
         public byte[] getCopy() {
             return copy.toByteArray();
         }
 
         @Override
         public void flushBuffer() throws IOException {
             if (writer != null) {
                 writer.flush();
             } else if (outputStream != null) {
                 outputStream.flush();
             }
         }
     }
 }
