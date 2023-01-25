package mythlap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.nio.file.Path;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Environment {

	protected Path imagePath;
	
	JPanel healthBar;
	JPanel armourBar;
	JLabel allInfo;
	JLabel charPic;
	
	Border border= BorderFactory.createLineBorder(Color.decode("#a98573"),2);
	
	
	
	public ImageIcon getScaledImage(int x,int y) {
		String pathAbs=imagePath.toAbsolutePath().toString();
		Image imgOfAlive=new ImageIcon(pathAbs).getImage();
		imgOfAlive=imgOfAlive.getScaledInstance(x,y,java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaledImg=new ImageIcon(imgOfAlive);
		
		return scaledImg;
	}
	
	public void setPath(Path imgPath) {
		imagePath=imgPath;
	}
	
	public JPanel getHealthBar() {
		return healthBar;
	}
	public JPanel getArmourBar() {
		return armourBar;
	}
	
	
	public JLabel getHealthBar(String charName,int health,int armour) {
		
		 allInfo=new JLabel();
		 
		 charPic=new JLabel();;
		if(charName.equals("ragnar")) {
			Character ragnar=new Character("ragnar",100);
		
			charPic=new JLabel(ragnar.getScaledImage(40,40));
		}
		else if(charName.equals("tomris")) {
			Character tomris=new Character("tomris",100);
			charPic=new JLabel(tomris.getScaledImage(40,40));
		}
		 charPic.setBorder(border);
		 healthBar=new JPanel();
		 armourBar=new JPanel();
		
		
		Dimension picD=charPic.getPreferredSize();
		charPic.setBounds(0,0,picD.width,picD.height);
		
		
		healthBar.setBounds(50,0,health,20);
		healthBar.setBackground(Color.red);
		armourBar.setBounds(50,25,armour,20);
		armourBar.setBackground(Color.gray);
		healthBar.setBorder(border);
		armourBar.setBorder(border);
		
		allInfo.add(charPic);
		allInfo.add(healthBar);
		allInfo.add(armourBar);
		
		
		return allInfo;
	}
	
	
	
}
