package mythlap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;



import java.awt.Color;

import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;    
import java.awt.event.*;    
public class MainGameWindow extends JFrame implements KeyListener {

	int level;
	
	int xCur;
	int yCur;
	int xMove;
	int yMove;
	int [][] moveMatrix;
	int [][] trsLocs;
	int [][] enemyLocs;
	JLabel ragnarLabel;
	JLabel tomrisLabel;
	JLabel healthItemLabel;
	Item healthItem=new Item("health");
	JLabel poisonItemLabel;
	Item poisonItem=new Item("poison");
	JLabel armourItemLabel;
	Item armourItem=new Item("armour");
	
	static int score=0;
	JLabel dragonLabel;
	JLabel orkLabel;
	Enemy dragon=new Enemy("dragon",75);
	Enemy ork=new Enemy("ork",100);
	JPanel healthBar;
	JPanel armourBar;
	JLabel allHealthArmour;
	
	
	
	Labirent currentLabirent;
	DuelloScene currentDuello;
	private JLabel currentLevel;
	private JLabel	duelloLabel;
	
	private JPanel labirentPanel=new JPanel();
	private JPanel charSelPanel=new JPanel();
	private JPanel duelloPanel=new JPanel();
	private Character ragnar;
	private Character tomris;
	private Character selectedChar;
	JLabel charLabel;
	Border border= BorderFactory.createLineBorder(Color.decode("#a98573"),3);
	Clock clock;
	
	long seconds;
	long seconds2;
	public MainGameWindow(int lv) {
		 clock=Clock.systemDefaultZone();
		 seconds=clock.millis();
		//getLabirent();
		characterSelection();
		level=lv;
		charSelPanel.setLayout(null);
		labirentPanel.setLayout(null);
		duelloPanel.setLayout(null);
		setResizable(false);
		
		
		
		
		
		
		getContentPane().add(charSelPanel);
		
	}//end of constructor
	
	
	
	
	
	
	
	public void characterSelection() {
		
		
		JLabel choose=new JLabel("Choose Character");
		Dimension chsDim=choose.getPreferredSize();
		choose.setBounds(450,20,chsDim.width+60,chsDim.height+10);
		choose.setFont(new Font("Serif",Font.BOLD,20));
		choose.setVisible(true);
		charSelPanel.add(choose);
		
		choose.setBorder(border);
		choose.setBackground(Color.decode("#443731"));
		choose.setForeground(Color.decode("#8bae90"));
		
		
		charSelPanel.setBackground(Color.black );
		CharSelectionHandler charHandler=new CharSelectionHandler();
		 ragnar=new Character("ragnar",100);
		 tomris=new Character("tomris",100);
		 ragnarLabel=new JLabel(ragnar.getScaledImage(300, 400));
		 tomrisLabel=new JLabel(tomris.getScaledImage(300, 400));
         ragnarLabel.setBorder(border);		
		int xloc=100;
		int yloc=70;
		
		ragnarLabel.addMouseListener(charHandler);
		tomrisLabel.addMouseListener(charHandler);
		Dimension frameChar=ragnarLabel.getPreferredSize();
		ragnarLabel.setBounds(xloc,yloc,frameChar.width,frameChar.height);
		tomrisLabel.setBounds(xloc+500,yloc,frameChar.width,frameChar.height);
		
		charSelPanel.add(tomrisLabel);
		charSelPanel.add(ragnarLabel);
		
		tomrisLabel.setVisible(true);
		ragnarLabel.setVisible(true);
	
		
		
		
		JLabel rgL=new JLabel("Ragnar");
		Dimension rglDim=rgL.getPreferredSize();
		rgL.setBounds(200,500,rglDim.width+28,rglDim.height+10);
		rgL.setFont(new Font("Serif",Font.BOLD,20));
		rgL.setVisible(true);
		charSelPanel.add(rgL);
		
		rgL.setBorder(border);
		
		rgL.setBackground(Color.decode("#443731"));
		rgL.setForeground(Color.decode("#8bae90"));
		
		
		
		
		JLabel tmL=new JLabel("Tomris");
		
		tmL.setBounds(700,500,rglDim.width+25,rglDim.height+10);
		tmL.setFont(new Font("Serif",Font.BOLD,20));
		tmL.setVisible(true);
		charSelPanel.add(tmL);
		tmL.setBorder(border);
		
		tmL.setBackground(Color.decode("#443731"));
		tmL.setForeground(Color.decode("#8bae90"));
		
		
		
		
		
		
		
		
		
	
	}
	
