package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;
import controller.*;

/**
 * A program grafikus megjelen�t�s��rt felel�s oszt�ly.
 */
public class View extends JFrame{

	private static final long serialVersionUID = -7943582539078518219L;
	private Controller controller;
	private JPanel mainPanel;
	private JPanel startScreenPanel;
	private JPanel mapChoosingScreenPanel;
	private JPanel gameScreenPanel;
	private GamePanel gamePanel;
	private ControlPanel controlPanel;
	private JTextField txtLoadMap;
	private JButton btnNewGame;
	private JButton btnExit;
	public static BufferedImage imgOfRobot;
	public static BufferedImage imgOfCleaner;
	
	/**
	 * Konstruktor, inicializ�lja a controller adattagot a kapott c objektummal,
	 * inicializ�lja a t�bbi adattagot, be�ll�tja �ket a megfelel� helyre,
	 * �s be�ll�tja az esem�ny kezel�ket.
	 * 
	 * @param c
	 */
	public View(Controller c){
		
		try {
			View.imgOfRobot=ImageIO.read(this.getClass().getResource("/robot.png"));
			View.imgOfCleaner=ImageIO.read(this.getClass().getResource("/cleaner.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.controller=c;
		this.mainPanel=new JPanel();
		this.startScreenPanel=new JPanel();
		this.mapChoosingScreenPanel=new JPanel();
		this.gameScreenPanel=new JPanel();
		this.gamePanel=new GamePanel();
		this.controlPanel=new ControlPanel(c);
		this.txtLoadMap=new JTextField("Type the name of the map then hit enter!");
		this.btnNewGame=new JButton("NewGame");
		this.btnExit=new JButton("Exit");
		
		
		this.gameScreenPanel.setLayout(new BorderLayout());
		this.gameScreenPanel.add(this.gamePanel, BorderLayout.CENTER);
		this.gameScreenPanel.add(this.controlPanel, BorderLayout.EAST);
		
		this.btnNewGame.setFont(new Font("Arial", Font.PLAIN, 30));
		this.btnExit.setFont(new Font("Arial", Font.PLAIN, 30));
		JPanel innerPanel=new JPanel(new BorderLayout());
		innerPanel.setMaximumSize(new Dimension(400, 200));
		innerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		innerPanel.add(btnNewGame, BorderLayout.NORTH);
		innerPanel.add(btnExit, BorderLayout.SOUTH);
		this.startScreenPanel.setLayout(new BoxLayout(this.startScreenPanel, BoxLayout.PAGE_AXIS));
		this.startScreenPanel.add(Box.createVerticalGlue());
		this.startScreenPanel.add(innerPanel);
		this.startScreenPanel.add(Box.createVerticalGlue());
		
		this.txtLoadMap.setFont(new Font("Arial", Font.PLAIN, 30));
		this.txtLoadMap.setMaximumSize(new Dimension(540, 10));
		this.mapChoosingScreenPanel.setLayout(new BoxLayout(this.mapChoosingScreenPanel, BoxLayout.PAGE_AXIS));
		this.mapChoosingScreenPanel.add(Box.createVerticalGlue());
		this.mapChoosingScreenPanel.add(this.txtLoadMap);
		this.mapChoosingScreenPanel.add(Box.createVerticalGlue());
		
		this.mainPanel.setLayout(new CardLayout());
		mainPanel.add(startScreenPanel, "startScreen");
		mainPanel.add(mapChoosingScreenPanel, "mapChoosingScreenPanel");
		mainPanel.add(gameScreenPanel, "gameScreenPanel");
		
		this.add(this.mainPanel);
		
		this.setTitle("Phoebe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		//esem�nykezel�k
		this.btnNewGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.btnNewGameEventHandler();
			}
		});
		this.btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.btnExitEventHandler();
			}
		});
		this.txtLoadMap.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.txtLoadMapEventHandler(txtLoadMap.getText());
				txtLoadMap.setText("Type the name of the map then hit enter!");
			}
		});
		this.txtLoadMap.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				txtLoadMap.setText("");		//�gy belekattint�s ut�n r�gt�n �rhatjuk a p�lya nev�t, nem kell el�tte kit�r�lni a sz�veget
			}
		});
	}
	
	/**
	 * A f� panel cardlayoutot haszn�l, �s az ebben l�v�
	 * elemek k�z�l a k�vetkez�t mutatja
	 */
	public void showNextCard(){
		((CardLayout)this.mainPanel.getLayout()).next(this.mainPanel);
	}
	
	/**
	 * Megh�vja a gamePanel updateGraphics met�dus�t,�s a
	 * controlPanel update met�dus�t, majd �nmag�n a repaint met�dust
	 */
	public void update(){
		this.gamePanel.updateGraphics();
		this.controlPanel.update();
		this.repaint();
	}
	
	/**
	 * Megh�vja a gamePanel init met�dus�t a kapott gm objektummal,
	 * majd a controlPanel init met�dus�t a kapott objektummal,
	 * v�g�l �nmag�n a pack met�dust
	 * 
	 * @param gm
	 */
	public void init(GameManager gm){
		this.gamePanel.init(gm);
		this.controlPanel.init(gm);
		this.pack();
	}
	
}
