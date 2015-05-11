package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Oil objektumokat és a hozzájuk tartozó OilView-kat
 * létrehozó és törlõ osztály
 *
 */

public class OilFactory {
	
	/**
	 * létrehoz egy új Oil-t a hozzá tartozó
	 * OilView-val együtt, az OilView-t
	 * belerakja a drawableViews listába,
	 * majd visszatér a létrehozott Oillal
	 * 
	 * @param p Olajfolt pozíciója
	 * @return A létrehozott Oil objektum
	 */
	
	public static Oil create(Point p){
		Oil oil=new Oil(p);												//létrejön az új Oil
		GamePanel.drawableViews.add(new OilView(oil));					//létrejön egy OilView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);						//rendezi a drawableViews-t
		return oil;														//visszaadja az Oilt
	}
	
	/**
	 * Törli a paraméterben átadott Oilhoz
	 * tartozó OilViewt a drawableViews listából
	 * 
	 * @param o Törölni kívánt OilView-hoz tartozó Oil referenciája
	 */
	
	public static void remove(Oil o){
		for(int i=0;i<GamePanel.drawableViews.size();++i){				//végigmegy a listán és megkeresi az átadott Oil-t
			if(GamePanel.drawableViews.get(i).equals(o))
				GamePanel.drawableViews.remove(i);						//ha megtalálta törli
		}
	}
	
}
