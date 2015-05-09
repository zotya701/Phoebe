package view;

public interface Drawable extends Comparable<Drawable>{
	
	public void Draw(Graphics2D g2);
	public int getPriority();
	
}
