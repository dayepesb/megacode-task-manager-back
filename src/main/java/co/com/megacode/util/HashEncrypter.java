package co.com.megacode.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashEncrypter {

    public static String hashMD5(String word) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(word.getBytes());

        byte[] digest = messageDigest.digest();

        String mdHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return mdHash;

    }
}
