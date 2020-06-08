package Controller;

import java.util.Scanner;
import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class Controller {
	private View view;
	private MainModel model;

	Scanner scan = new Scanner(System.in);

	public Controller(MainModel theModel, View theView) {
		this.model = theModel;
		this.view = theView;

		EventHandler<ActionEvent> addABallotPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.addABallot();

			}
		};
		view.addEventToAddABallot(addABallotPressed);

		EventHandler<ActionEvent> addACititzenPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.addACitizen();

			}
		};
		view.addEventToAddACitizen(addACititzenPressed);

		EventHandler<ActionEvent> addAPartyPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				view.addAParty();
			}
		};
		view.addEventToAddAParty(addAPartyPressed);

		EventHandler<ActionEvent> addACandidatePressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				model.updateParties(view);
				view.addACandidate();

			}
		};
		view.addEventToAddACandidate(addACandidatePressed);

		ChangeListener<String> comboBoxPressed = new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				view.updateComboBox(); 
			}
		};
		view.addListenerToComboBox(comboBoxPressed);

		EventHandler<ActionEvent> addButtonPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
					try {
						view.updateModel(model);
					} catch (IDOutOfRange e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ageOutOfRange e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		};
		view.addEventToAddButton(addButtonPressed);

		EventHandler<ActionEvent> showAllBallotsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				try {
					view.showAllBallots(model);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.addEventToShowAllBallots(showAllBallotsPressed);

		EventHandler<ActionEvent> showAllCitizensPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				try {
					view.showAllCitizens(model);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.addEventToShowAllCitizens(showAllCitizensPressed);

		EventHandler<ActionEvent> showAllPartiesPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				try {
					view.showAllParties(model);
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.addEventToShowAllParties(showAllPartiesPressed);

		EventHandler<ActionEvent> nextCitizenPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(model.nextVoter()) {
					view.nextCitizen(model.getVoterName(),model.getVoterID());
				}else {
					view.endVote(model);
				}
			}
		};
		view.addEventToNextCitizen(nextCitizenPressed);


		EventHandler<ActionEvent> votePressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				model.updateParties(view);
				model.createVoters();
				model.nextVoter();
				view.nextCitizen(model.getVoterName(),model.getVoterID());
				view.vote();
			}
		};
		view.addEventToVote(votePressed);

		EventHandler<ActionEvent> showResultsPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				try {
					if(view.getVotingIsDone()) {
						view.showResults(model);
					}
				} catch (IDOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ageOutOfRange e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		view.addEventToShowResults(showResultsPressed);

		EventHandler<ActionEvent> exitPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clearview();
				System.exit(0);
			}
		};
		view.addEventToExit(exitPressed);

		EventHandler<ActionEvent> showViewPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.showView();
			}
		};
		view.addEventToShowView(showViewPressed);
	}
}
