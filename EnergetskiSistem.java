package lab32023;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {

	private Plac plac;
	private Baterija baterija;
	Button dugme;
	Choice izbor_za_dodavanje=new Choice();
	
	public EnergetskiSistem(int brred, int brkolona, int cap) {
		setSize(500, 500);
		plac=new Plac(brred, brkolona);
		baterija=new Baterija(cap);
		dugme=new Button("Dodaj");
		
		this.add(plac.p, BorderLayout.CENTER);
		//this.add(dugme, BorderLayout.NORTH);
		dodajSeverniDeo();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e ) {
				dispose();
			}
		});
		
		setResizable(false);
		setVisible(true);
		
	}
	
	public void dodajSeverniDeo() {
		Panel p1=new Panel();
		p1.add(dugme, BorderLayout.CENTER);
		//this.add(p1, BorderLayout.NORTH);
		
		izbor_za_dodavanje.add("Hidroelektrana");
		p1.add(izbor_za_dodavanje, BorderLayout.CENTER);
		this.add(p1, BorderLayout.NORTH);
		
		dugme.addActionListener((ae)->{
			plac.izaberiParcelu();
			
			if(izbor_za_dodavanje.getSelectedItem()=="Hidroelektrana") {
				plac.dodajProizvodjaca(new Hidroelektrana(baterija));
			}
		});

	}
	
	public static void main(String[] args) {
		new EnergetskiSistem(5, 5, 200);
	}

}
