package com.panditya.elements_logger.DTO;

public class LogDTO {
        
    private final String uuid;
    
    private final String service_name;

    private final Short year;

    private final Short month;

    private final Short day;

    private final Short hour;

    private final Short minute;

    private final Short second;

    private final Short milisecond;
 
    private final String method_details;

    private final String message;

    private final String level;

    public LogDTO(String uuid, String service_name, Short year, Short month, Short day, Short hour, Short minute,
            Short second, Short milisecond, String method_details, String message, String level) {
        this.uuid = uuid;
        this.service_name = service_name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.milisecond = milisecond;
        this.method_details = method_details;
        this.message = message;
        this.level = level;
    }

    public String getUuid() {
        return uuid;
    }

    public String getService_name() {
        return service_name;
    }

    public Short getYear() {
        return year;
    }

    public Short getMonth() {
        return month;
    }

    public Short getDay() {
        return day;
    }

    public Short getHour() {
        return hour;
    }

    public Short getMinute() {
        return minute;
    }

    public Short getSecond() {
        return second;
    }

    public Short getMilisecond() {
        return milisecond;
    }

    public String getMethod_details() {
        return method_details;
    }

    public String getMessage() {
        return message;
    }

    public String getLevel() {
        return level;
    }

   

    
}
