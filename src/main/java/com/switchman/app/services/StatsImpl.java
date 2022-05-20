package com.switchman.app.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchman.app.dto.DnaInformationDTO;
import com.switchman.app.dto.StatsDTO;
import com.switchman.app.entities.DNA;
import com.switchman.app.repositories.DNARepository;
import com.switchman.app.util.DNAToBd;

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

	public void saveDNA(DnaInformationDTO dna, boolean isMutant) {
		DNA dnaIsinRepo = findBydnaInformation(Arrays.toString(dna.getDna()));
		if (dnaIsinRepo == null) {
			saveDNA(new DNAToBd().transformerDNADtoToDNA(dna, isMutant));
		}
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
