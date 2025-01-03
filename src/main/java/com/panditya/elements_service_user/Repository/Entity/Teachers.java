package com.panditya.elements_service_user.Repository.Entity;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.Person;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.TeacherTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="teachers",schema="dev")
public class Teachers extends Person{

    @Column(name="teachers_tags")
    @Enumerated(EnumType.STRING)
    private Set<TeacherTags> teachersTags;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy="teachers")
    //@JoinColumn(referencedColumnName="id")
    private Set<com.panditya.elements_service_user.Repository.Entity.Course> courses_id=new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    //@JoinColumn(name = "college_id")
    private  com.panditya.elements_service_user.Repository.Entity.College cur_college;

    public Teachers(){}

    public Teachers(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            @NotNull String name, String image, Set<String> paraname, Set<String> parabody, boolean approved,
            boolean deleted, Timestamp created_on, Timestamp last_updated, String gender, Set<TeacherTags> teachersTags,
            Set<Course> courses_id, College cur_college) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, gender);
        this.teachersTags = teachersTags;
        this.courses_id = courses_id;
        this.cur_college = cur_college;
    }

    public Set<TeacherTags> getTeachersTags() {
        return teachersTags;
    }

    public void setTeachersTags(Set<TeacherTags> teachersTags) {
        this.teachersTags = teachersTags;
    }

    public Set<com.panditya.elements_service_user.Repository.Entity.Course> getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(Set<com.panditya.elements_service_user.Repository.Entity.Course> courses_id) {
        this.courses_id = courses_id;
    }

    public com.panditya.elements_service_user.Repository.Entity.College getCur_college() {
        return cur_college;
    }

    public void setCur_college(com.panditya.elements_service_user.Repository.Entity.College cur_college) {
        this.cur_college = cur_college;
    }



    
   
  
    
}
