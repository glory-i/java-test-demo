package qucoon.mod.SpringServerless.utility;

import org.apache.commons.codec.binary.Base64;
import org.mindrot.jbcrypt.BCrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;


public class CredentialUtils {
   private static final String HASH_KEY = "ZXlKeVpYTndiMjV6WldOdlpHVWlPaUl3TUNJc0luSmxjM0J2Ym5ObGJXVnpjMkZuWlNJNklsVnpaWElnWkc4Z1pYaHBjM1FpZlE=";

    /**
     * Hashes the input string with SHA-512 using a key, username, and input.
     *
     * @param input    the string to hash
     * @param username the username used in the hash
     * @return Base64-encoded SHA-512 hash, or null on error
     */
    public static String hash(String input, String username) {
        String algorithm = "SHA-512";
        String encoding = "UTF-16";
        String usernameNew = (username != null) ? username.toLowerCase(Locale.getDefault()) : "";
        String plaintext = HASH_KEY + usernameNew + input;
        try {
            MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(plaintext.getBytes(encoding));
            byte[] rawByte = msgDigest.digest();
            return new String(Base64.encodeBase64(rawByte));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The Encoding Is Not Supported");
        }
        return null;
    }

    /**
     * Validates if the encrypted text matches the new encrypted form.
     *
     * @param input     the input string
     * @param encrypted the encrypted string to compare against
     * @return true if they match, false otherwise
     */
    public static boolean validate(String input, String encrypted) {
        return encrypted != null && encrypted.equals(input);
    }

    /**
     * BCrypt-hashes the input string.
     *
     * @param input the string to hash
     * @return the BCrypt hash
     */
    public static String bcryptHash(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt());
    }

    /**
     * Validates a plaintext password against a BCrypt hash.
     *
     * @param plaintext      the plaintext password
     * @param hashedPassword the BCrypt hash
     * @return true if valid, false otherwise
     */
    public static boolean bcryptValidate(String plaintext, String hashedPassword) {
        return plaintext != null && hashedPassword != null && BCrypt.checkpw(plaintext, hashedPassword);
    }

    public static void main(String[] a){
        String pwd="123456mmmkjhswiysnbguhwhiwkb";
        String enc = bcryptHash(pwd);
        System.out.println("enc=="+enc);
        //enc==$2a$10$eUSxP2RkBJkOqtxbFjFPyupIL0ov4Qfc2FEuXAtAsBZU4Cy16rI3K
        //enc==$2a$10$9Rq5tycfh9IW4d72I41BnOIa30CwGn0XhqB6eCS77b3VlF5LZFjR6
        //enc==$2a$10$im/WXE10jPBbB68eCzxhR.RKFux19nhtbLAi6Md7.dvNTVz4ps2.G
        System.out.println(bcryptValidate(pwd,enc));
    }

    /**
     * Generates SHA-512 hash of the input string and encodes as Base64.
     *
     * @param input the string to hash
     * @return Base64-encoded SHA-512 hash, or null on error
     */
    public static String toSha512(String input) {
        String algorithm = "SHA-512";
        String encoding = "UTF-16";
        try {
            MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(input.getBytes(encoding));
            byte[] rawByte = msgDigest.digest();
            return new String(Base64.encodeBase64(rawByte));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The Encoding Is Not Supported");
        }
        return null;
    }
}
