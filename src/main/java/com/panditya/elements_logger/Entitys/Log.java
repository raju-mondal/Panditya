package com.panditya.elements_logger.Entitys;

import com.github.f4b6a3.uuid.UuidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Log {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    //@Column(name="log_uuid", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    @Column(name="log_uuid", columnDefinition = "VARCHAR(255)", updatable = false, nullable = false)
    private String log_uuid;
    

    

    @Column(name="service_name",updatable=false,nullable=false)
    private String service_name;

    @Column(name="year",updatable=false,nullable=false)
    private Short year;

    @Column(name="month",updatable=false,nullable=false)
    private Short month;

    @Column(name="day",updatable=false,nullable=false)
    private Short day;

    @Column(name="hour",updatable=false,nullable=false)
    private Short hour;

    @Column(name="minute",updatable=false,nullable=false)
    private Short minute;

    @Column(name="second",updatable=false,nullable=false)
    private Short second;

    @Column(name="milisecond",updatable=false,nullable=false)
    private Short milisecond;
 
    @Column(name="method_details",updatable=false,nullable=false)
    private String method_details;

    @Column(name="message",updatable=false,nullable=false)
    private String message;

    @Column(name="level",updatable=false,nullable=false)
    private String level;

    public Log(){}

    

    public Log( String service_name, Short year, Short month, Short day, Short hour, Short minute,
            Short second, Short milisecond, String method_details, String message, String level) {
        this.log_uuid = UuidCreator.getTimeOrderedEpoch().toString();
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



    

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Short getMonth() {
        return month;
    }

    public void setMonth(Short month) {
        this.month = month;
    }

    public Short getDay() {
        return day;
    }

    public void setDay(Short day) {
        this.day = day;
    }

    public Short getHour() {
        return hour;
    }

    public void setHour(Short hour) {
        this.hour = hour;
    }

    public Short getMinute() {
        return minute;
    }

    public void setMinute(Short minute) {
        this.minute = minute;
    }

    public Short getSecond() {
        return second;
    }
    
    public Short getMilisecond() {
        return milisecond;
    }

    public void setMilisecond(Short milisecond) {
        this.milisecond = milisecond;
    }


    public void setSecond(Short second) {
        this.second = second;
    }

    public String getMethod_details() {
        return method_details;
    }

    public void setMethod_details(String method_details) {
        this.method_details = method_details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    public String getLog_uuid() {
        return log_uuid;
    }

}

