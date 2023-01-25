package mythlap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mythlap.ScoreComparator;
import mythlap.ScoreHandler.LineRec;

public class ScoreHandler {

	
	private String fileName;
	FileWriter fWriter;
	public ScoreHandler(String file) {
		
		setFileName(file);
		
		
	}
	
	
	
	public void setFileName(String fl) {
		fileName=fl;
		
		
	}
	public String getFileName() {
		return fileName;
	}
	
	public void writeToFile(String line) {
		try {
			fWriter=new FileWriter(getFileName(),true);
			fWriter.write(line);
			fWriter.close();
		}
		catch(IOException exc) {
			
			JOptionPane.showMessageDialog(null,"There is a problem while recording score to the file!","Error Message",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
			
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null,"There is an error while writing to the file","Error Message",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	public ArrayList<String> readTheFile() {
		
			ArrayList <String> allOutput=new ArrayList<String>();
			try {
			
				File theQuestions=new File(fileName);
				Scanner readQ=new Scanner(theQuestions);
		
					while(readQ.hasNextLine()) {
				
						String data=readQ.nextLine();
						allOutput.add(data);
						
					}
					
			}
		
		
		
			catch(FileNotFoundException exc){
			
					
					JOptionPane.showMessageDialog(null,"File is not found!","Error Message",JOptionPane.ERROR_MESSAGE);
					System.exit(1);
			}
			catch (IndexOutOfBoundsException exc) {
			
				
				JOptionPane.showMessageDialog(null,"Some lines are not in valid structure in records file","Error Message",JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			
			}
			catch(Exception exc) {
				JOptionPane.showMessageDialog(null,"There is an error while reading the file!","Error Message",JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			return allOutput;
	}
	
	public String sort10() {
		String top10="";
		try {
		ArrayList<LineRec> rcds=new ArrayList<LineRec>();
		for(String i:readTheFile()) {
			rcds.add(new LineRec(i));
		}
		Collections.sort(rcds,new ScoreComparator());
		 top10="";
		for(int i=0;i <10;i++) {
			if(i>rcds.size()-1)break;
			top10=top10+"\n"+rcds.get(i).getLine();
		}
		}
		catch(IndexOutOfBoundsException ext) {
			//JOptionPane.showMessageDialog(null,"There in no score until now!","Information Message",JOptionPane.INFORMATION_MESSAGE);
			top10="there is no score!";
			return top10;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"There is an error while reading the scores!","Error Message",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return top10;
	}







public class LineRec{
	
	private String oneLineOfRec;
	
	private int points;
    public LineRec(String theLine) {
    	
    	setLine(theLine);
    	
    }	
    public void setLine(String theLine) {
    	
    		
    		String [] lineSep=theLine.split(" ");
    		points=Integer.valueOf(lineSep[1]);
    		String dots=".";
    		for(int i=1;i<20-lineSep[0].length();i++) {
    			dots=dots+".";
    		}
    		oneLineOfRec=lineSep[0]+ dots+lineSep[1];
    	
    }
    public int getScore() {
    	return points*100;
    }
    
    public String getLine() {
    	return oneLineOfRec;
    }
}

}
