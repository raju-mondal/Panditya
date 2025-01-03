package com.panditya.elements_service_user.DTO.Scholarship;


public class ScholarshipDTOShort {


    Long id;
    String name ; 
    String image ;

    public ScholarshipDTOShort(){}
    public ScholarshipDTOShort(Long id, String name, String image) {
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
