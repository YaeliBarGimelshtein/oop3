package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import Model.IDOutOfRange;
import Model.MainModel;
import Model.ageOutOfRange;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
//finish try catch
//change to action listener
public class Controller {
	private View theView;
	private MainModel theModel;
	
	Scanner scan= new Scanner(System.in);
	
	public Controller(MainModel theModel, View theView) {
		this.theModel=theModel;
		this.theView=theView;
		
		//add event:
//		ChangeListener<Toggle> buttonPressed= new ChangeListener<Toggle>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//				String pressed;
//				pressed= theView.getPressed();
//				try {
//					theView.update(theModel, pressed, scan);
//				} catch (IDOutOfRange e) {
//					// TODO Auto-generated catch block
//					
//				} catch (ageOutOfRange e) {
//					// TODO Auto-generated catch block
//					
//				}
//				
//			}
//		};
//		theView.addChangeListenerToToggleGroup(buttonPressed);
		
		ActionListener buttonPressed= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pressed;
				pressed= theView.getPressed();
				try {
					theView.update(theModel, pressed, scan);
				} catch (IDOutOfRange er) {
					// TODO Auto-generated catch block
					
				} catch (ageOutOfRange er) {
					// TODO Auto-generated catch block
					
				}
				
			}
		};
		theView.addActionListenerToView(buttonPressed);
	}

}
