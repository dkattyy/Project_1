package lab32023;

public class Baterija {

	private int trKolicinaEnergije;
	private int maxKap;
	
	public Baterija(int maxK) {
		maxKap=maxK;
		trKolicinaEnergije=maxK;
	}
	
	public void dodajEnergiju(int e) {
		trKolicinaEnergije+=e;
		if(trKolicinaEnergije>maxKap) trKolicinaEnergije=maxKap; 
	}
	
	public void potpunoIsprazniBateriju() {
		trKolicinaEnergije=0;
	}
	
	public boolean jePuna() {
		return trKolicinaEnergije==maxKap;
	}
}
