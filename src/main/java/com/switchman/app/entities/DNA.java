package com.switchman.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class DNA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String[] dnaInformation;
	
	private boolean isMutant; 

	public void Dna() {
	    }

	    public void Dna(String[] dnaInformation) {

	        this.dnaInformation = dnaInformation;
	     
	    }

	
	
	
}