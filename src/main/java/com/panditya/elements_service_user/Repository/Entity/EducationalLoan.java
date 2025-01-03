package com.panditya.elements_service_user.Repository.Entity;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.Awards;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="educational_loan",schema="dev")
public class EducationalLoan extends Awards{



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        schema="dev",
        name = "loan_college",
        joinColumns = @JoinColumn(name = "educationalLoan_id"),
        inverseJoinColumns = @JoinColumn(name = "college_id")
    )
    private Set<com.panditya.elements_service_user.Repository.Entity.College> colleges=new HashSet<>();

    public EducationalLoan(long id, long createdByUser, long approvedByUser, long searchCount,
            Set<PandityaTags> allTags, String name, String image, Set<String> paraname, Set<String> parabody,
            boolean approved, boolean deleted, Timestamp created_on, Timestamp last_updated, String url, String address,
            String award_cur_type, double award_value, Set<College> colleges) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, url, address, award_cur_type, award_value);
        this.colleges = colleges;
    }

    public EducationalLoan(){super();}
    
    

   
   
    
}
