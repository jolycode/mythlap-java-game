package mythlap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
public class Labirent extends Environment{

	private int lv;
	int[][]boundArr;
	public int xMove;
	int yMove;
	int initialCharPosX;
	int initialCharPosY;
	
	public Labirent(int lv) {
		super();
		setLevel(lv);
		setImage();
		setMoves();
		setPosChar();
	}
	
	
	public void setMoves() {
		if(lv==0) {
			 xMove=49;
			 yMove=48;	
		}
		else if(lv==1) {
			 xMove=49;
			 yMove=48;	
		}
		else if (lv==2) {
			 xMove=38;
			 yMove=34;
		}
		else if(lv==3) {
			 xMove=25;
			 yMove=24;
		}
	}
	
	
	public void setPosChar() {
		if(lv==0) {
			initialCharPosX=25;
			initialCharPosY=42;
		}
		else if(lv==1) {
			initialCharPosX=25;
			initialCharPosY=42;
		}
		else if(lv==2)
		{
			initialCharPosX=17;
			initialCharPosY=33;
		}
		else if(lv==3) {
			initialCharPosX=4;
			initialCharPosY=430;
		}
		
	}
	
	public int [] getCharPos(){
		int [] pstn= {0,0};
		pstn[0]=initialCharPosX;
		pstn[1]=initialCharPosY;
		return pstn;
	}
	
	public int getMX() {
		return xMove;
	}
	public int getMY() {
		return yMove;
		
	}
	
	public int [] getNonCharInitials() {
		int x=0,y=0;
		int [] pst= {0,0};
		if(lv==0) {
			x=25;
		    y=42;
		}
		else if(lv==1) {
			x=25;
		    y=42;
		}
		else if(lv==2)
		{
			x=17;
			y=33;
		}
		else if(lv==3) {
			x=5;
			y=-5;
		}
		pst[0]=x;
		pst[1]=y;
		return pst;
	}
	
	
	int [] getLabSizeLoc() {
		int [] sz= {0,0,0,0};
		if(lv==0) {
			sz[0]=780;
			sz[1]=190;
			sz[2]=70;
			sz[3]=200;
			
		}
		else if(lv==1) {
			sz[0]=780;
			sz[1]=190;
			sz[2]=70;
			sz[3]=200;
			
		}
		else if(lv==2) {
			sz[0]=750;
			sz[1]=450;
			sz[2]=140;
			sz[3]=90;
			
		}
		else if(lv==3) {
			sz[0]=850;
			sz[1]=470;
			sz[2]=100;
			sz[3]=85;
			
		}
		return sz;
	}
	
	
	int  getObjectSize() {
		int sz=0;
		if(lv==0) {
			sz=50;
		}
		else if(lv==1) {
			sz=50;
		}
		else if(lv==2) {
			sz=40;
		}
		else if(lv==3) {
			sz=30;
		}
		return sz;
	}
	
	
	
	public void setLevel(int lev) {
		
		if(lev>=0 & lev<4) {
			lv=lev;
		}
		
	}//set the current level of game
	
	
	public int getLevel() {
		
		return lv;
		
	}
	
	
	
