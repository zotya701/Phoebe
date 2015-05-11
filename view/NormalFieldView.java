package view;

import java.awt.Color;
import java.awt.Graphics2D;

import model.*;

/**
 * A hozz� tartoz� NormalField grafikus megjelen�t�s��rt felel�s oszt�ly
 *
 */

public class NormalFieldView implements Drawable{
	
	private final static int priority = 0;
	private NormalField normalField;
	
	/**
	 * Konstruktor, be�ll�tja a normalField attrib�tumot a kapott nf referenci�ra
	 * @param nf
	 */
	
	public NormalFieldView(NormalField nf){
		normalField=nf;
	}
	
	/**
	 * Kirajzolja a hozz� tartoz� NormalField objektumot
	 */
	
	@Override
	public void Draw(Graphics2D g2){
		g2.setColor(Color.WHITE);														//kirajzol egy feh�r n�gyzetet
		g2.fillRect(normalField.getPosition().x*25, normalField.getPosition().y*25, 25, 25);
		g2.setColor(Color.BLACK);														//rajzol a n�gyzet k�r� egy fekete keretet
		g2.drawRect(normalField.getPosition().x*25, normalField.getPosition().y*25, 25, 25);
	}
	
	
	/**
	 * Visszaadja a kirajzol�si priorit�st
	 */
	
	@Override
	public int getPriority(){
		return priority;
	}
	
	/**
	 * Igazzal t�r vissza ha a kapott referencia megegyezik a normalField attrib�tummal
	 */
	
	public boolean equals(Object o){
		return normalField==o;
	}
	
	/**
	 * �sszehasonl�tja a kapott Drawable priorit�s�t a saj�tj�val, majd visszaadja az eredm�nyt
	 */
	
	public int compareTo(Drawable d){
		return Integer.valueOf(NormalFieldView.priority).compareTo(Integer.valueOf(d.getPriority()));
	}

}