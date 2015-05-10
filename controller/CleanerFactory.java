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
 * Cleaner objektumokat l�trehoz� �s t�rl� oszt�ly
 *
 */

public class CleanerFactory{
	
	/**
	 * l�trehoz egy �j Cleanert majd visszaadja azt
	 * @param map
	 * @param p
	 * @return
	 */
	
	public static Cleaner create(Map map, Point p){
		Cleaner cleaner=new Cleaner(map,p);							//l�trej�n az �j Cleaner
		GamePanel.drawableViews.add(new CleanerView(cleaner));		//l�trej�n egy CleanerView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);					//rendezi a drawableViews-t
		return cleaner;												//visszaadja a Cleanert
	}
	
	/**
	 * T�rli a param�terben �tadott Cleanert
	 * @param c
	 */
	
	public static void remove(Cleaner c){							
		for(int i=0;i<GamePanel.drawableViews.size();++i){			//v�gigmegy a list�n �s megkeresi az �tadott Cleanert
			if(GamePanel.drawableViews.get(i).equals(c))
				GamePanel.drawableViews.remove(i);					//ha megtal�lta t�rli
		}
	}
	
}
