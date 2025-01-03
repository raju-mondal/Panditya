package com.panditya.elements_service_user.DTO.College;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class CollegeDTOShort {


    Long id;
    String name ; 
    String image ;

    public CollegeDTOShort(){}
    public CollegeDTOShort(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    } 

    
}
