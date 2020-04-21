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

/**
 * The GameTile class represents every tile in the tic tac toe board. Since these tiles all contain their own IDs and data,
 * this class could be used for Super Tic Tac Toe or games with many more tiles than just a 3x3 grid. 
 *
 * @author ziobroa
 *
 */
public class GameTile 
{
	
	protected int ownerID;
	protected int switchID;
	protected boolean isLocked;
	protected String name;
	/**
	 * Constructor
	 * @param n
	 * @param d
	 */
	public GameTile(String n,int d)
	{
		this.switchID=d;
		this.name=n;
		this.ownerID=-1;
		this.isLocked=false;
	}
	/**
	 * Changes ownerID and locks the tile once it is changed.
	 * @param oid
	 */
	public void changeOID(int oid)
	{
		if(this.getLock()==false)
		{
			this.ownerID=oid;
		}
		lock();
	}
	/**
	 * locks the tile
	 */
	public void lock()
	{
		this.isLocked=true;
	}
	/**
	 * unlocks the tile
	 */
	public void unlock()
	{
		this.isLocked=false;
	}
	/**
	 * returns whether the lock is closed.
	 * @return
	 */
	public boolean getLock()
	{
		return this.isLocked;
	}
	/**
	 * Returns the owner ID
	 * @return
	 */
	public int getOID()
	{
		return this.ownerID;
	}
	/**
	 * Returns the tileName, only for debugPrinting.
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * Resets the tile for new games.
	 */
	public void reset()
	{
		this.ownerID=-1;
		this.isLocked=false;
	}
	public String toString()
	{
		return String.format("Name: %s, OID: %d, Lock: %b",this.getName(),this.getOID(),this.getLock());
	}

	
}
