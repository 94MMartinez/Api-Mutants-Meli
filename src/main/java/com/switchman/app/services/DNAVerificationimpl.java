package com.switchman.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchman.app.repositories.DNARepository;

@Service
public class DNAVerificationimpl implements DNAVerificationService {
    
	@Autowired
	public DNARepository dnaRepo;
	
	
	
	 public boolean isMutant(String[] dna) {

    return mutantPerLine(dna) + mutantPerColumn(dna) + mutantPerDiagonal(dna) + mutantPerContraDiagonal(dna) >= 2;
}

    private int mutantPerContraDiagonal(String[] dna) {
        if (dna.length == 0) {
            return 0;
        }
        int someDiagonalMutant = 0;
        for (int i = 0; i < dna.length && ((dna.length - i) >= 4); i++) {
            int counter = 0;
            int aux = i+1;
            int aux2 = dna.length - 1;
            int aux3 = aux2 - 1;
            for (int j = dna.length - 1; ( aux2 >= 4 - 1) ; j--) {         
                if (dna[i].charAt(aux2) == dna[aux].charAt(aux3)) {
                    aux += 1;
                    aux3 -= 1;
                    counter = counter + 1;
                    if (counter == 3) {
                        someDiagonalMutant = someDiagonalMutant + 1;
                        counter = 0;
                        aux2 -= 1;
                        aux3 = aux2 - 1;
                        aux = i + 1;
                    }
                } else {
                    counter = 0;
                    aux2 -= 1;
                    aux3 = aux2 - 1;
                    aux = i + 1;

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
        for (int i = 0; i < dna.length && ((dna.length - i) >= 4) ; i++) {
            int counter = 0;
            int aux = i+1;
            int aux2 = 0;
            int aux3 = 1;
            for (int j = 0; ((dna.length - aux2) >= 4) && aux < dna.length; j++) {        
                if (dna[i].charAt(aux2) == dna[aux].charAt(aux3)) {
                    aux += 1;
                    aux3 +=1;
                    counter = counter + 1;
                    if(counter == 3){
                        someDiagonalMutant =  someDiagonalMutant + 1;
                        counter = 0;
                    }
                }else {
                    counter = 0;
                    aux2 += 1;
                    aux3 = aux2 + 1;
                    aux = i + 1;

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
        for(int i = 0; i < dna.length ; i ++){
            int counter = 0;
            int aux = 0;
            int aux2 = 1;
            for (int j = 0 ;aux2 < dna[0].length() && counter < 3; j++) {                
                if (dna[i].charAt(aux) != dna[i].charAt(aux2)) {
                    aux = aux2;
                    aux2 +=1;
                    counter = 0;
                }
                else{
                    aux2 +=1;
                    counter = counter + 1;
                    if(counter == 3){
                        someLineMutant = someLineMutant + 1;
                        counter = 0;
                    }
                }
            }
        }
        return someLineMutant;
    }

    private int  mutantPerColumn(String[] dna) {
        if (dna.length == 0) {
            return 0;
        }
        int someColumMutant = 0;

        for (int i = 0; i < dna.length && ((dna.length - i) >= 4); i++) {
            int aux2 = i+1;
            int counter = 0;
            int aux = 0;
            for (int j = 0;aux < dna.length ; j++) {
                if( dna[i].charAt(aux) != dna[aux2].charAt(aux)){
                    counter = 0;
                    aux +=1;
                    aux2 = i + 1;
                }else {
                    aux2 += 1;
                    counter += 1;
                    if(counter == 3){
                        counter = 0;
                        someColumMutant = someColumMutant + 1;
                        aux2 = i + 1;
                        aux +=1;
                    }
                }
            }
        }
        return someColumMutant;
    }

}
