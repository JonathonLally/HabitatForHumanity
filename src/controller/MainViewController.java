package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private TextField user_textfield;

    @FXML
    private PasswordField password_passfield;
    
    @FXML
    private Text invalid_text;
    
    @FXML
    void user_login(ActionEvent event) { //ActionEvent when user enters info
    	login(user_textfield.getText(), password_passfield.getText());
    	user_textfield.clear();
    	password_passfield.clear();
    }
    @FXML
    void launchCustomerViewFXML() {
    	launchCustomerView();
    }
    
    public void login(String id, String password) { //This will attempt to find the user, launch new window for each type
    	toInvalid_Text("Invalid login");
    }
    
    public void toInvalid_Text(String message) { //This writes to the error text, ex invalid login info
    	invalid_text.setText(message);
    }
    
    public void launchCustomerView() {
    	try {
    		Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/CustomerViewFX.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/material-fx-v0_3.css").toExternalForm());
			secondaryStage.setTitle("CustomerView");
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }


}
