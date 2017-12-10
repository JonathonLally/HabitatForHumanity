package control;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InventoryDirectViewController {
	@FXML TextArea idArea;
	@FXML TextArea typeArea;
	@FXML TextArea dimArea;
	@FXML TextArea priceArea;
	@FXML TextArea materialArea;
	@FXML TextArea descriptionArea;
	@FXML TextField testfield;
	@FXML ImageView imgView;
	
	private Connection con;
	
	public void initialize(String in) {
		connectDB();
		buildData(in);		
		disconnectDB();		
		
	}
	
	private void buildData(String current) {
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM inventory");			
			while(rs.next()) {
				if (rs.getString("inv_id").equals(current)) {
					try {
						setidArea(rs.getString("inv_id"));
						settypeArea(rs.getString("inv_type"));
						setdimArea(rs.getString("inv_material"));
						setpriceArea(rs.getString("inv_price"));
						setmaterialArea(rs.getString("inv_material"));
						setdescriptionArea(rs.getString("inv_description"));
						setPicture(rs.getString("inv_picture"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setPicture(String input) {
		try {
			File file = new File("resources/" + input);
			Image image = new Image(file.toURI().toString());
			System.out.println(input);
			imgView.setImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/habitatsql", "root", "U3Z3aacoskOO55ndVAOf");
			System.out.println("Direct View Connected to DB");
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
	
	public void setidArea(String input) {
		idArea.setText(input);
	}
	public void settypeArea(String input) {
		typeArea.setText(input);
	}
	public void setdimArea(String input) {
		dimArea.setText(input);
	}
	public void setpriceArea(String input) {
		priceArea.setText(input);
	}
	public void setmaterialArea(String input) {
		materialArea.setText(input);
	}
	public void setdescriptionArea(String input) {
		descriptionArea.setText(input);
	}
	public void initData(String currentInv) {			
		connectDB();
		buildData(currentInv);
		disconnectDB();
	}
	
	

}
