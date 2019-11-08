package myPacks;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

public class WelcomeController implements Initializable {
	
	@FXML
	ImageView Image1,image2;
	@FXML 
	Button SignUp;
	@FXML 
	Pane Pane2;
	@FXML 
	Button LoginBtn;
	@FXML TextField username;
	@FXML PasswordField password;
	@FXML AnchorPane anchor;

	@Override
	public void initialize(URL a, ResourceBundle ar) {
		// TODO Auto-generated method stub
		
			
			Image1.setImage(new Image(getClass().getResourceAsStream("/pics/studee.png")));

			image2.setImage(new Image(getClass().getResourceAsStream("/pics/studee.png")));
			
		
		
		
	}
	
	public void connect() throws ClassNotFoundException, SQLException, IOException {
		
	
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/School","root","");
		
		Statement st=con.createStatement();
		
		
		String user=username.getText();
		String pswd=password.getText();
		
		String query="SELECT Password,Username FROM login";
		
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			
			String usernam=rs.getString("Username");
			String password=rs.getString("Password");
			
			if(usernam.equals(user) && password.equals(pswd)) {
				
				Parent next=FXMLLoader.load(getClass().getClassLoader().getResource("Interface.fxml"));
				
				Stage mpya=new Stage();
				mpya.setScene(new Scene(next));
				mpya.setTitle("Bold Online ver 4.6");
				mpya.show();
				
				anchor.getScene().getWindow().hide();
			
				System.out.println("Logged in Sucessful");
				
				
			} if (user.isEmpty() && pswd.isEmpty()){
				
				
					System.out.println("Value can't be empty");
				
				
		
				
			}else {
				
				 username.setText("Invalid");
				 
		
					
			}
			
			
		}
		
		
		
		
	}

	@FXML
	public void LoginHere(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		
		 connect();
		 
			
		
	}

	@FXML
	public void SignUp(ActionEvent event) throws IOException {
	
		Parent sign=FXMLLoader.load(getClass().getClassLoader().getResource("SignUpUI.fxml"));
		
		Pane2.getChildren().clear();
		Pane2.getChildren().setAll(sign);
		
		
		
		
	}

}
