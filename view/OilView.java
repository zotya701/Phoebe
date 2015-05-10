package view;
import java.awt.Color;
import java.awt.Graphics2D;

import model.Oil;
/**
 * A hozz� tartoz� Oil grafikus megjelen�t�s��rt felel�s.
 */
public class OilView implements Drawable{
	
	private final static int priority = 2;
	private Oil oil;
	
	/**
	 *  Konstruktor, inicializ�lja az oil adattagot a kapott o objektummal.
	 */
	public OilView(Oil o){
		oil=o;
		
	}
	/**
	 * Az oil adattag health adattagj�nak f�ggv�ny�ben rajzol ki egy fekete k�rt az oil poz�ci�j�nak megfelel� helyre.
	 */
	public void Draw(Graphics2D g2){
		g2.setColor(Color.BLACK);
		int h=oil.getHealth();
		g2.fillOval(oil.getPosition().x*25+13-(int)(h*2.5), oil.getPosition().y*25+12-h*2, h*5, h*5);
	}
	/**
	 *  Visszat�r a priority adattag �rt�k�vel.
	 */
	public int getPriority(){
		return priority;
	}
	/**
	 * Igaz, ha o referenci�ja megegyezik oil�val, egy�bk�nt hamis.
	 */
	public boolean equals(Object o){
		return this==o;
	}
	/**
	 * Integer compareTo met�dus�val �sszehasonl�tja a saj�t priority-j�t a kapott objektum priority-j�vel.
	 */
	public int compareTo(Drawable d){
		return Integer.compare(OilView.priority,d.getPriority());
	}
	
}