	public void setImage() {
		if(lv==0) {
			setPath(Paths.get(".","level1.png"));
			
		}
		else if(lv==1) {
			setPath(Paths.get(".","level1.png"));
			
		}
		else if(lv==2) {
			
			setPath(Paths.get(".","level2.png"));
		}
		else if(lv==3) {
			setPath(Paths.get(".","level3.png"));
			
		}
		
	}
	
	
	public int[][] getboundaryMatrix(){
		 if(lv==0) {
			boundArr=new int[][]  {
		    	{1,1,1,0,0,0,0,0,0,0,0,0,1,1,1},
		    	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    	{1,1,1,0,0,0,0,0,0,0,0,0,1,1,1}
		   
		    };
		 }
		
		else if(lv==1) {
			boundArr=new int[][]  {
		    	{1,1,1,0,0,0,0,0,0,0,0,0,1,1,1},
		    	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    	{1,1,1,0,0,0,0,0,0,0,0,0,1,1,1}
		   
		    };
	    
		}
		else if(lv==2) {
			 boundArr=new int[][]  {
			    	{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
			    	{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
			    	{0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
			    	{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			    	{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
			    	{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1}
			    	
			   
			    };
			
		}
	    
		else if (lv==3) {
			 
			    
			   
			    
			    boundArr=new int[][]  {
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0},
			    	{0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0},
			    	{0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			    	{0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1},
			    	{0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1},
			    	{0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
			    	{0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
			    	{0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
			    	{0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			    	{1,1,1,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0}
			    	
			   
			    };
		}
	    
	    
	    
	    
	    
	    
	    return boundArr; // rerunning the array witch created inside this method.
	}
	
	
	public int[][] treasureLocs(int [][] boundARR) {
		
		int [][] copyBoundArr=new int [boundARR.length][boundARR[0].length];
		for(int i=0;i<boundARR.length;i++) {
			for(int j=0;j<boundARR[0].length;j++) {
				copyBoundArr[i][j]=boundARR[i][j];
			}
		}
		
		if(lv==0) {
			copyBoundArr[0][0]=0;
			copyBoundArr[1][4]=0;
			copyBoundArr[1][12]=0;
			copyBoundArr[boundARR.length-1][boundARR[0].length-1]=0;
		}
		
		else if(lv==1) {
			copyBoundArr[0][0]=0;
			copyBoundArr[1][4]=0;
			copyBoundArr[1][12]=0;
			copyBoundArr[boundARR.length-1][boundARR[0].length-1]=0;
		}
			
		
		
		if(lv==2) {
			copyBoundArr[0][0]=0;
			copyBoundArr[2][5]=0;
			copyBoundArr[8][13]=0;
			copyBoundArr[boundARR.length-1][boundARR[0].length-1]=0;
		}
		
		if(lv==3) {
			
			copyBoundArr[18][0]=0;
			copyBoundArr[8][9]=0;
			copyBoundArr[16][14]=0;
			copyBoundArr[1][15]=0;
			
			
		}
		
		
		
		Random rand = new Random();
		int[][] rtArr=new int [3][2] ;
		for(int k=0;k<3;k++) {
		
			int y = rand.nextInt(boundARR.length);
			int x = rand.nextInt(boundARR[0].length);
			while(copyBoundArr[y][x]==0 ) {
			 	y = rand.nextInt(boundARR.length);
			 	x = rand.nextInt(boundARR[0].length);
			 	
			}
			copyBoundArr[y][x]=0;
			rtArr[k][0]= x;
			rtArr[k][1]=y;
		}
			
		return rtArr;
		
	}
	
	
	
	public int [][] getEnemyLocs(){
		
		if(lv==0) {
			int [][] locs=new int[][] {{4,1},{12,1}};
			return locs;
			
		}
		
		else if(lv==1) {
			int [][] locs=new int[][] {{4,1},{12,1}};
			return locs;
			
		}
		else if(lv==2) {
			int [][] locs=new int[][] {{5,2},{13,8}};
			return locs;
			
		}
		else {
			
			int [][] locs=new int[][] {{9,8},{14,16}};
			return locs;
		}
		
	}//end of getEnemyLocs func
	
	public int [] getExitPoint() {
		int [] exit={0,0};
		if(lv==0) {
			exit[0]=99;
			exit[1]=99;
		}
		if(lv==1) {
			exit[0]= boundArr.length-1;
			exit[1]=boundArr[0].length-1;
		}
		else if(lv==2) {
			exit[0]= boundArr.length-1;
			exit[1]=boundArr[0].length-1;
		}
		else if(lv==3) {
			exit[0]= 1;
			exit[1]=  15;
		}
		
			return exit;
		
	}
	
}
