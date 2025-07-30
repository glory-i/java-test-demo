
 package qucoon.mod.SpringServerless.repository.annotation;
 
 
 import java.lang.annotation.ElementType;
 import java.lang.annotation.Retention;
 import java.lang.annotation.RetentionPolicy;
 import java.lang.annotation.Target;
 
 @Retention(RetentionPolicy.RUNTIME)
 @Target({ElementType.FIELD, ElementType.METHOD})
 public @interface Column {
   String type() default "String";
   boolean primaryKey() default false;
   boolean foreignKey() default false;
   boolean uniqueKey() default false;
   boolean autoIncrement() default false;
   int startValue() default 1;
   int step() default 1;
   String defaultValue() default "";
   String reference() default "";
   String valueList() default "";
   boolean nullable() default false;
   int length() default 100;
   int decimalLimit() default 1;
 }
