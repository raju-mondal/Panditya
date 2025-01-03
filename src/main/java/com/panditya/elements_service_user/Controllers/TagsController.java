package com.panditya.elements_service_user.Controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_service_user.Repository.Entity.Models.logic.CollegeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CourseTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.ExamTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.NovelTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.ScholarshipTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.TeacherTags;


@RestController
@RequestMapping(path="/alltags",produces="application/json")
public class TagsController
{
    
    @GetMapping()
    public ResponseEntity<List<PandityaTags>> pandityaTags() {
        System.out.println("pandityaTags Called  :: ");
        return ResponseEntity.ok().body(List.of(PandityaTags.values()));
    }
    
    @GetMapping("/college")
    public ResponseEntity<List<CollegeTags>> collegeTags() {
        System.out.println("collegeTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(List.of(CollegeTags.values()));
    }
    
    @GetMapping("/exam")
    public ResponseEntity<List<ExamTags>> examTags() {
        System.out.println("ExamTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(List.of(ExamTags.values()));
    }
    
        
    @GetMapping("/course")
    public ResponseEntity<List<CourseTags>> courseTags() {
        System.out.println("CourseTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(List.of(CourseTags.values()));
    }
    
    @GetMapping("/novel")
    public ResponseEntity<List<NovelTags>> novelTags() {
        System.out.println("NovelTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(List.of(NovelTags.values()));
    }
    
        
    @GetMapping("/scholarship")
    public ResponseEntity<List<ScholarshipTags>> scholarshipTags() {
        System.out.println("scholarshipTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(List.of(ScholarshipTags.values()));
    }
    
    @GetMapping("/teacher")
    public ResponseEntity<List<TeacherTags>> teacherTags() {
        System.out.println("teacherTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(List.of(TeacherTags.values()));
    }
    
    
}

