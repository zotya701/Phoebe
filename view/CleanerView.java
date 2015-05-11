package view;

import java.awt.Graphics2D;

import model.Cleaner;

/**
 * A hozz� tartoz� Cleaner grafikus megjelen�t�s��rt felel�s oszt�ly
*/

public class CleanerView implements Drawable{
	
	private final static int priority = 4;
	private Cleaner cleaner;
	
	/**
	 * Konstruktor, be�ll�tja a cleaner attrib�tum�t a kapott Cleanerre
	*/
	
	public CleanerView(Cleaner c){
		cleaner=c;
	}
	
	/**
	 * Kirajzolja a hozz� tartoz� Cleaner objektumot
	*/
	
	@Override
	public void Draw(Graphics2D g2){
		g2.drawImage(View.imgOfCleaner, cleaner.getPosition().x*25, cleaner.getPosition().y*25+10, 10, 10, null);
	}
	
	/**
	 * Visszaadja a kirajzol�si priorit�s�t
	*/
	
	@Override
	public int getPriority(){
		return priority;
	}
	
	/**
	 * Igazzal t�r vissza, ha a kapott referencia megegyezik a cleaner attrib�tummal
	*/
	
	public boolean equals(Object o){
		return cleaner==o;
	}
	
	/**
	 * �sszehasonl�tja a kapott Drawable �s a saj�t priorit�s�t, majd visszaadja az eredm�nyt
	*/
	
	public int compareTo(Drawable d){
		return Integer.valueOf(CleanerView.priority).compareTo(Integer.valueOf(d.getPriority()));
	}

}
