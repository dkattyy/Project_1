package lab32023;

import java.awt.Color;
import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable {

	protected int osnovnoVreme;
	protected Baterija baterija;
	protected boolean radi=false;
	protected Thread nit=new Thread();
	
	protected boolean proizveo_uspesno=false;
	
	public Proizvodjac(char oznaka, Color b, int oVreme, Baterija bat) {
		super(oznaka, b);
		osnovnoVreme=oVreme;
		baterija=bat;
		nit.start();
	}
	
	public int ukupnoVremeProizvodnje() {
		Random r=new Random();
		int br=0+r.nextInt(300);
		int uk=osnovnoVreme+br;
		return uk;
	}

	public synchronized void pokreni() {
		radi=true;
		notify();
	}
	
	public synchronized void zaustavi() {
	   if(nit!=null) {
		   radi=false;
		   nit.interrupt();
	   }
	}
	
	@Override
	public void run() {
		try {
			while(!nit.interrupted()) {
				synchronized(this) {
					while(!radi) wait();
				}
				
				Thread.sleep(ukupnoVremeProizvodnje());

				proizvediEnergiju();
				
				if(proizveo_uspesno) {
					this.setForeground(Color.RED);
				}
				
				Thread.sleep(300);
			}
			
		}catch(InterruptedException e) {}
	}

	public abstract void proizvediEnergiju();

}
