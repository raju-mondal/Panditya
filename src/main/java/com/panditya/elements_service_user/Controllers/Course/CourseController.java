package com.panditya.elements_service_user.Controllers.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_service_user.DTO.Course.CourseDTOShort;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CourseTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Services.Course.CourseService;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping(path="/course/",produces="application/json")
public class CourseController 
{
    

    @Autowired
    private final CourseService CourseService;

    public CourseController(CourseService CourseService){
        this.CourseService=CourseService;
    }  

    @GetMapping("/status")
    public String checkStatus() {
        System.out.println("checkStatus Called  :: ");
        return new StringBuilder("Status check SITARAM Users").toString();
    }
    
    @GetMapping("/name/{name}/")
    public ResponseEntity<List<CourseDTOShort>> getShortViewByName(@PathVariable String name,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByName Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(CourseService.getShortViewByName(name,Id));
    }
    
    @GetMapping("/location/{address}/")
    public ResponseEntity<List<CourseDTOShort>> getShortViewByLocation(@PathVariable String address,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByLocation Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(CourseService.getShortViewByLocation(address,Id));
    }
    
    @GetMapping("/searchcount/{count}/")
    public ResponseEntity<List<CourseDTOShort>> getShortViewBySearchCount(@PathVariable Long count,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewBySearchCount Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(CourseService.getShortViewBySearchCount(count,Id));
    }

      
    @GetMapping("/id/{id}")  
    public ResponseEntity<?> getLongViewID(@PathVariable Long id) {
        System.out.println("getLongViewID Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(CourseService.getLongViewIDCustom(id));
    }

    @GetMapping(value="/tags/{tag}/", 
    produces = MediaType.APPLICATION_JSON)   
    public ResponseEntity<List<CourseDTOShort>> getShortViewByPandityaTags(@PathVariable @Valid PandityaTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByPandityaTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(CourseService.findByPandityaTags(tag,Id));
    }

    @GetMapping("/coursetags/{tag}/")    
    public ResponseEntity<List<CourseDTOShort>> getShortViewByCourseTags(@PathVariable CourseTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByCourseTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(CourseService.findByCourseTags(tag,Id));
    }

  

}

