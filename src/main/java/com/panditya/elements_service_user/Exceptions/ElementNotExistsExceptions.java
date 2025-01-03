package com.panditya.elements_service_user.Exceptions;




public class ElementNotExistsExceptions extends RuntimeException{

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

    public ElementNotExistsExceptions(){}

    public ElementNotExistsExceptions(String msg){
        super(msg);

    }

    public ElementNotExistsExceptions(String msg,String errorCode){
        super(msg);
        this.errorCode=errorCode;
    }

    public ElementNotExistsExceptions(Throwable cause){
        super(cause);
    }

    public ElementNotExistsExceptions(Throwable cause,String errorCode){
        super(cause);
        this.errorCode=errorCode;
    }

    public ElementNotExistsExceptions(String msg,Throwable cause,String errorCode){
        super(msg,cause);
        this.errorCode=errorCode;
    }

     public ElementNotExistsExceptions(String msg,String errorCode,String method,String path){
        super(msg);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;

    }
    
}
