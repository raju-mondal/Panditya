package com.panditya.elements_service_user.Repository.Entity;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.Video;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.EdutubeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name="edutube",schema="dev")
public class Edutube extends Video{

    @Column(name="eduTube_tags")
    @Enumerated(EnumType.STRING)
    private Set<EdutubeTags> eduTubeTags;


    
    public Edutube(){super();}



    public Edutube(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            String name, String image, Set<String> paraname, Set<String> parabody, boolean approved, boolean deleted,
            Timestamp created_on, Timestamp last_updated, String url, Set<EdutubeTags> eduTubeTags) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, url);
        this.eduTubeTags = eduTubeTags;
    }



    public Set<EdutubeTags> getEduTubeTags() {
        return eduTubeTags;
    }



    public void setEduTubeTags(Set<EdutubeTags> eduTubeTags) {
        this.eduTubeTags = eduTubeTags;
    }

   
  

}
