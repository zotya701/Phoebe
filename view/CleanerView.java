package view;

import java.awt.Graphics2D;

import model.Cleaner;

public class CleanerView implements Drawable{
	
	private final static int priority = 4;
	private Cleaner cleaner;
	
	public CleanerView(Cleaner c){
		cleaner=c;
	}
	
	@Override
	public void Draw(Graphics2D g2){
		g2.drawImage(View.imgOfCleaner,cleaner.getPosition().x*25,
				cleaner.getPosition().y*25,25,25,null);
	}
	
	@Override
	public int getPriority(){
		return priority;
	}
	
	public boolean equals(Object o){
		return this==o;
	}
	
	public int compareTo(Drawable d){
		return Integer.compare(CleanerView.priority,d.getPriority());
	}

}