	public void putHealth(JLabel labImg) {
		allHealthArmour=currentLabirent.getHealthBar(selectedChar.getName(),selectedChar.getHealth(),selectedChar.getArmour());
		allHealthArmour.setBounds(20,20,1000,300);
		labirentPanel.add(allHealthArmour);
		allHealthArmour.setVisible(true);
		healthBar=currentLabirent.getHealthBar();
		armourBar=currentLabirent.getArmourBar();
	}
	
	public void getLabirent(int lv) {
		if(lv==1) {
			addKeyListener(this);
		}
		setFocusable(true);
		requestFocus();
		//level1
		labirentPanel.removeAll();
		labirentPanel.repaint();
		labirentPanel.revalidate();
		
		labirentPanel.setBackground(Color.decode("#464646") );
		currentLabirent=new Labirent(lv);
		xMove=currentLabirent.getMX();
		
		yMove=currentLabirent.getMY();
		moveMatrix=currentLabirent.getboundaryMatrix();
		
		trsLocs=currentLabirent.treasureLocs(moveMatrix);
		enemyLocs=currentLabirent.getEnemyLocs();
		
		
		
		
		
		
		
		int initialX=currentLabirent.getCharPos()[0];
		int initialY=currentLabirent.getCharPos()[1];
		int nonCharIX=currentLabirent.getNonCharInitials()[0];
		int nonCharIY=currentLabirent.getNonCharInitials()[1];
		if(level==3) {
			xCur=0;yCur=18;
		}
		else {
			xCur=0;yCur=0;
		}
		int [] labParameters=currentLabirent.getLabSizeLoc();
		int objSize=currentLabirent.getObjectSize();
		currentLevel=new JLabel(currentLabirent.getScaledImage(labParameters[0],labParameters[1]));
		Dimension levelImageSize=currentLevel.getPreferredSize();
		currentLevel.setBounds(labParameters[2],labParameters[3],levelImageSize.width,levelImageSize.height);
		labirentPanel.add(currentLevel);
		labirentPanel.setVisible(true);
		currentLevel.setVisible(true);
		
		
		
		/*
		 allHealthArmour=currentLabirent.getHealthBar(selectedChar.getName(),selectedChar.getHealth(),selectedChar.getArmour());
			allHealthArmour.setBounds(20,20,1000,300);
			currentLevel.add(allHealthArmour);
			allHealthArmour.setVisible(true);
			*/
			putHealth(currentLevel);
			
			
			healthBar=currentLabirent.getHealthBar();
			armourBar=currentLabirent.getArmourBar();
		
		
		
		healthItem.isUsed=false;
		armourItem.isUsed=false;
		poisonItem.isUsed=false;
		
		healthItemLabel=new JLabel(healthItem.getScaledImage(objSize, objSize));
		poisonItemLabel=new JLabel(poisonItem.getScaledImage(objSize,objSize));
		armourItemLabel=new JLabel(armourItem.getScaledImage(objSize, objSize));
		
		Dimension itemDim=healthItemLabel.getPreferredSize();
		healthItemLabel.setBounds(nonCharIX+trsLocs[0][0]*xMove,nonCharIY+trsLocs[0][1]*yMove,itemDim.width,itemDim.height);
		currentLevel.add(healthItemLabel);
		healthItemLabel.setVisible(true);
		
		
		poisonItemLabel.setBounds(nonCharIX+trsLocs[1][0]*xMove,nonCharIY+trsLocs[1][1]*yMove,itemDim.width,itemDim.height);
		currentLevel.add(poisonItemLabel);
		poisonItemLabel.setVisible(true);
		
		
		armourItemLabel.setBounds(nonCharIX+trsLocs[2][0]*xMove,nonCharIY+trsLocs[2][1]*yMove,itemDim.width,itemDim.height);
		currentLevel.add(armourItemLabel);
		armourItemLabel.setVisible(true);
		
		
		
		
		
		 charLabel=new JLabel(selectedChar.getScaledImage(objSize, objSize));
		
		Dimension charD=charLabel.getPreferredSize();
		
		charLabel.setBounds(initialX,initialY,charD.width,charD.height);
		currentLevel.add(charLabel);
		
		charLabel.setVisible(true);
		
		
		dragon.hasDuello=false;
		dragon.inDuello=false;
		ork.hasDuello=false;
		ork.inDuello=false;
		
		dragonLabel=new JLabel(dragon.getScaledImage(objSize, objSize));
		orkLabel=new JLabel(ork.getScaledImage(objSize, objSize));
		Dimension enemyDim= dragonLabel.getPreferredSize();
		dragonLabel.setBounds(nonCharIX+enemyLocs[0][0]*xMove,nonCharIY+enemyLocs[0][1]*yMove,enemyDim.width,enemyDim.height);
		currentLevel.add(dragonLabel);
		dragonLabel.setVisible(true);
		
		
		
		
	
		orkLabel=new JLabel(ork.getScaledImage(objSize, objSize));
		
		orkLabel.setBounds(nonCharIX+enemyLocs[1][0]*xMove,nonCharIY+enemyLocs[1][1]*yMove,enemyDim.width,enemyDim.height);
		currentLevel.add(orkLabel);
		orkLabel.setVisible(true);
		
		
	}
	
