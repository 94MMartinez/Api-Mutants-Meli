package com.switchman.app.services;

import com.switchman.app.dto.StatsDTO;
import com.switchman.app.entities.DNA;

public interface StatsService {

	public StatsDTO getStats();

	void saveDNA(DNA dna);

	DNA findBydnaInformation(String dna);

}