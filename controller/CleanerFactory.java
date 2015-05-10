package controller;
import java.util.List;
import java.awt.Point;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import view.CleanerView;
import view.Drawable;
import view.GamePanel;
import model.Cleaner;

/**
 * Cleaner objektumokat létrehozó és törlõ osztály
 *
 */

public class CleanerFactory{
	
	/**
	 * létrehoz egy új Cleanert majd visszaadja azt
	 * @param map
	 * @param p
	 * @return
	 */
	
	public static Cleaner create(Map map, Point p){
		Cleaner cleaner=new Cleaner(map,p);							//létrejön az új Cleaner
		GamePanel.drawableViews.add(new CleanerView(cleaner));		//létrejön egy CleanerView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);					//rendezi a drawableViews-t
		return cleaner;												//visszaadja a Cleanert
	}
	
	/**
	 * Törli a paraméterben átadott Cleanert
	 * @param c
	 */
	
	public static void remove(Cleaner c){							
		for(int i=0;i<GamePanel.drawableViews.size();++i){			//végigmegy a listán és megkeresi az átadott Cleanert
			if(GamePanel.drawableViews.get(i).equals(c))
				GamePanel.drawableViews.remove(i);					//ha megtalálta törli
		}
	}
	
}
