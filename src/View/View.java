package View;

import java.util.Vector;

import Model.IDOutOfRange;
import Model.MainModel;
import Model.Party;
import Model.ageOutOfRange;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;

public class View {
	private Button addABallot;
	private Button addACitizen;
	private Button addACandidate;
	private Button addAParty;
	private VBox leftMenu;
	private ComboBox<String> kind;
	private ComboBox<String> party;
	private String function;
	private TextField txtField;
	private TextField txtField2;
	private TextField txtField3;
	private TextField txtField4;
	private Text txtFieldtxt;
	private Text txtFieldtxt2;
	private Text txtFieldtxt3;
	private Text txtFieldtxt4;
	private Text txtCheckBox;
	private BorderPane bp;
	private Pane parametersPane;
	private HBox parametersBox;
	private Button add;
	private Button showAllBallots;
	private Button showAllCitizens;
	private Button showAllParties;
	private Label output;
	private VBox textFields;
	private HBox txt1;
	private HBox txt2;
	private HBox txt3;
	private HBox txt4;
	private HBox HcheckBox;
	private CheckBox check;

	public View(Stage primaryStage) {
		add = new Button("Add!");
		add.setPrefSize(100, 50);
		add.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		addABallot = new Button("Add Ballot");
		addABallot.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		addACitizen = new Button("Add Citizen");
		addACitizen.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		addACandidate = new Button("Add Candidate");
		addACandidate.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		addAParty = new Button("Add Party");
		addAParty.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		showAllBallots = new Button("Show All Ballots");
		showAllBallots.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		showAllCitizens = new Button("Show All Cititzens");
		showAllCitizens.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		showAllParties = new Button("Show All Parties");
		showAllParties.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		// add.setFont(Font.font(20));
		leftMenu = new VBox();
		output = new Label();
		output.setLayoutX(400);
		output.setLayoutY(300);
		output.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		output.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		//// Text fields and texts area////

		txtField = new TextField();
		txtField2 = new TextField();
		txtField3 = new TextField();
		txtField4 = new TextField();
		txtField.setPrefSize(250, 40);
		txtField2.setPrefSize(250, 40);
		txtField3.setPrefSize(250, 40);
		txtField4.setPrefSize(250, 40);
		txtFieldtxt = new Text();
		txtFieldtxt.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		txtFieldtxt2 = new Text();
		txtFieldtxt2.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		txtFieldtxt3 = new Text();
		txtFieldtxt3.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		txtFieldtxt4 = new Text();
		txtFieldtxt4.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		txtCheckBox = new Text();
		txtCheckBox.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		check = new CheckBox();
		txt1 = new HBox();
		txt2 = new HBox();
		txt3 = new HBox();
		txt4 = new HBox();
		HcheckBox = new HBox();
		txt1.getChildren().addAll(txtFieldtxt, txtField);
		txt2.getChildren().addAll(txtFieldtxt2, txtField2);
		txt3.getChildren().addAll(txtFieldtxt3, txtField3);
		txt4.getChildren().addAll(txtFieldtxt4, txtField4);
		HcheckBox.getChildren().addAll(txtCheckBox, check);
		textFields = new VBox();
		textFields.getChildren().addAll(txt1, txt2, txt3, txt4, HcheckBox);

		leftMenu.getChildren().addAll(addABallot, addACitizen, addAParty, addACandidate, showAllBallots,
				showAllCitizens, showAllParties);

		kind = new ComboBox<String>();
		kind.setPrefSize(250, 40);
		party = new ComboBox<String>();
		party.setPrefSize(250, 40);

		bp = new BorderPane();
		parametersPane = new Pane();
		parametersBox = new HBox();
		parametersBox.getChildren().addAll(kind, party, textFields, add); // yakir
																			// sim
																			// oto
																			// mitahat!!!!!!!!!!!
		parametersPane.getChildren().addAll(parametersBox, output);
		parametersPane.setVisible(false);
		bp.setCenter(parametersPane);
		bp.setLeft(leftMenu);
		BorderPane.setMargin(leftMenu, new Insets(20, 40, 20, 20));
		BorderPane.setMargin(parametersPane, new Insets(20, 40, 20, 20));
		HBox.setMargin(kind, new Insets(20, 40, 20, 20));
		HBox.setMargin(txtFieldtxt, new Insets(25, 0, 20, 20));
		HBox.setMargin(txtField, new Insets(20, 40, 20, 10));
		HBox.setMargin(add, new Insets(20, 40, 20, 300));

		Scene scene = new Scene(bp, 1700, 950);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void addABallot() {
		function = "addABallot";
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		kind.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(false);
		txt3.setVisible(false);
		kind.getItems().addAll("Sick Citizen Ballot", "Soldier Ballot", "Citizen Ballot", "Sick Soldier Ballot",
				"Candidate Ballot", "Sick Candidate Ballot");
		kind.setValue("Sick Citizen Ballot");
		txtFieldtxt.setText("Address");
		kind.setStyle("-fx-font: 18px Verdana");

	}

	public void addACitizen() {
		function = "addACitizen";
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		kind.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		txt3.setVisible(true);
		txt4.setVisible(false);
		HcheckBox.setVisible(false);
		kind.getItems().addAll("Citizen", "Soldier", "Sick Citizen", "Sick Soldier");
		kind.setValue("Citizen");
		kind.setStyle("-fx-font: 18px Verdana");
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("ID");
		txtFieldtxt3.setText("Birth year");
		txtFieldtxt4.setText("Number of sick days");
		txtCheckBox.setText("Carry a weapon?");

	}

	public void addAParty() {
		function = "addAParty";
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		txt3.setVisible(false);
		kind.setVisible(true);
		kind.getItems().addAll("Right", "Left", "Center");
		kind.setValue("Right");
		kind.setStyle("-fx-font: 18px Verdana");
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("Date");

	}

	public void addACandidate() {
		function = "addACandidate";
		parametersPane.setVisible(true);
		parametersBox.setVisible(true);
		kind.setVisible(true);
		party.setVisible(true);
		txt1.setVisible(true);
		txt2.setVisible(true);
		txt3.setVisible(true);
		txt4.setVisible(false);
		HcheckBox.setVisible(false);
		kind.getItems().addAll("Candidate", "Sick Candidate");
		kind.setValue("Candidate");
		kind.setStyle("-fx-font: 18px Verdana");
		party.setStyle("-fx-font: 18px Verdana");
		party.setValue("Meretz");
		txtFieldtxt.setText("Name");
		txtFieldtxt2.setText("ID");
		txtFieldtxt3.setText("Birth year");
		txtFieldtxt4.setText("Number of sick days");

	}

	public void showAllBallots(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showAllBallots";
		parametersBox.setVisible(false);
		parametersPane.setVisible(true);
		updateModel(theModel);

	}

	public void showAllCitizens(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showAllCitizens";
		parametersBox.setVisible(false);
		parametersPane.setVisible(true);
		updateModel(theModel);

	}

	public void showAllParties(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		function = "showAllParties";
		parametersBox.setVisible(false);
		parametersPane.setVisible(true);
		updateModel(theModel);
	}

	public void addEventToAddABallot(EventHandler<ActionEvent> addABallotPressed) {
		addABallot.setOnAction(addABallotPressed);

	}

	public void updateModel(MainModel theModel) throws IDOutOfRange, ageOutOfRange {
		if (function == "addABallot") {
			String kind = getComboKind();
			String ballotAdress = txtField.getText();
			if (txtField.getText().isEmpty()) {
				// add.setStyle("-fx-background-color: #f54331; ");
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Please enter Ballot address");
				msg.show();
			} else {
				// add.setStyle("-fx-background-color: #00b120; ");
				theModel.addABallotUpdate(kind, ballotAdress);
				Alert msg = new Alert(AlertType.CONFIRMATION);
				msg.setContentText("Ballot added!");
				msg.show();
				clearview(); // needs to be updated!
			}
		} else if (function == "addACitizen") {
			String kind = getComboKind();
			String name = txtField.getText();
			int ID;
			int year;
			boolean carryWeapon = check.isSelected();
			int sickDays;
			if (txtField.getText().isEmpty() || txtField2.getText().isEmpty() || txtField3.getText().isEmpty()
					|| kind == "Sick Citizen" || kind == "Sick Soldier") {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill all the details!");
				msg.show();
			} else if (kind == "Sick Citizen" || kind == "Sick Soldier") {
				if (txtField4.getText().isEmpty()) {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Must enter number of sick days!");
					msg.show();
				}

			} else {
				ID = Integer.parseInt(txtField2.getText());
				year = Integer.parseInt(txtField3.getText());
				sickDays = Integer.parseInt(txtField4.getText());
				boolean added = theModel.addACitizenUpdate(kind, name, ID, year, carryWeapon, sickDays);
				if (added) {
					Alert msg = new Alert(AlertType.CONFIRMATION);
					msg.setContentText("Citizen added!");
					msg.show();
					clearview();
				} else {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Citizen already in the system!");
					msg.show();
					clearview();
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
			int sickDays=0;
			if (txtField.getText().isEmpty() || txtField2.getText().isEmpty() || txtField3.getText().isEmpty()) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Must fill all the details!");
				msg.show();
			} else if (kind == "Sick Candidate") {
				if (txtField4.getText().isEmpty()) {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Must enter number of sick days!");
					msg.show();
				}

			} else {
				ID = Integer.parseInt(txtField2.getText());
				year = Integer.parseInt(txtField3.getText());
				if(kind == "Sick Candidate")
				sickDays = Integer.parseInt(txtField4.getText());
				boolean added = theModel.addACandidateUpdate(kind, name, ID, year, sickDays, party);
				if (added) {
					Alert msg = new Alert(AlertType.CONFIRMATION);
					msg.setContentText("Candidate added!");
					msg.show();
					clearview();
				} else {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setContentText("Candidate already in the system!");
					msg.show();
					clearview();
				}
			}

		} else if (function == "showAllBallots") {
			output.setText(theModel.showAllBallotsUpdate());
		} else if (function == "showAllCitizens") {
			output.setText(theModel.showAllCitizensUpdate());
		} else if (function == "showAllParties") {
			output.setText(theModel.showAllPartiesUpdate());
		}

	}

	public String getComboKind() {

		return kind.getValue();
	}

	public void clearview() {
		kind.getItems().clear();
		output.setText("");
		check.setSelected(false);
		txt1.setVisible(false);
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt4.setVisible(false);
		HcheckBox.setVisible(false);
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
		}
		else if (function == "addACandidate"){
			if (getComboKind() == "Sick Candidate") {
				txt4.setVisible(true);
			} else {
				txt4.setVisible(false);
			}
		}
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

	public void setPartiesToComboBox(Vector<String> runningParties) {
		party.getItems().addAll(runningParties);

	}

}
