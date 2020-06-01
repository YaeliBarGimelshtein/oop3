
import Controller.Controller;
import View.View;
import id315000539_id318353356_id208722710.MainModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {	
		launch(args);	
}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainModel theModel= new MainModel();
		View theView= new View(primaryStage);
		Controller theController= new Controller(theModel,theView);
	}
}
