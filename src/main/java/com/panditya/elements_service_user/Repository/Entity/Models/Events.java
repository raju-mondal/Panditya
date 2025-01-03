package com.panditya.elements_service_user.Repository.Entity.Models;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public abstract class Events extends Degree{

  
 @Column
  private String contact ;

public Events(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
    String name, String image, Set<String> paraname, Set<String> parabody, boolean approved, boolean deleted,
    Timestamp created_on, Timestamp last_updated, String url, String address, String contact) {
  super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved, deleted,
      created_on, last_updated, url, address);
  this.contact = contact;
}



public Events(){super();}

/*
 * 
 * 

Contact

 */
}
