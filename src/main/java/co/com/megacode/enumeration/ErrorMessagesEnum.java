package co.com.megacode.enumeration;

import static co.com.megacode.constant.Constant.*;

public enum ErrorMessagesEnum {

    INTERNAL_ERROR(-1L,"an error has ocurred in the application"),
    CRYPTING_ERROR(-2L,"A problem has occurred encrypting the data"),
    INVALID_TYPE_IMAGE(-3L,"The image type is invalid"),
    INVALID_TYPE_NAME(-4L,"The image name is invalid"),
    ERROR_NAME_EMPTY(-5L,LABEL_ERROR_NAME_EMPTY),
    ERROR_LASTNAME_EMPTY(-6L,LABEL_ERROR_LASTNAME_EMPTY),
    ERROR_USERNAME_EMPTY(-7L,LABEL_ERROR_USERNAME_EMPTY),
    ERROR_EMAIL_EMPTY(-8L,LABEL_ERROR_EMAIL_EMPTY),
    ERROR_EMAIL_INVALID_FORMAT(-9L,LABEL_ERROR_EMAIL_INVALID_FORMAT),
    ERROR_PASSWORD_EMPTY(-10L,LABEL_ERROR_PASSWORD_EMPTY),
    ERROR_PASSWORD_INVALID(-11L,LABEL_ERROR_PASSWORD_INVALID),
    ERROR_USERNAME_EXIST(-12L,LABEL_ERROR_USERNAME_EXIST),
    ERROR_EMAIL_REGISTER(-13L,LABEL_ERROR_EMAIL_REGISTER),
    ERROR_DECRYPT_AES(-14L,LABEL_ERROR_DECRYPT_AES),
    ERROR_BAD_CREDENTIALS(-15L,LABEL_ERROR_BAD_CREDENTIALS);

    private Long codeError;
    private String message;

    ErrorMessagesEnum(java.lang.Long codeError, String message) {
        this.codeError = codeError;
        this.message = message;
    }

    public java.lang.Long getCodeError() {
        return codeError;
    }

    public void setCodeError(java.lang.Long codeError) {
        this.codeError = codeError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