	public void getDuelloScene(Enemy enemy) {
		duelloPanel.removeAll();
		JLabel characterInDuello=new JLabel(selectedChar.getScaledImage(300, 300));
		JLabel enemyInDuello;
		if(enemy.getName().equals("ork")) {
				 enemyInDuello=new JLabel(ork.getScaledImage(300,300));
				 Dimension enemyInD=enemyInDuello.getPreferredSize();
				 enemyInDuello.setBounds(650,210,enemyInD.width,enemyInD.height);
				 
		}
		else  {
				enemyInDuello=new JLabel(dragon.getScaledImage(300, 300));
				Dimension enemyInD=enemyInDuello.getPreferredSize();
				enemyInDuello.setBounds(650,100,enemyInD.width,enemyInD.height);
				
				
		}
		JPanel enemyHealth= new JPanel();
		GiveAnimation animator=new GiveAnimation(characterInDuello,enemyInDuello);
		currentDuello=new DuelloScene(selectedChar,enemy,healthBar,enemyHealth,armourBar,labirentPanel,duelloPanel,this,currentLevel,animator);
		animator.setDuelloScene(currentDuello);
		duelloLabel=new JLabel(currentDuello.getScaledImage(1040,600));
		Dimension duelloImageSize=duelloLabel.getPreferredSize();
		duelloLabel.setBounds(0,0,duelloImageSize.width,duelloImageSize.height);
		duelloPanel.add(duelloLabel);
		duelloPanel.setVisible(true);
		duelloLabel.setVisible(true);
		
		allHealthArmour.setBounds(20,20,700,200);
		duelloLabel.add(allHealthArmour);
		allHealthArmour.setVisible(true);
		
		
		//JLabel characterInDuello=new JLabel(selectedChar.getScaledImage(300, 300));
		Dimension charInD=characterInDuello.getPreferredSize();
		if(selectedChar.getName().equals("ragnar")) {
			characterInDuello.setBounds(40,210,charInD.width,charInD.height);
			
		}
		else if(selectedChar.getName().equals("tomris")) {
			characterInDuello.setBounds(40,225,charInD.width,charInD.height);
			
		}
		duelloLabel.add(characterInDuello);
		
		
		
		
	
		enemyHealth.setBounds(enemy.healthBarInfo()[0],enemy.healthBarInfo()[1],enemy.health/4,15);
		enemyHealth.setBackground(Color.red);
		enemyHealth.setBorder(border);
		duelloLabel.add(enemyHealth);
		enemyHealth.setVisible(true);
		
		
		duelloLabel.add(enemyInDuello);
		enemyInDuello.setVisible(true);
		
		
		
		currentDuello.putButtons(duelloLabel);
		
		
	}
	
	
	
	
	private class CharSelectionHandler  implements MouseInputListener {
     
