package com.jimmy.core.exception;

public class SiteException extends RuntimeException {
    private String message;
    private String code;
    public SiteException(String message){
        super(message);
        this.message=message;
    }
    public SiteException(Throwable throwable){
        super(throwable);
    }
    public SiteException(Throwable throwable, String message, String code){
        super(message,throwable);
        this.message=message;
        this.code=code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
