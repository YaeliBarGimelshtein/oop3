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

		EventHandler<ActionEvent> addACititzenPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				theView.addACitizen();

			}
		};
		theView.addEventToAddACitizen(addACititzenPressed);

		EventHandler<ActionEvent> addAPartyPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				theView.addAParty();
			}
		};
		theView.addEventToAddAParty(addAPartyPressed);

		EventHandler<ActionEvent> addACandidatePressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				theModel.updateParties(theView);
				theView.addACandidate();

			}
		};
		theView.addEventToAddACandidate(addACandidatePressed);

		ChangeListener<String> comboBoxPressed = new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				theView.updateComboBox(); // later!!!

			}
		};
		theView.addListenerToComboBox(comboBoxPressed);

		EventHandler<ActionEvent> addButtonPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					theView.updateModel(theModel);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		theView.addEventToAddButton(addButtonPressed);

		EventHandler<ActionEvent> showAllBallotsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				try {
					theView.showAllBallots(theModel);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		theView.addEventToShowAllBallots(showAllBallotsPressed);

		EventHandler<ActionEvent> showAllCitizensPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				try {
					theView.showAllCitizens(theModel);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		theView.addEventToShowAllCitizens(showAllCitizensPressed);

		EventHandler<ActionEvent> showAllPartiesPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				try {
					theView.showAllParties(theModel);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		theView.addEventToShowAllParties(showAllPartiesPressed);
		
		EventHandler<ActionEvent> nextCitizenPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(theModel.nextVoter()) {
				theView.nextCitizen(theModel.getVoterName(),theModel.getVoterID());
				}else {
					theView.endVote();
				}
			}
		};
		theView.addEventToNextCitizen(nextCitizenPressed);
		
		
		EventHandler<ActionEvent> votePressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.clearview();
				theModel.updateParties(theView);
				theModel.createVoters();
				theModel.nextVoter();
				theView.nextCitizen(theModel.getVoterName(),theModel.getVoterID());
				theView.vote();
			}
		};
		theView.addEventToVote(votePressed);
	}

	
}
