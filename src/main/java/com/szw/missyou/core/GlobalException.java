package com.szw.missyou.core;

import com.sun.net.httpserver.HttpsServer;
import com.szw.missyou.core.configation.ExceptionCodeConfiguration;
import com.szw.missyou.exception.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 14:04
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {

    @Autowired
    private ExceptionCodeConfiguration codes;

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UnfiyResponse handleException(HttpServletRequest request, Exception e) {
        String method = request.getMethod();
        System.out.println(e);
        String requestURI = request.getRequestURI();
        UnfiyResponse unifyResponse = new UnfiyResponse(9999, "服务器异常", method + " " + requestURI);
        return unifyResponse;
    }

    ;

    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity handleHttpException(HttpServletRequest request, HttpException e) {
        String method = request.getMethod();

        String requestURI = request.getRequestURI();

        UnfiyResponse unifyResponse = new UnfiyResponse(e.getHttpStatusCode(), codes.getMessage(e.getCode()), method + " " + requestURI);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus resolve = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity responseEntity = new ResponseEntity<>(unifyResponse, httpHeaders, resolve);

        return responseEntity;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnfiyResponse handleValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        String method = request.getMethod();

        String requestURI = request.getRequestURI();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String messages = formatAllErrorMessages(allErrors);
        UnfiyResponse unfiyResponse = new UnfiyResponse(10001, messages, method + " " + requestURI);
        return unfiyResponse;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public UnfiyResponse handleViolationException(HttpServletRequest request, ConstraintViolationException e) {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        String messages = e.getMessage();
        UnfiyResponse unfiyResponse = new UnfiyResponse(10001, messages, method + " " + requestURI);
        return unfiyResponse;
    }


    private String formatAllErrorMessages(List<ObjectError> errors) {
        StringBuffer r = new StringBuffer();
        errors.forEach(err ->
                r.append(err.getDefaultMessage()).append(";"));
        return r.toString();
    }

}
