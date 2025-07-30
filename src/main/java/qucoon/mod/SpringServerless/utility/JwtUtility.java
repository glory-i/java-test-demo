package qucoon.mod.SpringServerless.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import org.json.JSONArray;
import org.json.JSONObject;
import qucoon.mod.SpringServerless.model.response.LoginResponse;
import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import qucoon.mod.SpringServerless.utility.model.request.ModulePrivilege;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class JwtUtility {
    private static final String DEFAULT_KEY =
            "Wsxz5jbL3BHV6BVaJhbVbzNsVCf4rCkp58UmHLAUDYbE9bUF8eVP5QJphFzdPATXwe2VJPabTznMYaEe8ZP6bqnx23JXgfq3UhZrS5wnz6qymktAg2w";

    private String key;

    private static final int expirationInHours = 1;

    public void setKey(String key) {
        this.key = key;
    }



    public static void main(String[] args) {
        // 1. Initialize JWT utility
        JwtUtility jwtUtil = new JwtUtility();
 String token ="Bearer eyJhbGciOiJIUzUxMiJ9.eyJ0ZWFjaGVyVXBkYXRlZEF0IjoiMjAyNS0wNS0yMiAxNTo1ODo1NS4yNiIsInRlYWNoZXJFbWFpbCI6InRvcGUub2xha3VubGVAcXVjb29uLmNvbSIsInByaXZpbGVnZXMiOlsiQ1JFQVRFfFRFQUNIRVIiLCJDUkVBVEV8U1RVREVOVCIsIkNSRUFURXxDTEFTUyIsIkNSRUFURXxVU0VSX09UUCIsIkNSRUFURXxMT0dJTl9ISVNUT1JZIiwiQ1JFQVRFfFBSSVZJTEVHRSIsIkNSRUFURXxST0xFIiwiQ1JFQVRFfFJPTEVfUFJJVklMRUdFIiwiQ1JFQVRFfE1PRFVMRSIsIkNSRUFURXxBVURJVF9MT0ciLCJVUERBVEV8VEVBQ0hFUiIsIlVQREFURXxTVFVERU5UIiwiVVBEQVRFfENMQVNTIiwiVVBEQVRFfFVTRVJfT1RQIiwiVVBEQVRFfExPR0lOX0hJU1RPUlkiLCJVUERBVEV8UFJJVklMRUdFIiwiVVBEQVRFfFJPTEUiLCJVUERBVEV8Uk9MRV9QUklWSUxFR0UiLCJVUERBVEV8TU9EVUxFIiwiVVBEQVRFfEFVRElUX0xPRyIsIkRFTEVURXxURUFDSEVSIiwiREVMRVRFfFNUVURFTlQiLCJERUxFVEV8Q0xBU1MiLCJERUxFVEV8VVNFUl9PVFAiLCJERUxFVEV8TE9HSU5fSElTVE9SWSIsIkRFTEVURXxQUklWSUxFR0UiLCJERUxFVEV8Uk9MRSIsIkRFTEVURXxST0xFX1BSSVZJTEVHRSIsIkRFTEVURXxNT0RVTEUiLCJERUxFVEV8QVVESVRfTE9HIiwiUkVBRHxURUFDSEVSIiwiUkVBRHxTVFVERU5UIiwiUkVBRHxDTEFTUyIsIlJFQUR8VVNFUl9PVFAiLCJSRUFEfExPR0lOX0hJU1RPUlkiLCJSRUFEfFBSSVZJTEVHRSIsIlJFQUR8Uk9MRSIsIlJFQUR8Uk9MRV9QUklWSUxFR0UiLCJSRUFEfE1PRFVMRSIsIlJFQUR8QVVESVRfTE9HIiwiQ0hFQ0tFUnxURUFDSEVSIiwiQ0hFQ0tFUnxTVFVERU5UIiwiQ0hFQ0tFUnxDTEFTUyIsIkNIRUNLRVJ8VVNFUl9PVFAiLCJDSEVDS0VSfExPR0lOX0hJU1RPUlkiLCJDSEVDS0VSfFBSSVZJTEVHRSIsIkNIRUNLRVJ8Uk9MRSIsIkNIRUNLRVJ8Uk9MRV9QUklWSUxFR0UiLCJDSEVDS0VSfE1PRFVMRSIsIkNIRUNLRVJ8QVVESVRfTE9HIl0sInRlYWNoZXJJZCI6MTAwLjAsInRlYWNoZXJOYW1lIjoic3RyaW5nIiwidGVhY2hlclN0YXR1cyI6IkFDVElWRSIsInJlc3BvbnNlTWVzc2FnZSI6IkNvbXBsZXRlZCBzdWNjZXNzZnVsbHkiLCJ0ZWFjaGVyQ3JlYXRlZEF0IjoiMjAyNS0wNS0yMiAxNTo1ODoxNi43OCIsInJlc3BvbnNlQ29kZSI6IjAwIiwiaWF0IjoxNzQ3OTQwNDQ5LCJleHAiOjE3NDc5NDQwNDl9.8aUYcVb0_0Uk1QbKHHLrK8hRL9io9W-EyaFS7AJp7nVzayTjejFkeR2Txyj9Mc4_QZi77Ch0ne3vpexG3R1OHg";

        try {
            ModulePrivilege createTeacher = new ModulePrivilege("CREATE","TEACHER");
            jwtUtil.privilegeAuthorization(createTeacher, token, LoginResponse.class);

        } catch (Exception s) {
            s.printStackTrace();
        }

    }


    public String generateJwt(String username, JSONObject jwtUser, List<ModulePrivilege> privileges) {
        String joinedPrivileges = privileges.stream()
                .map(p -> p.getModule() + "|" + p.getPrivilege())
                .collect(Collectors.joining(","));

        jwtUser.put("privileges", List.of(joinedPrivileges.split(",")));

        Map<String, Object> claims = GSON.fromJson(jwtUser.toString(), Map.class);

        String token = Jwts.builder()
                .setSubject(username)
                //.addClaims(claims)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + new TimeUtil().hoursToMilliseconds(expirationInHours)))
                .signWith(Keys.hmacShaKeyFor((key != null ? key : DEFAULT_KEY).getBytes()))
                .compact();


        return "Bearer " + token;
    }

    public <T> T privilegeAuthorization(
            ModulePrivilege privilege,
            String token,
            Class<T> clazz
    ) {
        String required = (privilege.getModule() + "|" + privilege.getPrivilege()).toUpperCase().replaceAll("[^a-zA-Z0-9]", "");
        //System.out.println("required=="+required);
        JSONArray privilegesJson;
        String responseJson;


            // JWT-backed lookup
            JSONObject claims = extractObjectJson(token);
            Object raw = claims.opt("privileges");
            privilegesJson = new JSONArray(raw != null ? raw.toString() : "[]");
            responseJson = claims.toString();
        //System.out.println("responseJson=="+responseJson.toString());

        // Check for matching privilege
        for (int i = 0; i < privilegesJson.length(); i++) {
            String p = privilegesJson.getString(i).toUpperCase().replaceAll("[^a-zA-Z0-9]", "");;
            //System.out.println("ppp="+p);
            if (p.equals(required) || p.contains("*")) {
                //return GSON.fromJson(responseJson, clazz);
                return GSON.fromJson(responseJson, clazz);
            }
        }

        throw new CustomExceptions.AccessNotAllowedException("Insufficient Privilege");
    }

    private Claims extractAllClaims(String token) {
        if (token == null || token.isEmpty()) {
            throw new InvalidKeyException("Authorization is required for this endpoint");
        }
        if (!token.startsWith("Bearer ")) {
            throw new InvalidKeyException("JWT Token must begin with Bearer");
        }
        String secret = (key != null ? key : DEFAULT_KEY);
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token.substring(7))
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }





    public JSONObject extractObjectJson(String token) {
        Claims claims = extractAllClaims(token);
        return new JSONObject(claims);
    }
}
