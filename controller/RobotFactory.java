package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Robot objektumokat �s a hozz�juk tartoz� RobotViewokat
 * l�trehoz� �s t�rl� oszt�ly
 */

public class RobotFactory {
	
	/**
	 * l�trehoz egy �j Robotot a hozz� tartoz�
	 * RobotView-val egy�tt, a RobotView-t
	 * belerakja a drawableViews �s robotViews
	 * list�kba, majd visszat�r a l�trehozott Robottal
	 *
	 * @param map Referencia a p�ly�ra
	 * @param p Robot poz�ci�ja
	 * @param v	Robot sebess�gvektora
	 * @return	A l�trehozott Robot objektum
	 */
	
	public static Robot create(Map map, Point p, Point v){
		Robot robot=new Robot(map,p,v);										//l�trej�n az �j Robot
		RobotView rv=new RobotView(robot, new Point(map.getSize()));		//l�trej�n egy RobotView
		GamePanel.drawableViews.add(rv);									//beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		GamePanel.robotViews.add(rv);										//beker�l a robotViews-ba a sebess�g kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return robot;														//visszaadja a Robotot
	}
	
	/**
	 *  T�rli a param�terben �tadott Robothoz
	 *  tartoz� RobotViewt a drawableViews �s
	 *  robotViews list�kb�l
	 *  
	 * @param r T�r�lni k�v�nt robotView-hoz tartoz� Robot referenci�ja
	 */
	
	public static void remove(Robot r){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//v�gigmegy a list�n �s megkeresi az �tadott Robot-ot
			if(GamePanel.drawableViews.get(i).equals(r))
				GamePanel.drawableViews.remove(i);							//ha megtal�lta t�rli
		}
		for(int i=0;i<GamePanel.robotViews.size();++i){						//v�gigmegy a list�n �s megkeresi az �tadott Robot-ot
			if(GamePanel.robotViews.get(i).equals(r))
				GamePanel.robotViews.remove(i);								//ha megtal�lta t�rli
		}
	}
	
}
