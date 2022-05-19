package com.switchman.app.services;

import org.springframework.stereotype.Service;

@Service
public class DNAVerificationimpl implements DNAVerificationService {

	public boolean isMutant(String[] dna) {
		return mutantPerLine(dna) + mutantPerColumn(dna) 
		+ mutantPerDiagonal(dna) + mutantPerContraDiagonal(dna) >= 2;
	}

	private int mutantPerContraDiagonal(String[] dna) {
		if (dna.length == 0) {
			return 0;
		}
		int someDiagonalMutant = 0;

		for (int actualRow = 0; actualRow < dna.length && ((dna.length - actualRow) >= 4); actualRow++) {
			int letterEquals = 0;
			int rowToCompare = actualRow + 1;
			int actualColumn = dna.length - 1;
			int columnToCompare = actualColumn - 1;
			for (int j = dna.length - 1; (actualColumn >= 4 - 1); j--) {
				if (dna[actualRow].charAt(actualColumn) == dna[rowToCompare].charAt(columnToCompare)) {
					rowToCompare += 1;
					columnToCompare -= 1;
					letterEquals = letterEquals + 1;
					if (letterEquals == 3) {
						someDiagonalMutant = someDiagonalMutant + 1;
						letterEquals = 0;
						actualColumn -= 1;
						columnToCompare = actualColumn - 1;
						rowToCompare = actualRow + 1;
					}
				} else {
					letterEquals = 0;
					actualColumn -= 1;
					columnToCompare = actualColumn - 1;
					rowToCompare = actualRow + 1;

				}
			}
		}
		return someDiagonalMutant;
	}

	private int mutantPerDiagonal(String[] dna) {
		if (dna.length == 0) {
			return 0;
		}
		int someDiagonalMutant = 0;
		for (int actualRow = 0; actualRow < dna.length && ((dna.length - actualRow) >= 4); actualRow++) {
			int letterEquals = 0;
			int rowToCompare = actualRow + 1;
			int actualColumn = 0;
			int columnToCompare = 1;
			for (int j = 0; ((dna.length - actualColumn) >= 4) && columnToCompare < dna.length; j++) {
				if (dna[actualRow].charAt(actualColumn) == dna[rowToCompare].charAt(columnToCompare)) {
					rowToCompare += 1;
					columnToCompare += 1;
					letterEquals = letterEquals + 1;
					if (letterEquals == 3) {
						someDiagonalMutant = someDiagonalMutant + 1;
						letterEquals = 0;
					}
				} else {
					letterEquals = 0;
					actualColumn += 1;
					columnToCompare = actualColumn + 1;
					rowToCompare = actualRow + 1;

				}
			}
		}
		return someDiagonalMutant;
	}

	private int mutantPerLine(String[] dna) {
		if (dna.length == 0) {
			return 0;
		}
		int someLineMutant = 0;
		for (int actualRow = 0; actualRow < dna.length; actualRow++) {
			int letterEquals = 0;
			int actualColumn = 0;
			int columnToCompare = 1;
			for (int j = 0; columnToCompare < dna[0].length() && letterEquals < 3; j++) {
				if (dna[actualRow].charAt(actualColumn) != dna[actualRow].charAt(columnToCompare)) {
					actualColumn = columnToCompare;
					columnToCompare += 1;
					letterEquals = 0;
				} else {
					columnToCompare += 1;
					letterEquals = letterEquals + 1;
					if (letterEquals == 3) {
						someLineMutant = someLineMutant + 1;
						letterEquals = 0;
					}
				}
			}
		}
		return someLineMutant;
	}

	private int mutantPerColumn(String[] dna) {
		if (dna.length == 0) {
			return 0;
		}
		int someColumMutant = 0;

		for (int actualRow = 0; actualRow < dna.length && ((dna.length - actualRow) >= 4); actualRow++) {
			int rowToCompare = actualRow + 1;
			int letterEquals = 0;
			int actualColumn = 0;
			for (int j = 0; actualColumn < dna[0].length(); j++) {
				if (dna[actualRow].charAt(actualColumn) != dna[rowToCompare].charAt(actualColumn)) {
					letterEquals = 0;
					actualColumn += 1;
					rowToCompare = actualRow + 1;
				} else {
					rowToCompare += 1;
					letterEquals += 1;
					if (letterEquals == 3) {
						letterEquals = 0;
						someColumMutant = someColumMutant + 1;
						rowToCompare = actualRow + 1;
						actualColumn += 1;
					}
				}
			}
		}
		return someColumMutant;
	}

}
