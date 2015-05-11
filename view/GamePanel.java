package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.*;


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
	 * Konstruktor, inicializ�lja a drawableviews
	 * �s robotViews list�kat.
	 */
	public GamePanel(){
		if(drawableViews==null) drawableViews = new ArrayList<Drawable>();
		if(robotViews==null) robotViews = new ArrayList<RobotView>();
	}
	
	/**
	 * V�gig iter�l a dravableViews list�n, �s mindegyikre megh�vja a draw met�dusukat,
	 * majd, ha v�get �rt a j�t�k, akkor ki �rja a robotok megtett t�vols�gait.
	 */
	public void updateGraphics(){
		g2.setColor(Color.BLACK);											//el�sz�r az eg�szet feket�re sz�nezi,
		g2.fillRect(0, 0, imageOfGame.getWidth(), imageOfGame.getWidth());	//mert k�l�n OutsideFieldView-t nem csin�ltunk
		for(int i=0;i<drawableViews.size();i++){
			drawableViews.get(i).Draw(g2);									//azt�n a rendez�s szerint sorban kirajzolja az elemeket
		}
		if(this.gm.gameEnded()){
			   this.g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			   g2.setColor(Color.RED);
			   for(int i=0;i<GameManager.robots.size();++i){				//ez itt sz�pen, form�zva jelen�ti meg a robotok megtett t�vols�gait
			    String temp=GameManager.robots.get(i).getId()+". Robot's travelled route:"+GameManager.robots.get(i).getRouteTravelled();
			          Rectangle2D r = fm.getStringBounds(temp, g2);
			          int x = (this.imageOfGame.getWidth() - (int) r.getWidth()) / 2;
			          int y = (this.imageOfGame.getHeight() - (int) r.getHeight()) / (GameManager.robots.size()+1)*(i+1) + fm.getAscent();
			          g2.drawString(temp, x, y);							//a megfelel� helyre rajzolja ki a stringet
			   }
			  }
		
	}
	
	/**
	 * Kirajzolja g drawImage met�dus�val az imageOfGame BufferedImage-et,
	 * majd ha m�g nem �rt v�get a j�t�k, akkor v�gig iter�l a robotViews list�n, 
	 * �s kirajzolja mindegyik robot sebess�gvektor�t tartalmaz� BufferedImage-et.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(gm!=null){
			g.drawImage(imageOfGame, 0, 0, imageOfGame.getWidth(), imageOfGame.getHeight(), null);	//c�lszer�bb csak egy k�pet kirajzolni, �s a k�pre rajzolni amikor sz�ks�ges 
			if(!gm.gameEnded()){
				for(RobotView rv : robotViews){
					g.drawImage(rv.getImgForVelVec(), 0, 0, gm.getMapSize().x*25, gm.getMapSize().y*25, null);
				}
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
		this.imageOfGame=new BufferedImage(gm.getMapSize().x*25, gm.getMapSize().y*25, BufferedImage.TYPE_INT_ARGB);
		this.g2=this.imageOfGame.createGraphics();
		this.g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.setPreferredSize(new Dimension(gm.getMapSize().x*25, gm.getMapSize().y*25));
		this.g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		this.fm = g2.getFontMetrics(new Font("TimesRoman", Font.PLAIN, 30));
	}
	
}
