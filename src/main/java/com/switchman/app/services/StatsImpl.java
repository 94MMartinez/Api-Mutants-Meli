package com.switchman.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchman.app.dto.StatsDTO;
import com.switchman.app.entities.DNA;
import com.switchman.app.repositories.DNARepository;

@Service
public class StatsImpl implements StatsService {

	@Autowired
	protected DNARepository dnaRepository;

	public StatsDTO getStats() {
		long countMutants = dnaRepository.countAllByIsMutant(true);
		long countHuman = dnaRepository.countAllByIsMutant(false);
		StatsDTO stats = new StatsDTO(countMutants, countHuman);
		return stats;
	}

	@Override
	public void saveDNA(DNA dna) {
		dnaRepository.save(dna);
	}

	@Override
	public DNA findBydnaInformation(String dna) {
		return dnaRepository.findBydnaInformation(dna);
	}

}
