package View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
	private Group root;
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
	private BorderPane bp;
	private ToggleGroup tg;
	
	public View(Stage primaryStage) {
		this.root= new Group(); 
		tg= new ToggleGroup(); // to check if mouse was pressed on a diffrent button
		
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
		
		Pane drawPane= new Pane(); //set center of scene
		drawPane.getChildren().add(root);
		
		VBox buttons= new VBox(); //view organization
		buttons.getChildren().addAll(addABallot,addACitizen,addAParty,addACandidateToParty,
				showAllBallots,showAllCitizens,showAllParties);
		VBox elecionButtons= new VBox();
		elecionButtons.getChildren().addAll(elections,ShowElectionResults,exit);
		
		
		bp=new BorderPane(); //adding all the features to the scene in order of left,center, right
		bp.setCenter(drawPane);
		bp.setLeft(buttons);
		bp.setRight(elecionButtons);
		
		Scene scene= new Scene(bp,500,500); //to show the view
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
