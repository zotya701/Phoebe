package controller;

import java.awt.Point;

import model.GameManager;
import model.Robot;
import view.View;
import view.GamePanel;

/**
 * Az MVC modell-bõl a Controllert megvalósító osztály
 * @author zmarci
 *
 */

public class Controller {
	
	private GameManager gm;
	private View view;
	
	/**
	 * A Controller konstruktora
	 * létrehot egy új View objektumot és beállítja azt a view attribútumába
	 */
	
	public Controller(){
		view=new View(this);
	}
	
	/**
	 * Az Up gomb eseménykezelõ metódusa
	 */
	
	public void btnUpEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lekérdezi az aktuális játékos azonosítóját
		Robot robot=GameManager.robots.get(currentPlayer);		//elkéri az azonosítóhoz tartozó robotot
		robot.modifySpeed(new Point(0,-1));						//beállítja a robot sebességét
		view.update();											//majd frissíti a view-t
	}
	
	/**
	 * A Rigth gomb eseménykezelõ metódusa
	 */
	
	public void btnRightEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lekérdezi az aktuális játékos azonosítóját
		Robot robot=GameManager.robots.get(currentPlayer);		//elkéri az azonosítóhoz tartozó robotot
		robot.modifySpeed(new Point(1,0));						//beállítja a robot sebességét
		view.update();											//majd frissíti a view-t
	}
	
	/**
	 * A Down gomb eseménykezelõ metódusa
	 */
	
	public void btnDownEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lekérdezi az aktuális játékos azonosítóját
		Robot robot=GameManager.robots.get(currentPlayer);		//elkéri az azonosítóhoz tartozó robotot
		robot.modifySpeed(new Point(0,1));						//beállítja a robot sebességét
		view.update();											//majd frissíti a view-t
	}
	
	/**
	 * A Left gomb eseménykezelõ metódusa
	 */
	
	public void btnLeftEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lekérdezi az aktuális játékos azonosítóját
		Robot robot=GameManager.robots.get(currentPlayer);		//elkéri az azonosítóhoz tartozó robotot
		robot.modifySpeed(new Point(-1,0));						//beállítja a robot sebességét
		view.update();											//majd frissíti a view-t
		
	}
	
	/**
	 * A Jump gomb eseménykezelõ metódusa
	 */
	
	public void btnJumpEventHandler(){
		if(gm.gameEnded()){
			view.showNextCard();
		}
		else{												
			gm.step();											//egyébként folytatódik a játék a következõ lépéssel
			view.update();										//majd frissül a view
		}
	}
	
	/**
	 * A PlaceGoo gomb eseménykezelõ metódusa
	 */
	
	public void btnPlaceGooEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lekérdezi az aktuális játékos azonosítóját
		Robot robot=GameManager.robots.get(currentPlayer);		//elkéri az azonosítóhoz tartozó robotot
		robot.placeGoo();										//majd a robot lehelyezi a csapdát a saját mezõjére
	}
	
	/**
	 * A PlaceOil gomb eseménykezelõ metódusa
	 */
	
	public void btnPlaceOilEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lekérdezi az aktuális játékos azonosítóját
		Robot robot=GameManager.robots.get(currentPlayer);		//elkéri az azonosítóhoz tartozó robotot
		robot.placeOil();										//majd a robot lehelyezi a csapdát a saját mezõjére
	}
	
	/**
	 * Betölti a filename-ben megadott nevû map-et
	 */
	
	public void txtLoadMapEventHandler(String filename){
		gm.loadMap(filename);
	}
	
	/**
	 * A NewGame gomb eseménykezelõ metódusa
	 */
	
	public void btnNewGameEventHandler(){
		GamePanel.drawableViews.clear();
		GamePanel.robotViews.clear();
		view.showNextCard();
	}
	
	/**
	 * Az Exit gomb eseménykezelõ metódusa
	 * A System.exit(0) segítségével kilép az alkalmazásból
	 */
	
	public void btnExitEventHandler(){
		System.exit(0);
	}
	
	/**
	 *Az inicializáláshoz szükséges metódus
	 *Beállítja a gm attribútumot a játékhoz tartozó GameManager objektumra
	 */
	
	public void set(GameManager gm){
		this.gm=gm;
	}
	
}
