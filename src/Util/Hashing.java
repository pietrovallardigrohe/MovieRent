package Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hashing {

    public static String hash(char[] word) {

        StringBuilder sb = new StringBuilder();
        for(char c : word) {
            sb.append(c);
        }
        String password = sb.toString();


        if(password.trim() != "") {

            try {

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] result = md.digest(password.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(result);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }


        }

        return null;

    }

    public static String hash(String word) {

        if(word.trim() != "") {

            try {

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] result = md.digest(word.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(result);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

}
