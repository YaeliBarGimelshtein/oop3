package View;



import java.util.Scanner;
import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private TextField input;
	
	private BorderPane bp; //to devide stage to left, right, center

	
	public View(Stage primaryStage) {
		this.root= new Group(); 
		output=new Label(); //for massages
		output.setAlignment(Pos.BOTTOM_CENTER);
		input=new TextField(); //not on screen yet
		input.setVisible(false);
		root.getChildren().addAll(output,input);
		
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
		ShowElectionResults.setVisible(false);
		exit= new Button("EXIT");
		buttons.getChildren().addAll(addABallot,addACitizen); //add all!!
		
		Pane functionsPane= new Pane(); //set center of scene
		functionsPane.getChildren().add(root);
		
		VBox buttons= new VBox(); //view organization
		buttons.getChildren().addAll(addABallot,addACitizen,addAParty,addACandidateToParty,
				showAllBallots,showAllCitizens,showAllParties, elections,ShowElectionResults,exit);
		
		VBox.setMargin(addABallot, new Insets(10, 10, 10, 10));
		VBox.setMargin(addACitizen, new Insets(10, 10, 10, 10));
		VBox.setMargin(addAParty, new Insets(10, 10, 10, 10));
		VBox.setMargin(addACandidateToParty, new Insets(10, 10, 10, 10));
		VBox.setMargin(showAllBallots, new Insets(10, 10, 10, 10));
		VBox.setMargin(showAllCitizens, new Insets(10, 10, 10, 10));
		VBox.setMargin(showAllParties, new Insets(10, 10, 10, 10));
		VBox.setMargin(elections, new Insets(10, 10, 10, 10));
		VBox.setMargin(ShowElectionResults, new Insets(10, 10, 10, 10));
		VBox.setMargin(exit, new Insets(10, 10, 10, 10));
		
		bp=new BorderPane(); //adding all the features to the scene in order of left,center, right
		bp.setCenter(functionsPane);
		bp.setLeft(buttons);
		
		
		Scene scene= new Scene(bp,1920,1020); //to show the view
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void update(MainModel m,Scanner scan) throws IDOutOfRange, ageOutOfRange { //show the updated model
		root.getChildren().clear();
		//m.update(scan);
	}

//	public String getPressed() {
//		if(addABallot.isPressed()) {
//			return addABallot.getText();
//		}else if (addACitizen.isPressed()) {
//			return addACitizen.getText();
//		}else if (addAParty.isPressed()) {
//			return addAParty.getText();
//		}else if (addACandidateToParty.isPressed()) {
//			return addACandidateToParty.getText();
//		}else if (showAllBallots.isPressed()) {
//			return showAllBallots.getText();
//		}else if (showAllCitizens.isPressed()) {
//			return showAllCitizens.getText();
//		}else if(showAllParties.isPressed()) {
//			return showAllParties.getText();
//		}else if (elections.isPressed()) {
//			return elections.getText();
//		}else if (ShowElectionResults.isPressed()) {
//			return ShowElectionResults.getText();
//		}else {
//			return exit.getText();
//		}
//	}

	public void addEventHandlerToView(EventHandler<ActionEvent> eventForSubmitButton) {
		addABallot.setOnAction(eventForSubmitButton);
	}

	public void addABallotUpdate(MainModel theModel, Scanner scan) {
		theModel.addABallotUpdate(scan);
	}
	
	public void updateLabel(String newStr) {
		this.output.setText(newStr);
	}
	
	
}
