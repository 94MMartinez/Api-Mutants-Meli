package com.switchman.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.entities.DNA;
import com.switchman.app.services.DNAVerificationService;

@RestController
@RequestMapping("/mutant/")
public class MutantController   {
	
	private DNAVerificationService dnaVerification;
	
	
	@Autowired
	public MutantController(DNAVerificationService dnaVerification) {
		this.dnaVerification = dnaVerification;
	}
	
	
	@PostMapping("")
	public boolean sendDNA (@RequestBody String[] dna) {
		return dnaVerification.isMutant(dna);
	}
	
	

}
