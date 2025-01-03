package com.panditya.elements_service_user.Controllers.Edutube;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panditya.elements_service_user.DTO.Edutube.EdutubeDTOShort;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.EdutubeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Services.Edutube.EdutubeService;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping(path="/edutube/",produces="application/json")
public class EdutubeController 
{
    

    @Autowired
    private final EdutubeService EdutubeService;

    public EdutubeController(EdutubeService EdutubeService){
        this.EdutubeService=EdutubeService;
    }  

    @GetMapping("/status")
    public String checkStatus() {
        System.out.println("checkStatus Called  :: ");
        return new StringBuilder("Status check SITARAM Users").toString();
    }
    
    @GetMapping("/name/{name}/")
    public ResponseEntity<List<EdutubeDTOShort>> getShortViewByName(@PathVariable String name,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByName Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(EdutubeService.getShortViewByName(name,Id));
    }
    
    @GetMapping("/location/{address}/")
    public ResponseEntity<List<EdutubeDTOShort>> getShortViewByLocation(@PathVariable String address,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByLocation Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(EdutubeService.getShortViewByLocation(address,Id));
    }
    
    @GetMapping("/searchcount/{count}/")
    public ResponseEntity<List<EdutubeDTOShort>> getShortViewBySearchCount(@PathVariable Long count,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewBySearchCount Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(EdutubeService.getShortViewBySearchCount(count,Id));
    }

      
    @GetMapping("/id/{id}")  
    public ResponseEntity<?> getLongViewID(@PathVariable Long id) {
        System.out.println("getLongViewID Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(EdutubeService.getLongViewIDCustom(id));
    }

    @GetMapping(value="/tags/{tag}/", 
    produces = MediaType.APPLICATION_JSON)   
    public ResponseEntity<List<EdutubeDTOShort>> getShortViewByPandityaTags(@PathVariable @Valid PandityaTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByPandityaTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(EdutubeService.findByPandityaTags(tag,Id));
    }

    @GetMapping("/edutubetags/{tag}/")    
    public ResponseEntity<List<EdutubeDTOShort>> getShortViewByEdutubeTags(@PathVariable EdutubeTags tag,@RequestParam(name="lastid",defaultValue="0") Long Id) {
        System.out.println("getShortViewByEdutubeTags Called  :: ");
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(EdutubeService.findByEdutubeTags(tag,Id));
    }

  

}

