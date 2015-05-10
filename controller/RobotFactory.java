package controller;

import java.awt.Point;
import java.util.Collections;
import java.util.Map;

import model.Cleaner;
import model.Robot;
import view.CleanerView;
import view.GamePanel;
import view.RobotView;

/**
 * Robot objektumokat l�trehoz� �s t�rl� oszt�ly
 *
 */

public class RobotFactory {
	
	/**
	 * l�trehoz egy �j Robotot majd visszaadja azt
	 *
	 * @param map
	 * @param p
	 * @param v
	 * @param size
	 * @return
	 */
	
	public static Robot create(Map map, Point p, Point v, Point size){
		Robot robot=new Robot(map,p,v);										//l�trej�n az �j Robot
		GamePanel.drawableViews.add(new RobotView(robot,size));				//l�trej�n egy RobotView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return robot;														//visszaadja a Robotot
	}
	
	/**
	 *  T�rli a param�terben �tadott Robotot
	 * @param r
	 */
	
	public static void remove(Robot r){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//v�gigmegy a list�n �s megkeresi az �tadott Robot-ot
			if(GamePanel.drawableViews.get(i).equals(r))
				GamePanel.drawableViews.remove(i);							//ha megtal�lta t�rli
		}
	}
	
}
