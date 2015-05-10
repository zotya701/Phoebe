package controller;

import java.awt.Point;
import java.util.Collections;

import model.Cleaner;
import model.Oil;
import view.CleanerView;
import view.GamePanel;
import view.OilView;

/**
 * Oil objektumokat l�trehoz� �s t�rl� oszt�ly
 *
 */

public class OilFactory {
	
	/**
	 * l�trehoz egy �j Oil-t majd visszaadja azt
	 * @param p
	 * @return
	 */
	
	public static Oil create(Point p){
		Oil oil=new Oil(p);												//l�trej�n az �j Oil
		GamePanel.drawableViews.add(new OilView(oil));					//l�trej�n egy OilView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);						//rendezi a drawableViews-t
		return oil;														//visszaadja a Robotot
	}
	
	/**
	 * T�rli a param�terben �tadott Oil-t
	 * @param o
	 */
	
	public static void remove(Oil o){
		for(int i=0;i<GamePanel.drawableViews.size();++i){				//v�gigmegy a list�n �s megkeresi az �tadott Oil-t
			if(GamePanel.drawableViews.get(i).equals(o))
				GamePanel.drawableViews.remove(i);						//ha megtal�lta t�rli
		}
	}
	
}
