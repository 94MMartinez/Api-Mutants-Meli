package com.switchman.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.switchman.app.entities.DNA;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long>  {

}
