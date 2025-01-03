package com.panditya.elements_service_user.Repository.Entity;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.Awards;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.ScholarshipTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name="scholarship",schema="dev")
public class Scholarship extends Awards{

    @Column(name="scholarship_tags")
    @Enumerated(EnumType.STRING)
    private Set<ScholarshipTags> scholarshipTags;

    public Set<ScholarshipTags> getScholarshipTags() {
        return scholarshipTags;
    }

    public void setScholarshipTags(Set<ScholarshipTags> scholarshipTags) {
        this.scholarshipTags = scholarshipTags;
    }

    public Scholarship(){super();}

    public Scholarship(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            String name, String image, Set<String> paraname, Set<String> parabody, boolean approved, boolean deleted,
            Timestamp created_on, Timestamp last_updated, String url, String address, String award_cur_type,
            double award_value, Set<ScholarshipTags> scholarshipTags) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, url, address, award_cur_type, award_value);
        this.scholarshipTags = scholarshipTags;
    }
 
    
    
}
