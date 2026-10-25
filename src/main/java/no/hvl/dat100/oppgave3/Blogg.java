package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];

	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int i = 0;
		while(i < nesteledig){
			if(innleggtabell[i].erLik(innlegg)){
				return i;
			}
			i++;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if(finnInnlegg(innlegg) != -1){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean ledigPlass() {
		if(nesteledig < innleggtabell.length && innleggtabell.length > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(ledigPlass()){
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString() {
		String output = nesteledig + "\n";
		int i = 0;
		while(i < nesteledig && nesteledig != 0){
			output += innleggtabell[i].toString();
			i++;
		}
		return output;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}