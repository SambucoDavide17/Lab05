package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	public List<String> anagrammi(String parola) {
		
		List<String> risultato = new LinkedList<String>();
		permuta("", parola, 0, risultato);
		return risultato;
		
	}

	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
		
		if(lettere.length() == 0) {
			risultato.add(parziale);
		} else {
			for(int pos = 0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato);
			}
		}
	}
}