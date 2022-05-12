package com.switchman.app.dto;

import javax.validation.constraints.NotNull;
import java.util.Arrays;


public class DnaInformationDTO {

	@NotNull
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public DnaInformationDTO() {
	}

	public DnaInformationDTO(@NotNull String[] dna) {
		this.dna = dna;
	}



	@Override
	public String toString() {
		return "DnaInformationDTO{" +
				"dna=" + Arrays.toString(dna) +
				'}';
	}
}