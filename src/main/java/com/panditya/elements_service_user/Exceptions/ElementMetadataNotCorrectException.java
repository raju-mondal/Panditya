package com.panditya.elements_service_user.Exceptions;

public class ElementMetadataNotCorrectException extends RuntimeException{
    String errorCode = "EMNC",method="UNKN",path="UNDEFINED";

    public String getErrorCode() {
        return errorCode;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public ElementMetadataNotCorrectException(){}

    public ElementMetadataNotCorrectException(String msg){
        super((msg == null) ? "Metada Not Correct to save the Object" : msg);

    }

    public ElementMetadataNotCorrectException(String msg,String errorCode){
        super((msg == null) ? "Metada Not Correct to save the Object" : msg);
        this.errorCode=this.errorCode+errorCode;
    }

    public ElementMetadataNotCorrectException(Throwable cause){
        super(cause);
    }

    public ElementMetadataNotCorrectException(Throwable cause,String errorCode){
        super(cause);
        this.errorCode=this.errorCode+errorCode;
    }

    public ElementMetadataNotCorrectException(String msg,Throwable cause,String errorCode,String method,String path){
        super((msg == null) ? "Metada Not Correct to save the Object" : msg,cause);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;


    }
    public ElementMetadataNotCorrectException(String msg,String errorCode,String method,String path){
    
        super((msg == null) ? "Metada Not Correct to save the Object" : msg);
        this.errorCode=this.errorCode+errorCode;
        this.method=method;
        this.path=path;

    }
    
}

