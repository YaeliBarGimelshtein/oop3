package View;

import Model.MainModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		addABallot.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		add = new Button("Add!");
		add.setPrefSize(100, 50);
		add.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		//add.setFont(Font.font(20));
		leftMenu = new VBox();
		txtField = new TextField();
		txtField.setPrefSize(250, 40);
		txtFieldtxt = new Text();
		txtFieldtxt.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		leftMenu.getChildren().addAll(addABallot);
		kind = new ComboBox<String>();
		kind.setPrefSize(250, 40);
		bp = new BorderPane();
		parametersPane = new Pane();
		parametersBox = new HBox();
		parametersBox.getChildren().addAll(kind, txtFieldtxt, txtField, add);
		parametersPane.getChildren().addAll(parametersBox);
		parametersPane.setVisible(false);
		bp.setCenter(parametersPane);
		bp.setLeft(leftMenu);
		bp.setMargin(leftMenu, new Insets(20,40,20,20));
		bp.setMargin(parametersPane, new Insets(20,40,20,20));
		parametersBox.setMargin(kind, new Insets(20,40,20,20));
		parametersBox.setMargin(txtFieldtxt, new Insets(25,0,20,20));
		parametersBox.setMargin(txtField, new Insets(20,40,20,10));
		parametersBox.setMargin(add, new Insets(20,40,20,300));

		Scene scene = new Scene(bp, 1700, 950);
		
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
		kind.setStyle("-fx-font: 18px Verdana");

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
				//add.setStyle("-fx-background-color: #f54331; ");
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Please enter Ballot address");
				msg.show();
			}
			else{
				//add.setStyle("-fx-background-color: #00b120; ");
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
