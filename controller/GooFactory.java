package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Goo objektumokat és a hozzájuk tartozó GooView-kat
 * létrehozó és törlõ osztály
 */

public class GooFactory {
	
	/**
	 * létrehoz egy új Goo-t a hozzá tartozó
	 * GooView-val együtt, a GooView-t
	 * belerakja a drawableViews listába,
	 * majd visszatér a létrehozott Gooval
	 * 
	 * @param p Ragacsfolt pozíciója
	 * @return A létrehozott Goo objektum
	 */
	
	public static Goo create(Point p){
		Goo goo=new Goo(p);													//létrejön az új Goo
		GamePanel.drawableViews.add(new GooView(goo));						//létrejön egy GooView és bekerül a drawableViews-ba a kirajzolás érdekében
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return goo;															//visszaadja a Goo-t
	}
	
	/**
	 * Törli a paraméterben átadott Goohoz
	 * tartozó GooViewt a drawableViews listából
	 * 
	 * @param g Törölni kívánt GooView-hoz tartozó Goo referenciája
	 */
	
	public static void remove(Goo g){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//végigmegy a listán és megkeresi az átadott Goo-t
			if(GamePanel.drawableViews.get(i).equals(g))
				GamePanel.drawableViews.remove(i);							//ha megtalálta törli
		}
	}
	
}
