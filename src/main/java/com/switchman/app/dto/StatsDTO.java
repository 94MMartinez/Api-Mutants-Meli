package com.switchman.app.dto;


public class StatsDTO {

	private long count_mutant_dna;
	
	private long count_human_dna;

	private double ratio;

	
	public StatsDTO(long countMutants, long countHuman) {
		this.count_mutant_dna = countMutants;
		this.count_human_dna = countHuman;
	}
	
	@Override
	public String toString() {
		return "Total Mutants: " + count_mutant_dna + 
				", Total Humans: " + count_human_dna + 
				", Ratio: " + ratio;
	}
	
	public long getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public long getCount_human_dna() {
		return count_human_dna;
	}
	
	
	public float getRatio() {
		long total = count_mutant_dna + count_human_dna;
		if (total == 0) {
			return 1f;
		} else {
			return count_mutant_dna / (float) total;
		}
	
	
}
	}