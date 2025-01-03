package com.panditya.elements_service_user.advicer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.panditya.elements_service_user.Exceptions.ElementAlreadyExistsExceptions;
import com.panditya.elements_service_user.Exceptions.ElementMetadataNotCorrectException;
import com.panditya.elements_service_user.Exceptions.ElementNotExistsExceptions;
import com.panditya.elements_service_user.Exceptions.ElementNotFoundException;
import com.panditya.elements_service_user.Response.APIResponse;


@FunctionalInterface
interface DefaultAdvice<T>{

     T makenotNull(T value, T defaultValue);
    
} 

 

@RestControllerAdvice
public class ExceptionAdvicer extends RuntimeException{
     @Autowired
   //rivate Print print; 

   private static final DefaultAdvice<String> stringImpl = (String value, String defaultValue) -> value == null ? defaultValue: value;
   private static final DefaultAdvice<HttpStatus> httpStatusImpl = (HttpStatus value, HttpStatus defaultValue) -> value == null ? defaultValue: value;
   private static final DefaultAdvice<LocalDateTime> timestampImpl = (LocalDateTime value, LocalDateTime defaultValue) -> value == null ? defaultValue: value;



    private static APIResponse getCustomResponse(String guid,String errorCode,String msg,String path,String method,LocalDateTime theTimestamp){
        
        return new APIResponse(
            stringImpl.makenotNull(guid, "UNKN"),
            stringImpl.makenotNull(errorCode, "UNKN"),
            stringImpl.makenotNull(msg, "unidentified"),
            stringImpl.makenotNull(path, "No specific path found"),
            stringImpl.makenotNull(method, "unkn method"),
            timestampImpl.makenotNull(theTimestamp,LocalDateTime.now())
        );
    }

 
 
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResponse> nullPointer(NullPointerException ex){
        System.out.println("NullPointer is catched now \n\n"+"--".repeat(50)+"\n\n");
    
        return new ResponseEntity<>( getCustomResponse(
            null,
            "NULL001",
            ex.getMessage(),           
            null,
            "UNKNOWN", 
            null
    ),HttpStatus.BAD_REQUEST);      
    }
 
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<String> nullPointer(InvalidDataAccessResourceUsageException ex){
       
        return new ResponseEntity<>("DB Error Please check with Admin Code - DB#123", HttpStatus.NOT_ACCEPTABLE);
    }




    @ExceptionHandler(ElementAlreadyExistsExceptions.class)
    public ResponseEntity<APIResponse> elementNotFoundException(ElementAlreadyExistsExceptions ex){
        return new ResponseEntity<>(
            getCustomResponse(
                ex.getErrorCode(),
                null,
                ex.getMessage(),           
                null,
                ex.getMethod(), 
                null
        ),HttpStatus.BAD_REQUEST);     
    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<APIResponse> elementNotFoundException(ElementNotFoundException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                ex.getErrorCode(),
                null,
                ex.getMessage(),           
                null,
                ex.getMethod(), 
                null
        ),HttpStatus.BAD_REQUEST);     
    }

    @ExceptionHandler(NoSuchFieldError.class)
    public ResponseEntity<APIResponse> noSuchFieldError(NoSuchFieldError ex){
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                null,
                null,           
                null,
                null, 
                null
        ),HttpStatus.BAD_REQUEST);     
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<APIResponse> UnsupportedOperationException(RuntimeException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                "PError1",
                "Not Implemented yet",           
                "Not found",
                String.valueOf(ex.getStackTrace()), 
                LocalDateTime.now()
        ),HttpStatus.BAD_REQUEST);     
    }

  /*  @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponse> elementNotFoundException(ElementNotFoundException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                ex.getErrorCode(),
                ex.getMessage(),           
                ex.getPath(),
                ex.getMethod(), 
                LocalDateTime.now()
        ),HttpStatus.NOT_FOUND);     
        HttpMessageNotReadableException
        
    }*/

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse> httpMessageNotReadableException(HttpMessageNotReadableException ex){
      
      
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                "",
               ex.getMessage(),           
                "UNKNN",
                "", 
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        java.util.HashMap<String,String> allErrors = new java.util.HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            allErrors.put(error.getField(),error.getDefaultMessage())  
        );
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                "",
                allErrors.toString(),           
                "UNKNN",
                "", 
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<APIResponse> HttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex){
        System.out.println("\n\n"+"HttpMediaTypeNotAcceptableException Raised and catched "+"\n\n");
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                null,
                ex.getMessage(),           
                null,
                null, 
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

@ExceptionHandler(MethodArgumentTypeMismatchException.class)
public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
    String error = "The IDENTIFIER you entered is invalid, as it should contain only numbers.";
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
}
/* 
 

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" ;
    }*/
    
    @ExceptionHandler(ElementNotExistsExceptions.class)
    public ResponseEntity<APIResponse> elementMetadataNotCorrectException(ElementNotExistsExceptions ex){
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                ex.getErrorCode(),
                ex.getMessage(),           
                ex.getPath(),
                ex.getMethod(), 
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }


    

    @ExceptionHandler(ConverterNotFoundException.class)
    public ResponseEntity<APIResponse> converterNotFoundException(ConverterNotFoundException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                "CONV001",
                ex.getMessage(),           
                null,
                null, 
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    @ExceptionHandler(ElementMetadataNotCorrectException.class)
    public ResponseEntity<APIResponse> elementMetadataNotCorrectException(ElementMetadataNotCorrectException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                null,
                ex.getErrorCode(),
                ex.getMessage(),           
                ex.getPath(),
                ex.getMethod(), 
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }



}
