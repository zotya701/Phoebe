package controller;

import java.awt.Point;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.Cleaner;
import model.Goo;
import view.CleanerView;
import view.Drawable;
import view.GamePanel;
import view.GooView;

/**
 * Goo objektumokat l�trehoz� �s t�rl� oszt�ly
 *
 */

public class GooFactory {
	
	/**
	 * l�trehoz egy �j Goo-t majd visszaadja azt
	 * @param p
	 * @return
	 */
	
	public static Goo create(Point p){
		Goo goo=new Goo(p);													//l�trej�n az �j Goo
		GamePanel.drawableViews.add(new GooView(goo));						//l�trej�n egy GooView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return goo;															//visszaadja a Goo-t
	}
	
	/**
	 * T�rli a param�terben �tadott Goo-t
	 * @param g
	 */
	
	public static void remove(Goo g){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//v�gigmegy a list�n �s megkeresi az �tadott Goo-t
			if(GamePanel.drawableViews.get(i).equals(g))
				GamePanel.drawableViews.remove(i);							//ha megtal�lta t�rli
		}
	}
	
}
