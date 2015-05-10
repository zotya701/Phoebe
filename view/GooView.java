package view;

import java.awt.Color;
import java.awt.Graphics2D;

import model.Goo;

/**
 * A hozz� tartoz� Goo grafikus megjelen�t�s��rt felel�s.
 */

public class GooView implements Drawable{
	
	private final static int priority = 1;
	private Goo goo;
	
	/**
	 * Konstruktor, inicializ�lja a goo adattagot a kapott g objektummal.
	 */
	public GooView(Goo g){
		goo=g;
	}
	/**
	 * A goo adattag health adattagj�nak f�ggv�ny�ben rajzol ki egy z�ld k�rt a goo poz�ci�j�nak megfelel� helyre.
	 */
	@Override
	public void Draw(Graphics2D g2){
		g2.setColor(Color.GREEN);
		int h=goo.getHealth();
		g2.fillOval(goo.getPosition().x*25+13-(int)(h*2.5), goo.getPosition().y*25+12-h*2, h*5, h*5);
		 
	}
	/**
	 * Visszat�r a priority adattag �rt�k�vel.
	 */
	@Override
	public int getPriority(){
		return priority;
	}
	
	
	/**
	 *  Igaz, ha o referenci�ja megegyezik goo�val, egy�bk�nt hamis.
	 */
	public boolean equals(Object o){
		return this==o;
	}
	
	/**
	 * Integer compareTo met�dus�val �sszehasonl�tja a saj�t priority-j�t a kapott objektum priority-j�vel.
	 */
	public int compareTo(Drawable d){
		return Integer.compare(GooView.priority,d.getPriority());
	}
	
}
