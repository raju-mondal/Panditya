package com.panditya.elements_logger.Exceptions;

public class LogNotFound extends RuntimeException {
 
    private static final String errorCode="LNF001";
    
    public static String getErrorcode() {
        return errorCode;
    }

    private final StringBuilder message;
    
   

    @Override
    public String getMessage() {
        return message.toString();
    }

    public LogNotFound(StringBuilder message){
        super(message.toString());
        this.message=message;
    }

}
