package controller;

import java.awt.Point;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.Cleaner;
import model.NormalField;
import view.CleanerView;
import view.Drawable;
import view.GamePanel;
import view.NormalFieldView;

/**
 * NormalField objektumokat létrehozó és törlõ osztály
 *
 */

public class NormalFieldFactory {
	
	/**
	 * létrehoz egy új NormalField-et majd visszaadja azt
	 * @param p
	 * @return
	 */
	
	public static NormalField create(Point p){
		NormalField nf=new NormalField(p);										//létrejön az új NormalField
		GamePanel.drawableViews.add(new NormalFieldView(nf));					//létrejön egy NormalFieldView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);								//rendezi a drawableViews-t
		return nf;																//visszaadja a NormalField-et
	}
	
	/**
	 * Törli a paraméterben átadott NormalField-et
	 * @param nf
	 */
	
	public static void remove(NormalField nf){
		for(int i=0;i<GamePanel.drawableViews.size();++i){						//végigmegy a listán és megkeresi az átadott NormalField-et
			if(GamePanel.drawableViews.get(i).equals(nf))
				GamePanel.drawableViews.remove(i);								//ha megtalálta törli
		}
	}
	
}
