package com.panditya.elements_service_user.Exceptions;

public class UnsupportedOperationException extends RuntimeException{
    String errorCode = "UOE",method="UNKN",path="UNDEFINED";

    public UnsupportedOperationException(){}

    public UnsupportedOperationException(String msg){
        super(msg);

    }

    public UnsupportedOperationException(String msg,String errorCode){
        super(msg);
        this.errorCode=this.errorCode+errorCode;
    }

    public UnsupportedOperationException(Throwable cause){
        super(cause);
    }

    public UnsupportedOperationException(Throwable cause,String errorCode){
        super(cause);
        this.errorCode=this.errorCode+errorCode;
    }

    public UnsupportedOperationException(String msg,Throwable cause,String errorCode,String method,String path){
        super(msg,cause);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;


    }
    public UnsupportedOperationException(String msg,String errorCode,String method,String path){
        super(msg);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;

    }
    
}

