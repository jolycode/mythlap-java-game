package mythlap;

import javax.swing.JFrame;

public class RunGame {
	public static void main(String[] args) {
		// MainGameWindow theGame=new MainGameWindow();
		 
	 //	theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	 theGame.setSize(1040,600);
	//	 theGame.setVisible(true);
		MainMenu menu=new MainMenu();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(600,500);
		menu.setVisible(true);
	}
}




