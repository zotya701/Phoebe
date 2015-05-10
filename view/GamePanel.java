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
  * A játék pályájának és a zajló játéknak a grafikus megjelenítése.
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
	 * Konstruktor, inicializálja a kettõ listát
	 */
	
	public GamePanel(){
		if(drawableViews==null) drawableViews = new ArrayList<Drawable>();
		if(robotViews==null) robotViews = new ArrayList<RobotView>();
		
	}
	
	/**
	 * Végig iterál a dravableViews adattagon, és mindegyikre meghívja a draw metódusukat,
	 * majd, ha véget ért a játék, akkor ki írja a robotok megtett távolságait.
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
	 * Kirajzolja g drawImage metódusával az imageOfGame BufferedImage-et,
	 * majd ha még nem ért véget a játék, akkor végig iterál a robotViews listán, 
	 * és kirajzolja mindegyik robot sebességvektorát tartalmazó BufferedImage-et.
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
 *  Inicializálja a gm adattagot a kapott gm objektummal, 
 *  létrehozza az imageOfGame adattag BufferedImage-ét a pálya méretének megfelelõen, 
 *  g2 adattagot inicializálja imageOfGame createGraphics metódusával,
 *  a panel preferált méretét beállítja a pálya méretének megfelelõen.
 */
	public void init(GameManager gm){
		this.gm=gm;
		imageOfGame = new BufferedImage(gm.getMapSize().x*25, gm.getMapSize().y*25, BufferedImage.TYPE_INT_ARGB);		
		g2= imageOfGame.createGraphics();
	}
	
}
