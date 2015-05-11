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
	 * Konstruktor, inicializálja a drawableviews
	 * és robotViews listákat.
	 */
	public GamePanel(){
		if(drawableViews==null) drawableViews = new ArrayList<Drawable>();
		if(robotViews==null) robotViews = new ArrayList<RobotView>();
	}
	
	/**
	 * Végig iterál a dravableViews listán, és mindegyikre meghívja a draw metódusukat,
	 * majd, ha véget ért a játék, akkor ki írja a robotok megtett távolságait.
	 */
	public void updateGraphics(){
		g2.setColor(Color.BLACK);											//elõszõr az egészet feketére színezi,
		g2.fillRect(0, 0, imageOfGame.getWidth(), imageOfGame.getWidth());	//mert külön OutsideFieldView-t nem csináltunk
		for(int i=0;i<drawableViews.size();i++){
			drawableViews.get(i).Draw(g2);									//aztán a rendezés szerint sorban kirajzolja az elemeket
		}
		if(this.gm.gameEnded()){
			   this.g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			   g2.setColor(Color.RED);
			   for(int i=0;i<GameManager.robots.size();++i){				//ez itt szépen, formázva jeleníti meg a robotok megtett távolságait
			    String temp=GameManager.robots.get(i).getId()+". Robot's travelled route:"+GameManager.robots.get(i).getRouteTravelled();
			          Rectangle2D r = fm.getStringBounds(temp, g2);
			          int x = (this.imageOfGame.getWidth() - (int) r.getWidth()) / 2;
			          int y = (this.imageOfGame.getHeight() - (int) r.getHeight()) / (GameManager.robots.size()+1)*(i+1) + fm.getAscent();
			          g2.drawString(temp, x, y);							//a megfelelõ helyre rajzolja ki a stringet
			   }
			  }
		
	}
	
	/**
	 * Kirajzolja g drawImage metódusával az imageOfGame BufferedImage-et,
	 * majd ha még nem ért véget a játék, akkor végig iterál a robotViews listán, 
	 * és kirajzolja mindegyik robot sebességvektorát tartalmazó BufferedImage-et.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(gm!=null){
			g.drawImage(imageOfGame, 0, 0, imageOfGame.getWidth(), imageOfGame.getHeight(), null);	//célszerûbb csak egy képet kirajzolni, és a képre rajzolni amikor szükséges 
			if(!gm.gameEnded()){
				for(RobotView rv : robotViews){
					g.drawImage(rv.getImgForVelVec(), 0, 0, gm.getMapSize().x*25, gm.getMapSize().y*25, null);
				}
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
		this.imageOfGame=new BufferedImage(gm.getMapSize().x*25, gm.getMapSize().y*25, BufferedImage.TYPE_INT_ARGB);
		this.g2=this.imageOfGame.createGraphics();
		this.g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.setPreferredSize(new Dimension(gm.getMapSize().x*25, gm.getMapSize().y*25));
		this.g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		this.fm = g2.getFontMetrics(new Font("TimesRoman", Font.PLAIN, 30));
	}
	
}
