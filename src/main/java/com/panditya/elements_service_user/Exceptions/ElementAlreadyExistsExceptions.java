package com.panditya.elements_service_user.Exceptions;




public class ElementAlreadyExistsExceptions extends RuntimeException{

    private String errorCode = "ENE", method =null, path=null;
    public String getErrorCode() {
        return errorCode;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public ElementAlreadyExistsExceptions(){}

    public ElementAlreadyExistsExceptions(String msg){
        super(msg);

    }

    public ElementAlreadyExistsExceptions(String msg,String errorCode){
        super(msg);
        this.errorCode=errorCode;
    }

    public ElementAlreadyExistsExceptions(Throwable cause){
        super(cause);
    }

    public ElementAlreadyExistsExceptions(Throwable cause,String errorCode){
        super(cause);
        this.errorCode=errorCode;
    }

    public ElementAlreadyExistsExceptions(String msg,Throwable cause,String errorCode){
        super(msg,cause);
        this.errorCode=errorCode;
    }

     public ElementAlreadyExistsExceptions(String msg,String errorCode,String method,String path){
        super(msg);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;

    }
    
}
