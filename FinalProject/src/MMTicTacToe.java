import javax.swing.JLabel;


public class MMTicTacToe extends EnterName {
	
	public static JLabel label;
	public static void main(String[] args){
		
		EnterName.main(args);
		TicTacToeGame gui = new TicTacToeGame();
		gui.setLocation(370,330); //makes the location in the middle of the page - looks like the middle of the page to me
		gui.setSize(500,500);
	}


}
