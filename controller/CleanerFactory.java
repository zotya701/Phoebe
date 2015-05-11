package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Cleaner objektumokat és a hozzájuk tartozó CleanerView-kat
 * létrehozó és törlõ osztály
 */

public class CleanerFactory{
	
	/**
	 * létrehoz egy új Cleanert a hozzá tartozó
	 * CleanerView-val együtt, a CleanerView-t
	 * belerakja a drawableViews listába,
	 * majd visszatér a létrehozott Cleanerrel
	 *
	 * @param map Referencia a pályára
	 * @param p Cleaner pozíciója
	 * @return	A létrehozott Cleaner objektum
	 */
	
	public static Cleaner create(Map map, Point p){
		Cleaner cleaner=new Cleaner(map,p);							//létrejön az új Cleaner
		GamePanel.drawableViews.add(new CleanerView(cleaner));		//létrejön egy CleanerView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);					//rendezi a drawableViews-t
		return cleaner;												//visszaadja a Cleanert
	}
	
	/**
	 * Törli a paraméterben átadott Cleanerhez
	 * tartozó CleanerViewt a drawableViews listából
	 * 
	 * @param c Törölni kívánt CleanerView-hoz tartozó Cleaner referenciája
	 */
	
	public static void remove(Cleaner c){							
		for(int i=0;i<GamePanel.drawableViews.size();++i){			//végigmegy a listán és megkeresi az átadott Cleanert
			if(GamePanel.drawableViews.get(i).equals(c))
				GamePanel.drawableViews.remove(i);					//ha megtalálta törli
		}
	}
	
}
