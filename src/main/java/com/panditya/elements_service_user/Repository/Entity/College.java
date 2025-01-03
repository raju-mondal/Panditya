package com.panditya.elements_service_user.Repository.Entity;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.institution;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CollegeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="college",schema="dev")
public class College extends institution{

    @Column(nullable=true)
    @Enumerated(EnumType.STRING)
    private Set<CollegeTags> collegeTags;


    public Set<CollegeTags> getCollegeTags() {
        return collegeTags;
    }



    public void setCollegeTags(Set<CollegeTags> collegeTags) {
        this.collegeTags = collegeTags;
    }


   

    public College(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            @NotNull String name, String image, Set<String> paraname, Set<String> parabody, boolean approved,
            boolean deleted, Timestamp created_on, Timestamp last_updated, @NotNull String url, String contact,
            String address, Set<CollegeTags> collegeTags ) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, url, contact, address);
        this.collegeTags = collegeTags;
       
    }

    public College(){super();}
    //@OneToMany(mappedBy="college",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JoinColumn(name = "Teachers_id", referencedColumnName = "id")
    //private Set<Teachers> all_Teachers = new ArraySet<>();



    
    
    



}
