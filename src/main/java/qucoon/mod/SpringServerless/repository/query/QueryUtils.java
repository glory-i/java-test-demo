
 package qucoon.mod.SpringServerless.repository.query;
 
 import org.sql2o.Connection;
 import org.sql2o.Query;
 
 
 public class QueryUtils {
 
   public static Query createQueryWithoutOnMappingFailure(Connection connection, String queryText) {
     return createQueryWithoutOnMappingFailure(connection, queryText, true);
   }
 
   public static Query createQueryWithoutOnMappingFailure(Connection connection, String queryText, boolean returnGeneratedKeys) {
     try {
       return connection.createQuery(queryText, returnGeneratedKeys)
           .throwOnMappingFailure(false);
     } catch (Exception e) {
       System.out.println("e.printStackTrace() :: 0001");
       e.printStackTrace();
      // throw new SuspectedMalfunction(e.getMessage());
     }
     return null;
   }
 }
