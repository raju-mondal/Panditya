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
public abstract class Book extends elements{
    
    
    @Column
    private String url;

    public Book(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            @NotNull String name, String image, Set<String> paraname, Set<String> parabody, boolean approved,
            boolean deleted, Timestamp created_on, Timestamp last_updated, String url) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated);
        this.url = url;
    }

    public Book(){super();}
   
    


}
