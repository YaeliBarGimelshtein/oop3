package Controller;



import java.util.Scanner;
import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//finish try catch
//change to action listener
public class Controller {
	private View theView;
	private MainModel theModel;
	
	Scanner scan= new Scanner(System.in);
	
	public Controller(MainModel theModel, View theView) {
		this.theModel=theModel;
		this.theView=theView;
		
		//add event:
		EventHandler<ActionEvent> addABallotPressed= new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				theView.updateLabel("You have chose to add a ballot:");
				theView.addABallotUpdate(theModel,scan);
			}
		};
		theView.addEventHandlerToView(addABallotPressed);
	}

}
