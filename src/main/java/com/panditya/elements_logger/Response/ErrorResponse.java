package com.panditya.elements_logger.Response;

import java.time.LocalDateTime;

public class ErrorResponse {
    

    private final String errorCode;

    private final String errorMessage;
 
    private final LocalDateTime timestamp;
    
    public ErrorResponse( String errorCode, String errorMessage,
            LocalDateTime timestamp) {
        this.errorCode=errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

  

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
