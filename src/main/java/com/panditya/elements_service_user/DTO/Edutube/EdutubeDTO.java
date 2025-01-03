package com.panditya.elements_service_user.DTO.Edutube;

import java.util.List;

public class EdutubeDTO {

      
    String  url ;       
    List<String> paraname;      
    List<String> parabody;

    public EdutubeDTO(){}
    
    public EdutubeDTO(String url, List<String> paraname, List<String> parabody) {
        this.url = url;
        this.paraname = paraname;
        this.parabody = parabody;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
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
