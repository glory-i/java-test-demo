
 package qucoon.mod.SpringServerless.config;
 
 import javax.servlet.ServletOutputStream;
 import javax.servlet.WriteListener;
 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.OutputStream;
 
 public class ServletOutputStreamCopier extends ServletOutputStream {
   
   private final OutputStream outputStream;
   private final ByteArrayOutputStream copy;
 
   public ServletOutputStreamCopier(OutputStream outputStream) {
     this.outputStream = outputStream;
     this.copy = new ByteArrayOutputStream(1024);
   }
 
   @Override
   public void write(int b) throws IOException {
     outputStream.write(b);
     copy.write(b);
   }
 
   public byte[] getCopy() {
     return copy.toByteArray();
   }
 
   @Override
   public boolean isReady() {
     return true; // TODO: Implement proper readiness check if needed
   }
 
   @Override
   public void setWriteListener(WriteListener listener) {
     // TODO: Implement WriteListener handling if necessary
   }
 }
