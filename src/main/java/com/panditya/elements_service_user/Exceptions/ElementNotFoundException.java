package com.panditya.elements_service_user.Exceptions;



public final class ElementNotFoundException extends RuntimeException{

    private String errorCode = "ENF", method =null, path=null;

    public String getErrorCode() {
        return errorCode;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public ElementNotFoundException(){}

    public ElementNotFoundException(String msg){
        super(msg);

    }

    public ElementNotFoundException(String msg,String errorCode){
        super(msg);
        this.errorCode=errorCode;
    }

    public ElementNotFoundException(Throwable cause){
        super(cause);
    }

    public ElementNotFoundException(Throwable cause,String errorCode){
        super(cause);
        this.errorCode=errorCode;
    }

    public ElementNotFoundException(String msg,Throwable cause,String errorCode){
        super(msg,cause);
        this.errorCode=errorCode;
        
    }
    
    public ElementNotFoundException(String msg,String errorCode,String method,String path){
        super(msg);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;

    }
}
