package com.panditya.elements_service_user.Repository.Entity;

import java.sql.Timestamp;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.Degree;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//@Table(name="college",schema="dev")


@Entity
@Table(name="exams",schema="dev")
public class Exams extends Degree{

    @OneToOne
    private com.panditya.elements_service_user.Repository.Entity.Course course_id;

    public Exams(){super();}

    public Exams(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            String name, String image, Set<String> paraname, Set<String> parabody, boolean approved, boolean deleted,
            Timestamp created_on, Timestamp last_updated, String url, String address, Course course_id) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, url, address);
        this.course_id = course_id;
    }
   
    

    //@OneToMany(mappedBy="college",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JoinColumn(name = "Teachers_id", referencedColumnName = "id")
    //private Set<Teachers> all_Teachers = new ArraySet<>();
    
    
  

  /*
Contact
Address
Teachers
Students
Loans
Courses
    */
}
