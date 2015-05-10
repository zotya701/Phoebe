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
 * Robot objektumokat létrehozó és törlõ osztály
 *
 */

public class RobotFactory {
	
	/**
	 * létrehoz egy új Robotot majd visszaadja azt
	 *
	 * @param map
	 * @param p
	 * @param v
	 * @param size
	 * @return
	 */
	
	public static Robot create(Map map, Point p, Point v, Point size){
		Robot robot=new Robot(map,p,v);										//létrejön az új Robot
		GamePanel.drawableViews.add(new RobotView(robot,size));				//létrejön egy RobotView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return robot;														//visszaadja a Robotot
	}
	
	/**
	 *  Törli a paraméterben átadott Robotot
	 * @param r
	 */
	
	public static void remove(Robot r){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//végigmegy a listán és megkeresi az átadott Robot-ot
			if(GamePanel.drawableViews.get(i).equals(r))
				GamePanel.drawableViews.remove(i);							//ha megtalálta törli
		}
	}
	
}
