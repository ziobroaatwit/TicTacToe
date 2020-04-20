package application;
	
import java.net.URL;


import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//I legit have no idea what is happening right now.
//I kind of know what is happening now.
public class MainController extends Application implements Initializable {
	GameTile tL = new GameTile("tL",0); //0,0
	GameTile tM = new GameTile("tM",1); //0,1
	GameTile tR = new GameTile("tR",2); //0,2
	GameTile mL = new GameTile("mL",3); //1,0 
	GameTile mM = new GameTile("mM",4); //1,1 
	GameTile mR = new GameTile("mR",5); //1,2
	GameTile bL = new GameTile("bL",6); //2,0
	GameTile bM = new GameTile("bM",7); //2,1
	GameTile bR = new GameTile("bR",8); //2,2
	GameTile[] board = new GameTile[] {tL,tM,tR,mL,mM,mR,bL,bM,bR}; //This is the GameTile Board
	Bot Player = new Bot("Human"); //Player Bot just for data storage.
	Bot AI = new Bot("CPU1"); //AI Bot for gameplay.
	public int turn = 0; //counts turns
	String status = String.format("It is %s's turn!",playerName()); //String for Status.
	String turncount = String.format("Turns: %d",turn); //String for turns, doesnt work.
	int gameOver=0; //Game over flag.
	int pTurn=0; //Turn Flag.
	int lastTurn=1; //Last turn flag.
	
	public void game() //Handles the AI and processing, then redraws the buttons and checks for Win/Loss
	{
		if(gameOver==0)	
		{
			changeTurn();
			System.out.println(AI.getName()+" is thinking...");
    		int move=AI.moveCheck(board);
    		if(move!=-2)
    		{
    		System.out.println("My next move will be: "+move);
    		board[move].changeOID(AI.getOID());
    		}
    		buttonRedraw();
    		statusCheck();
		}
	}
    public void changeTurn() //flips the turn when called.
    {
    	if(pTurn==0)
    	{
    		lastTurn=0;
    		pTurn=1;
    	}
    	else
    	{
    		lastTurn=1;
    		pTurn=0;
    	}
    }
    public boolean getGameOver() //gets gameOver using the boardManipulator class
    {
    	boardManipulator current = new boardManipulator(board);
    	return current.playerWon(lastTurn);
    }
    public void statusCheck() //Checks if gameOver is true and sets the game to GameOver if it is.
    {
    	if(getGameOver()==true)
    	{
    		gameOver=1;
    	}
    }
	
	@Override
	public void start(Stage TicTacToe) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
	        Scene scene = new Scene(root);
	        TicTacToe.setScene(scene);
	        TicTacToe.setTitle("Tic Tac Toe");
	        TicTacToe.setResizable(false);
	        TicTacToe.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
		@FXML
	    private Button TopLeft; //0

	    @FXML
	    private Button TopMid; //1

	    @FXML
	    private Button TopRight; //2

	    @FXML
	    private Button MidLeft; //3

	    @FXML
	    private Button Mid; //4 

	    @FXML
	    private Button MidRight; //5 
	    
	    @FXML
	    private Button BottomLeft; //6 

	    @FXML
	    private Button BottomMid; //7 

	    @FXML
	    private Button BottomRight; //8 
	    
	    @FXML
	    private TextField Status; //Field for status, kind of useless
	    
	    @FXML
	    private TextField Turns; //Turns dont count correctly I dont know why.
	    
	   //All the display methods now simply act as a turn reset. As soon as the player clicks, it sets the id of the gameTile corresponding to
	   //the button tells the game to check if any one has won, but proceed anyway, the game method knows how to handle this.
	    @FXML
	    void displayTL(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    		turn++;//turn being taken
	    		//CPU=1, PLAYER=0
	    		if (pTurn==1) 
	    		{ 
	    		
	    		}
	    		else {
	    		board[0].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    		}	
	    	}
	    	
	    }
	    
	    @FXML
	    void displayBL(ActionEvent event) {
	    if(gameOver==0)
	    {
	    	turn++;//turn being taken
	    	
	    	if (pTurn==1) {

	    	}else {

	    		board[6].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }
	    	
	    }
	
	    @FXML
	    void displayBM(ActionEvent event) {
	    if(gameOver==0)
	    {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {
	    		
	    	}
	    		else{
	    		board[7].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }
	    }

	    @FXML
	    void displayBR(ActionEvent event) {
	    if(gameOver==0)
	    {
	    	turn++;//turn 1 is being taken
	    	if (pTurn==1) {
	    	}else {

	    		board[8].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }
	    }

	    @FXML
	    void displayM(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {
	    	}else {
	    		board[4].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	}
	    }

	    @FXML
	    void displayML(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {

	    	}else {
	    		board[3].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	}
	    }

	    @FXML
	    void displayMR(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {//if even(player 2 O's)
	    	}else {
	    		board[5].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	}
	    }

	    @FXML
	    void displayTM(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {//if even(player 2 O's)
	    	}else {
	    		board[1].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	}
	    }

	    @FXML
	    void displayTR(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {
	    	}else {
	    		board[2].changeOID(0);
	    		statusCheck();
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	}
	    }
	    @FXML
	    void displayStatusText() //Empty method I forgot what this was for
	    {
	    	
	    }
	    void debugBoard() //prints the gameboard
	    {
	        for(int i=0;i<board.length;i++)
	        {
	        	System.out.println(board[i].toString());
	        }
	    }
		public void buttonRedraw() //Redraws the text of all buttons and fields after the GameTile array has been modified. 
		{	
			if(gameOver==0){
			Status.setText(status);
			}
			Turns.setText(turncount);
			
			if(board[0].getOID()==0)
				TopLeft.setText("X");
				else if(board[0].getOID()==1)
				TopLeft.setText("O");
				else
					TopLeft.setText("-");
			
			if(board[1].getOID()==0)
				TopMid.setText("X");
				else if(board[1].getOID()==1)
				TopMid.setText("O");
				else
					TopMid.setText("-");
			
			if(board[2].getOID()==0)
				TopRight.setText("X");
				else if(board[2].getOID()==1)
				TopRight.setText("O");
				else
					TopRight.setText("-");
			
			if(board[3].getOID()==0)
				MidLeft.setText("X");
				else if(board[3].getOID()==1)
				MidLeft.setText("O");
				else
					MidLeft.setText("-");
			
			if(board[4].getOID()==0)
				Mid.setText("X");
				else if(board[4].getOID()==1)
				Mid.setText("O");
				else
					Mid.setText("-");
			
			if(board[5].getOID()==0)
				MidRight.setText("X");
				else if(board[5].getOID()==1)
				MidRight.setText("O");
				else 
					MidRight.setText("-");
			
			if(board[6].getOID()==0)
				BottomLeft.setText("X");
				else if(board[6].getOID()==1)
				BottomLeft.setText("O");
				else
					BottomLeft.setText("-");
			if(board[7].getOID()==0)
				BottomMid.setText("X");
				else if(board[7].getOID()==1)
				BottomMid.setText("O");
				else
					BottomMid.setText("-");
			
			if(board[8].getOID()==0)
				BottomRight.setText("X");
				else if(board[8].getOID()==1)
				BottomRight.setText("O");	
				else 
					BottomRight.setText("-");
		}
		public String playerName() //Returns player name when called based on whos turn it is for the turn status.
		{
			if(pTurn==0)
			{
				return Player.getName();
			}
			else
			{
				return AI.getName();
			}
		}
	
}
