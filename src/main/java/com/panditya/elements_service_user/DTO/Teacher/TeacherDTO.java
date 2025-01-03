package com.panditya.elements_service_user.DTO.Teacher;

import java.util.List;

public class TeacherDTO {

    String contact;     
    String  url ;  
    String  address ;      
    List<String> paraname;      
    List<String> parabody;

    public TeacherDTO(){}
    public TeacherDTO(String contact, String url, String address, List<String> paraname, List<String> parabody) {
        this.contact = contact;
        this.url = url;
        this.address = address;
        this.paraname = paraname;
        this.parabody = parabody;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<String> getParaname() {
        return paraname;
    }
    public void setParaname(List<String> paraname) {
        this.paraname = paraname;
    }
    public List<String> getParabody() {
        return parabody;
    }
    public void setParabody(List<String> parabody) {
        this.parabody = parabody;
    }

    
    
}
