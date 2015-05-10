package view;

import java.awt.Graphics2D;

import model.Cleaner;

/**
 * A hozzá tartozó Cleaner grafikus megjelenítésért felelős osztály
*/

public class CleanerView implements Drawable{
	
	private final static int priority = 4;
	private Cleaner cleaner;
	
	/**
	 * Konstruktor, beállítja a cleaner attribútumát a kapott Cleanerre
	*/
	
	public CleanerView(Cleaner c){
		cleaner=c;
	}
	
	/**
	 * Kirajzolja a hozzá tartozó Cleaner objektumot
	*/
	
	@Override
	public void Draw(Graphics2D g2){
		g2.drawImage(View.imgOfCleaner,cleaner.getPosition().x*25,
				cleaner.getPosition().y*25,25,25,null);
	}
	
	/**
	 * Visszaadja a kirajzolási prioritását
	*/
	
	@Override
	public int getPriority(){
		return priority;
	}
	
	/**
	 * Igazzal tér vissza, ha a kapott referencia megegyezik a cleaner attribútummal
	*/
	
	public boolean equals(Object o){
		return this==o;
	}
	
	/**
	 * Összehasonlítja a kapott Drawable és a saját prioritását majd visszaadja az eredményt
	*/
	
	public int compareTo(Drawable d){
		return Integer.compare(CleanerView.priority,d.getPriority());
	}

}
