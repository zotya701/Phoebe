package view;
import java.awt.Graphics2D;

public interface Drawable extends Comparable<Drawable>{
	
	public void Draw(Graphics2D g2);
	public int getPriority();
	
}
