package com.switchman.app.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.entities.DNA;
import com.switchman.app.services.DNAVerificationService;

@RestController
@RequestMapping("/mutant/")
public class MutantController   {
	
	private DNAVerificationService dnaverification;
	
	
	
	
	
	@PostMapping("")
	public void sendDNA (@RequestBody DNA dna) {
	}
	

}
