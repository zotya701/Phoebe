package controller;

import java.awt.Point;
import java.io.File;

import model.GameManager;
import model.Robot;
import view.View;
import view.GamePanel;

/**
 * Az MVC modell-b�l a Controllert megval�s�t� oszt�ly
 * @author zmarci
 *
 */

public class Controller {
	
	private GameManager gm;
	private View view;
	
	/**
	 * A Controller konstruktora
	 * l�trehoz egy �j View objektumot �s be�ll�tja azt a view attrib�tum�ba
	 */
	
	public Controller(){
		view=new View(this);
	}
	
	/**
	 * Az Up gomb esem�nykezel� met�dusa
	 */
	
	public void btnUpEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lek�rdezi az aktu�lis j�t�kos azonos�t�j�t
		Robot robot=GameManager.robots.get(currentPlayer);		//elk�ri az azonos�t�hoz tartoz� robotot
		robot.modifySpeed(new Point(0,-1));						//be�ll�tja a robot sebess�g�t
		view.update();											//majd friss�ti a view-t
	}
	
	/**
	 * A Rigth gomb esem�nykezel� met�dusa
	 */
	
	public void btnRightEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lek�rdezi az aktu�lis j�t�kos azonos�t�j�t
		Robot robot=GameManager.robots.get(currentPlayer);		//elk�ri az azonos�t�hoz tartoz� robotot
		robot.modifySpeed(new Point(1,0));						//be�ll�tja a robot sebess�g�t
		view.update();											//majd friss�ti a view-t
	}
	
	/**
	 * A Down gomb esem�nykezel� met�dusa
	 */
	
	public void btnDownEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lek�rdezi az aktu�lis j�t�kos azonos�t�j�t
		Robot robot=GameManager.robots.get(currentPlayer);		//elk�ri az azonos�t�hoz tartoz� robotot
		robot.modifySpeed(new Point(0,1));						//be�ll�tja a robot sebess�g�t
		view.update();											//majd friss�ti a view-t
	}
	
	/**
	 * A Left gomb esem�nykezel� met�dusa
	 */
	
	public void btnLeftEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lek�rdezi az aktu�lis j�t�kos azonos�t�j�t
		Robot robot=GameManager.robots.get(currentPlayer);		//elk�ri az azonos�t�hoz tartoz� robotot
		robot.modifySpeed(new Point(-1,0));						//be�ll�tja a robot sebess�g�t
		view.update();											//majd friss�ti a view-t
		
	}
	
	/**
	 * A Jump gomb esem�nykezel� met�dusa
	 */
	
	public void btnJumpEventHandler(){
		if(gm.gameEnded()){
			view.showNextCard();
		}
		else{												
			gm.step();											//egy�bk�nt folytat�dik a j�t�k a k�vetkez� l�p�ssel
			view.update();										//majd friss�l a view
		}
	}
	
	/**
	 * A PlaceGoo gomb esem�nykezel� met�dusa
	 */
	
	public void btnPlaceGooEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lek�rdezi az aktu�lis j�t�kos azonos�t�j�t
		Robot robot=GameManager.robots.get(currentPlayer);		//elk�ri az azonos�t�hoz tartoz� robotot
		robot.placeGoo();										//majd a robot lehelyezi a csapd�t a saj�t mez�j�re
		view.update();											//v�g�l friss�l a view
	}
	
	/**
	 * A PlaceOil gomb esem�nykezel� met�dusa
	 */
	
	public void btnPlaceOilEventHandler(){
		int currentPlayer=gm.getCurrentPlayer();				//lek�rdezi az aktu�lis j�t�kos azonos�t�j�t
		Robot robot=GameManager.robots.get(currentPlayer);		//elk�ri az azonos�t�hoz tartoz� robotot
		robot.placeOil();										//majd a robot lehelyezi a csapd�t a saj�t mez�j�re
		view.update();											//v�g�l friss�l a view
	}
	
	/**
	 * Bet�lti a filename-ben megadott nev� map-et
	 */
	
	public void txtLoadMapEventHandler(String filename){
		if(new File("maps/"+filename+".map").exists() && new File("maps/"+filename+".robots").exists()){
				this.gm.loadMap(filename);
				this.view.init(this.gm);
				this.view.showNextCard();
				this.view.update();
		}
	}
	
	/**
	 * A NewGame gomb esem�nykezel� met�dusa
	 */
	
	public void btnNewGameEventHandler(){
		GamePanel.drawableViews.clear();
		GamePanel.robotViews.clear();
		view.showNextCard();
	}
	
	/**
	 * Az Exit gomb esem�nykezel� met�dusa
	 * A System.exit(0) seg�ts�g�vel kil�p az alkalmaz�sb�l
	 */
	
	public void btnExitEventHandler(){
		System.exit(0);
	}
	
	/**
	 *Az inicializ�l�shoz sz�ks�ges met�dus
	 *Be�ll�tja a gm attrib�tumot a j�t�khoz tartoz� GameManager objektumra
	 */
	
	public void set(GameManager gm){
		this.gm=gm;
	}
	
}
