package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * NormalField objektumokat és a hozzájuk tartozó NormalFieldView-kat
 * létrehozó és törlõ osztály
 */

public class NormalFieldFactory {
	
	/**
	 * létrehoz egy új NormalFieldet a hozzá tartozó
	 * NormalFieldView-val együtt, a NormalFieldView-t
	 * belerakja a drawableViews listába,
	 * majd visszatér a létrehozott NormalField-el
	 * 
	 * @param p NormalField pozíciója
	 * @return A létrehozott NormalField objektum
	 */
	
	public static NormalField create(Point p){
		NormalField nf=new NormalField(p);										//létrejön az új NormalField
		GamePanel.drawableViews.add(new NormalFieldView(nf));					//létrejön egy NormalFieldView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);								//rendezi a drawableViews-t
		return nf;																//visszaadja a NormalField-et
	}
	
	/**
	 * Törli a paraméterben átadott NormalFieldhez
	 * tartozó NormalFieldViewt a drawableViews listából
	 * 
	 * @param nf Törölni kívánt NormalFieldView-hoz tartozó NormalField referenciája
	 */
	
	public static void remove(NormalField nf){
		for(int i=0;i<GamePanel.drawableViews.size();++i){						//végigmegy a listán és megkeresi az átadott NormalField-et
			if(GamePanel.drawableViews.get(i).equals(nf))
				GamePanel.drawableViews.remove(i);								//ha megtalálta törli
		}
	}
	
}
