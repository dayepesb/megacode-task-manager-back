package co.com.megacode.config.handler;

import co.com.megacode.DTO.ApiError;
import co.com.megacode.exception.MegacodeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,(long)HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());

            return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter( MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,(long)HttpStatus.BAD_REQUEST.value(), error);

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, (long)HttpStatus.BAD_REQUEST.value(),"Error exception");

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value = MegacodeException.class)
    public ResponseEntity<Object> defaultErrorMegacodeHandler(HttpServletRequest httpServletRequest, MegacodeException e) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT,e.getErrorCode(), e.getMessage());

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> defaultConstraintViolationHandler(HttpServletRequest httpServletRequest, ConstraintViolationException e) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT,(long)HttpStatus.CONFLICT.value(), e.getMessage());

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> defaultDataIntegrityViolationHandler(HttpServletRequest httpServletRequest, DataIntegrityViolationException e) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT,(long)HttpStatus.CONFLICT.value(), "Ha ocurrido un problema interno");

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultErrorHandler(HttpServletRequest httpServletRequest, Exception e) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT,(long)HttpStatus.CONFLICT.value(), e.getMessage());

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
