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
 * NormalField objektumokat l�trehoz� �s t�rl� oszt�ly
 *
 */

public class NormalFieldFactory {
	
	/**
	 * l�trehoz egy �j NormalField-et majd visszaadja azt
	 * @param p
	 * @return
	 */
	
	public static NormalField create(Point p){
		NormalField nf=new NormalField(p);										//l�trej�n az �j NormalField
		GamePanel.drawableViews.add(new NormalFieldView(nf));					//l�trej�n egy NormalFieldView �s beker�l a drawableViews-ba a kirajzol�s �rdek�ben
		Collections.sort(GamePanel.drawableViews);								//rendezi a drawableViews-t
		return nf;																//visszaadja a NormalField-et
	}
	
	/**
	 * T�rli a param�terben �tadott NormalField-et
	 * @param nf
	 */
	
	public static void remove(NormalField nf){
		for(int i=0;i<GamePanel.drawableViews.size();++i){						//v�gigmegy a list�n �s megkeresi az �tadott NormalField-et
			if(GamePanel.drawableViews.get(i).equals(nf))
				GamePanel.drawableViews.remove(i);								//ha megtal�lta t�rli
		}
	}
	
}
