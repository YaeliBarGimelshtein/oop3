package View;

import Model.MainModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	private Button addABallot;
	private VBox leftMenu;
	private ComboBox<String> kind;
	private String function;
	private TextField txtField;
	private Text txtFieldtxt;
	private BorderPane bp;
	private Pane parametersPane;
	private HBox parametersBox;
	private Button add;

	public View(Stage primaryStage) {

		addABallot = new Button("Add Ballot");
		add = new Button("Add!");
		leftMenu = new VBox();
		txtField = new TextField();
		txtFieldtxt = new Text();
		leftMenu.getChildren().addAll(addABallot);
		kind = new ComboBox<String>();
		bp = new BorderPane();
		parametersPane = new Pane();
		parametersBox = new HBox();
		parametersBox.getChildren().addAll(kind, txtFieldtxt, txtField, add);
		parametersPane.getChildren().addAll(parametersBox);
		parametersPane.setVisible(false);
		bp.setCenter(parametersPane);

		bp.setLeft(leftMenu);
		Scene scene = new Scene(bp, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void addABallot() {
		function = "addABallot";
		parametersPane.setVisible(true);
		kind.getItems().addAll("Sick Citizen Ballot", "Soldier Ballot", "Citizen Ballot", "Sick Soldier Ballot",
				"Candidate Ballot", "Sick Candidate Ballot");
		kind.setValue("Sick Citizen Ballot");
		txtFieldtxt.setText("Address");

	}

	public void addEventToAddABallot(EventHandler<ActionEvent> addABallotPressed) {
		addABallot.setOnAction(addABallotPressed);

	}

	public String getFunction() {
		return function;
	}

	public void updateModel(MainModel theModel) {
		if (function == "addABallot") {
			String kind = getCombo();
			String ballotAdress = txtField.getText();
			if (txtField.getText().isEmpty()){
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Please enter Ballot address");
				msg.show();
			}
			else{
				theModel.addABallotUpdate(kind, ballotAdress);
				Alert msg = new Alert(AlertType.CONFIRMATION);
				msg.setContentText("Ballot added!");
				msg.show();
				clearview();
			}

		}

	}

	public String getCombo() {

		return kind.getValue();
	}

	public void clearview() {
		kind.getItems().removeAll();

	}

	public void updateComboBox(String function2) {

	}

	public void addEventToAddButton(EventHandler<ActionEvent> addButtonPressed) {
		add.setOnAction(addButtonPressed);

	}
}
