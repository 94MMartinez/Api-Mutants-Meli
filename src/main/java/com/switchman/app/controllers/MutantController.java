package com.switchman.app.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.switchman.app.dto.DnaInformationDTO;
import com.switchman.app.entities.DNA;
import com.switchman.app.services.DNAVerificationService;
import com.switchman.app.services.StatsImpl;


@RestController
@RequestMapping(path = "/mutant")
public class MutantController {

	private DNAVerificationService dnaVerification;

	@Autowired
	private StatsImpl statsService;

	@Autowired
	public MutantController(DNAVerificationService dnaVerification) {
		this.dnaVerification = dnaVerification;
	}

	@PostMapping
	public ResponseEntity<Object> isMutant(@RequestBody @Valid DnaInformationDTO dna) {
		try {
			Boolean isMutant = dnaVerification.isMutant(dna.getDna());			
			saveDNA(dna, isMutant);
			if (isMutant)  {
				return  ResponseEntity.status(HttpStatus.OK).body("Welcome Brother Mutant!");
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("YA FILTHY HUMAN!!");				
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	protected void saveDNA(DnaInformationDTO dna, boolean isMutant) {
		DNA dnaIsinRepo = statsService.findBydnaInformation(Arrays.toString(dna.getDna()));
		if(dnaIsinRepo == null) {
		statsService.saveDNA(new DNAToBd().transformerDNADtoToDNA(dna, isMutant));
		}
	}

}