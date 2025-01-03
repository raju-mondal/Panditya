package com.panditya.elements_service_user.Services.Course;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.panditya.elements_service_user.DTO.Course.CourseDTO;
import com.panditya.elements_service_user.DTO.Course.CourseDTOShort;
import com.panditya.elements_service_user.Exceptions.ElementNotExistsExceptions;
import com.panditya.elements_service_user.Repository.CourseRepository;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.CourseTags;
import com.panditya.elements_service_user.Repository.Entity.Models.logic.PandityaTags;


@Service
public class CourseService 
{
    @Value("${CustomConfiguration.ReadCount:5}")
    private static Integer dataReadCount ;

    @Autowired
    private CourseRepository CourseRepository ;

    public static CourseDTO convertToCourseDTO(Object[] CourseArray){
       
        return new CourseDTO(
            CourseArray[0].toString(), 
            CourseArray[1].toString(),
            List.of((String[]) CourseArray[2]),
            List.of((String[]) CourseArray[3]));
    }

    
    public static CourseDTOShort convertToCourseDTOShort(Object[] CourseArray){
       
        return new CourseDTOShort(
            Long.valueOf(CourseArray[0].toString()), 
            CourseArray[1].toString(), 
            CourseArray[2].toString());
    }

    public List<CourseDTOShort> getShortViews(List<Object[]> allCourses){

        return allCourses
                .stream()   
                .map(CourseService::convertToCourseDTOShort)
                .collect(Collectors.toList());
    }

    private static final void print(String s){
        System.out.println("\n".repeat(2)+"-".repeat(50)+s+"\n".repeat(2)+"-".repeat(50));
    }

    public CourseDTO getLongViewIDCustom(Long Id)throws ElementNotExistsExceptions{
        List<Object[]> curCourseArray=CourseRepository.findByIDCustom(Id);
        if(!curCourseArray.isEmpty()){
           // print("Found Course With curCourseArray RAMSITA"+curCourseArray.get(0).length);
            return  convertToCourseDTO(curCourseArray.get(0));
        }
        throw new ElementNotExistsExceptions("","");
    }

    public List<CourseDTOShort> getShortViewByName(String name,Long Id){
        return getShortViews(this.CourseRepository.findByNameLike(name,Id,dataReadCount));
    }

    public List<CourseDTOShort> getShortViewByLocation(String address,Long Id){
        return getShortViews(this.CourseRepository.findByLocationLike(address,Id,dataReadCount));
    }
    
    public List<CourseDTOShort> getShortViewBySearchCount(Long searchCount,Long Id){
        return getShortViews(this.CourseRepository.findBySearchCount(searchCount,Id,dataReadCount));
    }
    
    public List<CourseDTOShort> findByPandityaTags(PandityaTags tagName,Long Id){
       
        return getShortViews(this.CourseRepository.findByPandityaTags(tagName.name(),Id,dataReadCount));
      
        
    }

    public List<CourseDTOShort> findByCourseTags(CourseTags tagName,Long Id){

        return getShortViews(this.CourseRepository.findByCourseTags(tagName.name(),Id,dataReadCount));
    }

    
}
