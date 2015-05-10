package view;
import java.awt.Color;
import java.awt.Graphics2D;

import model.Oil;
/**
 * A hozzá tartozó Oil grafikus megjelenítéséért felelõs.
 */
public class OilView implements Drawable{
	
	private final static int priority = 2;
	private Oil oil;
	
	/**
	 *  Konstruktor, inicializálja az oil adattagot a kapott o objektummal.
	 */
	public OilView(Oil o){
		oil=o;
		
	}
	/**
	 * Az oil adattag health adattagjának függvényében rajzol ki egy fekete kört az oil pozíciójának megfelelõ helyre.
	 */
	public void Draw(Graphics2D g2){
		g2.setColor(Color.BLACK);
		int h=oil.getHealth();
		g2.fillOval(oil.getPosition().x*25+13-(int)(h*2.5), oil.getPosition().y*25+12-h*2, h*5, h*5);
	}
	/**
	 *  Visszatér a priority adattag értékével.
	 */
	public int getPriority(){
		return priority;
	}
	/**
	 * Igaz, ha o referenciája megegyezik oiléval, egyébként hamis.
	 */
	public boolean equals(Object o){
		return this==o;
	}
	/**
	 * Integer compareTo metódusával összehasonlítja a saját priority-jét a kapott objektum priority-jével.
	 */
	public int compareTo(Drawable d){
		return Integer.compare(OilView.priority,d.getPriority());
	}
	
}
