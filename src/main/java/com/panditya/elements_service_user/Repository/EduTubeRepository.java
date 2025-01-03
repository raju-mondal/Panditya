package com.panditya.elements_service_user.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;




@RepositoryRestResource
public interface EduTubeRepository extends  JpaRepository<com.panditya.elements_service_user.Repository.Entity.Edutube, Long>{
    
    @Query(value="select url,paraname,parabody from dev.edutube where id=?1 limit 1",nativeQuery=true)
    public List<Object[]> findByIDCustom(Long ID);

    @Query(value = "select id,name,image from  dev.edutube where dev.edutube.id >=:Id AND  dev.edutube.name LIKE CONCAT('%',:searchName,'%') limit :limit", nativeQuery = true)
    public List<Object[]> findByNameLike(@Param("searchName") String searchName,@Param("Id") Long Id,@Param("limit") Integer limit);
    
    @Query(value = "select id,name,image from  dev.edutube where dev.edutube.id >=:Id AND dev.edutube.address LIKE CONCAT('%',:location,'%') limit :limit", nativeQuery = true)
    public List<Object[]> findByLocationLike(@Param("location") String location,@Param("Id") Long Id,@Param("limit") Integer limit);
    
    @Query(value = "select id,name,image from  dev.edutube where dev.edutube.id >=:Id AND dev.edutube.search_count >=:searchCount  limit :limit ", nativeQuery = true)
    public List<Object[]> findBySearchCount(@Param("searchCount") Long searchCount,@Param("Id") Long Id,@Param("limit") Integer limit);
    
    @Query(value = "select id,name,image from  dev.edutube where dev.edutube.id >=:Id AND :tagName =ANY(all_tags) limit :limit ", nativeQuery = true)
    public List<Object[]> findByPandityaTags(@Param("tagName") String tagName,@Param("Id") Long Id,@Param("limit") Integer limit);

    @Query(value = "select id,name,image from  dev.edutube where dev.edutube.id >=:Id AND :edutubeTagName =ANY(edutube_tags) limit :limit ", nativeQuery = true)
    public List<Object[]> findByEdutubeTags(@Param("edutubeTagName") String edutubeTagName,@Param("Id") Long Id,@Param("limit") Integer limit);

 }
