package view;

import java.awt.Graphics2D;

import model.Goo;

public class GooView implements Drawable{
	
	private final static int priority = 1;
	private Goo goo;
	
	public GooView(Goo g){
		goo=g;
	}
	
	@Override
	public void Draw(Graphics2D g2){
	}
	
	@Override
	public int getPriority(){
		return priority;
	}
	
	public boolean equals(Object o){
		return this==o;
	}
	
	public int compareTo(Drawable d){
		return Integer.compare(GooView.priority,d.getPriority());
	}
	
}
