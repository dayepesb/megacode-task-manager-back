package co.com.megacode.constant;

import java.util.regex.Pattern;

public class Constant {

    public static Integer MIN_NUMBER_STR_SECRET_KEY = 128;
    public static Integer MAX_NUMBER_STR_SECRET_KEY = 256;
    public static Integer ITER_NUMBER_EXCRYPT_PASSWORD = 10000;
    public static Integer LENGTH_HASH_ENCODE_PASSSWORD = 256;
    public static String PRIVATE_KEY_AES = "aesEncryptionKey";
    public static String PRIVATE_IV_AES = "encryptionIntVec";


    public static String REGULAR_EXPRESSION_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static Integer MINUMUN_CHARACTERS_PASSWORD = 8;
    public static final Pattern [] REGEX_PATTERNS = new Pattern[]{
            Pattern.compile(".*[A-Z].*"),
            Pattern.compile(".*[a-z].*"),
            Pattern.compile(".*[0-9].*")
    };

    public static String LABEL_ERROR_NAME_EMPTY = "megacode.form.name.empty";
    public static String LABEL_ERROR_LASTNAME_EMPTY = "megacode.form.lastname.empty";
    public static String LABEL_ERROR_USERNAME_EMPTY = "megacode.form.username.empty";
    public static String LABEL_ERROR_EMAIL_EMPTY = "megacode.form.email.empty";
    public static String LABEL_ERROR_EMAIL_INVALID_FORMAT = "megacode.form.email.invalid";
    public static String LABEL_ERROR_PASSWORD_EMPTY = "megacode.form.password.empty";
    public static String LABEL_ERROR_PASSWORD_INVALID = "megacode.form.password.invalid";
    public static String LABEL_ERROR_USERNAME_EXIST = "megacode.form.username.exist";
    public static String LABEL_ERROR_EMAIL_REGISTER = "megacode.form.email.exist";
    public static String LABEL_ERROR_DECRYPT_AES = "megacode.decrypt.error.aes";
    public static String LABEL_ERROR_BAD_CREDENTIALS = "megacode.user.bad.credentials";
    public static String LABEL_TOKEN_EXPIRED = "megacode.user.token.expired";
    public static String LABEL_TOKEN_CONVERSION = "megacode.user.token.error.conversion";
    public static String LABEL_USER_INACTIVATE = "megacode.user.inactivate";
    public static String LABEL_EMAIL_NO_REGISTER = "megacode.enail.noregister";
    public static String LABEL_USER_VERIFY = "megacode.user.verify";
}
