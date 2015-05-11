package view;

import java.awt.Graphics2D;

/**
 * A kirajzolható osztályokat fogja össze.
 */
public interface Drawable extends Comparable<Drawable>{
	
	/**
	 * Az objektum kirajzolása
	 * @param g2 A Graphics2D amivel rajzol
	 */
	public void Draw(Graphics2D g2);
	
	/**
	 * Ennek segítségével történik a rendezés a kirajzolható objektumokat tároló listában
	 * @return A prioritás értéke
	 */
	public int getPriority();
	
}
