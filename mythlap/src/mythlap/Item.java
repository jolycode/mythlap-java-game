package mythlap;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class Item {

	boolean isUsed=false;
	String name;
	protected Path imagePath;
	
	
	public Item(String nm) {
		setName(nm);
		setImage();
		
		
		
	}
	public void setName(String nm) {
		name=nm;
	}
	
	public ImageIcon getScaledImage(int x,int y) {
		String pathAbs=imagePath.toAbsolutePath().toString();
		Image imgOfAlive=new ImageIcon(pathAbs).getImage();
		imgOfAlive=imgOfAlive.getScaledInstance(x,y,java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaledImg=new ImageIcon(imgOfAlive);
		
		return scaledImg;
	}
	
	public void setImage() {
		if(name.equals("health")) {
			setPath(Paths.get(".","can.png"));
			
		}
		else if(name.equals("poison")) {
			
			setPath(Paths.get(".","zehir.png"));
		}
		else if(name.equals("armour")) {
			setPath(Paths.get(".","kalkan.png"));
			
		}
		else if (name.equals("fire")) {
			setPath(Paths.get(".","fireball.png"));
		}
		
	}
	public void setPath(Path imgPath) {
		imagePath=imgPath;
	}
	
	
	public boolean getUsed() {
		return isUsed;
	}
	public void setUsed(boolean use) {
		isUsed=use;
	}
	
}
