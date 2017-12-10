package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveItemViewController extends Application{
	@FXML private TextArea idArea;
	@FXML private TextArea typeArea;
	@FXML private TextArea descriptionArea;
	@FXML private TextField removeField;
	
	@FXML public void remove() {
	}
	
	private Connection con;
	
	public void initialize() {
		connectDB();
		fillFields();
		disconnectDB();
	}
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/habitatsql", "root", "U3Z3aacoskOO55ndVAOf");
			System.out.println("User View Connected to DB");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void disconnectDB() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Connection cannot close");
		}
	}

	public String getRemoveField() {
		String output = removeField.getText();
		removeField.clear();
		return output;
	}
	public void setIdArea(String input) {
		idArea.setText(input);
	}
	
	public void setTypeArea(String input) {
		typeArea.setText(input);
	}
	public void setDescriptionArea(String input) {
		descriptionArea.setText(input);
	}
	
	public void fillFields() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from inventory");
			StringBuilder ids = new StringBuilder();
			StringBuilder types = new StringBuilder();
			StringBuilder descriptions = new StringBuilder();
			while(rs.next()) {
				ids.append(rs.getInt("inv_id") + "\n");
				types.append(rs.getString("inv_type") + "\n");
				descriptions.append(rs.getString("inv_description") + "\n");
			}
			setIdArea(ids.toString());
			setTypeArea(types.toString());
			setDescriptionArea(descriptions.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
