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

/**
 * This class is the mainController of the Tic Tac Toe Game, It handles the game logic and drawing the UI.
 * @author ziobroa
 *
 */
public class MainController extends Application implements Initializable {
	/**
	 * This list of tiles initializes the tiles that correspond to the buttons on the board.
	 */
	GameTile tL = new GameTile("tL",0); //0,0
	GameTile tM = new GameTile("tM",1); //0,1
	GameTile tR = new GameTile("tR",2); //0,2
	GameTile mL = new GameTile("mL",3); //1,0 
	GameTile mM = new GameTile("mM",4); //1,1 
	GameTile mR = new GameTile("mR",5); //1,2
	GameTile bL = new GameTile("bL",6); //2,0
	GameTile bM = new GameTile("bM",7); //2,1
	GameTile bR = new GameTile("bR",8); //2,2
	/**
	 * This array is effectively the board that will be manipulated to control the game using the boardManipulator class.
	 */
	GameTile[] board = new GameTile[] {tL,tM,tR,mL,mM,mR,bL,bM,bR}; //This is the GameTile Board
	/**
	 * This "Bot" Player exists solely for the purpose of storing data for UI aspects. 
	 * No Point in a unique human class if Bot already contains the fields needed.
	 */
	Bot Player = new Bot("Human"); //Player Bot just for data storage.
	/**
	 * This is the AI player, this one created so that the methods needed to determine a move to make can be leveraged.
	 */
	Bot AI = new Bot("CPU1"); //AI Bot for gameplay.
	/**
	 * These following variables contain various information that either controls game state or
	 * would have been leveraged for a better user experience.
	 */
	public int turn = 0; //counts turns
	String status = String.format("Game Running..."); //String for Status.
	String turncount = String.format("Turns: %d",turn); //String for turns, doesn't work.
	int winner=-1; //winner storage
	int gameOver=0; //Game over flag.
	int pTurn=0; //Turn Flag.
	int lastTurn=1; //Last turn flag.
	/**
	 * This game method is a bit of a misnomer, but effectively controls the AI's turn since the turn is induced by the Human player
	 * clicking a button.
	 * 
	 * if the game is not over, the method flips the turn, and then carries out calling the AI's thought process for the move.
	 * This move id is returned to this class, and then the board is manipulated using it's changeOID method which sets the GameTile to be
	 * owned by the player that changed it, in this case it is always the AI.
	 * 
	 * After this change, the buttonRedraw method edits all the button text to reflect the current GameTile board.
	 * A win/loss condition is checked for after the redraw.
	 */
	public void game() //Handles the AI and processing, then redraws the buttons and checks for Win/Loss
	{
		if(gameOver==0)	
		{
			turn+=1;
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
	/**
	 * the changeTurn method simply flips the turn from 1 to 0 or 0 to 1 when called. 
	 */
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
    /**
     * the getGameOver method retrieves whether a win state has occurred on the last turn.
     * @return true or false from boardManipulator.gameOver()
     */
    public boolean getGameOver() //gets gameOver using the boardManipulator class
    {
    	boardManipulator current = new boardManipulator(board);
    	return current.gameOver();
    }
    /**
     * Checks who actually won the game or if it was a draw.
     */
    public void whoWon()
    {
    	boardManipulator current = new boardManipulator(board);
    	if(current.playerWon(1)==true)
    	{
    		winner=1;
    	}
    	else if(current.playerWon(0)==true)
    	{
    		winner=0;
    	}
    	else
    	{
    		winner=-1;
    	}
    }
    /**
     * statusCheck simply grabs the result of the getGameOver method and sets the gameOver flag if the game is infact, over.
     *  Then alters the appropriate text fields if the game is over.
     */
    public void statusCheck() //Checks if gameOver is true and sets the game to GameOver if it is.
    {
    	if(getGameOver()==true)
    	{
    		gameOver=1;
    		whoWon();
    		Status.setText("Game Over!");
    		Winner.setText(editWinner());
    	}
    }
	/**
	 * start method initializes the JavaFX window.
	 */
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
	/**
	 * The following is all of the declared FXML buttons for the game to operate.
	 * These are used by the player, comments have them numbered by their ID.
	 */
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
	    /**
	     * These TextFields would have been used for the game status but with the current speed of the game the AI turn is practically invisible.
	     */
	    @FXML
	    private TextField Status; 
	    
	    @FXML
	    private TextField Winner;
	    
	    @FXML
	    private TextField Turns; 
	    
	    @FXML
	    private Button Reset;
	    /**
	     * These FXML declarations are methods that tell the game what to do when the buttons are interacted with in any fashion. 
	     * The turn counter is ticked up, and if it is the players turn (pTurn=0), clicking the button alters the ownerID of the corresponding
	     * GameTile, and in a similar fashion, checks for a win condition, flips the turn, passes the turn to the AI and calls its turn method,
	     * then redraws the board to reflect the changes made.
	     * @param event
	     */
	   //All the display methods now simply act as a turn reset. As soon as the player clicks, it sets the id of the gameTile corresponding to
	   //the button tells the game to check if any one has won, but proceed anyway, the game method knows how to handle this.
	    @FXML
	    void displayTL(ActionEvent event) {
	    	if(gameOver==0)
	    	{
	    		turn+=1;//turn being taken
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
	    	turn+=1;//turn being taken
	    	
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
	    	turn+=1;//turn 1 is being taken
	    	
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
	    	turn+=1;//turn 1 is being taken
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
	    	turn+=1;//turn 1 is being taken
	    	
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
	    	turn+=1;//turn 1 is being taken
	    	
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
	    	turn+=1;//turn 1 is being taken
	    	
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
	    	turn+=1;//turn 1 is being taken
	    	
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
	    	turn+=1;//turn 1 is being taken
	    	
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
	    /**
	     * This method simply exists to print the board if needed and is only meant for us as the developers.
	     */
	    void debugBoard() //prints the gameboard
	    {
	        for(int i=0;i<board.length;i++)
	        {
	        	System.out.println(board[i].toString());
	        }
	    }
	    /**
	     * The buttonRedraw method redraws all textElements on the board to reflect changes to its corresponding GameTile if the game
	     * is not over. 
	     */
		public void buttonRedraw() //Redraws the text of all buttons and fields after the GameTile array has been modified. 
		{	
			if(gameOver==0){
			Status.setText(status);
			}
			Turns.setText(editTurnCount());
			
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
		/**
		 * This method returns the string of the player name depending on turn.
		 * @return String player name
		 */
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
		/*
		 * Edits Turn Strings
		 * 
		 */
		public String editTurnCount()
		{
			return turncount=String.format("Turns: %d",turn);
		}
		/**
		 * Edits the winnerText for the Winner TextField.
		 * @return string for winner.
		 */
		public String editWinner()
		{
			String winnerText="";
			if(winner==0)
			{
				winnerText = Player.getName();
			}
			else if(winner==1)
			{
				winnerText = AI.getName();
			}
			else
			{
				return "It's a Draw!";
			}
			return String.format("%s wins!", winnerText);
		}
		/**
		 * Resets the entire gamestate so that the game can be played repeatedly.
		 */
		@FXML
		void resetGame()
		{
			for(int i=0;i<board.length;i++)
			{
				board[i].reset();
			}
			turn=0;
			winner=-1;
			gameOver=0;
			pTurn=0;
			lastTurn=1;
			Status.setText("Game Start!");
			Winner.setText("");
			Turns.setText("Turns: 0");
			buttonRedraw();
			
		}
	
}
