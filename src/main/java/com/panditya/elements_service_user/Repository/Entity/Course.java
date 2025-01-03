package com.panditya.elements_service_user.Repository.Entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.panditya.elements_service_user.Repository.Entity.Models.Degree;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CourseTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course",schema="dev")
public class Course extends Degree{

    @Column(name="course_tags")
    @Enumerated(EnumType.STRING)
    private Set<CourseTags> courseTags;

    public Course(long id, long createdByUser, long approvedByUser, long searchCount, Set<PandityaTags> allTags,
            String name, String image, Set<String> paraname, Set<String> parabody, boolean approved, boolean deleted,
            Timestamp created_on, Timestamp last_updated, String url, String address, Set<CourseTags> courseTags,
            Exams exams_id, Set<Teachers> teachers, Set<College> colleges) {
        super(id, createdByUser, approvedByUser, searchCount, allTags, name, image, paraname, parabody, approved,
                deleted, created_on, last_updated, url, address);
        this.courseTags = courseTags;
        this.exams_id = exams_id;
        this.teachers = teachers;
        this.colleges = colleges;
    }

    public Set<CourseTags> getCourseTags() {
        return courseTags;
    }

    public void setCourseTags(Set<CourseTags> courseTags) {
        this.courseTags = courseTags;
    }

    public com.panditya.elements_service_user.Repository.Entity.Exams getExams_id() {
        return exams_id;
    }

    public void setExams_id(com.panditya.elements_service_user.Repository.Entity.Exams exams_id) {
        this.exams_id = exams_id;
    }

    public Set<com.panditya.elements_service_user.Repository.Entity.Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<com.panditya.elements_service_user.Repository.Entity.Teachers> teachers) {
        this.teachers = teachers;
    }

    public Set<com.panditya.elements_service_user.Repository.Entity.College> getColleges() {
        return colleges;
    }

    public void setColleges(Set<com.panditya.elements_service_user.Repository.Entity.College> colleges) {
        this.colleges = colleges;
    }

    @OneToOne
    private com.panditya.elements_service_user.Repository.Entity.Exams exams_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        schema="dev",
        name = "course_teachers",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "teachers_id")
    )
    private Set<com.panditya.elements_service_user.Repository.Entity.Teachers> teachers=new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        schema="dev",
        name = "course_college",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "college_id")
    )
    private Set<com.panditya.elements_service_user.Repository.Entity.College> colleges=new HashSet<>();

    public Course(){super();}
    
}
