import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EnterName extends TicTacToeGame {

public static String player1 = "";
public static String player2 = "";

public static void main (String[] args){
JFrame frame = new JFrame("Player Information");
JOptionPane.showInputDialog(frame, "Player X Name:");
  JTextField labelplayer1 = new JTextField(40);
  labelplayer1.setText(player1);        
       
        
JOptionPane.showInputDialog(frame, "Player O Name:");
JTextField labelplayer2 = new JTextField(40);
labelplayer2.setText(player2);
return;
}

}

