package view;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.GameManager;


 /**
  * A j�t�k p�ly�j�nak �s a zajl� j�t�knak a grafikus megjelen�t�se.
  */
public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1377560835838591524L;
	private GameManager gm;
	private BufferedImage imageOfGame;
	private Graphics2D g2;
	private FontMetrics fm;
	public static List<Drawable> drawableViews;
	public static List<RobotView> robotViews;
	
	/**
	 * Konstruktor, inicializ�lja a kett� list�t
	 */
	
	public GamePanel(){
		if(drawableViews==null) drawableViews = new ArrayList<Drawable>();
		if(robotViews==null) robotViews = new ArrayList<RobotView>();
		
	}
	
	/**
	 * V�gig iter�l a dravableViews adattagon, �s mindegyikre megh�vja a draw met�dusukat,
	 * majd, ha v�get �rt a j�t�k, akkor ki �rja a robotok megtett t�vols�gait.
	 */
	public void updateGraphics(){
		for(int i=0;i< drawableViews.size();i++){
			drawableViews.get(i).Draw(g2);	
		}
		
		if(this.gm.gameEnded()){
			   this.g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			   g2.setColor(Color.RED);
			   for(int i=0;i<GameManager.robots.size();++i){
			    String temp=GameManager.robots.get(i).getId()+". Robot's travelled route:"+GameManager.robots.get(i).getRouteTravelled();
			          Rectangle2D r = fm.getStringBounds(temp, g2);
			          int x = (this.imageOfGame.getWidth() - (int) r.getWidth()) / 2;
			          int y = (this.imageOfGame.getHeight() - (int) r.getHeight()) / (GameManager.robots.size()+1)*(i+1) + fm.getAscent();
			          g2.drawString(temp, x, y);
			   }
			  }
		
	}
	
	/**
	 * Kirajzolja g drawImage met�dus�val az imageOfGame BufferedImage-et,
	 * majd ha m�g nem �rt v�get a j�t�k, akkor v�gig iter�l a robotViews list�n, 
	 * �s kirajzolja mindegyik robot sebess�gvektor�t tartalmaz� BufferedImage-et.
	 */
	public void paintComponent(Graphics g){
		g.drawImage(this.imageOfGame,0,0,imageOfGame.getWidth(), imageOfGame.getHeight(), null);
		
		
		if(!this.gm.gameEnded()){
			for(int i=0; i<robotViews.size();i++){
				g.drawImage(robotViews.get(i).getImgForVelVec(),0, 0, gm.getMapSize().x*25, gm.getMapSize().y*25, null);
				
			}
			
			
			
			
		}
		
	}
	
/**
 *  Inicializ�lja a gm adattagot a kapott gm objektummal, 
 *  l�trehozza az imageOfGame adattag BufferedImage-�t a p�lya m�ret�nek megfelel�en, 
 *  g2 adattagot inicializ�lja imageOfGame createGraphics met�dus�val,
 *  a panel prefer�lt m�ret�t be�ll�tja a p�lya m�ret�nek megfelel�en.
 */
	public void init(GameManager gm){
		this.gm=gm;
		imageOfGame = new BufferedImage(gm.getMapSize().x*25, gm.getMapSize().y*25, BufferedImage.TYPE_INT_ARGB);		
		g2= imageOfGame.createGraphics();
	}
	
}
