package com.panditya.elements_logger.Exceptions;

public class LogFormatNotCorrect extends RuntimeException {
 
    private static final String errorCode="LFNC01";
    private final StringBuilder message;

    public static String getErrorcode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message.toString();
    }

    public LogFormatNotCorrect(StringBuilder message){
        super(message.toString());
        this.message=message;
    }


}
