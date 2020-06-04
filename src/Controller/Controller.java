package Controller;

import java.awt.event.ActionListener;
import java.util.Scanner;
import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//finish try catch
//change to action listener
public class Controller {
	private View theView;
	private MainModel theModel;

	Scanner scan = new Scanner(System.in);

	public Controller(MainModel theModel, View theView) {
		this.theModel = theModel;
		this.theView = theView;

		EventHandler<ActionEvent> addABallotPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				theView.addABallot();

			}
		};
		theView.addEventToAddABallot(addABallotPressed);

		ChangeListener<String> comboBoxPressed = new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				theView.updateComboBox(theView.getFunction()); // later!!!

			}
		};

		EventHandler<ActionEvent> addButtonPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.updateModel(theModel);

			}
		};
		theView.addEventToAddButton(addButtonPressed);

	}

}
