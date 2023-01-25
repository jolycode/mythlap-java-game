package mythlap;

public class Enemy extends Alive {

	
		boolean hasDuello=false;
		boolean inDuello=false;
		int [] healthBarInfos= {0,0};
		public Enemy(String info,int stre) {
			super(info,stre);
			
			
			if(info.equals("dragon")) {
				setPath("Canavar2.png");
				setHealth(500);
			}
			else if(info.equals("ork")) {
				setPath("Canavar3.png");
				setHealth(750);
			}
			
			
		
			
		}
		
		public int [] healthBarInfo() {
			
			if(getName().equals("ork")) {
				healthBarInfos[0]=720;
				healthBarInfos[1]=170;
			
			}
			else {
				healthBarInfos[0]=740;
				healthBarInfos[1]=95;
			}
			
			return healthBarInfos;
			
		}
	
	
	
}
