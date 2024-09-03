package com.example.catalogoapi.Domain.Common;

import com.example.catalogoapi.Domain.Static.ReplyMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ApiResult<T> {
    @JsonInclude
    private T data;

    @JsonInclude
    private ResponseMetadata metadata;

    @JsonInclude
    private List<String> errors;

    private UserLoginErrors loginErrors;

    public void setData(T data) {
        this.data = data;
    }

    protected ApiResult(T data) {

        this.data = data;
    }

    protected ApiResult(HttpStatus statusCode) {
        this.metadata = new ResponseMetadata(statusCode);
    }

    protected ApiResult(HttpStatus statusCode, T data) {
        this.data = data;
        this.metadata = new ResponseMetadata(statusCode);
    }

    protected ApiResult(HttpStatus statusCode, String message, T data) {
        this.metadata = new ResponseMetadata(message, statusCode);
        this.data = data;
    }

    protected ApiResult(HttpStatus statusCode, String message) {
        this.metadata = new ResponseMetadata(message, statusCode);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(HttpStatus.OK, ReplyMessage.Success.QUERY, data);
    }

    public static <T> ApiResult<T> notFound() {
        return new ApiResult<>(HttpStatus.NOT_FOUND, ReplyMessage.Error.NOT_FOUND);
    }

    public static <T> ApiResult<T> created(T data) {
        return new ApiResult<>(data);
    }

    public static <T> ApiResult<T> created() {
        return new ApiResult<>(HttpStatus.CREATED);
    }

    public static <T> ApiResult<T> error(String errorMessage) {
        ApiResult<T> result = new ApiResult<>(HttpStatus.BAD_REQUEST);
        result.errors = new ArrayList<>();
        result.errors.add(errorMessage);
        return result;
    }

    public static <T> ApiResult<T> noContent() {
        return new ApiResult<>(HttpStatus.NO_CONTENT);
    }

    public static <T> ApiResult<T> validate(UserLoginErrors errorMessage) {
        ApiResult<T> result = new ApiResult<>(HttpStatus.UNAUTHORIZED);
        result.loginErrors = errorMessage;
        return result;
    }

    public static <T> ApiResult<T> login(T data) {
        return new ApiResult<>(data);
    }

    public T getData() {
        return data;
    }

    public ResponseMetadata getMetadata() {
        return metadata;
    }

    public List<String> getErrors() {
        return errors;
    }

    public UserLoginErrors getLoginErrors() {
        return loginErrors;
    }
}

class ResponseMetadata {
    private HttpStatus statusCode;
    private String message;

    public ResponseMetadata(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ResponseMetadata(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseMetadata() {
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}

class UserLoginErrors {
    private List<String> emailErrors;
    private List<String> passwordErrors;

    public UserLoginErrors() {
        this.emailErrors = new ArrayList<>();
        this.passwordErrors = new ArrayList<>();
    }

    public List<String> getEmailErrors() {
        return emailErrors;
    }

    public List<String> getPasswordErrors() {
        return passwordErrors;
    }
}
