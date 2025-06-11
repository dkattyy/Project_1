package lab32023;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;


public class Plac{

	public Panel p;
	private Parcela[][] resetka;
	private int redovi,kolone;
	private Parcela izabrana;
	
	public Plac(int brRed, int brKol) {
		redovi=brRed;
		kolone=brKol;
		
		resetka=new Parcela[redovi][kolone];
		
		p=new Panel(new GridLayout(redovi, kolone, 1, 1));
		
		for(int i=0;i<redovi;i++) {
			for(int j=0;j<kolone;j++) {
				//verovatnoca da bude travnata je 0.7;vodena 0.3
				
				double vrv=Math.random();
				if(vrv<=0.7)
					resetka[i][j]=new TravnataPovrs();
				else 
					resetka[i][j]=new VodenaPovrs();
				
				p.add(resetka[i][j]);
			}
		}
	}
	
	public void izaberiParcelu() {
		
		for(int i=0; i<redovi; i++) {
   		 for(int j=0; j<kolone; j++) {
   			 if(resetka[i][j].izabrana) {
   				 izabrana = resetka[i][j];
   				// izabrana.setSize(izabrana.getWidth()+20, izabrana.getHeight()+20);
   			 }
   		 }
   	 }
	}
	
	public void dodajProizvodjaca(Proizvodjac pr) {
//		for(int i=0;i<redovi;i++) {
//			for(int j=0;j<kolone;j++) {
//				if(resetka[i][j]==izabrana) {
//					resetka[i][j]=p;  //dodajemo proizvodjaca na odabranu parcelu
//				}
//			}
//		}
		
		if(izabrana != null) {
    		
            if((pr instanceof Hidroelektrana ) && !( izabrana instanceof VodenaPovrs)) {  //p mora da bude hidroelektrana da bi mogo da proizvodi 
   			 izabrana.promeniBojuPozadine(Color.RED);
   			 return;
   		 }
   			 
   		 if(izabrana instanceof Proizvodjac) {
   			 izabrana.promeniBojuPozadine(Color.RED);
   			 return;
   		 }
   		 
   		 int r=-1, k=-1;
   		 for(int i=0;i<redovi;i++){
			for(int j=0;j<kolone;j++) {
				if(resetka[i][j]==izabrana) {
					r=i;
					k=j;
				}
			 }
		 }
   		 p.remove(izabrana);
   		 izabrana =pr;
   		 resetka[r][k] = pr;
   		
   		 p.add(p,r*kolone+k );
   		 p.revalidate();
   	 }
		
	}
	
	public void zaustavi() { //zaustavlja rad svih proizvodjaca na placu
   	 for(int i=0; i<redovi; i++) {
   		 for(int j=0; j<kolone; j++) {
   			 if(resetka[i][j] instanceof Proizvodjac) {
   				Proizvodjac pr=(Proizvodjac) resetka[i][j];
   				pr.zaustavi();
   			 }
   		 }
   	 }
    }
}