			public void mousePressed(MouseEvent e) {
			   
			}
			
			public void mouseReleased(MouseEvent e) {
			   
			}
			
			public void mouseEntered(MouseEvent e) {
			  
			  Point fareLoc=e.getPoint();
			  if(fareLoc.x<350 && fareLoc.x>150) {
				tomrisLabel.setBorder(null);  
				ragnarLabel.setBorder(border);  
			  }
			  else if(fareLoc.x<15 && fareLoc.x>-15) {
				  tomrisLabel.setBorder(border);
				  ragnarLabel.setBorder(null);
			  }
			}
			
			public void mouseExited(MouseEvent e) {
			  
			}
			
			public void mouseClicked(MouseEvent e) {
			  
			  
			  if(e.getSource().equals(ragnarLabel)) {
				  
				 
				  
				 
				  
				  tomris=null;
				  selectedChar=ragnar;
				  getLabirent(1);
				  
				  remove(charSelPanel);
			  }
			  else {
				  
				 
				  ragnar=null;
				  selectedChar=tomris;
				  getLabirent(level);
				  
				  
				  	remove(charSelPanel);
				  
				  
				  
			  }
			  
			  getContentPane().add(labirentPanel);
			  
			  repaint();
			  revalidate();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	
	}
	
	
	

	

		
		
