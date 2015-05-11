package view;

import java.awt.Color;
import java.awt.Graphics2D;

import model.*;

public class NormalFieldView implements Drawable{
	
	private final static int priority = 0;
	private NormalField normalField;
	
	public NormalFieldView(NormalField nf){
	}
	
	public void Draw(Graphics2D g2){
	}
	
	public int getPriority(){
	}
	
	public boolean equals(Object o){
		return normalField==o;
	}
	
	public int compareTo(Drawable d){
		return Integer.valueOf(NormalFieldView.priority).compareTo(Integer.valueOf(d.getPriority()));
	}
	
}
