package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.*;

/**
 * A programot ir�ny�t� oszt�ly, felel�ss�gei:
 * P�lya/robotok inicializ�l�sa, j�t�k ind�t�sa,
 * j�t�kosok/robotok l�ptet�se, j�t�k v�ge, 
 * kommunik�ci� a felhaszn�l�i fel�lettel.
 */
public class GameManager {
	
//priv�t adattagok kezdete
	/**
	 * Referencia a p�ly�ra
	 */
	private Map map;

	/**
	 *  Sz�mon tartja �pp melyik j�t�kos van a soron.
	 */
	private int currentPlayer;

	/**
	 * Sz�mon tartja �pp melyik k�rben vannak a j�t�kosok.
	 */
	private int round;
	
	/**
	 * 
	 */
	private boolean gameEnded;
//priv�t adattagok v�ge

//statikus adattagok kezdete
	/**
	 * Lista a p�ly�n l�v� olajokr�l
	 */
	public static List<Oil> oilList			=	new ArrayList<Oil>();

	/**
	 * Lista a p�ly�n l�v� csapd�kr�l
	 */
	public static List<Trap> trapList		=	new ArrayList<Trap>();
	
	/**
	 * Lista a p�ly�n l�v� robotokr�l
	 */
	public static List<Robot> robots		=	new ArrayList<Robot>(4);
	
	/**
	 * Lista a p�ly�n l�v� kisrobotokr�l
	 */
	public static List<Cleaner> cleaners	=	new ArrayList<Cleaner>();
	
	/**
	 * 
	 */
	public static Controller controller;
//statikus adattagok v�ge
	
//publikus met�dusok kezdete
	/**
	 * Konstruktor. Inicializ�lja az attrib�tumokat.
	 */
	public GameManager(Controller c){
		this.currentPlayer		=	0;
		this.round				=	1;
		this.map				=	null;
		this.gameEnded			=	false;
		GameManager.controller=c;
	}

