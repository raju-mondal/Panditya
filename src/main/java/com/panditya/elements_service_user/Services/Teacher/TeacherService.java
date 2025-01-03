package com.panditya.elements_service_user.Services.Teacher;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.panditya.elements_service_user.DTO.Teacher.TeacherDTO;
import com.panditya.elements_service_user.DTO.Teacher.TeacherDTOShort;
import com.panditya.elements_service_user.Exceptions.ElementNotExistsExceptions;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.TeacherTags;
import com.panditya.elements_service_user.Repository.TeachersRepository;


@Service
public class TeacherService 
{
    @Value("${CustomConfiguration.ReadCount:5}")
    private static Integer dataReadCount ;

    @Autowired
    private TeachersRepository teachersRepository ;

    public static TeacherDTO convertToTeacherDTO(Object[] TeacherArray){
       
        return new TeacherDTO(
            TeacherArray[0].toString(), 
            TeacherArray[1].toString(), 
            TeacherArray[2].toString(),
            List.of((String[]) TeacherArray[3]),
            List.of((String[]) TeacherArray[4]));
    }

    
    public static TeacherDTOShort convertToTeacherDTOShort(Object[] TeacherArray){
       
        return new TeacherDTOShort(
            Long.valueOf(TeacherArray[0].toString()), 
            TeacherArray[1].toString(), 
            TeacherArray[2].toString());
    }

    public List<TeacherDTOShort> getShortViews(List<Object[]> allTeachers){

        return allTeachers
                .stream()   
                .map(TeacherService::convertToTeacherDTOShort)
                .collect(Collectors.toList());
    }

    private static final void print(String s){
        System.out.println("\n".repeat(2)+"-".repeat(50)+s+"\n".repeat(2)+"-".repeat(50));
    }

    public TeacherDTO getLongViewIDCustom(Long Id)throws ElementNotExistsExceptions{
        List<Object[]> curTeacherArray=teachersRepository.findByIDCustom(Id);
        if(!curTeacherArray.isEmpty()){
           // print("Found Teacher With curTeacherArray RAMSITA"+curTeacherArray.get(0).length);
            return  convertToTeacherDTO(curTeacherArray.get(0));
        }
        throw new ElementNotExistsExceptions("","");
    }

    public List<TeacherDTOShort> getShortViewByName(String name,Long Id){
        return getShortViews(this.teachersRepository.findByNameLike(name,Id,dataReadCount));
    }

    public List<TeacherDTOShort> getShortViewByLocation(String address,Long Id){
        return getShortViews(this.teachersRepository.findByLocationLike(address,Id,dataReadCount));
    }
    
    public List<TeacherDTOShort> getShortViewBySearchCount(Long searchCount,Long Id){
        return getShortViews(this.teachersRepository.findBySearchCount(searchCount,Id,dataReadCount));
    }
    
    public List<TeacherDTOShort> findByPandityaTags(PandityaTags tagName,Long Id){
       
        return getShortViews(this.teachersRepository.findByPandityaTags(tagName.name(),Id,dataReadCount));
      
        
    }

    public List<TeacherDTOShort> findByTeacherTags(TeacherTags tagName,Long Id){

        return getShortViews(this.teachersRepository.findByTeachersTags(tagName.name(),Id,dataReadCount));
    }

    
}
