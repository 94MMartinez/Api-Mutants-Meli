package com.switchman.app.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.switchman.app.entities.DNA;

@Repository
public interface DNARepository extends  CrudRepository<DNA, Long> {
    
	DNA findBydnaInformation(String dnaInformation);

    long countAllByIsMutant(Boolean isMutant);
    
    
}