	/**
	 * Bet�lti a p�ly�t egy f�jlb�l, �s l�trehozza a robotokat.
	 * @param filename A f�jl neve amiben a p�lya van.
	 */
	public void loadMap(String filename){
		try {
			if(new File("maps/"+filename+".map").exists()){											//akkor t�ltse be az adatokat ha van honnan
				this.map		=	new Map("maps/"+filename+".map");								//l�trehoz egy p�ly�t a filename nev� f�jlb�l
				File robotsFile	=	new File("maps/"+filename+".robots");
				if(robotsFile.exists()){													//ha l�tezik a robotok adatait tartalmaz� f�jl
					Robot.statid=0;															//�j bet�lt�sn�l megint null�r�l induljon
					GameManager.robots.clear();												//ez sem �rt, ha ki�r�tj�k m�s robotok bet�lt�se el�tt
					this.currentPlayer=0;
					this.round=1;
					GameManager.cleaners.clear();											//szint�n
					BufferedReader BR	=	new BufferedReader(new FileReader(robotsFile));
				    while(BR.ready()){														//am�g van adat a robotok adatait tartalmaz� f�jlban
				    	String[] p=BR.readLine().split("\\s+");								//feldarabolja a beolvasott stringet space-enk�nt
				    	if(p.length>=4){													//robotok konstruktor�ban mapon k�v�l m�g kell 2 pont, ez�rt a legal�bb 4
				    		int x1,x2,y1,y2;
				    		x1=Integer.parseInt(p[0]);
				    		y1=Integer.parseInt(p[1]);
				    		x2=Integer.parseInt(p[2]);
				    		y2=Integer.parseInt(p[3]);
				    		//GameManager.robots.add(new Robot(this.map, new Point(x1, y1), new Point(x2, y2)));
				    		GameManager.robots.add(RobotFactory.create(this.map, new Point(x1, y1), new Point(x2, y2)));
				    	}
				    }
				    BR.close();
				}
				this.gameEnded=false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Elind�tja a j�t�kot.
	 */
	/*
	public void start(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){												//v�gtelen ciklusban olvassa a felhaszn�l� inputjait, ha exitet ad, kil�p az eg�sz programb�l
			String command="";
			String[] splittedCommand;								//n�h�ny parancs t�bb param�terb�l �ll, ilyenkor feladaraboljuk �s ebbe a v�ltoz�ba tessz�k �ket
			try {
				command=br.readLine();
	//loadMap
				if(command.contains("loadMap")){					//ha tartalmazza a parancs a loadMap stringet
					splittedCommand=command.split("\\s+");			//feldarabolja a stringet space-enk�nt
					if(splittedCommand.length>=2){					//ha legal�b 2 r�sz string maradt
						String filename	=	splittedCommand[1];		//a param�ter�l kapott f�jln�v
						if(new File(filename).exists()){			//akkor t�ltse be az adatokat ha van honnan
							GameManager.cleaners.clear();			//�r�ti a takar�t�robotok list�j�t
							this.map	=	new Map(filename);		//bet�lt egy p�ly�t a loadMap param�ter��l kapott f�jlb�l
						}
					}
				}
	//loadRobots
				else if(command.contains("loadRobots")){
					splittedCommand=command.split("\\s+");
					if(splittedCommand.length>=2){
						File robotsFile=new File(splittedCommand[1]);
						if(robotsFile.exists()){													//ha l�tezik a robotok adatait tartalmaz� f�jl
							Robot.statid=0;															//nem �rt null�zni
							GameManager.robots.clear();												//ezt sem �rt �r�teni
							BufferedReader BR = new BufferedReader(new FileReader(robotsFile));
						    while(BR.ready()){														//am�g van adat a robotok adatait tartalmaz� f�jlban
						    	String[] p=BR.readLine().split("\\s+");								//feldarabolja a beolvasott stringet space-enk�nt
						    	if(p.length>=4){													//legal�bb 4 kell
						    		int x1,x2,y1,y2;
						    		x1=Integer.parseInt(p[0]);
						    		y1=Integer.parseInt(p[1]);
						    		x2=Integer.parseInt(p[2]);
						    		y2=Integer.parseInt(p[3]);
						    		//GameManager.robots.add(new Robot(this.map, new Point(x1, y1), new Point(x2, y2)));
						    		//GameManager.robots.add(RobotFactory.create(this.map, new Point(x1, y1), new Point(x2, y2)));
						    	}
						    }
						    BR.close();
						}
					}
				}
	//step
				else if(command.contains("step")){
					splittedCommand=command.split("\\s+");
					if(splittedCommand.length>=2){
						int i=Integer.parseInt(splittedCommand[1]);			//h�ny k�r teljen el
						for(int a=0;a<i;++a){
							Cleaner[] cleanersArr=GameManager.cleaners.toArray(new Cleaner[GameManager.cleaners.size()]);
							for(int j=0;j<cleanersArr.length;++j){			//l�pteti a takar�t�robotokat
								cleanersArr[j].move();
							}
							Oil[] oils=GameManager.oilList.toArray(new Oil[GameManager.oilList.size()]);
							for(int j=0;j<oils.length;++j){					//mindegyik olajfolt "�let�t" cs�kkenti egyel
								oils[j].roundElapsed();
							}
							if(round%10==0){								//minden 10. k�rben tiszt�t�robotok jutnak be a p�ly�ra bal sz�lr�l
								for(int y=4;y<this.map.getSize().y;y=y+10){	//a megadott helyekre
									if(GameManager.cleaners.size()<10){		//de 10n�l t�bb egyszerre nem lehet a p�ly�n
										//GameManager.cleaners.add(new Cleaner(this.map, new Point(0, y)));
										GameManager.cleaners.add(CleanerFactory.create(this.map, new Point(0, y)));
									}
								}
							}
							int robotsAlive=0;
							for(Robot r : GameManager.robots){				//megsz�molja h�ny robot "�l" m�g
								if(r.isAlive()){
									robotsAlive=robotsAlive+1;
								}
							}
							round=round+1;
							if((round>20 || robotsAlive<=1) && GameManager.robots.size()>=2 ){		//ha csak 1 robot �l, vagy v�ge a j�t�knak (eltelt 20 k�r)
								this.end();
							}
						}
					}
				}
	//jump
				else if(command.contains("jump")){
					splittedCommand=command.split("\\s+");
					if(splittedCommand.length>=4){
						int id		=	Integer.parseInt(splittedCommand[1]);
						int x		=	Integer.parseInt(splittedCommand[2]);
						int y		=	Integer.parseInt(splittedCommand[3]);
						if(id>=0 && id<GameManager.robots.size())
							GameManager.robots.get(id).jump();		//id.-edik robotot ugratja, az (x,y) m�dos�t� sebess�g vektorral
					}
				}
	//placeTrap
				else if(command.contains("placeTrap")){
					splittedCommand=command.split("\\s+");
					if(splittedCommand.length>=3){
						int id		=	Integer.parseInt(splittedCommand[1]);
						int type	=	Integer.parseInt(splittedCommand[2]);
						if(id>=0 && id<GameManager.robots.size()){					//id.edik robot lerak egy csapd�t, a type-nak megfelel�en 1-ragacs, 2-olaj
							if(type==1){
								GameManager.robots.get(id).placeGoo();
							}
							else if(type==2){
								GameManager.robots.get(id).placeOil();
							}
						}
					}
				}
	//addCleaner
				else if(command.contains("addCleaner")){
					splittedCommand=command.split("\\s+");
					if(splittedCommand.length>=3){
						int x	=	Integer.parseInt(splittedCommand[1]);
						int y	=	Integer.parseInt(splittedCommand[2]);
						GameManager.cleaners.add(new Cleaner(this.map, new Point(x, y)));		//hozz�ad egy takar�t�robotot az (x,y) koordin�t�j� helyre
					}
				}
	//exit
				else if(command.equals("exit")){
					br.close();
					System.exit(0);		//kil�p :D
				}
	//showMap
				else if(command.equals("showMap")){
					this.map.Print();	//konzolon megjelen�ti a mapot, de csak a mez�k t�pus�t 0-norm�l mez�, #-�rok
				}
	//listTraps
				else if(command.equals("listTraps")){
					for(Trap trap : GameManager.trapList)	//konzolra kilist�zza a csapd�kat
						trap.Print();
				}
	//listRobots
				else if(command.equals("listRobots")){
					for(Robot robot : GameManager.robots)	//konzolra kilist�zza a robotokat
						robot.Print();
				}
	//listCleaners
				else if(command.equals("listCleaners")){
					for(Cleaner cleaner : cleaners)			//konzolra kilist�zza a takar�t�robotokat
						cleaner.Print();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	*/
	
	/**
	 * Minden h�v�sra a k�vetkez� j�t�kos robotja ugrik.
	 */
	public void step(){
		if(map!=null){
			GameManager.robots.get(currentPlayer).jump();
			GameManager.robots.get(currentPlayer).isCurrent(false);
			currentPlayer	=	currentPlayer+1;
			while(currentPlayer<robots.size() && !robots.get(currentPlayer).isAlive()){
				currentPlayer	=	currentPlayer+1;
			}
			if(currentPlayer==GameManager.robots.size()){
				Cleaner[] cleanersArr=GameManager.cleaners.toArray(new Cleaner[GameManager.cleaners.size()]);
				for(int j=0;j<cleanersArr.length;++j){
					cleanersArr[j].move();
				}
				Oil[] oils=GameManager.oilList.toArray(new Oil[GameManager.oilList.size()]);
				for(int j=0;j<oils.length;++j){
					oils[j].roundElapsed();
				}
				if(round%10==0){
					for(int y=4;y<this.map.getSize().y;y=y+10){
						if(GameManager.cleaners.size()<10){
							//GameManager.cleaners.add(new Cleaner(this.map, new Point(0, y)));
							GameManager.cleaners.add(CleanerFactory.create(this.map, new Point(0, y)));
						}
					}
				}
				int robotsAlive=0;
				for(Robot r : GameManager.robots){
					if(r.isAlive()){
						robotsAlive=robotsAlive+1;
					}
				}
				if(round>=100 || robotsAlive<=1){
					this.end();
				}
				
				currentPlayer	=	0;
				round			=	round+1;
				while(currentPlayer<robots.size() && !robots.get(currentPlayer).isAlive()){
					currentPlayer	=	currentPlayer+1;
				}
			}
			robots.get(currentPlayer).isCurrent(true);
		}
	}

	/**
	 * V�get vet a fut� j�t�knak.
	 */
	public void end(){
		this.gameEnded=true;
	}
	
	
	/**
	 * Visszaadja az �pp soron l�v� j�t�kost
	 */
	public int getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	/**
	 * Visszat�r a p�lya m�ret�vel
	 */
	public Point getMapSize(){
		return this.map.getSize();
	}
	
	/**
	 * Visszat�r az eltelt k�r�k sz�m�val
	 */
	public int getCurrentRound(){
		return this.round;
	}
	
	/**
	 * Visszaadja, hogy v�get �rt-e a j�t�k
	 */
	public boolean gameEnded(){
		return this.gameEnded;
	}
	
	public static void main(String[] args){
		Controller controller=new Controller();
		GameManager gm=new GameManager(controller);
		controller.set(gm);
		//controller.init(gm);
		//gm.start();
	}
//publikus met�dusok v�ge
}
