package View;

import java.util.Vector;

import com.sun.javafx.charts.Legend;
import com.sun.javafx.geom.Rectangle;

import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class View {
	// buttons:
	private Button addABallot;
	private Button addACitizen;
	private Button addACandidate;
	private Button addAParty;
	private Button showAllBallots;
	private Button showAllCitizens;
	private Button showAllParties;
	private Button vote;
	private Button nextCitizen;
	private Button showResults;
	private Button exit;
	private Button add;
	// for coding only!!
	private Button showView;

	private ComboBox<String> kind;
	private ComboBox<String> party;
	private CheckBox check;
	// leyout:
	private VBox leftMenu;
	private VBox comboTxt1;
	private VBox comboTxt2;
	private HBox comboBoxesAndTexts;
	private BorderPane bp;
	private ScrollPane parametersPane;
	private VBox parametersBox;
	private HBox textFields;
	private VBox txt1;
	private VBox txt2;
	private VBox txt3;
	private VBox txt4;
	private VBox HcheckBox;
	private VBox txtAndCheck;
	private VBox comboAndTexts;
	private HBox addAndNext;
	// output:
	private TextField txtField;
	private TextField txtField2;
	private TextField txtField3;
	private TextField txtField4;
	private Text txtFieldtxt;
	private Text txtFieldtxt2;
	private Text txtFieldtxt3;
	private Text txtFieldtxt4;
	private Text txtCheckBox;
	private Text comboBoxtxt;
	private Text comboBoxtxt2;
	private String resultsString;
	private Label output;

	private BarChart<String,Number> barChart;
	private XYChart.Series results;

	private String function;
	private boolean voteIsDone;

	public View(Stage primaryStage) {
		// coding only!!
		showView = new Button("Show View");
		showView.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showView.setPrefSize(140, 30);
		//showView.setStyle("-fx-border-color: #ac5454");
		showView.setStyle("-fx-background-color: #54ac96;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showView.setTextFill(Color.WHITE);
		//showView.setBorder("-fx-border-color: #54ac96");
		
		// buttons:
		addABallot = new Button("Add Ballot");
		addABallot.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		addABallot.setPrefSize(140, 30);
		addABallot.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		addABallot.setTextFill(Color.WHITE);

		addACitizen = new Button("Add Citizen");
		addACitizen.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		addACitizen.setPrefSize(140, 30);
		addACitizen.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		addACitizen.setTextFill(Color.WHITE);

		addACandidate = new Button("Add Candidate");
		addACandidate.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		addACandidate.setPrefSize(140, 30);
		addACandidate.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		addACandidate.setTextFill(Color.WHITE);

		addAParty = new Button("Add Party");
		addAParty.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		addAParty.setPrefSize(140, 30);
		addAParty.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		addAParty.setTextFill(Color.WHITE);

		showAllBallots = new Button("Show All Ballots");
		showAllBallots.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllBallots.setPrefSize(140, 30);
		showAllBallots.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllBallots.setTextFill(Color.WHITE);

		showAllCitizens = new Button("Show All Cititzens");
		showAllCitizens.setFont(Font.font("Verdana", FontWeight.BOLD, 11.6));
		showAllCitizens.setPrefSize(140, 30);
		showAllCitizens.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllCitizens.setTextFill(Color.WHITE);

		showAllParties = new Button("Show All Parties");
		showAllParties.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllParties.setPrefSize(140, 30);
		showAllParties.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllParties.setTextFill(Color.WHITE);

		vote = new Button("vote!");
		vote.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		vote.setPrefSize(140, 30);
		vote.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		vote.setTextFill(Color.WHITE);

		showResults = new Button("show Results");
		showResults.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showResults.setDisable(true);
		showResults.setPrefSize(140, 30);
		showResults.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showResults.setTextFill(Color.WHITE);

		add = new Button("Add!");
		add.setPrefSize(60, 30);
		add.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		add.setPrefSize(140, 30);
		add.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		add.setTextFill(Color.WHITE);

		nextCitizen = new Button("Next");
		nextCitizen.setPrefSize(60, 30);
		nextCitizen.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		nextCitizen.setPrefSize(140, 30);
		nextCitizen.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		nextCitizen.setTextFill(Color.WHITE);

		exit = new Button("Exit");
		exit.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		exit.setPrefSize(140, 30);
		exit.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		exit.setTextFill(Color.WHITE);

		kind = new ComboBox<String>();
		kind.setPrefSize(160, 30);
		
		party = new ComboBox<String>();
		party.setPrefSize(160, 30);

		check = new CheckBox();
		// output:
		output = new Label();
		output.setText("Label example");
		output.setLayoutX(50);
		output.setLayoutY(50);
		output.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		output.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		output.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		output.setTextFill(Color.WHITE);
		output.setWrapText(true);
		output.setMaxWidth(1000);
		

		txtField = new TextField();
		txtField.setPrefSize(120, 40);
		txtField2 = new TextField();
		txtField2.setPrefSize(120, 40);
		txtField3 = new TextField();
		txtField3.setPrefSize(120, 40);
		txtField4 = new TextField();
		txtField4.setPrefSize(120, 40);

		txtFieldtxt = new Text();
		txtFieldtxt.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		txtFieldtxt2 = new Text();
		txtFieldtxt2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		txtFieldtxt3 = new Text();
		txtFieldtxt3.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		txtFieldtxt4 = new Text();
		txtFieldtxt4.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		txtCheckBox = new Text();
		txtCheckBox.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		comboBoxtxt = new Text();
		comboBoxtxt.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		comboBoxtxt2 = new Text();
		comboBoxtxt2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		
		// layout:
		leftMenu = new VBox();
		comboTxt1=new VBox();
		comboTxt2=new VBox();
		comboBoxesAndTexts=new HBox();
		txt1 = new VBox();
		txt2 = new VBox();
		txt3 = new VBox();
		txt4 = new VBox();
		HcheckBox = new VBox();
		txtAndCheck=new VBox();
		comboAndTexts=new VBox();
		addAndNext=new HBox();
		textFields = new HBox();
		bp = new BorderPane();
		parametersPane = new ScrollPane();
		
		parametersBox = new VBox();
		parametersBox.setAlignment(Pos.TOP_CENTER);

		results = new XYChart.Series();
		results.setName("Election Resualts");


		createBarChart();		
		
		// Connection between all:
		voteIsDone = false;
		txt1.getChildren().addAll(txtFieldtxt, txtField);
		txt2.getChildren().addAll(txtFieldtxt2, txtField2);
		txt3.getChildren().addAll(txtFieldtxt3, txtField3);
		txt4.getChildren().addAll(txtFieldtxt4, txtField4);

		VBox.setMargin(txtFieldtxt, new Insets(0,0,0,40));
		VBox.setMargin(txtFieldtxt2, new Insets(0,0,0,50));
		VBox.setMargin(txtFieldtxt3, new Insets(0,0,0,25));

		
		txt1.setSpacing(10);
		txt2.setSpacing(10);
		txt3.setSpacing(10);
		txt4.setSpacing(10);

		HcheckBox.getChildren().addAll(txtCheckBox, check);
		HcheckBox.setSpacing(10);
		VBox.setMargin(check, new Insets(0,0,0,45));
		
		comboTxt1.getChildren().addAll(comboBoxtxt,kind);
		VBox.setMargin(comboBoxtxt, new Insets(0,0,0,40));
		comboTxt1.setSpacing(10);
		comboTxt2.getChildren().addAll(comboBoxtxt2,party);
		VBox.setMargin(comboBoxtxt2, new Insets(0,0,0,40));
		comboTxt2.setSpacing(10);

		
		comboBoxesAndTexts.getChildren().addAll(comboTxt1,comboTxt2);
		comboBoxesAndTexts.setSpacing(40);

		comboAndTexts.getChildren().addAll(comboBoxesAndTexts,textFields);
		comboAndTexts.setSpacing(50);
		
		addAndNext.getChildren().addAll(add,nextCitizen);
		addAndNext.setSpacing(100);
		
		
		textFields.getChildren().addAll(txt1, txt2, txt3, txt4);		
		textFields.setSpacing(20);
		HBox.setMargin(txt1, new Insets(0,0 , 0, 90));
		
		txtAndCheck.getChildren().addAll(textFields,HcheckBox);
		txtAndCheck.setSpacing(20);
		VBox.setMargin(HcheckBox, new Insets(0,0,0,215));
		
		leftMenu.getChildren().addAll(addABallot, addACitizen, addAParty, addACandidate, showAllBallots,
				showAllCitizens, showAllParties, vote, showResults, exit, showView);

		parametersBox.getChildren().addAll(comboAndTexts,txtAndCheck,addAndNext); // yakir
		parametersBox.setSpacing(20);
		VBox.setMargin(comboAndTexts, new Insets(50,50,50,90));
		VBox.setMargin(addAndNext, new Insets(50,50,50,80));


		

		Group root= new Group();
		root.getChildren().addAll(parametersBox,barChart,output);
		parametersPane.setContent(root);
		parametersPane.setVisible(false);
		parametersPane.setStyle("-fx-background: #f3eace;-fx-border-color: #f3eace;");
		
		barChart.setLayoutY(470);
		barChart.setLayoutX(100);

		bp.setCenter(parametersPane);
		bp.setLeft(leftMenu);
		

		BorderPane.setMargin(leftMenu, new Insets(20, 40, 20, 20));
		leftMenu.setSpacing(10);

		bp.styleProperty().set("-fx-background-color: #f3eace");	
		
		Rectangle2D screen = Screen.getPrimary().getBounds();
		Scene scene = new Scene(bp, screen.getMaxX()-50, screen.getMaxY()-130);
		
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(false);
		primaryStage.show();
	}

	public void addABallot() {
		function = "addABallot";
		add.setVisible(true);
		add.setText("Add!");
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		kind.setVisible(true);
		comboBoxtxt.setVisible(true);
		comboBoxtxt.setText("Ballot Kind");
		txt1.setVisible(true);
		kind.getItems().addAll("Sick Citizen Ballot", "Soldier Ballot", "Citizen Ballot", "Sick Soldier Ballot",
				"Candidate Ballot", "Sick Candidate Ballot");
		kind.setValue("Sick Citizen Ballot");
		txtFieldtxt.setText("Address");
		kind.setStyle("-fx-font: 12px Verdana");

	}

	public void addACitizen() {
		function = "addACitizen";
		add.setVisible(true);
		add.setText("Add!");
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		kind.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		txt3.setVisible(true);
		comboBoxtxt.setVisible(true);
		kind.getItems().addAll("Citizen", "Soldier", "Sick Citizen", "Sick Soldier");
		kind.setValue("Citizen");
		kind.setStyle("-fx-font: 12px Verdana");
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("ID");
		txtFieldtxt3.setText("Birth year");
		txtFieldtxt4.setText("Number of sick days");
		txtCheckBox.setText("Carry a weapon?");
		comboBoxtxt.setText("Citizen Kind");
	}

	public void addAParty() {
		function = "addAParty";
		add.setVisible(true);
		add.setText("Add!");
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		kind.setVisible(true);
		comboBoxtxt.setVisible(true);
		kind.getItems().addAll("Right", "Left", "Center");
		kind.setValue("Right");
		kind.setStyle("-fx-font: 12px Verdana");
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("Date");
		comboBoxtxt.setText("Party Faction");
		VBox.setMargin(txtFieldtxt2, new Insets(0,0,0,45));
	}

	public void addACandidate() {
		function = "addACandidate";
		add.setVisible(true);
		add.setText("Add!");
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		kind.setVisible(true);
		party.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		txt3.setVisible(true);
		comboBoxtxt.setVisible(true);
		comboBoxtxt2.setVisible(true);
		kind.getItems().addAll("Candidate", "Sick Candidate");
		kind.setValue("Candidate");
		kind.setStyle("-fx-font: 12px Verdana");
		party.setStyle("-fx-font: 12px Verdana");
		party.setValue("Meretz");
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("ID");
		txtFieldtxt3.setText("Birth year");
		txtFieldtxt4.setText("Number of sick days");
		comboBoxtxt.setText("Candidate Kind");
		comboBoxtxt2.setText("Party");
		VBox.setMargin(comboBoxtxt, new Insets(0,0,0,25));
		VBox.setMargin(comboBoxtxt2, new Insets(0,0,0,65));

	}

	public void showAllBallots(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showAllBallots";
		parametersPane.setVisible(true);
		output.setVisible(true);
		updateModel(theModel);

	}

	public void showAllCitizens(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showAllCitizens";
		parametersPane.setVisible(true);
		output.setVisible(true);
		updateModel(theModel);

	}

	public void showAllParties(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showAllParties";
		output.setVisible(true);
		parametersPane.setVisible(true);
		updateModel(theModel);
	}

	public void vote() {
		function = "vote";
		kind.setVisible(true);
		kind.getItems().addAll("Yes", "No");
		add.setText("Done");
		add.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		parametersPane.setVisible(true);
		nextCitizen.setVisible(true);
		nextCitizen.setDisable(true);
		addABallot.setDisable(true);
		addACitizen.setDisable(true);
		addACandidate.setDisable(true);
		addAParty.setDisable(true);
		showAllBallots.setDisable(true);
		showAllCitizens.setDisable(true);
		showAllParties.setDisable(true);
		showResults.setDisable(true);
		comboBoxtxt.setVisible(true);
		comboBoxtxt.setText("Do You Want To Vote?");
		VBox.setMargin(comboBoxtxt, new Insets(0,0,0,5));
	}

	public void showResults(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showResults";
		parametersPane.setVisible(true);
		barChart.setVisible(true);
		output.setVisible(true);
		vote.setDisable(true);
		updateModel(theModel);
	}

	private void createBarChart() {
		// creating Axis
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Parties");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Votes");
		// creating the bar chart
		barChart = new BarChart(xAxis, yAxis);
		
	}

	public void updateModel(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		if (function == "addABallot") {
			String kind = getComboKind();
			String ballotAdress = txtField.getText();
			if (txtField.getText().isEmpty()) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Please enter Ballot address");
				msg.show();
			} else {
				theModel.addABallotUpdate(kind, ballotAdress);
				Alert msg = new Alert(AlertType.CONFIRMATION);
				msg.setContentText("Ballot added!");
				msg.show();
				clearview(); 
			}
		} else if (function == "addACitizen") {
			String kind = getComboKind();
			String name = txtField.getText();
			int ID;
			int year;
			boolean carryWeapon = check.isSelected();
			int sickDays = 0;
			if (txtField.getText().isEmpty() || txtField2.getText().isEmpty() || txtField3.getText().isEmpty()) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill all the details!");
				msg.show();
			} else if ((kind == "Sick Citizen" && txtField4.getText().isEmpty())
					|| (kind == "Sick Soldier" && txtField4.getText().isEmpty())) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must enter number of sick days!");
				msg.show();
			} else {
				ID = Integer.parseInt(txtField2.getText());
				year = Integer.parseInt(txtField3.getText());
				if (kind == "Sick Citizen" || kind == "Sick Soldier") {
					sickDays = Integer.parseInt(txtField4.getText());
				}
				boolean added = theModel.addACitizenUpdate(kind, name, ID, year, carryWeapon, sickDays);
				if (added) {
					Alert msg = new Alert(AlertType.CONFIRMATION);
					msg.setContentText("Citizen added!");
					msg.show();
					clearview();
				} else {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Not possible to add-the person already exists");
					msg.show();
				}
			}
		} else if (function == "addAParty") {
			String partyName = txtField.getText();
			String partyDate = txtField2.getText();
			if (txtField.getText().isEmpty() || txtField2.getText().isEmpty()) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill all the details!");
				msg.show();
			} else {
				theModel.addAPartyUpdate(partyName, kind.getValue(), partyDate);
				Alert msg = new Alert(AlertType.CONFIRMATION);
				msg.setContentText("Party added!");
				msg.show();
				clearview();
			}
		} else if (function == "addACandidate") {
			String kind = getComboKind();
			String party = this.party.getValue();
			String name = txtField.getText();
			int ID;
			int year;
			int sickDays = 0;
			if (txtField.getText().isEmpty() || txtField2.getText().isEmpty() || txtField3.getText().isEmpty()) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill all the details!");
				msg.show();
			} else if (kind == "Sick Candidate" && txtField4.getText().isEmpty() ) {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Must enter number of sick days!");
					msg.show();
			} else {
				ID = Integer.parseInt(txtField2.getText());
				year = Integer.parseInt(txtField3.getText());
				if (kind == "Sick Candidate")
					sickDays = Integer.parseInt(txtField4.getText());
				boolean added = theModel.addACandidateUpdate(kind, name, ID, year, sickDays, party);
				if (added) {
					Alert msg = new Alert(AlertType.CONFIRMATION);
					msg.setContentText("Candidate added!");
					msg.show();
					clearview();
				} else {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Not possible to add-the person already exists");
					msg.show();
				}
			}
		} else if (function == "showAllBallots") {
//			Alert msg = new Alert(AlertType.INFORMATION);
//			msg.setContentText(theModel.showAllBallotsUpdate());
//			msg.show();
			output.setText(theModel.showAllBallotsUpdate());
			//clearview();
		} else if (function == "showAllCitizens") {
//			Alert msg = new Alert(AlertType.INFORMATION);
//			msg.setContentText(theModel.showAllCitizensUpdate());
//			msg.show();
			//clearview();
			output.setText(theModel.showAllCitizensUpdate());
		} else if (function == "showAllParties") {
			output.setText(theModel.showAllPartiesUpdate());
//			Alert msg = new Alert(AlertType.INFORMATION);
//			msg.setContentText(theModel.showAllPartiesUpdate());
//			msg.show();
			//clearview();
		} else if (function == "vote") {
			Boolean isVoting = false;
			if (getComboKind() == "") {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("must choose whether to vote or not!");
				msg.show();
				nextCitizen.setDisable(true);
				kind.setDisable(false);
				party.setDisable(false);
			} else {
				nextCitizen.setDisable(false);
				kind.setDisable(true);
				party.setDisable(true);
				if (getComboKind() == "Yes") {
					isVoting = true;
				}
				String party = this.party.getValue();
				theModel.electionsUpdate(party, isVoting);
				Alert msg = new Alert(AlertType.CONFIRMATION);
				msg.setHeaderText("Thank you for youre vote!");
				msg.setContentText("press next for next voter");
				msg.show();
				add.setDisable(true);
			}

		} else if (function == "showResults") {
//			Alert msg = new Alert(AlertType.INFORMATION);
			output.setText(resultsString);
//			msg.setContentText(resultsString);
//			msg.show();
			barChart.setVisible(true);
		}
	}


	public String getComboKind() {
		return kind.getValue();
	}

	public void clearview() {
		barChart.setVisible(false);
		kind.getItems().clear();
		party.getItems().clear();
		output.setText("");
		output.setVisible(false);
		check.setSelected(false);
		txt1.setVisible(false);
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt4.setVisible(false);
		HcheckBox.setVisible(false);
		kind.setVisible(false);
		party.setVisible(false);
		add.setVisible(false);
		nextCitizen.setVisible(false);
		txtField.setDisable(false);
		txtField2.setDisable(false);
		txtField.setText("");
		txtField2.setText("");
		txtField3.setText("");
		txtField4.setText("");
		comboBoxtxt.setVisible(false);
		comboBoxtxt2.setVisible(false);
	}

	public void updateComboBox() {
		if (function == "addACitizen") {
			if (getComboKind() == "Sick Citizen" || getComboKind() == "Sick Soldier") {
				txt4.setVisible(true);
			} else {
				txt4.setVisible(false);
			}
			if (getComboKind() == "Sick Soldier" || getComboKind() == "Soldier") {
				HcheckBox.setVisible(true);
			} else {
				HcheckBox.setVisible(false);
			}
		} else if (function == "addACandidate") {
			if (getComboKind() == "Sick Candidate") {
				txt4.setVisible(true);
			} else {
				txt4.setVisible(false);
			}
		} else if (function == "vote") {
			if (getComboKind() == "Yes") {
				party.setVisible(true);
				comboBoxtxt2.setVisible(true);
				comboBoxtxt2.setText("Party");
				comboTxt2.setMargin(comboBoxtxt2, new Insets(0,0,0,65));
				party.setValue("HaLikud");
			} else {
				party.setVisible(false);
			}
		}
	}

	public void addEventToAddABallot(EventHandler<ActionEvent> addABallotPressed) {
		addABallot.setOnAction(addABallotPressed);
	}

	public void addEventToAddButton(EventHandler<ActionEvent> addButtonPressed) {
		add.setOnAction(addButtonPressed);

	}

	public void addEventToShowAllBallots(EventHandler<ActionEvent> showAllButtonsPressed) {
		showAllBallots.setOnAction(showAllButtonsPressed);

	}

	public void addEventToShowAllCitizens(EventHandler<ActionEvent> showAllCitizensPressed) {
		showAllCitizens.setOnAction(showAllCitizensPressed);

	}

	public void addEventToShowAllParties(EventHandler<ActionEvent> showAllPartiesPressed) {
		showAllParties.setOnAction(showAllPartiesPressed);

	}

	public void addEventToAddAParty(EventHandler<ActionEvent> addAPartyPressed) {
		addAParty.setOnAction(addAPartyPressed);

	}

	public void addEventToAddACitizen(EventHandler<ActionEvent> addACititzenPressed) {
		addACitizen.setOnAction(addACititzenPressed);

	}

	public void addListenerToComboBox(ChangeListener<String> comboBoxPressed) {
		kind.valueProperty().addListener(comboBoxPressed);

	}

	public void addEventToAddACandidate(EventHandler<ActionEvent> addACandidatePressed) {
		addACandidate.setOnAction(addACandidatePressed);

	}

	public void addEventToVote(EventHandler<ActionEvent> votePressed) {
		vote.setOnAction(votePressed);
	}

	public void setPartiesToComboBox(Vector<String> runningParties) {
		party.getItems().addAll(runningParties);

	}

	public void addEventToNextCitizen(EventHandler<ActionEvent> nextCitizenPressed) {
		nextCitizen.setOnAction(nextCitizenPressed);
	}

	public void addEventToShowResults(EventHandler<ActionEvent> showResultsPressed) {
		showResults.setOnAction(showResultsPressed);
	}

	public void addEventToExit(EventHandler<ActionEvent> exitPressed) {
		exit.setOnAction(exitPressed);
	}

	public void showView() {
		parametersBox.setVisible(true);
		parametersPane.setVisible(true);
		kind.getItems().clear();
		party.getItems().clear();
		output.setText("Label");
		output.setVisible(true);
		check.setSelected(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		txt3.setVisible(true);
		txt4.setVisible(true);
		HcheckBox.setVisible(true);
		kind.setVisible(true);
		party.setVisible(true);
		add.setVisible(true);
		nextCitizen.setVisible(true);
		txtField.setDisable(true);
		txtField2.setDisable(true);
		txtField.setText("txtField");
		txtField2.setText("txtField2");
		txtField3.setText("txtField3");
		txtField4.setText("txtField4");
		txtFieldtxt.setText("txtFieldtxt");
		txtFieldtxt2.setText("txtFieldtxt2");
		txtFieldtxt3.setText("txtFieldtxt3");
		txtFieldtxt4.setText("txtFieldtxt4");
		txtCheckBox.setText("check box txt");
		barChart.setVisible(true);
		comboBoxtxt.setVisible(true);
		comboBoxtxt2.setVisible(true);
		comboBoxtxt.setText("comboBoxtxt");
		comboBoxtxt2.setText("comboBoxtxt2");
		txtAndCheck.setVisible(true);
	}

	public void nextCitizen(String voterName, String voterID) {
		kind.setValue("");
		party.setValue("");
		txtField.setText(voterName);
		txtField.setDisable(true);
		txtField2.setText(voterID);
		txtField2.setDisable(true);
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("ID");
		add.setDisable(false);
		nextCitizen.setDisable(true);
		kind.setDisable(false);
		party.setDisable(false);
	}

	public void endVote(MainModel model) {
		voteIsDone = true;
		Alert msg = new Alert(AlertType.CONFIRMATION);
		msg.setHeaderText("Thank you for youre vote!");
		msg.setContentText("the voting is done!");
		msg.show();
		clearview();
		showResults.setDisable(false);
		showAllBallots.setDisable(false);
		showAllCitizens.setDisable(false);
		showAllParties.setDisable(false);
		this.vote.setDisable(true);
		this.addABallot.setDisable(true);
		this.addACitizen.setDisable(true);
		this.addAParty.setDisable(true);
		this.addACandidate.setDisable(true);
		resultsString=model.showResultsUpdate();
		model.setNumberOfVotersPerParty();
		model.setInfoForView(results);
		barChart.getData().add(results);
		barChart.setStyle("-fx-text-fill: #54ac96");
		for(Node n:barChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: #54ac96;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
        }
		for(Node m : barChart.getChildrenUnmodifiable()){
			   if(m instanceof Legend){
			      for(Legend.LegendItem legendItem : ((Legend)m).getItems()){
			        legendItem.getSymbol().setStyle("-fx-background-color: #54ac96;");
			      }
			   }
			}

	}

	public boolean getVotingIsDone() {
		return voteIsDone;
	}

	public void addEventToShowView(EventHandler<ActionEvent> showViewPressed) {
		showView.setOnAction(showViewPressed);

	}

	public XYChart.Series getXYChart() {
		return results;
	}

	public void IDOutOfRangeMassage() {
		Alert msg = new Alert(AlertType.ERROR);
		msg.setHeaderText("The ID you typed is invalid");
		msg.setContentText("ID Out Of Range Massage");
		msg.show();
	
	}

	public void ageOutOfRangeMassage() {
		Alert msg = new Alert(AlertType.ERROR);
		msg.setHeaderText("The age you typed is invalid");
		msg.setContentText("Age out of range");
		msg.show();
		
	}

}
