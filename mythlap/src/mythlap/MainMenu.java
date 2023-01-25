package mythlap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainMenu extends JFrame{
	
	private JButton scores =new JButton("Scores"); 
	private JButton history=new JButton("History"); 
	private JButton playGame=new JButton("Play Game"); 
	private JButton gamingInfo=new JButton("Gaming Information"); 
	private JButton quitGame=new JButton("Quit Game"); 
	private JButton playDemo=new JButton("PlayDemo");
	
	
	
	private JPanel menuPanel=new JPanel();
	
	private JPanel scorePanel=new JPanel();
	private JPanel historyPanel =new JPanel();
	
	private JPanel gamingInfoPanel=new JPanel();
	
	Border border= BorderFactory.createLineBorder(Color.decode("#a98573"),3);
	

	Path backImage = Paths.get(".","MenuArkaplan.png");
	String pathArka=backImage.toAbsolutePath().toString();
	Image imgArka=new ImageIcon(pathArka).getImage();
	Image arkaImg=imgArka.getScaledInstance(600,500,java.awt.Image.SCALE_SMOOTH);
	ImageIcon scaledImg=new ImageIcon(arkaImg);
	JLabel imgLabel=new JLabel(scaledImg);
	JLabel imgLabel2=new JLabel(scaledImg);
	JLabel imgLabel3=new JLabel(scaledImg);
	JLabel imgLabel4=new JLabel(scaledImg);
	Dimension dimImg=imgLabel.getPreferredSize();
	
	
	public MainMenu() {
		
		putHistory();
		putMenu();
		putScores();
		putInfo();
		
		
		imgLabel.setBounds(0,0,dimImg.width,dimImg.height);
		menuPanel.add(imgLabel);
		imgLabel.setVisible(true);
		
		menuPanel.setLayout(null);
		//menuPanel.setBackground(Color.black);
		
		
		
		imgLabel4.setBounds(0,0,dimImg.width,dimImg.height);
		historyPanel.add(imgLabel4);
		imgLabel4.setVisible(true);
		historyPanel.setLayout(null);
		historyPanel.setBackground(Color.black);
		
		
		
		imgLabel2.setBounds(0,0,dimImg.width,dimImg.height);
		scorePanel.add(imgLabel2);
		imgLabel2.setVisible(true);
		scorePanel.setLayout(null);
		//scorePanel.setBackground(Color.black);
		
		
		
		imgLabel3.setBounds(0,0,dimImg.width,dimImg.height);
		gamingInfoPanel.add(imgLabel3);
		imgLabel3.setVisible(true);
		gamingInfoPanel.setLayout(null);
		//gamingInfoPanel.setBackground(Color.black);
		//empty.setLayout(null);
		setResizable(false);
		getContentPane().add(menuPanel);
	}
	
	
	
public void putScores() {
	
	
	goBackToMenuHandler backListen=new goBackToMenuHandler();
	//read scores file and show top 10 with jTextLabel
	JButton goBack=new JButton("Back");
	goBack.setBorder(border);
	goBack.setBackground(Color.decode("#443731"));
	goBack.setForeground(Color.decode("#8bae90"));
	Dimension goBackDim=goBack.getPreferredSize();
	goBack.setBounds(500,20,goBackDim.width+20,goBackDim.height+10);
	scorePanel.add(goBack);
	goBack.setVisible(true);
	goBack.addActionListener(backListen);
	
	
	
	
	
	ScoreHandler sH=new ScoreHandler("./scores.txt");
	String list10=sH.sort10();
	
	JTextArea top10scores=new JTextArea(list10);
	top10scores.setEditable(false);
	top10scores.setForeground(Color.white);
	top10scores.setBackground(Color.decode("#362d2a"));
	//top10scores.setOpaque(true);
	top10scores.setFont(top10scores.getFont().deriveFont(20f));
	Dimension top10scoresD=top10scores.getPreferredSize();
	top10scores.setBounds(190,80,top10scoresD.width+5,top10scoresD.height);
	scorePanel.add(top10scores);
	top10scores.setVisible(true);
}	
	
	

	

public void putHistory() {
	
	goBackToMenuHandler backListen=new goBackToMenuHandler();
	JButton goBack=new JButton("Back");
	goBack.setBorder(border);
	goBack.setBackground(Color.decode("#443731"));
	goBack.setForeground(Color.decode("#8bae90"));
	Dimension goBackDim=goBack.getPreferredSize();
	goBack.setBounds(500,20,goBackDim.width+20,goBackDim.height+10);
	historyPanel.add(goBack);
	
	
	JTextArea historyP=new JTextArea("One day, a tower appeared in the\n middle of the Earth, reaching up to the\n sky. The gift at the top of the Tower\n was"
			+ " so bright that it attracted the\n attention of all the warriors, but the\n world's best 4 warriors were brave\n enough to"
			+ " dare to climb the Tower.\n The warriors, who set out from their\n own countries, finally met  under the\n Tower. From that "
			+ "moment on, a great\n rivalry began for the treasure");
	historyP.setFont(historyP.getFont().deriveFont(20f));
	historyP.setForeground(Color.white);
	historyP.setBackground(Color.decode("#362d2a"));
	historyP.setEditable(false);
	Dimension histDim=historyP.getPreferredSize();
	historyP.setBounds(120,100,350,histDim.height+200);
	historyPanel.add(historyP);
	historyP.setVisible(true);
		
	
	//here the history paragraph will come with JTextField
	
	
	
	
	
	goBack.addActionListener(backListen);
	
	
	goBack.setVisible(true);
	
	
	
}


public void putInfo(){
	
	goBackToMenuHandler backListen=new goBackToMenuHandler();
	JButton goBack=new JButton("Back");
	goBack.setBorder(border);
	goBack.setBackground(Color.decode("#443731"));
	goBack.setForeground(Color.decode("#8bae90"));
	Dimension goBackDim=goBack.getPreferredSize();
	goBack.setBounds(500,20,goBackDim.width+20,goBackDim.height+10);
	gamingInfoPanel.add(goBack);
	goBack.addActionListener(backListen);
	
	//how to play informations will be in here with JTextfield
	
								   
	JTextArea gmInfo=new JTextArea("There are movement buttons w,a,s,d \n "
			+						 "which are moving the character in the \n"
			+						 "labirent in four direction respectively.\n"
			+						 "In duello scene,there are 3 buttons\n "
			+ 						"which are for attack,heal and roll\n "
			+ 						"a dice.The attack button attacks to\n "
			+ 						"enemy.Heal button increases current \n "
			+						 "health and roll a dice button rolls\n "
			+ 						"a dice which passes the enemy if the\n "
			+ 						"dice number is greater than 5,else\n "
			+ 						"the turn goes to the enemy which \n "
			+ 							"is ready to attack. ");
	gmInfo.setFont(gmInfo.getFont().deriveFont(20f));
	gmInfo.setForeground(Color.white);
	gmInfo.setBackground(Color.decode("#362d2a"));
	gmInfo.setEditable(false);
	Dimension gmInfoD=gmInfo.getPreferredSize();
	gmInfo.setBounds(125,60,350,gmInfoD.height);
	gamingInfoPanel.add(gmInfo);
	gmInfo.setVisible(true);
	
	Dimension demoDim=playDemo.getPreferredSize();
	playDemo.setBounds(250,400,demoDim.width,demoDim.height);
	playDemo.setBackground(Color.decode("#443731"));
	playDemo.setForeground(Color.decode("#8bae90"));
	playDemo.setBorder(border);
	gamingInfoPanel.add(playDemo);
	playDemo.addActionListener(backListen);
	
	
}

public void putMenu() {
	
	int xloc=230;
	MenuButtonHandler menuListen=new MenuButtonHandler();
	scores.setBackground(Color.decode("#443731"));
    scores.setForeground(Color.decode("#8bae90"));
	Dimension scoreLabel=scores.getPreferredSize();
	scores.setBounds(xloc,40,scoreLabel.width+40,scoreLabel.height+20);
	menuPanel.add(scores);
	//empty.add(scores);
	scores.addActionListener(menuListen);
	scores.setBorder(border);
	
	scores.setVisible(true);
	
	history.setBackground(Color.decode("#443731"));
	history.setForeground(Color.decode("#8bae90"));
	Dimension historyLabel=history.getPreferredSize();
	history.setBounds(xloc,120,historyLabel.width+40,historyLabel.height+20);
	menuPanel.add(history);
	history.addActionListener(menuListen);
	history.setVisible(true);
	history.setBorder(border);
	
	
	playGame.setBackground(Color.decode("#443731"));
	playGame.setForeground(Color.decode("#8bae90"));
	Dimension playGameLabel=playGame.getPreferredSize();
	playGame.setBounds(xloc-10,200,playGameLabel.width+40,playGameLabel.height+20);
	menuPanel.add(playGame);
	playGame.addActionListener(menuListen);
	playGame.setVisible(true);
	playGame.setBorder(border);
	
	
	gamingInfo.setBackground(Color.decode("#443731"));
	gamingInfo.setForeground(Color.decode("#8bae90"));
	Dimension gamingInfoLabel=gamingInfo.getPreferredSize();
	gamingInfo.setBounds(xloc-33,280,gamingInfoLabel.width+40,gamingInfoLabel.height+20);
	menuPanel.add(gamingInfo);
	gamingInfo.addActionListener(menuListen);
	gamingInfo.setVisible(true);
	gamingInfo.setBorder(border);
	
	quitGame.setBackground(Color.decode("#443731"));
	quitGame.setForeground(Color.decode("#8bae90"));
	Dimension quitGameLabel=quitGame.getPreferredSize();
	quitGame.setBounds(xloc-10,360,quitGameLabel.width+40,quitGameLabel.height+20);
	menuPanel.add(quitGame);
	quitGame.addActionListener(menuListen);
	quitGame.setVisible(true);
	quitGame.setBorder(border);
	
}





private class MenuButtonHandler implements ActionListener{
	
	
	public void actionPerformed(ActionEvent event) {
					
					
					String theCmd=((JButton)event.getSource()).getActionCommand();
					if(theCmd.equals("Scores")) {
						remove(menuPanel);
						getContentPane().add(scorePanel);
						
						
						
						repaint();
						revalidate();
						
					}
					
					else if(theCmd.equals("History")) {
						
						
						remove(menuPanel);
						getContentPane().add(historyPanel);
						
						
						
						repaint();
						revalidate();
						
					}
					else if(theCmd.equals("Play Game")) {
						
						MainGameWindow theGame=new MainGameWindow(1);
						theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						theGame.setSize(1040,600);
						theGame.setVisible(true);
						dispose();
						
					}
					
					else if(theCmd.equals("Gaming Information")) {
						remove(menuPanel);
						getContentPane().add(gamingInfoPanel);
						
						
						
						repaint();
						revalidate();
					}
					else if(theCmd.equals("Quit Game")) {
						System.exit(1);
						//dispose();
						
						
					}
					
				}
				

		
	


}//end of listener of keyboard buttons class





private class goBackToMenuHandler implements ActionListener{
	
	
	public void actionPerformed(ActionEvent event) {
					
					
					String theCmd=((JButton)event.getSource()).getActionCommand();
					if(theCmd.equals("Back")) {
						
						remove(((JButton)event.getSource()).getParent());
						getContentPane().add(menuPanel);
						
						
						
						repaint();
						revalidate();
						
					}
					
					if(theCmd.equals("PlayDemo")) {
						
						MainGameWindow theGame=new MainGameWindow(0);
						theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						theGame.setSize(1040,600);
						theGame.setVisible(true);
						dispose();
						
						
					}
					
					
				}
				

		
	


}//end of listener of keyboard buttons class






}