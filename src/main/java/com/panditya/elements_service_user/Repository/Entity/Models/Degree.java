package com.panditya.elements_service_user.Repository.Entity.Models;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public abstract class Degree extends Video{
   @Column
   private String address;

public Degree(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
        String name, String image, Set<String> paraname, Set<String> parabody, boolean approved, boolean deleted,
        Timestamp created_on, Timestamp last_updated, String url, String address) {
    super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved, deleted,
            created_on, last_updated, url);
    this.address = address;
}

 
public Degree(){super();}
   


}
    

/*
 * 
 * 

Address

 */

