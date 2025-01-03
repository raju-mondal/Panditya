package com.panditya.elements_service_user.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panditya.elements_service_user.Repository.Entity.PandityaEvents;




@Repository
public interface PandityaEventsRepository extends  JpaRepository<PandityaEvents, Long>{
    
}
