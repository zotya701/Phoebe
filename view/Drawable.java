package view;

import java.awt.Graphics2D;

/**
 * A kirajzolhat� oszt�lyokat fogja �ssze.
 */
public interface Drawable extends Comparable<Drawable>{
	
	/**
	 * Az objektum kirajzol�sa
	 * @param g2 A Graphics2D amivel rajzol
	 */
	public void Draw(Graphics2D g2);
	
	/**
	 * Ennek seg�ts�g�vel t�rt�nik a rendez�s a kirajzolhat� objektumokat t�rol� list�ban
	 * @return A priorit�s �rt�ke
	 */
	public int getPriority();
	
}
