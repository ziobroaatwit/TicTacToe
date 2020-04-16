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
	    private Button TopLeft;

	    @FXML
	    private Button TopMid;

	    @FXML
	    private Button TopRight;

	    @FXML
	    private Button MidLeft;

	    @FXML
	    private Button Mid;

	    @FXML
	    private Button MidRight;

	    @FXML
	    private Button BottomLeft;

	    @FXML
	    private Button BottomMid;

	    @FXML
	    private Button BottomRight;
	    
	    public int turn = 0;//counts turns

	    @FXML
	    void displayTL(ActionEvent event) {
	    	turn++;//turn being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		TopLeft.setText("O");
	    	}else {
	    		TopLeft.setText("X");
	    	}
	    	
	    }
	    
	    @FXML
	    void displayBL(ActionEvent event) {
	    	turn++;//turn being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		BottomLeft.setText("O");
	    	}else {
	    		BottomLeft.setText("X");
	    	}
	    	
	    }
	
	    @FXML
	    void displayBM(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		BottomMid.setText("O");
	    	}else {
	    		BottomMid.setText("X");
	    	}
	    }

	    @FXML
	    void displayBR(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		BottomRight.setText("O");
	    	}else {
	    		BottomRight.setText("X");
	    	}
	    }

	    @FXML
	    void displayM(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		Mid.setText("O");
	    	}else {
	    		Mid.setText("X");
	    	}
	    }

	    @FXML
	    void displayML(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		MidLeft.setText("O");
	    	}else {
	    		MidLeft.setText("X");
	    	}
	    }

	    @FXML
	    void displayMR(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		MidRight.setText("O");
	    	}else {
	    		MidRight.setText("X");
	    	}
	    }

	    @FXML
	    void displayTM(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		TopMid.setText("O");
	    	}else {
	    		TopMid.setText("X");
	    	}
	    }

	    @FXML
	    void displayTR(ActionEvent event) {
	    	turn++;//turn 1 is being taken
	    	
	    	if (turn % 2 == 0) {//if even(player 2 O's)
	    		TopRight.setText("O");
	    	}else {
	    		TopRight.setText("X");
	    	}
	    }
	
}
