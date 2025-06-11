package lab32023;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {

	private int brojVodenihPovrsinaOkolo;
	
	public Hidroelektrana(Baterija bat) {
		super('H', Color.BLUE, 1500, bat);
		brojVodenihPovrsinaOkolo=0;
	}

	public void postaviBrojVodenihPovrsina(int i) {
		brojVodenihPovrsinaOkolo=i;
	}

	@Override
	public void proizvediEnergiju() {
		if(brojVodenihPovrsinaOkolo==0) proizveo_uspesno=false;
		else {
			for(int i=0;i<this.brojVodenihPovrsinaOkolo;i++) baterija.dodajEnergiju(1);
			proizveo_uspesno=true;
		}
	}

	
	
}
