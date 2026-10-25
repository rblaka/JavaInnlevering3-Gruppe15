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
		int utvid = innleggtabell.length * 2;
		Innlegg[] midlertidig = new Innlegg[utvid];
		int i = 0;
		while(i < nesteledig){
			midlertidig[i] = innleggtabell[i];
			innleggtabell[i] = null;
			i++;
		}
		innleggtabell = midlertidig;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if(finnes(innlegg)){
			if(leggTil(innlegg)){
				return true;
			}
			else{
				utvid();
				leggTil(innlegg);
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean slett(Innlegg innlegg) {
		int index = finnInnlegg(innlegg);
		if(index != -1){
			innleggtabell[index] = innleggtabell[nesteledig-1];
			innleggtabell[nesteledig-1] = null;
			nesteledig--;
			return true;
		}
		else{
			return false;
		}
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}