		public void keyPressed (KeyEvent e) {    
			int keyCode = e.getKeyCode();
	        switch( keyCode ) { 
	            case KeyEvent.VK_UP:
	               if(yCur!=0 && moveMatrix[yCur-1][xCur]!=0 && (  ork.inDuello==false && dragon.inDuello==false )) {
	            	   charLabel.setLocation(charLabel.getLocation().x,charLabel.getLocation().y-yMove);
	            	   yCur--;
	            	  
	            	}
	              
	                break;
	            case KeyEvent.VK_Q:
	            	int dialogButton = JOptionPane.YES_NO_OPTION;
	            	int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to go to Main Menu?","Warning",dialogButton);
	            	if(dialogResult == JOptionPane.YES_OPTION){
	            		RunGame.main(null);
	    	     		dispose();
	            	}
	            	
	            	break;
	            case KeyEvent.VK_DOWN:
	            	 if(yCur!= moveMatrix.length-1 && (  ork.inDuello==false && dragon.inDuello==false )) {
	            		 if( moveMatrix[yCur+1][xCur]!=0) {
	            	 	charLabel.setLocation(charLabel.getLocation().x,charLabel.getLocation().y+yMove);
	            	 	yCur++;
	            	 	
	            		 }
	            		 }
	            	 
	                break;
	            case KeyEvent.VK_LEFT:
	            	if(xCur!=0 && moveMatrix[yCur][xCur-1]!=0 && (  ork.inDuello==false && dragon.inDuello==false ))
	            		{
	            	
	            			charLabel.setLocation(charLabel.getLocation().x-xMove,charLabel.getLocation().y);
	            			xCur--;
	            			if(xCur==11 && level==2 && xMove==37) {
		            			xMove++;
		            		}
	            			if(xCur==11 && level==3 && xMove==26) {
	            				xMove--;
	            			}
	            			if(xCur==18 && level==3 && xMove==25) {
	            				xMove++;
	            			}
	        		}
	            	
	                break;
	            case KeyEvent.VK_RIGHT :
	            	
	            	if(xCur!=moveMatrix[yCur].length-1 && (  ork.inDuello==false && dragon.inDuello==false )) { 
	            		if(moveMatrix[yCur][xCur+1]!=0) {
	            		charLabel.setLocation(charLabel.getLocation().x+xMove,charLabel.getLocation().y);
	            		xCur++;
	            		if(xCur==11 && level==2 && xMove==38) {
	            			xMove-=1;
	            		}
	            		if(xCur==11 && level==3 && xMove==25) {
	            			xMove+=1;
	            		}
	            		if(xCur==18 && level==3 && xMove==26) {
	            			xMove-=1;
	            		}
	            		
	            		
	            	}
	            		}
	            	
	            	
	            	break;
	         }//end of switch
	        	if(xCur==trsLocs[0][0] && yCur==trsLocs[0][1] && healthItem.isUsed==false) {
	        		selectedChar.setHealth(selectedChar.getHealth()+100);
	        		healthItemLabel.setVisible(false);
	        		healthItem.isUsed=true;
	        		this.healthBar.setBounds(50,0,selectedChar.getHealth(),20);
	        		score+=50;
	        		
	        	}
	        	if(xCur==trsLocs[1][0] && yCur==trsLocs[1][1] && poisonItem.isUsed==false) {
	        		selectedChar.setHealth(selectedChar.getHealth()-100);
	        		poisonItemLabel.setVisible(false);
	        		poisonItem.isUsed=true;
	        		this.healthBar.setBounds(50,0,selectedChar.getHealth(),20);
	        		if(selectedChar.getHealth()<=0) {
	    				//get name and put score to table and to go main menu
	    				System.out.println("game over");
	    				JOptionPane.showMessageDialog(new JFrame(), "You lost.Game Over.", "Game Over",
						        JOptionPane.INFORMATION_MESSAGE);
	    				RunGame.main(null);
	    	     		dispose();
	    			}
	        		
	        	}
	        	if(xCur==trsLocs[2][0] && yCur==trsLocs[2][1] && armourItem.isUsed==false) {
	        		selectedChar.setArmour(selectedChar.getArmour()+50);
	        		selectedChar.setStrength(selectedChar.getStrength()+50);
	        		armourItemLabel.setVisible(false);
	        		armourItem.isUsed=true;
	        		this.armourBar.setBounds(50,25,selectedChar.getArmour(),20);
	        		score+=50;
	        	}
	        	if(xCur==enemyLocs[0][0] && yCur==enemyLocs[0][1] && dragon.hasDuello==false) {
	        		dragon.setHealth(500);
	        		dragonLabel.setVisible(false);
	        		dragon.hasDuello=true;
	        		dragon.inDuello=true;
	        		this.labirentPanel.setVisible(false);
	        		getContentPane().add(duelloPanel);
	        		getDuelloScene(dragon);
	        		repaint();
	        		revalidate();
	        		
	        	}
	        	
	        	if(xCur==enemyLocs[1][0] && yCur==enemyLocs[1][1] && ork.hasDuello==false) {
	        		ork.setHealth(750);
	        		orkLabel.setVisible(false);
	        		ork.hasDuello=true;
	        		ork.inDuello=true;
	        		this.labirentPanel.setVisible(false);
	        		getContentPane().add(duelloPanel);
	        		getDuelloScene(ork);
	        		repaint();
	        		revalidate();
	        	}
	        	
	        	
	        	if(yCur==currentLabirent.getExitPoint()[0] && xCur==currentLabirent.getExitPoint()[1]) {
	        		score+=100;
	        		
	        		if(level==2) {
	        			level=3;
	        			getLabirent(level);
	        		}
	        		
	        		
	        		
	        		else if(level==1) {
	        			level=2;
	        			getLabirent(level);
	        		}
	        		
	        		else if(level==3) {
	        			seconds2=clock.millis();
	        			int gameTime=(int)(seconds2-seconds)/1000;
	        			score+=100*gameTime;
	    				JOptionPane.showMessageDialog(new JFrame(), "You Win", "Congratulations",
						        JOptionPane.INFORMATION_MESSAGE);
	    				String nameFirstLast=JOptionPane.showInputDialog("Enter Your name and Surname");
	    				
	    				String lineToRecords="\n"+nameFirstLast+" "+score;
	    				
	    		
	    				ScoreHandler rcd=new ScoreHandler("./scores.txt");
	    				rcd.writeToFile(lineToRecords);
	    				
	    				
	    				RunGame.main(null);
	    	     		dispose();
	        			System.out.println("you win");
	        			
	        		}
	        		
	        	}
	        
	    }    
	// overriding the keyReleased() method of KeyListener interface where we set the text of the label when key is released  
	    public void keyReleased (KeyEvent e) {    
	       
	    }    
	// overriding the keyTyped() method of KeyListener interface where we set the text of the label when a key is typed  
	    public void keyTyped (KeyEvent e) {    
	    	
	    }    
		
		
		
		
		
	
	
	
}//end of class
