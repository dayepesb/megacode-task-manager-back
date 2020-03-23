package co.com.megacode.exception;

import co.com.megacode.enumeration.ErrorMessagesEnum;

public class MegacodeException extends Exception {

    private static final long serialVersionUID = 1L;

    private Long errorCode;

    public MegacodeException() {
        super("Error General");
    }

    public MegacodeException(ErrorMessagesEnum errorMessagesEnum) {
        super(errorMessagesEnum.getMessage());
        this.errorCode = errorMessagesEnum.getCodeError();
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }
}