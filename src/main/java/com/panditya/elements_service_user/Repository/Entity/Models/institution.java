package com.panditya.elements_service_user.Repository.Entity.Models;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.elements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public abstract class institution extends elements {

    @NotNull
   @Column(nullable=true)
   private String  url ;

   public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
    this.url = url;
}

public void setContact(String contact) {
    this.contact = contact;
}

public void setAddress(String address) {
    this.address = address;
}

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

@Column
   private String  contact ;
   
   @Column(nullable=false,length=200)
   private String  address ;


   public institution(){super();}

public institution(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
        @NotNull String name, String image, Set<String> paraname, Set<String> parabody, boolean approved,
        boolean deleted, Timestamp created_on, Timestamp last_updated, @NotNull String url, String contact,
        String address) {
    super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved, deleted,
            created_on, last_updated);
    this.url = url;
    this.contact = contact;
    this.address = address;
}

  
    

 
}
