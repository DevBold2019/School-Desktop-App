package myPacks;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
		
			Parent page=FXMLLoader.load(getClass().getClassLoader().getResource("WelcomeUI.fxml"));
			
			
			
			primaryStage.setScene(new Scene(page));
			Image icon=new Image(getClass().getResourceAsStream("/pics/studee.png"));
			primaryStage.getIcons().add(icon);
			primaryStage.centerOnScreen();
			primaryStage.setTitle("Bold ver 4.6");
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
