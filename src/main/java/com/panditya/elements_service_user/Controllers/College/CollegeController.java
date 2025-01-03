package com.panditya.elements_service_user.Controllers.College;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_service_user.DTO.College.CollegeDTOShort;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CollegeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Services.College.CollegeService;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping(path="/college/",produces="application/json")
public class CollegeController 
{
    

    @Autowired
    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService){
        this.collegeService=collegeService;
    }  

    @GetMapping("/status")
    public String checkStatus() {
        System.out.println("checkStatus Called  :: ");
        return new StringBuilder("Status check SITARAM Users").toString();
    }
    
    @GetMapping("/name/{name}/")
    public ResponseEntity<List<CollegeDTOShort>> getShortViewByName(@PathVariable String name,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByName Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(collegeService.getShortViewByName(name,Id));
    }
    
    @GetMapping("/location/{address}/")
    public ResponseEntity<List<CollegeDTOShort>> getShortViewByLocation(@PathVariable String address,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByLocation Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(collegeService.getShortViewByLocation(address,Id));
    }
    
    @GetMapping("/searchcount/{count}/")
    public ResponseEntity<List<CollegeDTOShort>> getShortViewBySearchCount(@PathVariable Long count,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewBySearchCount Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(collegeService.getShortViewBySearchCount(count,Id));
    }

      
    @GetMapping("/id/{id}")  
    public ResponseEntity<?> getLongViewID(@PathVariable Long id) {
        System.out.println("getLongViewID Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(collegeService.getLongViewIDCustom(id));
    }

    @GetMapping(value="/tags/{tag}/", 
    produces = MediaType.APPLICATION_JSON)   
    public ResponseEntity<List<CollegeDTOShort>> getShortViewByPandityaTags(@PathVariable @Valid PandityaTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByPandityaTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(collegeService.findByPandityaTags(tag,Id));
    }

    @GetMapping("/collegetags/{tag}/")    
    public ResponseEntity<List<CollegeDTOShort>> getShortViewByCollegeTags(@PathVariable CollegeTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByCollegeTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(collegeService.findByCollegeTags(tag,Id));
    }

  

}

