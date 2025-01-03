package com.panditya.elements_service_user.Services.College;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.panditya.elements_service_user.DTO.College.CollegeDTO;
import com.panditya.elements_service_user.DTO.College.CollegeDTOShort;
import com.panditya.elements_service_user.Exceptions.ElementNotExistsExceptions;
import com.panditya.elements_service_user.Repository.CollegeRepository;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CollegeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;


@Service
public class CollegeService 
{
    @Value("${CustomConfiguration.ReadCount:5}")
    private static Integer dataReadCount ;

    @Autowired
    private CollegeRepository collegeRepository ;

 

    public static CollegeDTO convertToCollegeDTO(Object[] collegeArray){
       
        return new CollegeDTO(
            collegeArray[0].toString(), 
            collegeArray[1].toString(), 
            collegeArray[2].toString(),
            List.of((String[]) collegeArray[3]),
            List.of((String[]) collegeArray[4]));
    }

    
    public static CollegeDTOShort convertToCollegeDTOShort(Object[] collegeArray){
       
        return new CollegeDTOShort(
            Long.valueOf(collegeArray[0].toString()), 
            collegeArray[1].toString(), 
            collegeArray[2].toString());
    }


    public List<CollegeDTOShort> getShortViews(List<Object[]> allColleges){

        return allColleges
                .stream()   
                .map(CollegeService::convertToCollegeDTOShort)
                .collect(Collectors.toList());
    }

    private static final void print(String s){
        System.out.println("\n".repeat(2)+"-".repeat(50)+s+"\n".repeat(2)+"-".repeat(50));
    }

   

 

    public CollegeDTO getLongViewIDCustom(Long Id)throws ElementNotExistsExceptions{
        List<Object[]> curCollegeArray=collegeRepository.findByIDCustom(Id);
        if(!curCollegeArray.isEmpty()){
           // print("Found College With curCollegeArray RAMSITA"+curCollegeArray.get(0).length);
            return  convertToCollegeDTO(curCollegeArray.get(0));
        }
        throw new ElementNotExistsExceptions("","");
    }

    public List<CollegeDTOShort> getShortViewByName(String name,Long Id){
        return getShortViews(this.collegeRepository.findByNameLike(name,Id,dataReadCount));
    }

    public List<CollegeDTOShort> getShortViewByLocation(String address,Long Id){
        return getShortViews(this.collegeRepository.findByLocationLike(address,Id,dataReadCount));
    }
    
    public List<CollegeDTOShort> getShortViewBySearchCount(Long searchCount,Long Id){
        return getShortViews(this.collegeRepository.findBySearchCount(searchCount,Id,dataReadCount));
    }
    
    public List<CollegeDTOShort> findByPandityaTags(PandityaTags tagName,Long Id){
       
        return getShortViews(this.collegeRepository.findByPandityaTags(tagName.name(),Id,dataReadCount));
      
        
    }

    public List<CollegeDTOShort> findByCollegeTags(CollegeTags tagName,Long Id){

        return getShortViews(this.collegeRepository.findByCollegeTags(tagName.name(),Id,dataReadCount));
    }

  

    
    
}
