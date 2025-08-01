
 package qucoon.mod.SpringServerless.config;
 
 import org.springframework.context.annotation.Configuration;
 import org.springframework.web.servlet.config.annotation.CorsRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
 @Configuration
 public class WebConfig implements WebMvcConfigurer {
 
   @Override
   public void addCorsMappings(CorsRegistry registry) {
     registry.addMapping("/**")
         .allowedMethods("*")
         .allowedHeaders("*")
         .allowedOrigins("*")
         //.allowCredentials(true)
         .exposedHeaders("Access-Control-Allow-Origin");
   }
 }
