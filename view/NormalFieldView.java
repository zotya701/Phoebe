package view;

import java.awt.Color;
import java.awt.Graphics2D;

import model.*;

/**
 * A hozzá tartozó NormalField grafikus megjelenítéséért felelõs osztály
 *
 */

public class NormalFieldView implements Drawable{
	
	private final static int priority = 0;
	private NormalField normalField;
	
	/**
	 * Konstruktor, beállítja a normalField attribútumot a kapott nf referenciára
	 * @param nf
	 */
	
	public NormalFieldView(NormalField nf){
		normalField=nf;
	}
	
	/**
	 * Kirajzolja a hozzá tartozó NormalField objektumot
	 */
	
	@Override
	public void Draw(Graphics2D g2){
		g2.setColor(Color.WHITE);														//kirajzol egy fehér négyzetet
		g2.fillRect(normalField.getPosition().x*25, normalField.getPosition().y*25, 25, 25);
		g2.setColor(Color.BLACK);														//rajzol a négyzet köré egy fekete keretet
		g2.drawRect(normalField.getPosition().x*25, normalField.getPosition().y*25, 25, 25);
	}
	
	
	/**
	 * Visszaadja a kirajzolási prioritást
	 */
	
	@Override
	public int getPriority(){
		return priority;
	}
	
	/**
	 * Igazzal tér vissza ha a kapott referencia megegyezik a normalField attribútummal
	 */
	
	public boolean equals(Object o){
		return normalField==o;
	}
	
	/**
	 * Összehasonlítja a kapott Drawable prioritását a sajátjával, majd visszaadja az eredményt
	 */
	
	public int compareTo(Drawable d){
		return Integer.valueOf(NormalFieldView.priority).compareTo(Integer.valueOf(d.getPriority()));
	}

}