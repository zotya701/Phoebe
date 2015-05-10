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
 * Goo objektumokat létrehozó és törlõ osztály
 *
 */

public class GooFactory {
	
	/**
	 * létrehoz egy új Goo-t majd visszaadja azt
	 * @param p
	 * @return
	 */
	
	public static Goo create(Point p){
		Goo goo=new Goo(p);													//létrejön az új Goo
		GamePanel.drawableViews.add(new GooView(goo));						//létrejön egy GooView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return goo;															//visszaadja a Goo-t
	}
	
	/**
	 * Törli a paraméterben átadott Goo-t
	 * @param g
	 */
	
	public static void remove(Goo g){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//végigmegy a listán és megkeresi az átadott Goo-t
			if(GamePanel.drawableViews.get(i).equals(g))
				GamePanel.drawableViews.remove(i);							//ha megtalálta törli
		}
	}
	
}
