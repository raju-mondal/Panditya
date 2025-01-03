package com.panditya.elements_service_user.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.panditya.elements_service_user.Repository.Entity.Exams;

@RepositoryRestResource
public interface ExamsRepository extends JpaRepository<Exams , Long>{

    
}
