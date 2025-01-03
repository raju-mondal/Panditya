package com.panditya.elements_service_user.Controllers.Teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_service_user.DTO.Teacher.TeacherDTOShort;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.TeacherTags;
import com.panditya.elements_service_user.Services.Teacher.TeacherService;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping(path="/teacher/",produces="application/json")
public class TeacherController 
{
    

    @Autowired
    private final TeacherService TeacherService;

    public TeacherController(TeacherService TeacherService){
        this.TeacherService=TeacherService;
    }  

    @GetMapping("/status")
    public String checkStatus() {
        System.out.println("checkStatus Called  :: ");
        return new StringBuilder("Status check SITARAM Users").toString();
    }
    
    @GetMapping("/name/{name}/")
    public ResponseEntity<List<TeacherDTOShort>> getShortViewByName(@PathVariable String name,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByName Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TeacherService.getShortViewByName(name,Id));
    }
    
    @GetMapping("/location/{address}/")
    public ResponseEntity<List<TeacherDTOShort>> getShortViewByLocation(@PathVariable String address,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByLocation Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TeacherService.getShortViewByLocation(address,Id));
    }
    
    @GetMapping("/searchcount/{count}/")
    public ResponseEntity<List<TeacherDTOShort>> getShortViewBySearchCount(@PathVariable Long count,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewBySearchCount Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TeacherService.getShortViewBySearchCount(count,Id));
    }

      
    @GetMapping("/id/{id}")  
    public ResponseEntity<?> getLongViewID(@PathVariable Long id) {
        System.out.println("getLongViewID Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TeacherService.getLongViewIDCustom(id));
    }

    @GetMapping(value="/tags/{tag}/", 
    produces = MediaType.APPLICATION_JSON)   
    public ResponseEntity<List<TeacherDTOShort>> getShortViewByPandityaTags(@PathVariable @Valid PandityaTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByPandityaTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TeacherService.findByPandityaTags(tag,Id));
    }

    @GetMapping("/teachertags/{tag}/")    
    public ResponseEntity<List<TeacherDTOShort>> getShortViewByTeacherTags(@PathVariable TeacherTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByTeacherTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TeacherService.findByTeacherTags(tag,Id));
    }

  

}

