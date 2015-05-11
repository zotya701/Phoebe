package view;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import controller.*;

/**
 * Megejeleníti a játékhoz szükséges információkat és tartalmazza az irányításhoz
 * szükséges gombokat.
 */
public class ControlPanel extends javax.swing.JPanel {
	
	private static final long serialVersionUID = -942904738582248857L;
	private Controller controller;
	private GameManager gm;
	private Point direction;
	
	
	/**
	 * Konstruktor, inicializálja a controller adattagot a kapott c objektummal,
	 * direction adattagot egy új (0,0) értékû Pointtal, majd meghívja az
	 * initComponents metódust, végül pedig beállítja a gombok eseménykezelõit.
	 * @param c Controllerre referencia.
	 */
    public ControlPanel(Controller c) {
    	this.controller=c;
    	direction=new Point(0,0);
        initComponents();
        
        
        this.btnJump.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.btnJumpEventHandler();
				direction=new Point(0,0);
				btnUp.setEnabled(true);
				btnRight.setEnabled(true);
				btnDown.setEnabled(true);
				btnLeft.setEnabled(true);
			}
		});
        this.btnUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!gm.gameEnded()){
					controller.btnUpEventHandler();
					direction.translate(0, -1);
					if(direction.y<=-1){			//ez a sok setEnabled azért, hogy az eredeti sebességet
						btnUp.setEnabled(false);	//csak 1-el lehessen módosítani minden irányba
						btnRight.setEnabled(false);
						btnDown.setEnabled(true);
						btnLeft.setEnabled(false);
					}
					else{
						btnUp.setEnabled(true);
						btnRight.setEnabled(true);
						btnDown.setEnabled(true);
						btnLeft.setEnabled(true);
					}
				}
			}
		});
        this.btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!gm.gameEnded()){
					controller.btnRightEventHandler();
					direction.translate(1, 0);
					if(direction.x>=1){
						btnUp.setEnabled(false);
						btnRight.setEnabled(false);
						btnDown.setEnabled(false);
						btnLeft.setEnabled(true);
					}
					else{
						btnUp.setEnabled(true);
						btnRight.setEnabled(true);
						btnDown.setEnabled(true);
						btnLeft.setEnabled(true);
					}
				}
			}
		});
        this.btnDown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!gm.gameEnded()){
					controller.btnDownEventHandler();
					direction.translate(0, 1);
					if(direction.y>=1){
						btnUp.setEnabled(true);
						btnRight.setEnabled(false);
						btnDown.setEnabled(false);
						btnLeft.setEnabled(false);
					}
					else{
						btnUp.setEnabled(true);
						btnRight.setEnabled(true);
						btnDown.setEnabled(true);
						btnLeft.setEnabled(true);
				}
				}
			}
		});
        this.btnLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!gm.gameEnded()){
					controller.btnLeftEventHandler();
					direction.translate(-1, 0);
					if(direction.x<=-1){
						btnUp.setEnabled(false);
						btnRight.setEnabled(true);
						btnDown.setEnabled(false);
						btnLeft.setEnabled(false);
					}
					else{
						btnUp.setEnabled(true);
						btnRight.setEnabled(true);
						btnDown.setEnabled(true);
						btnLeft.setEnabled(true);
					}
				}
			}
		});
        this.btnPlaceGoo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!gm.gameEnded())
					controller.btnPlaceGooEventHandler();
			}
		});
        this.btnPlaceOil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!gm.gameEnded())
					controller.btnPlaceOilEventHandler();
			}
		});
    }

    /**
     * Inicializálja a gombokat és címkéket, és beállítja õket a megfelelõ pozícióra.
     * Java része generált kód.
     */                        
    private void initComponents() {
    	javax.swing.JLabel jLabel1;
        javax.swing.JLabel jLabel2;
        javax.swing.JLabel jLabel3;
        javax.swing.JLabel jLabel4;
        javax.swing.JLabel jLabel5;
        javax.swing.JLabel jLabel6;
        javax.swing.JLabel jLabel7;

        jLabel1 = new javax.swing.JLabel();
        btnUp = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnJump = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblCurrentRound = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCurrentPlayer = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTravelledRoute = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGooTrapsLeft = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblOilTrapsLeft = new javax.swing.JLabel();
        btnPlaceGoo = new javax.swing.JButton();
        btnPlaceOil = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modifier velocity vector's direction");

        btnUp.setText("Up");

        btnLeft.setText("Left");

        btnJump.setText("Jump!");

        btnRight.setText("Right");

        btnDown.setText("Down");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setLabelFor(lblCurrentRound);
        jLabel4.setText("Current Round:");

        lblCurrentRound.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCurrentRound.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCurrentRound.setText("1");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setLabelFor(lblCurrentPlayer);
        jLabel5.setText("Current Player:");

        lblCurrentPlayer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCurrentPlayer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCurrentPlayer.setText("1");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setLabelFor(lblTravelledRoute);
        jLabel6.setText("Travelled Route:");

        lblTravelledRoute.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTravelledRoute.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTravelledRoute.setText("5.65578");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setLabelFor(lblStatus);
        jLabel7.setText("Status:");

        lblStatus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblStatus.setText("Normal");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Goo traps left:");

        lblGooTrapsLeft.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblGooTrapsLeft.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblGooTrapsLeft.setText("3");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Oil traps left:");

        lblOilTrapsLeft.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblOilTrapsLeft.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblOilTrapsLeft.setText("3");

        btnPlaceGoo.setText("Place Goo");

        btnPlaceOil.setText("Place Oil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnJump, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTravelledRoute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurrentPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCurrentRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGooTrapsLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOilTrapsLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPlaceGoo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlaceOil, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(btnUp)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLeft)
                    .addComponent(btnJump)
                    .addComponent(btnRight))
                .addGap(4, 4, 4)
                .addComponent(btnDown)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCurrentRound))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblCurrentPlayer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTravelledRoute))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblStatus))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblGooTrapsLeft))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblOilTrapsLeft))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlaceGoo)
                    .addComponent(btnPlaceOil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    /**
     * Ha még nem ért véget a játék, frissíti a címkéket a jelenlegi állapot szerint,
     * egyébként pedig mindegyik címke egy Game Over feliratot jelenít meg.
     */
    public void update(){
    	if(this.gm!=null && this.gm.gameEnded()==false){
    		this.lblCurrentPlayer.setText(String.valueOf(this.gm.getCurrentPlayer()));
        	this.lblCurrentRound.setText(String.valueOf(this.gm.getCurrentRound()));
        	this.lblTravelledRoute.setText(String.valueOf(GameManager.robots.get(this.gm.getCurrentPlayer()).getRouteTravelled()));
        	this.lblStatus.setText(GameManager.robots.get(this.gm.getCurrentPlayer()).getStatus());
        	this.lblGooTrapsLeft.setText(String.valueOf(GameManager.robots.get(this.gm.getCurrentPlayer()).getGooTrapsLeft()));
        	this.lblOilTrapsLeft.setText(String.valueOf(GameManager.robots.get(this.gm.getCurrentPlayer()).getOilTrapsLeft()));
    	}else{
			this.lblCurrentPlayer.setText("Game Over");
	    	this.lblCurrentRound.setText("Game Over");
	    	this.lblTravelledRoute.setText("Game Over");
	    	this.lblStatus.setText("Game Over");
	    	this.lblGooTrapsLeft.setText("Game Over");
	    	this.lblOilTrapsLeft.setText("Game Over");
    	}
    }
    
    /**
     * Inicializálja gm adattagot a kapott gm objektummal.
     * 
     * @param gm
     */
    public void init(GameManager gm){
    	this.gm=gm;
    }

 // Variables declaration - do not modify                     
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnJump;
    private javax.swing.JButton btnPlaceGoo;
    private javax.swing.JButton btnPlaceOil;
    private javax.swing.JLabel lblCurrentRound;
    private javax.swing.JLabel lblCurrentPlayer;
    private javax.swing.JLabel lblTravelledRoute;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblGooTrapsLeft;
    private javax.swing.JLabel lblOilTrapsLeft;
    // End of variables declaration
}
