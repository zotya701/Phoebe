package view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import model.*;

public class RobotView implements Drawable{
	
	private BufferedImage imgForVelVec;
	private Point size;
	private final static int priority = 3;
	private Robot robot;
	
	public RobotView(Robot r, Point size){
	}
	
	public void Draw(Graphics2D g2){
	}
	
	public int getPriority(){
	}
	
	public BufferedImage getImgForVelVec(){
	}
	
	public boolean equals(Object o){
	}
	
	public int compareTo(Drawable d){
	}
	
}
