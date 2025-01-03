package com.panditya.elements_service_user.Response;

import java.time.LocalDateTime;



public class APIResponse {
    

    private final String guid;
    private final String errorCode;
    private final String errorMessage;
   // private final HttpStatus message;    
 
    private final String path;
    private final String method;  
    private final LocalDateTime timestamp;
    
    public APIResponse(String guid, String errorCode, String errorMessage, String path, String method,
            LocalDateTime timestamp) {
        this.guid = guid;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.path = path;
        this.method = method;
        this.timestamp = timestamp;
    }

    public String getGuid() {
        return guid;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    
}


/*
 * 
 * 
 
 
    
 * 
 */