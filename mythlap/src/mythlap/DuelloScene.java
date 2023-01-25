package mythlap;
import java.util.Random;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class DuelloScene extends Environment{

	DuelloActionHandler duelloListen;
	Character relatedChar;
	Enemy relatedEnemy;
	JPanel healthBar;
	JPanel enemyHealthBar;
	JPanel armourBar;
	Border border= BorderFactory.createLineBorder(Color.decode("#a98573"),3);
	JPanel curLabPanel;
	JPanel duelloPanel;
	MainGameWindow labView;
	JLabel labPicture;
	GiveAnimation animator;
	
	
	int cl=40;
	public DuelloScene(Character cr,Enemy en,JPanel barH,JPanel enemyH,JPanel armP,JPanel curLab,JPanel duoPanel,MainGameWindow lab,JLabel labPic,GiveAnimation an) {
		super();
		imagePath=Paths.get(".","duelloScene.jpg");
		duelloListen=new DuelloActionHandler();
		relatedChar=cr;
		relatedEnemy=en;
		healthBar=barH;
		curLabPanel=curLab;
		duelloPanel=duoPanel;
		armourBar=armP;
		labView=lab;
		labPicture=labPic;
		enemyHealthBar=enemyH;
		animator=an;
		an.setVariables(cr, en, enemyH,barH,armP);
		if(relatedEnemy.getName().equals("dragon")) {
			an.dragonIdle.start();
		}
	}
	
	
	
	
	public void putButtons(JLabel backGround) {
		
		JButton attackBtn=new JButton("Attack");
		JButton healButton=new JButton("Heal");
		JButton rollADiceButton=new JButton("Dice");
		JButton menuButton=new JButton("Main Menu");
		animator.setBackGround(backGround,attackBtn,healButton,rollADiceButton);
		int xm=50;
		Dimension btnD=attackBtn.getPreferredSize();
		attackBtn.setBounds(100-xm,190+20,btnD.width,btnD.height);
		healButton.setBounds(200-xm,190,btnD.width,btnD.height);
		rollADiceButton.setBounds(300-xm,190+20,btnD.width,btnD.height);
		menuButton.setBounds(850,20,btnD.width+50,btnD.height);
		backGround.add(attackBtn);
		backGround.add(healButton);
		backGround.add(rollADiceButton);
		backGround.add(menuButton);
		
		attackBtn.setBorder(border);
		attackBtn.setBackground(Color.decode("#443731"));
		attackBtn.setForeground(Color.decode("#8bae90"));
		
		healButton.setBorder(border);
		healButton.setBackground(Color.decode("#443731"));
		healButton.setForeground(Color.decode("#8bae90"));
		
		rollADiceButton.setBorder(border);
		rollADiceButton.setBackground(Color.decode("#443731"));
		rollADiceButton.setForeground(Color.decode("#8bae90"));
		
		attackBtn.setVisible(true);
		healButton.setVisible(true);
		rollADiceButton.setVisible(true);
		
		menuButton.setBorder(border);
		menuButton.setBackground(Color.decode("#443731"));
		menuButton.setForeground(Color.decode("#8bae90"));
		
		menuButton.addActionListener(duelloListen);
		attackBtn.addActionListener(duelloListen);
		healButton.addActionListener(duelloListen);
		rollADiceButton.addActionListener(duelloListen);
	}
	
	public void goToLab() {
		if(relatedEnemy.getName().equals("dragon")) {
			animator.dragonIdle.stop();
		}
		duelloPanel.setVisible(false);
		curLabPanel.setVisible(true);
		
		relatedEnemy.inDuello=false;
		labView.putHealth(labPicture);
	}
	
	public void turnEnemy() {
		
		animator.enemyAttack.start();
		/*
		if(relatedChar.getArmour()>0) {
			relatedChar.setArmour(relatedChar.getArmour()-relatedEnemy.getStrength());
			System.out.println("enemy strength: "+relatedEnemy.getStrength());
			System.out.println("armour: "+relatedChar.getArmour());
			armourBar.setBounds(50,25,relatedChar.getArmour(),20);
			
		}
		else {
			relatedChar.setHealth(relatedChar.getHealth()-relatedEnemy.getStrength());
			healthBar.setBounds(50,0,relatedChar.getHealth(),20);
			
		}
		
		if(relatedChar.getHealth()<=0) {
			//get name and put score to table and to go main menu
			System.out.println("game over");
			RunGame.main(null);
			this.labView.dispose();
		}*/
		
	}
	
	private class DuelloActionHandler implements ActionListener {
		
		
		
		public void actionPerformed(ActionEvent event) {
			String theCmd=((JButton)event.getSource()).getActionCommand();
			if(theCmd.equals("Attack")) {
				
				//character location in the duello
				animator.timerChar.start();
				
				
				
				
			}
			else if(theCmd.equals("Heal")) {
				Random rand = new Random();
				int hl=50+rand.nextInt(100);
				MainGameWindow.score=MainGameWindow.score+=hl/2;
				relatedChar.setHealth(relatedChar.getHealth()+hl);
				//turn goes to enemy
				healthBar.setBounds(50,0,relatedChar.getHealth(),20);
				turnEnemy();
			}
			
			else if(theCmd.equals("Main Menu")) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
            	int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to go to Main Menu?","Warning",dialogButton);
            	if(dialogResult == JOptionPane.YES_OPTION){
            		RunGame.main(null);
    	     		labView.dispose();
            	}
				
			}
			else if(theCmd.equals("Dice")) {
				Random rand = new Random();
				int d=1+rand.nextInt(6);
				
				System.out.println("the dice is "+d);
				 JOptionPane.showMessageDialog(new JFrame(), "The dice is "+d, "Dice",
					        JOptionPane.INFORMATION_MESSAGE);
				 
				if(d<5) {
					MainGameWindow.score=MainGameWindow.score-(d*10);
					turnEnemy();
				}
				else {
					MainGameWindow.score=MainGameWindow.score+(d*10);
				/*	duelloPanel.setVisible(false);
					curLabPanel.setVisible(true);
					
					relatedEnemy.inDuello=false;
					labView.putHealth(labPicture);*/
					goToLab();
					
				}
				
				//roll a dice code if bigger than5 pass else turn goes to enemy
			}
				
		
			
		}
	}
}
