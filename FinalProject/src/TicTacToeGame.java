import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TicTacToeGame extends JFrame implements ActionListener{

JPanel panel;
public static JLabel label;
static JButton[] button;
private String letter = "";
  
int count = 0;//will keep track of how many inputs were used so if its <=9 then its a draw
int evenCount = 0;
int tt_matrix[][];
public static void main(String[] args){
 
new TicTacToeGame();
}

public TicTacToeGame(){
     
        
setTitle("Olivia's Tic Tac Toe Game");
panel = new JPanel();
panel.setLayout(new GridLayout(3,3)); // because there are 9 "buttons" or "box's" for a tic tac toe game and a 3x3 is what's going to make 9 buttons
this.add(panel); //Jframe will add panel
button = new JButton[9]; //here are the different 9 Jbuttons
for(int i = 0; i <= 8; i++){ //making the 9 Jbuttons
button[i] = new JButton();
panel.add(button[i]);//adding buttons from 0-8
button[i].setEnabled(true);//to use (in order to click buttons)
button[i].addActionListener(this); //method
}
// initialize the matrix we are checking for winner with
this.tt_matrix = new int[3][3];
for (int rows = 0; rows < 3; rows ++){
for (int cols = 0; cols < 3; cols ++){
this.tt_matrix[rows][cols] = 0; // 0 <- neutral, 1 <- X, 2 <- O
}
}
this.pack();
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
this.setVisible(true); //in order for the Jpanel to be seen
}
public void actionPerformed(ActionEvent e){
count++;//starts at 0, then will go to x, next time it's clicked it will go to sign, which will give it an o
int tt_col_coord = 0;
int tt_row_coord = 0;
for(int i =0; i < 9; i++){
if(button[i] == e.getSource()){
if(evenCount%2 == 0){ // if the count has no remainder, it will become an x
button[i].setText("X");
letter = "X";
button[i].setEnabled(false); //after it's clicked, it will make it enabled aka you can't click it any more to change it aka no cheating
// convert the i to matrix coord
if (i == 0) tt_col_coord = 0; else tt_col_coord = i % 3; // this is the col val
if (i == 0) tt_row_coord = 0; else tt_row_coord = i / 3; // this is the row val
}
else{
button[i].setText("O"); //if there is a remainder, it will become an o
letter = "O";
button[i].setEnabled(false);
if (i == 0) tt_col_coord = 0; else tt_col_coord = i % 3; // this is the col val. I got help for this part of the code
if (i == 0) tt_row_coord = 0; else tt_row_coord = i / 3; // this is the row val
}
}
}
// set the new coordinate value
boolean winner_found = false;
int winner = 0;
if (letter.equals("X")) this.tt_matrix[tt_row_coord][tt_col_coord] = 1;
else if (letter.equals("O")) this.tt_matrix[tt_row_coord][tt_col_coord] = 2; // just being explicit, could use an "else"
// check for winner
// finite ways to check for winners... first check rows
for (int x = 0; x < 3; x ++){
if ((tt_matrix[x][0] == tt_matrix[x][1]) && (tt_matrix[x][1]== tt_matrix[x][2]) && (tt_matrix[x][1] != 0)){
winner_found = true;
winner = tt_matrix[x][1];
break;
}
}
// check columns
for (int y = 0; y < 3; y ++){
if ((tt_matrix[0][y] == tt_matrix[1][y]) && (tt_matrix[1][y]== tt_matrix[2][y]) && (tt_matrix[1][y] != 0)){
winner_found = true;
winner = tt_matrix[1][y];
break;
}
}
// check diagonals
// top-left to bottom-right diag
if ((tt_matrix[0][0] == tt_matrix[1][1]) && (tt_matrix[1][1] == tt_matrix[2][2]) && (tt_matrix[1][1] != 0)){
winner_found = true;
winner = tt_matrix[1][1];
}
// top-right to bottom-left
if ((tt_matrix[0][2] == tt_matrix[1][1]) && (tt_matrix[1][1] == tt_matrix[2][0]) && (tt_matrix[1][1] != 0)){
winner_found = true;
winner = tt_matrix[1][1];
}
if(count >= 9 || winner_found){ //since there is no 10th button, there's no where else to go, so we have to reset the game
if (winner_found){
if (winner == 1){
JOptionPane.showMessageDialog(null, "Congratulations! " + EnterName.player1  + "X's win!" );
}
else{
JOptionPane.showMessageDialog(null, "Congratulations, O's win!" + EnterName.player2);
}
}
else
JOptionPane.showMessageDialog(null, "Blegh, you're not so good at this game");
for(int j = 0; j<= 8; j++){
button[j].setText(""); //resets all the buttons
button[j].setEnabled(true);
// reset the matrix
for (int xx = 0; xx < 3; xx ++){
for (int yy = 0; yy < 3; yy ++){
tt_matrix[xx][yy] = 0;
}
}
}
count = 0; //reset the count
evenCount = 0; //reset the count
return; //it will break out of action listener
}
evenCount++;
}
}

