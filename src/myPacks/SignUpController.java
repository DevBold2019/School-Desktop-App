package myPacks;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

public class SignUpController implements  Initializable{

	@FXML Button Register;
	@FXML ImageView image;
	@FXML TextField EnterUser;
	@FXML TextField enterEmail;
	@FXML PasswordField password;
	@FXML Pane pane;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	
			image.setImage(new Image(getClass().getResourceAsStream("/pics/studee.png")));
	
		
	}
	
	public void Connect() throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/School","root","");
		Statement st=conn.createStatement();
		
		
		if(EnterUser.getText().isEmpty() && password.getText().isEmpty() && enterEmail.getText().isEmpty()) {
			
			System.out.println("Errorssss");
			
			
		}else {
			
			String table="CREATE TABLE IF NOT EXISTS Login(Username varchar(50),Password varchar(50),Email varchar(80))";
			String data="INSERT INTO School.Login VALUES('"+EnterUser.getText()+"','"+ password.getText()+"','"+enterEmail.getText()+"')";
			
			st.executeUpdate(table);
			st.executeUpdate(data);
			
			System.out.println("Table Created\nData inserted Successfully");
			
			Parent next=FXMLLoader.load(getClass().getClassLoader().getResource("Interface.fxml"));
			
			Stage mpya=new Stage();
			mpya.setScene(new Scene(next));
			mpya.show();
			
			pane.getScene().getWindow().hide();
			
		
			
			
		}
	
		}
		

	@FXML 
	public void register(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		
		Connect();
		
	
		
		
	}

}
