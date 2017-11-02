package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    
    public void login(String id, String password) { //This will attempt to find the user, launch new window for each type
    	toInvalid_Text("Invalid login");
    }
    
    public void toInvalid_Text(String message) { //This writes to the error text, ex invalid login info
    	invalid_text.setText(message);
    }


}
