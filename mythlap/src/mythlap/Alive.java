package mythlap;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.ImageIcon;

public class Alive {

	
	Path imagePath;
	String name;
	int health;
	
	private int strength;
	public Alive(String pt,int stre) {
		
		
		setName(pt);
		setStrength(stre);
		
	}
	
	public ImageIcon getScaledImage(int x,int y) {
		String pathAbs=imagePath.toAbsolutePath().toString();
		Image imgOfAlive=new ImageIcon(pathAbs).getImage();
		imgOfAlive=imgOfAlive.getScaledInstance(x,y,java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaledImg=new ImageIcon(imgOfAlive);
		return scaledImg;
	}
	
	public void setName(String nm) {
		name=nm;
	}
	
	public void setPath(String pt) {
		
		
			imagePath=Paths.get(".",pt);
			
		
	
	
		
		
		
		
			
			
		
		
	}//end of setPath func
	
	public void setStrength(int v) {
		int d=0;
		if(this.getName().equals("ragnar") || this.getName().equals("tomris")) {
			Random rand = new Random();
			 d=1+rand.nextInt(200);
		}
		strength=v+d;
	}
	public int getStrength() {
		return strength;
	}
	public void setHealth(int hl) {
		if(hl<=0) {
			health=0;
		}
		else {
		health=hl;
		}
	}
	public int getHealth() {
		return health;
	}
	
	
	public String getName() {
		return name;
	}
	
}
