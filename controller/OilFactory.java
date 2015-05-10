package controller;

import java.awt.Point;
import java.util.Collections;

import model.Cleaner;
import model.Oil;
import view.CleanerView;
import view.GamePanel;
import view.OilView;

/**
 * Oil objektumokat létrehozó és törlõ osztály
 *
 */

public class OilFactory {
	
	/**
	 * létrehoz egy új Oil-t majd visszaadja azt
	 * @param p
	 * @return
	 */
	
	public static Oil create(Point p){
		Oil oil=new Oil(p);												//létrejön az új Oil
		GamePanel.drawableViews.add(new OilView(oil));					//létrejön egy OilView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);						//rendezi a drawableViews-t
		return oil;														//visszaadja a Robotot
	}
	
	/**
	 * Törli a paraméterben átadott Oil-t
	 * @param o
	 */
	
	public static void remove(Oil o){
		for(int i=0;i<GamePanel.drawableViews.size();++i){				//végigmegy a listán és megkeresi az átadott Oil-t
			if(GamePanel.drawableViews.get(i).equals(o))
				GamePanel.drawableViews.remove(i);						//ha megtalálta törli
		}
	}
	
}
