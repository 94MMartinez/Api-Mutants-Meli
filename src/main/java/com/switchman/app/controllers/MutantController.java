package com.switchman.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.dto.DnaInformationDTO;
import com.switchman.app.services.DNAVerificationService;

@RestController
@RequestMapping(path = "/mutant")
public class MutantController   {
	
	private DNAVerificationService dnaVerification;
	
	
	@Autowired
	public MutantController(DNAVerificationService dnaVerification) {
		this.dnaVerification = dnaVerification;
	}
	
	
	@PostMapping
	public ResponseEntity<Object> isMutant(@RequestBody @Valid DnaInformationDTO dna) {
		try {
			Boolean isMutant = dnaVerification.isMutant(dna.getDna());
			if (isMutant) {
				return ResponseEntity.status(HttpStatus.OK).body("Welcome Brother Mutant!");
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("YA FILTHY HUMAN!!");
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
			
	}
}