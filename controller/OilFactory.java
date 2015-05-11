package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * Oil objektumokat �s a hozz�juk tartoz� OilView-kat
 * l�trehoz� �s t�rl� oszt�ly
 *
 */

public class OilFactory {
	
	/**
	 * l�trehoz egy �j Oil-t a hozz� tartoz�
	 * OilView-val egy�tt, az OilView-t
	 * belerakja a drawableViews list�ba,
	 * majd visszat�r a l�trehozott Oillal
	 * 
	 * @param p Olajfolt poz�ci�ja
	 * @return A l�trehozott Oil objektum
	 */
	
	public static Oil create(Point p){
		Oil oil=new Oil(p);												//l�trej�n az �j Oil
		GamePanel.drawableViews.add(new OilView(oil));					//l�trej�n egy OilView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);						//rendezi a drawableViews-t
		return oil;														//visszaadja az Oilt
	}
	
	/**
	 * T�rli a param�terben �tadott Oilhoz
	 * tartoz� OilViewt a drawableViews list�b�l
	 * 
	 * @param o T�r�lni k�v�nt OilView-hoz tartoz� Oil referenci�ja
	 */
	
	public static void remove(Oil o){
		for(int i=0;i<GamePanel.drawableViews.size();++i){				//v�gigmegy a list�n �s megkeresi az �tadott Oil-t
			if(GamePanel.drawableViews.get(i).equals(o))
				GamePanel.drawableViews.remove(i);						//ha megtal�lta t�rli
		}
	}
	
}
