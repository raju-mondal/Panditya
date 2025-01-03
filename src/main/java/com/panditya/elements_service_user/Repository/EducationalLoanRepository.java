package com.panditya.elements_service_user.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.panditya.elements_service_user.Repository.Entity.EducationalLoan;

@RepositoryRestResource
public interface EducationalLoanRepository extends JpaRepository<EducationalLoan , Long>{

    
}
