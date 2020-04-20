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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//I legit have no idea what is happening right now.
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
	GameTile[] board = new GameTile[] {tL,tM,tR,mL,mM,mR,bL,bM,bR};
	Bot AI = new Bot("CPU1");
	int gameOver=0;
	int pTurn=0;
	
	public void game()
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
	}
    public void changeTurn()
    {
    	if(pTurn==0)
    	{
    		pTurn=1;
    	}
    	else
    	{
    		pTurn=0;
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
	    
	    public int turn = 0; //counts turns
	   
	    @FXML
	    void displayTL(ActionEvent event) {
	    	turn++;//turn being taken
	    	//CPU=1, PLAYER=0
	    	if (pTurn==1) 
	    	{ 
	    		
	    	}
	    	else {
	    		board[0].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	
	    }
	    
	    @FXML
	    void displayBL(ActionEvent event) {
	    	turn++;//turn being taken
	    	
	    	if (pTurn==1) {

	    	}else {

	    		board[6].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    	
	    }
	
	    @FXML
	    void displayBM(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {
	    		
	    	}
	    		else{
	    		board[7].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }

	    @FXML
	    void displayBR(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	if (pTurn==1) {
	    	}else {

	    		board[8].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }

	    @FXML
	    void displayM(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {
	    	}else {
	    		board[4].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }

	    @FXML
	    void displayML(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {

	    	}else {
	    		board[3].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }

	    @FXML
	    void displayMR(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {//if even(player 2 O's)
	    	}else {
	    		board[5].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }

	    @FXML
	    void displayTM(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {//if even(player 2 O's)
	    	}else {
	    		board[1].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }

	    @FXML
	    void displayTR(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (pTurn==1) {
	    	}else {
	    		board[2].changeOID(0);
	    		changeTurn();
	    		game();
	    		buttonRedraw();
	    	}
	    }
	    void debugBoard()
	    {
	        for(int i=0;i<board.length;i++)
	        {
	        	System.out.println(board[i].toString());
	        }
	    }
		public void buttonRedraw()
		{	
			if(board[0].getOID()==0)
				TopLeft.setText("X");
				else if(board[0].getOID()==1)
				TopLeft.setText("O");
			
			if(board[1].getOID()==0)
				TopMid.setText("X");
				else if(board[1].getOID()==1)
				TopMid.setText("O");
			
			if(board[2].getOID()==0)
				TopRight.setText("X");
				else if(board[2].getOID()==1)
				TopRight.setText("O");
			
			if(board[3].getOID()==0)
				MidLeft.setText("X");
				else if(board[3].getOID()==1)
				MidLeft.setText("O");
			
			if(board[4].getOID()==0)
				Mid.setText("X");
				else if(board[4].getOID()==1)
				Mid.setText("O");
			
			if(board[5].getOID()==0)
				MidRight.setText("X");
				else if(board[5].getOID()==1)
				MidRight.setText("O");
			
			if(board[6].getOID()==0)
				BottomLeft.setText("X");
				else if(board[6].getOID()==1)
				BottomLeft.setText("O");
			
			if(board[7].getOID()==0)
				BottomMid.setText("X");
				else if(board[7].getOID()==1)
				BottomMid.setText("O");
			
			if(board[8].getOID()==0)
				BottomRight.setText("X");
				else if(board[8].getOID()==1)
				BottomRight.setText("O");		
		}
	
}
