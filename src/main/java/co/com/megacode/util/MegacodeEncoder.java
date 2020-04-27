package co.com.megacode.util;

import co.com.megacode.exception.MegacodeException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static co.com.megacode.util.Constant.*;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_DECRYPT_AES;

public class MegacodeEncoder {

    public static String generateSalt(){

        Random r = new Random();
        int strLengthPassword = r.nextInt(( MAX_NUMBER_STR_SECRET_KEY - MIN_NUMBER_STR_SECRET_KEY ) + 1) + MIN_NUMBER_STR_SECRET_KEY;

        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(strLengthPassword, useLetters, useNumbers);

        return generatedString;
    }

    public static String encodingPasswordUser(String password, String secretKey) {
        Pbkdf2PasswordEncoder enconder = new Pbkdf2PasswordEncoder(secretKey, ITER_NUMBER_EXCRYPT_PASSWORD,LENGTH_HASH_ENCODE_PASSSWORD);

        String passwordEncoder = enconder.encode(password);

        return passwordEncoder;
    }

    public static String hashMD5(String word) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(word.getBytes());

        byte[] digest = messageDigest.digest();

        String mdHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return mdHash;

    }

    public static String decryptAes(String word) throws MegacodeException {
        try {
            IvParameterSpec iv = new IvParameterSpec(PRIVATE_IV_AES.getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(PRIVATE_KEY_AES.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(word));

            return new String(original);
        } catch (Exception ex) {
            throw new MegacodeException(ERROR_DECRYPT_AES);
        }
    }
}
