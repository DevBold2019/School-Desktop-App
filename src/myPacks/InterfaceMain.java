package myPacks;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Spinner;

public class InterfaceMain  implements Initializable{

	@FXML ComboBox <String>combo;
	@FXML ListView<String> list;
	@FXML AnchorPane regPane;
	@FXML Button Register;
	@FXML RadioButton Male;
	@FXML ToggleGroup gender;
	@FXML RadioButton Female;
	@FXML Spinner<String> levelEducation;
	@FXML ComboBox<String> learningMode;
	@FXML ComboBox<String> classTime;
	@FXML RadioButton mpesa;
	@FXML ToggleGroup payments;
	@FXML RadioButton equity;
	@FXML RadioButton cash;
	@FXML RadioButton others;
	@FXML Pane Reg;
	
	Statement st;

	@Override
	public void initialize(URL a, ResourceBundle ar) {
		// TODO Auto-generated method stub
		
		combo.getItems().addAll("Technology","Medicine","Business");
		
		learningMode.getItems().addAll("Online","FullTime","Evening");
	
		classTime.getItems().addAll("Weekends","FullTime","Holidays");
	}

	@FXML 
	public void GetSelected(ActionEvent event) {
		
	if(combo.getValue().equals("Technology")) {
			
		list.getItems().clear();
			list.getItems().addAll("Computer Science","Computer Engineering","Electronics");
			//list.getItems().clear();
			
		}else if(combo.getValue().equals("Medicine")) {
			
			list.getItems().clear();
			list.getItems().addAll("Food Chemical","Animal Health","Zoologist");
		
			
			
		}else {
			
			list.getItems().clear();
			list.getItems().addAll("Business Management","Accounting","Comerce");
			//list.getItems().clear();
		}

	}
	
	
				public void connectivity() throws ClassNotFoundException, SQLException {
					
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
					 st=con.createStatement();
					
					
					//String save=st.executeUpdate(sql);
					
					System.out.println("Tuko ndani");
					
	
	
					}
	
	

	@FXML 
	
	public void saveData(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		connectivity();
		
		
	}

}
