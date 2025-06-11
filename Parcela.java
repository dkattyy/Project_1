package lab32023;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Parcela extends Label{

	protected boolean izabrana=false;
	
	public Parcela(char oznaka, Color b) {
		super(String.valueOf(oznaka));
		this.setBackground(b);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Serif", Font.BOLD, 14));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//izabrana parcela; parcela to prijavljuje RODITELJSKOM KONTEJNERU
//				if(getParent()!=null) {
//					getParent().dispatchEvent(new KliknutoNaParcelu(Parcela.this, e));
//				}
				izabrana=!izabrana;
			}
		});
	}
	
	
	//prilagodjeni dogadjaj koji se koristi za prijavu klika roditeljskom kontejneru
	public static class KliknutoNaParcelu extends MouseEvent{
		private final Parcela parcela;
		
		public KliknutoNaParcelu(Parcela izvor, MouseEvent originalEvent) {
            super(izvor, originalEvent.getID(), originalEvent.getWhen(), originalEvent.getModifiers(), originalEvent.getX(), originalEvent.getY(), originalEvent.getClickCount(), originalEvent.isPopupTrigger(), originalEvent.getButton());
			this.parcela=izvor;
		}
		
		public Parcela getParcela() {
			return parcela;
		}
	}
	
	public void izaberiParcelu() {
		izabrana=!izabrana;
	}
	
	public boolean jeIzabrana() {
		return izabrana;
	}
	
	public void promeniBojuPozadine(Color b) {
		this.setBackground(b);
	}
	
}
