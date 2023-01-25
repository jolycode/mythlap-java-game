package mythlap;

import java.util.Comparator;

import mythlap.ScoreHandler;
public class ScoreComparator  implements Comparator<ScoreHandler.LineRec>  {

	
	
	public int compare(ScoreHandler.LineRec ln1,ScoreHandler.LineRec ln2) {
		
		int ln1Score=ln1.getScore();
		int ln2Score=ln2.getScore();
		
		if(ln1Score>ln2Score) {
			return -1;
		}
		else if(ln1Score<ln2Score) {
			return 1;
			
		}
		else {
			return 0;
		}
	}
}
