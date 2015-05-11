package controller;

import java.awt.Point;
import java.util.Collections;

import model.*;
import view.*;

/**
 * NormalField objektumokat �s a hozz�juk tartoz� NormalFieldView-kat
 * l�trehoz� �s t�rl� oszt�ly
 */

public class NormalFieldFactory {
	
	/**
	 * l�trehoz egy �j NormalFieldet a hozz� tartoz�
	 * NormalFieldView-val egy�tt, a NormalFieldView-t
	 * belerakja a drawableViews list�ba,
	 * majd visszat�r a l�trehozott NormalField-el
	 * 
	 * @param p NormalField poz�ci�ja
	 * @return A l�trehozott NormalField objektum
	 */
	
	public static NormalField create(Point p){
		NormalField nf=new NormalField(p);										//l�trej�n az �j NormalField
		GamePanel.drawableViews.add(new NormalFieldView(nf));					//l�trej�n egy NormalFieldView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);								//rendezi a drawableViews-t
		return nf;																//visszaadja a NormalField-et
	}
	
	/**
	 * T�rli a param�terben �tadott NormalFieldhez
	 * tartoz� NormalFieldViewt a drawableViews list�b�l
	 * 
	 * @param nf T�r�lni k�v�nt NormalFieldView-hoz tartoz� NormalField referenci�ja
	 */
	
	public static void remove(NormalField nf){
		for(int i=0;i<GamePanel.drawableViews.size();++i){						//v�gigmegy a list�n �s megkeresi az �tadott NormalField-et
			if(GamePanel.drawableViews.get(i).equals(nf))
				GamePanel.drawableViews.remove(i);								//ha megtal�lta t�rli
		}
	}
	
}
