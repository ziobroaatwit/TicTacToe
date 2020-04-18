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

public class GameTile 
{
	@FXML
	protected Button gameButton;
	
	protected int ownerID;
	protected boolean isLocked;
	
	public GameTile(Button s)
	{
		this.gameButton=s;
		this.ownerID=-1;
		this.isLocked=false;
	}
	public void changeOID(int oid)
	{
		this.ownerID=oid;
		this.changeLabel(getOID());
	}
	public void lock()
	{
		this.isLocked=true;
	}
	public void unlock()
	{
		this.isLocked=false;
	}
	public int getOID()
	{
		return this.ownerID;
	}
	public void changeLabel(int oid)
	{
		if (oid==1) {//if even(player 2 O's)
    		gameButton.setText("O");
    	}else {
    		gameButton.setText("X");
    	}
		lock();
	}
	public void reset()
	{
		this.ownerID=-1;
		this.isLocked=false;
		this.gameButton.setText("-");
	}
	public Button getButton()
	{
		return this.gameButton;
	}
	
}
