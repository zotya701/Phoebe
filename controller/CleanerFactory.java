package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Cleaner objektumokat �s a hozz�juk tartoz� CleanerView-kat
 * l�trehoz� �s t�rl� oszt�ly
 */

public class CleanerFactory{
	
	/**
	 * l�trehoz egy �j Cleanert a hozz� tartoz�
	 * CleanerView-val egy�tt, a CleanerView-t
	 * belerakja a drawableViews list�ba,
	 * majd visszat�r a l�trehozott Cleanerrel
	 *
	 * @param map Referencia a p�ly�ra
	 * @param p Cleaner poz�ci�ja
	 * @return	A l�trehozott Cleaner objektum
	 */
	
	public static Cleaner create(Map map, Point p){
		Cleaner cleaner=new Cleaner(map,p);							//l�trej�n az �j Cleaner
		GamePanel.drawableViews.add(new CleanerView(cleaner));		//l�trej�n egy CleanerView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);					//rendezi a drawableViews-t
		return cleaner;												//visszaadja a Cleanert
	}
	
	/**
	 * T�rli a param�terben �tadott Cleanerhez
	 * tartoz� CleanerViewt a drawableViews list�b�l
	 * 
	 * @param c T�r�lni k�v�nt CleanerView-hoz tartoz� Cleaner referenci�ja
	 */
	
	public static void remove(Cleaner c){							
		for(int i=0;i<GamePanel.drawableViews.size();++i){			//v�gigmegy a list�n �s megkeresi az �tadott Cleanert
			if(GamePanel.drawableViews.get(i).equals(c))
				GamePanel.drawableViews.remove(i);					//ha megtal�lta t�rli
		}
	}
	
}
