package co.com.megacode.enumeration;

public enum ErrorMessagesEnum {

    INTERNAL_ERROR(-1L,"an error has ocurred in the application"),
    CRYPTING_ERROR(-2L,"A problem has occurred encrypting the data"),
    INVALID_TYPE_IMAGE(-3L,"The image type is invalid"),
    INVALID_TYPE_NAME(-4L,"The image name is invalid");

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
