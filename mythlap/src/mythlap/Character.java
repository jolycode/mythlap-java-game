package mythlap;

import java.nio.file.Path;

public class Character extends Alive{

	
	
	int armour;
	
	public Character(String pt,int stre) {
		super(pt,stre);
		
		
		if(pt.equals("ragnar")) {
			setPath("Ragnar.png");
		}
		else if(pt.equals("tomris")) {
			setPath("Tomris.png");
		}
		
		setHealth(500);
		setArmour(100);
		
	}
	
	
	public void setArmour(int arm) {
		if(arm<=0) {
			armour=0;
		}
		else {
		armour=arm;}
	}
	public int getArmour() {
		return armour;
	}
	
	
}
