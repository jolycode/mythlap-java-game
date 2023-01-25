package mythlap;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GiveAnimation {

	JLabel charLabel;
	JLabel enemyLabel;
	Timer timerChar;
	Timer dragonIdle;
	Timer enemyAttack;

	Character relatedChar;
	Enemy relatedEnemy;
	JPanel enemyHealthBar;
	JPanel healthBar;
	JPanel armourBar;
	DuelloScene relatedScene;
	JLabel backGround;
	
	JButton attackB;
	JButton healB;
	JButton diceB;
	int tomrisCounter=0;
	int tomrisImageCounter=0;
	public GiveAnimation(JLabel charL,JLabel enL) {
		
		charLabel=charL;
		enemyLabel=enL;
		 tomrisCounter=0;
		 tomrisImageCounter=0;
		timerChar = new Timer(20, new ActionListener() {
			boolean attacked=false;
			int cl=40;
			int clt=80;
		
			int yl=350;
			JLabel tomrisBall;
			
		    public void actionPerformed(ActionEvent evt) {
		    	
		    	if(relatedChar.getName().equals("ragnar"))
		    	{	
		    		if(cl<500 && attacked==false) {	
		    			cl=cl+20;
		    			charLabel.setBounds(cl,210,300,300);
		    			attackB.setVisible(false);healB.setVisible(false);diceB.setVisible(false);
		    		}
		    		if (cl>=500 && attacked==false) {
		    			relatedEnemy.setHealth(relatedEnemy.getHealth()-relatedChar.getStrength());
		    			MainGameWindow.score+=75;
		    			enemyHealthBar.setBounds(relatedEnemy.healthBarInfo()[0],relatedEnemy.healthBarInfo()[1],relatedEnemy.health/4,15);
		    			if(relatedEnemy.getHealth()<=0) {
						/*duelloPanel.setVisible(false);
						curLabPanel.setVisible(true);
						
						relatedEnemy.inDuello=false;
						labView.putHealth(labPicture);*/
		    				MainGameWindow.score+=500;
		    				relatedScene.goToLab();
						
		    			}
		    			attacked=true;
					
		            
		    		}
		    		if(cl>40 && attacked==true) {
		    			cl=cl-20;
		    			charLabel.setBounds(cl,210,300,300);
		    		}
		    		
		    		if(cl<=40 && attacked==true) {
		    			attacked=false;
		        	
		    			attackB.setVisible(true);healB.setVisible(true);diceB.setVisible(true);
		    			timerChar.stop();
		    			relatedScene.turnEnemy();
		    		}
		    
		    
		    		}
		    
		    	 else if(relatedChar.getName().equals("tomris")) {
		    		
		    			
		    			
		    			
		    			if(clt==80) {
		    				 Path imagePath=Paths.get("./tomrisfire","frame_"+tomrisImageCounter+".png");
		    	    		 String pathAbs=imagePath.toAbsolutePath().toString();
		    	    		 Image imgOfAlive=new ImageIcon(pathAbs).getImage();
		    	    	   	 imgOfAlive=imgOfAlive.getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		    	    		 ImageIcon scaledImg=new ImageIcon(imgOfAlive);
		    	         	 tomrisBall=new JLabel(scaledImg);
		    				 backGround.add(tomrisBall);
		    			     tomrisBall.setVisible(true);
		    			}
		    			
		    			if(clt<500 && attacked==false) {	
			    			clt=clt+20;
			    			if(relatedEnemy.getName().equals("dragon")) {
			    			yl=yl-10;}
			    			else {
			    				yl=290;
			    			}
			    			
			    				tomrisImageCounter++;
			    				if(tomrisImageCounter==8) {
			    					tomrisImageCounter=0;
			    				}
			    			
			    			
			    			Path imagePath=Paths.get("./tomrisfire","frame_"+tomrisImageCounter+".png");
		    	    		 String pathAbs=imagePath.toAbsolutePath().toString();
		    	    		 Image imgOfAlive=new ImageIcon(pathAbs).getImage();
		    	    	   	 imgOfAlive=imgOfAlive.getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH);
		    	    		 ImageIcon scaledImg=new ImageIcon(imgOfAlive);
			    			tomrisBall.setIcon(scaledImg);
			    			attackB.setVisible(false);healB.setVisible(false);diceB.setVisible(false);
			    			tomrisBall.setBounds(clt+50,yl,70,70);
			    		}
			    		if (clt>=500 && attacked==false) {
			    			relatedEnemy.setHealth(relatedEnemy.getHealth()-relatedChar.getStrength());
			    			enemyHealthBar.setBounds(relatedEnemy.healthBarInfo()[0],relatedEnemy.healthBarInfo()[1],relatedEnemy.health/4,15);
			    			if(relatedEnemy.getHealth()<=0) {
							/*duelloPanel.setVisible(false);
							curLabPanel.setVisible(true);
							
							relatedEnemy.inDuello=false;
							labView.putHealth(labPicture);*/
			    				relatedScene.goToLab();
							
			    			}
			    			attacked=true;
						
			            
			    		}
			    		
			    		if( attacked==true) {
			    			clt=80;
			    			if(relatedEnemy.getName().equals("dragon")) {
			    				yl=350;
			    			}
			    			attacked=false;
			    			backGround.remove(tomrisBall);
			    			attackB.setVisible(true);healB.setVisible(true);diceB.setVisible(true);
			    			timerChar.stop();
			    			relatedScene.turnEnemy();
			    		}
		    			
		    			
		    		 
		    	 }
		    	}   
		   
		});
		
		dragonIdle= new Timer(10, new ActionListener() {
			int mv=0;
			int lim=20;
			boolean art=true;
			
		    public void actionPerformed(ActionEvent evt) {
		    
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    		if(mv<50 && art) {
		    			mv++;
		    		}
		    		if(mv>=50) {
		    			art=false;
		    		}
		    		if(mv>-50 && !art ) {
		    			mv--;
		    		}
		    		if(mv<=-50) {
		    			art=true;
		    		}
		    		enemyLabel.setBounds(650,100+mv,300,300);
		    		enemyHealthBar.setBounds(relatedEnemy.healthBarInfo()[0],relatedEnemy.healthBarInfo()[1]+mv,relatedEnemy.health/4,15);
		    	
		    	
		    	
		    	
		    	
		    }    
		});
		
		enemyAttack = new Timer(20, new ActionListener() {
			boolean attackedE=false;
			int cl=650;
			Item fire=new Item("fire");
    		JLabel fireBall=new JLabel(fire.getScaledImage(40, 40));
    		
    		
    		
    		int ym=100;
		    public void actionPerformed(ActionEvent evt) {
		    	if(relatedEnemy.getName().equals("ork")) {
		    		if(cl>90 && attackedE==false) {	
		    			cl=cl-20;
		    			enemyLabel.setBounds(cl,210,300,300);
		    			enemyHealthBar.setVisible(false);
		    		}
		        	if (cl<=90 && attackedE==false) {
		        		if(relatedChar.getArmour()>0) {
		        			relatedChar.setArmour(relatedChar.getArmour()-relatedEnemy.getStrength());
		    			
		    				armourBar.setBounds(50,25,relatedChar.getArmour(),20);
		    			
		    			}
		    			else {
		    				relatedChar.setHealth(relatedChar.getHealth()-relatedEnemy.getStrength());
		    				healthBar.setBounds(50,0,relatedChar.getHealth(),20);
		    			
		    			}
		        		if(relatedChar.getHealth()<=0) {
		        			System.out.println("game over");
		    				JOptionPane.showMessageDialog(new JFrame(), "You lost.Game Over.", "Game Over",
							        JOptionPane.INFORMATION_MESSAGE);
		    				RunGame.main(null);
		    	     		relatedScene.labView.dispose();
		    			}
						attackedE=true;
					
		            
		        	}
		        	if(cl<650 && attackedE==true) {
		        		cl=cl+20;
		    			enemyLabel.setBounds(cl,210,300,300);
		        	}
		        
		        	if(cl>=650 && attackedE==true) {
		        		attackedE=false;
		        	
		            	enemyHealthBar.setVisible(true);
		        		enemyAttack.stop();
		        	
		        	}
		        }
		    	else {
		    		if(cl==650) {
		    			backGround.add(fireBall);
		    			fireBall.setVisible(true);
		    		}
		    		cl=cl-20;
		    		ym=ym+10;
		    		fireBall.setBounds(cl,ym,40,40);
		    		if(cl<=110) {
		    			fireBall.setVisible(false);
		    			if(relatedChar.getArmour()>0) {
		        			relatedChar.setArmour(relatedChar.getArmour()-relatedEnemy.getStrength());
		    			
		    				armourBar.setBounds(50,25,relatedChar.getArmour(),20);
		    			
		    			}
		    			else {
		    				relatedChar.setHealth(relatedChar.getHealth()-relatedEnemy.getStrength());
		    				healthBar.setBounds(50,0,relatedChar.getHealth(),20);
		    			
		    			}
		        		if(relatedChar.getHealth()<=0) {
		    				
		    				System.out.println("game over");
		    				JOptionPane.showMessageDialog(new JFrame(), "You lost.Game Over.", "Game Over",
							        JOptionPane.INFORMATION_MESSAGE);
		    				RunGame.main(null);
		    	     		relatedScene.labView.dispose();
		    			}
		        		cl=650;
		        		ym=100;
		        		enemyAttack.stop();
		    		}
		    	}
		    }    
		});
		
	}
	
	
	
	
	public void setDuelloScene(DuelloScene scn) {
		relatedScene=scn;
	}
	public void setVariables(Character cr,Enemy en,JPanel enemyBar,JPanel hb,JPanel armp) {
		relatedChar=cr;
		relatedEnemy=en;
		enemyHealthBar=enemyBar;
		healthBar=hb;
		armourBar=armp;
	}
	
	public void setBackGround(JLabel bck,JButton btn1,JButton btn2,JButton btn3) {
		backGround=bck;
		attackB=btn1;
		healB=btn2;
		diceB=btn3;
	}
}
