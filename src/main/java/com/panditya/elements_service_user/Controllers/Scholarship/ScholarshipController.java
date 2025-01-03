package com.panditya.elements_service_user.Controllers.Scholarship;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_service_user.DTO.Scholarship.ScholarshipDTOShort;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.ScholarshipTags;
import com.panditya.elements_service_user.Services.Scholarship.ScholarshipService;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping(path="/scholarship/",produces="application/json")
public class ScholarshipController 
{
    

    @Autowired
    private final ScholarshipService ScholarshipService;

    public ScholarshipController(ScholarshipService ScholarshipService){
        this.ScholarshipService=ScholarshipService;
    }  

    @GetMapping("/status")
    public String checkStatus() {
        System.out.println("checkStatus Called  :: ");
        return new StringBuilder("Status check SITARAM Users").toString();
    }
    
    @GetMapping("/name/{name}/")
    public ResponseEntity<List<ScholarshipDTOShort>> getShortViewByName(@PathVariable String name,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByName Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ScholarshipService.getShortViewByName(name,Id));
    }
    
    @GetMapping("/location/{address}/")
    public ResponseEntity<List<ScholarshipDTOShort>> getShortViewByLocation(@PathVariable String address,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByLocation Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ScholarshipService.getShortViewByLocation(address,Id));
    }
    
    @GetMapping("/searchcount/{count}/")
    public ResponseEntity<List<ScholarshipDTOShort>> getShortViewBySearchCount(@PathVariable Long count,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewBySearchCount Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ScholarshipService.getShortViewBySearchCount(count,Id));
    }

      
    @GetMapping("/id/{id}")  
    public ResponseEntity<?> getLongViewID(@PathVariable Long id) {
        System.out.println("getLongViewID Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ScholarshipService.getLongViewIDCustom(id));
    }

    @GetMapping(value="/tags/{tag}/", 
    produces = MediaType.APPLICATION_JSON)   
    public ResponseEntity<List<ScholarshipDTOShort>> getShortViewByPandityaTags(@PathVariable @Valid PandityaTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByPandityaTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ScholarshipService.findByPandityaTags(tag,Id));
    }

    @GetMapping("/scholarshiptags/{tag}/")    
    public ResponseEntity<List<ScholarshipDTOShort>> getShortViewByScholarshipTags(@PathVariable ScholarshipTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByScholarshipTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ScholarshipService.findByScholarshipTags(tag,Id));
    }

  

}

