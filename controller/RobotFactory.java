package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Robot objektumokat és a hozzájuk tartozó RobotViewokat
 * létrehozó és törlõ osztály
 */

public class RobotFactory {
	
	/**
	 * létrehoz egy új Robotot a hozzá tartozó
	 * RobotView-val együtt, a RobotView-t
	 * belerakja a drawableViews és robotViews
	 * listákba, majd visszatér a létrehozott Robottal
	 *
	 * @param map Referencia a pályára
	 * @param p Robot pozíciója
	 * @param v	Robot sebességvektora
	 * @return	A létrehozott Robot objektum
	 */
	
	public static Robot create(Map map, Point p, Point v){
		Robot robot=new Robot(map,p,v);										//létrejön az új Robot
		RobotView rv=new RobotView(robot, new Point(map.getSize()));		//létrejön egy RobotView
		GamePanel.drawableViews.add(rv);									//bekerül a drawableViews-ba a kirajzolás érdekében
		GamePanel.robotViews.add(rv);										//bekerül a robotViews-ba a sebesség kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return robot;														//visszaadja a Robotot
	}
	
	/**
	 *  Törli a paraméterben átadott Robothoz
	 *  tartozó RobotViewt a drawableViews és
	 *  robotViews listákból
	 *  
	 * @param r Törölni kívánt robotView-hoz tartozó Robot referenciája
	 */
	
	public static void remove(Robot r){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//végigmegy a listán és megkeresi az átadott Robot-ot
			if(GamePanel.drawableViews.get(i).equals(r))
				GamePanel.drawableViews.remove(i);							//ha megtalálta törli
		}
		for(int i=0;i<GamePanel.robotViews.size();++i){						//végigmegy a listán és megkeresi az átadott Robot-ot
			if(GamePanel.robotViews.get(i).equals(r))
				GamePanel.robotViews.remove(i);								//ha megtalálta törli
		}
	}
	
}
