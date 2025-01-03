package com.panditya.elements_service_user.Services.Edutube;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.panditya.elements_service_user.DTO.Edutube.EdutubeDTO;
import com.panditya.elements_service_user.DTO.Edutube.EdutubeDTOShort;
import com.panditya.elements_service_user.Exceptions.ElementNotExistsExceptions;
import com.panditya.elements_service_user.Repository.EduTubeRepository;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.EdutubeTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;


@Service
public class EdutubeService 
{
    @Value("${CustomConfiguration.ReadCount:5}")
    private static Integer dataReadCount ;

    @Autowired
    private EduTubeRepository edutubeRepository ;

    public static EdutubeDTO convertToEdutubeDTO(Object[] EdutubeArray){
       
        return new EdutubeDTO(
            EdutubeArray[0].toString(), 
            List.of((String[]) EdutubeArray[1]),
            List.of((String[]) EdutubeArray[2]));
    }

    
    public static EdutubeDTOShort convertToEdutubeDTOShort(Object[] EdutubeArray){
       
        return new EdutubeDTOShort(
            Long.valueOf(EdutubeArray[0].toString()), 
            EdutubeArray[1].toString(), 
            EdutubeArray[2].toString());
    }

    public List<EdutubeDTOShort> getShortViews(List<Object[]> alledutube){

        return alledutube
                .stream()   
                .map(EdutubeService::convertToEdutubeDTOShort)
                .collect(Collectors.toList());
    }

    private static final void print(String s){
        System.out.println("\n".repeat(2)+"-".repeat(50)+s+"\n".repeat(2)+"-".repeat(50));
    }

    public EdutubeDTO getLongViewIDCustom(Long Id)throws ElementNotExistsExceptions{
        List<Object[]> curEdutubeArray=edutubeRepository.findByIDCustom(Id);
        if(!curEdutubeArray.isEmpty()){
           // print("Found Edutube With curEdutubeArray RAMSITA"+curEdutubeArray.get(0).length);
            return  convertToEdutubeDTO(curEdutubeArray.get(0));
        }
        throw new ElementNotExistsExceptions("","");
    }

    public List<EdutubeDTOShort> getShortViewByName(String name,Long Id){
        return getShortViews(this.edutubeRepository.findByNameLike(name,Id,dataReadCount));
    }

    public List<EdutubeDTOShort> getShortViewByLocation(String address,Long Id){
        return getShortViews(this.edutubeRepository.findByLocationLike(address,Id,dataReadCount));
    }
    
    public List<EdutubeDTOShort> getShortViewBySearchCount(Long searchCount,Long Id){
        return getShortViews(this.edutubeRepository.findBySearchCount(searchCount,Id,dataReadCount));
    }
    
    public List<EdutubeDTOShort> findByPandityaTags(PandityaTags tagName,Long Id){
       
        return getShortViews(this.edutubeRepository.findByPandityaTags(tagName.name(),Id,dataReadCount));
      
        
    }

    public List<EdutubeDTOShort> findByEdutubeTags(EdutubeTags tagName,Long Id){

        return getShortViews(this.edutubeRepository.findByEdutubeTags(tagName.name(),Id,dataReadCount));
    }

    
}
