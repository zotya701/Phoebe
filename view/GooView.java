package view;

import java.awt.Color;
import java.awt.Graphics2D;

import model.Goo;

/**
 * A hozzá tartozó Goo grafikus megjelenítéséért felelõs.
 */

public class GooView implements Drawable{
	
	private final static int priority = 1;
	private Goo goo;
	
	/**
	 * Konstruktor, inicializálja a goo adattagot a kapott g objektummal.
	 */
	public GooView(Goo g){
		goo=g;
	}
	/**
	 * A goo adattag health adattagjának függvényében rajzol ki egy zöld kört a goo pozíciójának megfelelõ helyre.
	 */
	@Override
	public void Draw(Graphics2D g2){
		g2.setColor(Color.GREEN);
		int h=goo.getHealth();
		g2.fillOval(goo.getPosition().x*25+13-(int)(h*2.5), goo.getPosition().y*25+12-h*2, h*5, h*5);
		 
	}
	/**
	 * Visszatér a priority adattag értékével.
	 */
	@Override
	public int getPriority(){
		return priority;
	}
	
	
	/**
	 *  Igaz, ha o referenciája megegyezik gooéval, egyébként hamis.
	 */
	public boolean equals(Object o){
		return this==o;
	}
	
	/**
	 * Integer compareTo metódusával összehasonlítja a saját priority-jét a kapott objektum priority-jével.
	 */
	public int compareTo(Drawable d){
		return Integer.compare(GooView.priority,d.getPriority());
	}
	
}
