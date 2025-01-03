package com.panditya.elements_service_user.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panditya.elements_service_user.Repository.Entity.Novels;




@Repository
public interface NovelsRepository extends  JpaRepository<Novels, Long>{
    
}
