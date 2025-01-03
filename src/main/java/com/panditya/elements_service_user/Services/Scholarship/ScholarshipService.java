package com.panditya.elements_service_user.Services.Scholarship;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.panditya.elements_service_user.DTO.Scholarship.ScholarshipDTO;
import com.panditya.elements_service_user.DTO.Scholarship.ScholarshipDTOShort;
import com.panditya.elements_service_user.Exceptions.ElementNotExistsExceptions;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.ScholarshipTags;
import com.panditya.elements_service_user.Repository.ScholarshipRepository;


@Service
public class ScholarshipService 
{
    @Value("${CustomConfiguration.ReadCount:5}")
    private static Integer dataReadCount ;

    @Autowired
    private ScholarshipRepository ScholarshipRepository ;

    public static ScholarshipDTO convertToScholarshipDTO(Object[] ScholarshipArray){
       
        return new ScholarshipDTO(
            ScholarshipArray[0].toString(), 
            ScholarshipArray[1].toString(), 
            ScholarshipArray[2].toString(),
            List.of((String[]) ScholarshipArray[3]),
            List.of((String[]) ScholarshipArray[4]));
    }

    
    public static ScholarshipDTOShort convertToScholarshipDTOShort(Object[] ScholarshipArray){
       
        return new ScholarshipDTOShort(
            Long.valueOf(ScholarshipArray[0].toString()), 
            ScholarshipArray[1].toString(), 
            ScholarshipArray[2].toString());
    }

    public List<ScholarshipDTOShort> getShortViews(List<Object[]> allScholarship){

        return allScholarship
                .stream()   
                .map(ScholarshipService::convertToScholarshipDTOShort)
                .collect(Collectors.toList());
    }

    private static final void print(String s){
        System.out.println("\n".repeat(2)+"-".repeat(50)+s+"\n".repeat(2)+"-".repeat(50));
    }

    public ScholarshipDTO getLongViewIDCustom(Long Id)throws ElementNotExistsExceptions{
        List<Object[]> curScholarshipArray=ScholarshipRepository.findByIDCustom(Id);
        if(!curScholarshipArray.isEmpty()){
           // print("Found Scholarship With curScholarshipArray RAMSITA"+curScholarshipArray.get(0).length);
            return  convertToScholarshipDTO(curScholarshipArray.get(0));
        }
        throw new ElementNotExistsExceptions("","");
    }

    public List<ScholarshipDTOShort> getShortViewByName(String name,Long Id){
        return getShortViews(this.ScholarshipRepository.findByNameLike(name,Id,dataReadCount));
    }

    public List<ScholarshipDTOShort> getShortViewByLocation(String address,Long Id){
        return getShortViews(this.ScholarshipRepository.findByLocationLike(address,Id,dataReadCount));
    }
    
    public List<ScholarshipDTOShort> getShortViewBySearchCount(Long searchCount,Long Id){
        return getShortViews(this.ScholarshipRepository.findBySearchCount(searchCount,Id,dataReadCount));
    }
    
    public List<ScholarshipDTOShort> findByPandityaTags(PandityaTags tagName,Long Id){
       
        return getShortViews(this.ScholarshipRepository.findByPandityaTags(tagName.name(),Id,dataReadCount));
      
        
    }

    public List<ScholarshipDTOShort> findByScholarshipTags(ScholarshipTags tagName,Long Id){

        return getShortViews(this.ScholarshipRepository.findByScholarshipTags(tagName.name(),Id,dataReadCount));
    }

}
