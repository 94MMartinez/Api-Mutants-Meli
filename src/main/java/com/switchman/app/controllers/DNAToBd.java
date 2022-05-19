package com.switchman.app.controllers;

import java.util.Arrays;

import com.switchman.app.dto.DnaInformationDTO;
import com.switchman.app.entities.DNA;

public class DNAToBd {

	
	
	public DNA transformerDNADtoToDNA(DnaInformationDTO dnaDto, boolean isMutant) {
        DNA dna = new DNA();
        dna.setDnaInformation(Arrays.toString(dnaDto.getDna()));
        dna.setMutant(isMutant);
        return dna;
        }

}
