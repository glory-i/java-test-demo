
 package qucoon.mod.SpringServerless.lambda;
 
 import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
 import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
 import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
 import com.amazonaws.services.lambda.runtime.Context;
 import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
 import qucoon.mod.SpringServerless.QucoonSpringServerlessApplication;
 
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 
 public class LambdaProxy implements RequestStreamHandler {
 
   @Override
   public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
     if (handler != null) {
       handler.proxyStream(inputStream, outputStream, context);
     }
   }
 
   private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
 
   static {
     try {
       handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(QucoonSpringServerlessApplication.class);
     } catch (Exception e) {
       // If initialization fails, force a cold start by rethrowing the exception
       e.printStackTrace();
       throw new RuntimeException("Could not initialize Spring framework", e);
     }
   }
 }
