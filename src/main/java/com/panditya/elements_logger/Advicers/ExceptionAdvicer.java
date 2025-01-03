package com.panditya.elements_logger.Advicers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.panditya.elements_logger.Exceptions.LogFormatNotCorrect;
import com.panditya.elements_logger.Exceptions.LogNotFound;
import com.panditya.elements_logger.Response.ErrorResponse;






@FunctionalInterface
interface DefaultAdvice<T>{

     T makenotNull(T value, T defaultValue);
    
} 


@RestControllerAdvice
public class ExceptionAdvicer extends RuntimeException{
    


   private static final DefaultAdvice<String> stringImpl = (String value, String defaultValue) -> value == null ? defaultValue: value;
   private static final DefaultAdvice<HttpStatus> httpStatusImpl = (HttpStatus value, HttpStatus defaultValue) -> value == null ? defaultValue: value;
   private static final DefaultAdvice<LocalDateTime> timestampImpl = (LocalDateTime value, LocalDateTime defaultValue) -> value == null ? defaultValue: value;



    private static ErrorResponse getCustomResponse(String errorCode,String msg,LocalDateTime theTimestamp){
        
        return new ErrorResponse(errorCode, msg, theTimestamp);
    }

    
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotAcceptableException() {
        
        return new ResponseEntity<>(
            getCustomResponse(
              
                "handleHttpMediaTypeNotAcceptableException",           
                null,
                null
        ),httpStatusImpl.makenotNull(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST) );     
    }
 
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> nullPointer(NullPointerException ex){
        System.out.println("NullPointer is catched now \n\n"+"--".repeat(50)+"\n\n");
     
        return new ResponseEntity<>( getCustomResponse(
          
            "NULL001",
            ex.getMessage(),       
            null
    ),HttpStatus.BAD_REQUEST);      
    }
    

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<ErrorResponse> classCastException(ClassCastException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                "CCE 001",
               
                ex.getMessage(),           
                null
        ),HttpStatus.BAD_REQUEST);     
    }


    @ExceptionHandler(NoSuchFieldError.class)
    public ResponseEntity<ErrorResponse> noSuchFieldError(NoSuchFieldError ex){
        return new ResponseEntity<>(
            getCustomResponse(
                "NSF001",
                "noSuchFieldError",           
                null
        ),HttpStatus.BAD_REQUEST);     
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorResponse> unsupportedOperationException(RuntimeException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                "PError1",
                "Not Implemented yet",           
                null
        ),HttpStatus.BAD_REQUEST);     
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(HttpMessageNotReadableException ex){
      
      
        return new ResponseEntity<>(
            getCustomResponse(
            
                "HMRE001",
               ex.getMessage(),           
                null
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        java.util.HashMap<String,String> allErrors = new java.util.HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            allErrors.put(error.getField(),error.getDefaultMessage())  
        );
        return new ResponseEntity<>(
            getCustomResponse(
               
                "MANV001",
                allErrors.toString(),           
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> noResourceFoundException(NoResourceFoundException ex){
      
      
        return new ResponseEntity<>(
            getCustomResponse(
            
                "NRF001",
                ex.getMessage(),           
                null
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    

    @ExceptionHandler(LogNotFound.class)
    public ResponseEntity<ErrorResponse> logNotFound(LogNotFound ex){
        return new ResponseEntity<>(
            getCustomResponse(
                LogNotFound.getErrorcode(),
                ex.getMessage(),      
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }


    @ExceptionHandler(LogFormatNotCorrect.class)
    public ResponseEntity<ErrorResponse> logFormatNotCorrect(LogFormatNotCorrect ex){
        return new ResponseEntity<>(
            getCustomResponse(
                
                LogFormatNotCorrect.getErrorcode(),
                ex.getMessage(),           
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }

    /*
     * 
     ! All are ultimate Types 
     */
    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<ErrorResponse> jpaSystemException(JpaSystemException ex){
        return new ResponseEntity<>(
            getCustomResponse(
                
                LogFormatNotCorrect.getErrorcode(),
                ex.getMessage(),           
                LocalDateTime.now()
        ),HttpStatus.NOT_ACCEPTABLE);     
        
    
    }
}
