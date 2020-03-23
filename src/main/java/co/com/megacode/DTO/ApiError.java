package co.com.megacode.DTO;

import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private Long code;
    private String message;

    public ApiError (HttpStatus status,Long code, String message) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}