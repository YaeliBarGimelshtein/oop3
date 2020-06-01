package View;

import java.awt.event.ActionListener;
import java.util.Scanner;
import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
	private Group root; // to add more info
	private Group buttons;
	
	private Button addABallot; //buttons for menu
	private Button addACitizen;
	private Button addAParty;
	private Button addACandidateToParty;
	private Button showAllBallots;
	private Button showAllCitizens;
	private Button showAllParties;
	private Button elections;
	private Button ShowElectionResults;
	private Button exit;
	
	private Label output;
	
	private BorderPane bp; //to devide stage to left, right, center

	
	public View(Stage primaryStage) {
		this.root= new Group(); 
		output=new Label(); //for massages
		root.getChildren().add(output);
		
		buttons= new Group();
		//+add buttons to toggle...
		addABallot= new Button("Add a ballot");
		addACitizen= new Button("Add a citizen");
		addAParty= new Button("Add a party");
		addACandidateToParty= new Button("Add a candidate to a party");
		showAllBallots=new Button("Show all ballots");
		showAllCitizens=new Button("Show all citizens");
		showAllParties=new Button("Show all parties");
		elections=new Button("Strat the election");
		ShowElectionResults=new Button("Show election results");
		exit= new Button("EXIT");
		buttons.getChildren().addAll(addABallot,addACitizen); //add all!!
		
		Pane functionsPane= new Pane(); //set center of scene
		functionsPane.getChildren().add(root);
		
		VBox buttons= new VBox(); //view organization
		buttons.getChildren().addAll(addABallot,addACitizen,addAParty,addACandidateToParty,
				showAllBallots,showAllCitizens,showAllParties);
		VBox elecionButtons= new VBox();
		elecionButtons.getChildren().addAll(elections,ShowElectionResults,exit);
		
		
		bp=new BorderPane(); //adding all the features to the scene in order of left,center, right
		bp.setCenter(functionsPane);
		bp.setLeft(buttons);
		bp.setRight(elecionButtons);
		
		Scene scene= new Scene(bp,500,500); //to show the view
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void update(MainModel m,String pressed,Scanner scan) throws IDOutOfRange, ageOutOfRange { //show the updated model
		root.getChildren().clear();
		m.update(pressed, scan);
	}

	public String getPressed() {
		if(addABallot.isPressed()) {
			return addABallot.getText();
		}else if (addACitizen.isPressed()) {
			return addACitizen.getText();
		}else if (addAParty.isPressed()) {
			return addAParty.getText();
		}else if (addACandidateToParty.isPressed()) {
			return addACandidateToParty.getText();
		}else if (showAllBallots.isPressed()) {
			return showAllBallots.getText();
		}else if (showAllCitizens.isPressed()) {
			return showAllCitizens.getText();
		}else if(showAllParties.isPressed()) {
			return showAllParties.getText();
		}else if (elections.isPressed()) {
			return elections.getText();
		}else if (ShowElectionResults.isPressed()) {
			return ShowElectionResults.getText();
		}else {
			return exit.getText();
		}
	}

//	public void addChangeListenerToToggleGroup(ChangeListener<Toggle> buttonPressed) {
//		tg.selectedToggleProperty().addListener(buttonPressed);
//	}

	public void addActionListenerToView(ActionListener buttonPressed) {
		
	}
	
}
