package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Goo objektumokat �s a hozz�juk tartoz� GooView-kat
 * l�trehoz� �s t�rl� oszt�ly
 */

public class GooFactory {
	
	/**
	 * l�trehoz egy �j Goo-t a hozz� tartoz�
	 * GooView-val egy�tt, a GooView-t
	 * belerakja a drawableViews list�ba,
	 * majd visszat�r a l�trehozott Gooval
	 * 
	 * @param p Ragacsfolt poz�ci�ja
	 * @return A l�trehozott Goo objektum
	 */
	
	public static Goo create(Point p){
		Goo goo=new Goo(p);													//l�trej�n az �j Goo
		GamePanel.drawableViews.add(new GooView(goo));						//l�trej�n egy GooView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);							//rendezi a drawableViews-t
		return goo;															//visszaadja a Goo-t
	}
	
	/**
	 * T�rli a param�terben �tadott Goohoz
	 * tartoz� GooViewt a drawableViews list�b�l
	 * 
	 * @param g T�r�lni k�v�nt GooView-hoz tartoz� Goo referenci�ja
	 */
	
	public static void remove(Goo g){
		for(int i=0;i<GamePanel.drawableViews.size();++i){					//v�gigmegy a list�n �s megkeresi az �tadott Goo-t
			if(GamePanel.drawableViews.get(i).equals(g))
				GamePanel.drawableViews.remove(i);							//ha megtal�lta t�rli
		}
	}
	
}
