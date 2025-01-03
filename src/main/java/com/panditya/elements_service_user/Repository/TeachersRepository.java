package com.panditya.elements_service_user.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;





@Repository
public interface TeachersRepository extends  JpaRepository<com.panditya.elements_service_user.Repository.Entity.Teachers, Long>{

    @Query(value="select contact,url,address,paraname,parabody from dev.teachers where id=?1 limit 1",nativeQuery=true)
    public List<Object[]> findByIDCustom(Long ID);

    @Query(value = "select id,name,image from  dev.teachers where dev.teachers.id >=:Id AND  dev.teachers.name LIKE CONCAT('%',:searchName,'%') limit :limit", nativeQuery = true)
    public List<Object[]> findByNameLike(@Param("searchName") String searchName,@Param("Id") Long Id,@Param("limit") Integer limit);
    
    
    @Query(value = "select id,name,image from  dev.teachers where dev.teachers.id >=:Id AND dev.teachers.address LIKE CONCAT('%',:location,'%') limit :limit", nativeQuery = true)
    public List<Object[]> findByLocationLike(@Param("location") String location,@Param("Id") Long Id,@Param("limit") Integer limit);
    
    @Query(value = "select id,name,image from  dev.teachers where dev.teachers.id >=:Id AND dev.teachers.search_count >=:searchCount  limit :limit ", nativeQuery = true)
    public List<Object[]> findBySearchCount(@Param("searchCount") Long searchCount,@Param("Id") Long Id,@Param("limit") Integer limit);
    
    @Query(value = "select id,name,image from  dev.teachers where dev.teachers.id >=:Id AND :tagName =ANY(all_tags) limit :limit ", nativeQuery = true)
    public List<Object[]> findByPandityaTags(@Param("tagName") String tagName,@Param("Id") Long Id,@Param("limit") Integer limit);

    @Query(value = "select id,name,image from  dev.teachers where dev.teachers.id >=:Id AND :teachersTagName =ANY(teachers_tags) limit :limit ", nativeQuery = true)
    public List<Object[]> findByTeachersTags(@Param("teachersTagName") String teachersTagName,@Param("Id") Long Id,@Param("limit") Integer limit);

}
