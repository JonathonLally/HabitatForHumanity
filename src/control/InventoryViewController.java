package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InventoryViewController extends Application{
	@FXML Button allButton;
	@FXML Button doorButton;
	@FXML Button windowButton;
	@FXML Button furnitureButton;
	@FXML Button electricalButton;
	@FXML Button plumbingButton;
	@FXML Button hardwareButton;
	@FXML Button lightingButton;
	@FXML TextArea idText;
	@FXML TextArea typeText;
	@FXML TextArea priceText;
	@FXML TextArea materialText;
	@FXML TextArea dimText;
	@FXML TextField invChoice;
	@FXML public void sortAll() {
		initialize();
	}
	@FXML public void sortDoors() {
		sortTable("Door");
	}
	@FXML public void sortWindows() {
		sortTable("Window");
	}
	@FXML public void sortFurniture() {
		sortTable("Furniture");
	}
	@FXML public void sortElectrical() {
		sortTable("Electrical");
	}
	@FXML public void sortPlumbing() {
		sortTable("Plumbing");
	}
	@FXML public void sortHardware() {
		sortTable("Hardware");
	}
	@FXML public void sortLighting() {
		sortTable("Lighting");
	}
	@FXML public void launchDirectInv() {
		showInventoryDirectView(getinvChoice());
	}
	
	private Connection con;
	
	public void initialize() {
		connectDB();
		buildTable();
		disconnectDB();
	}
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/habitatsql", "root", "U3Z3aacoskOO55ndVAOf");
			System.out.println("Inventory View Connected to DB");
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
	
	public void buildTable() { // Builds table at launch
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM inventory");
			StringBuilder idSB = new StringBuilder();
			StringBuilder typeSB = new StringBuilder();
			StringBuilder priceSB = new StringBuilder();
			StringBuilder materialSB = new StringBuilder();
			StringBuilder dimSB = new StringBuilder();
			while(rs.next()) {
				idSB.append(rs.getString("inv_id") + "\n");
				typeSB.append(rs.getString("inv_type") + "\n");
				priceSB.append(rs.getString("inv_price") + "\n");
				materialSB.append(rs.getString("inv_material") + "\n");
				dimSB.append(rs.getString("inv_dimensions") + "\n");
			}
			setidText(idSB.toString());
			settypeText(typeSB.toString());
			setpriceText(priceSB.toString());
			setmaterialText(materialSB.toString());
			setdimText(dimSB.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void sortTable(String sorter) { // Loads to table only values of a certain type
		connectDB();
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM inventory");
			StringBuilder idSB = new StringBuilder();
			StringBuilder typeSB = new StringBuilder();
			StringBuilder priceSB = new StringBuilder();
			StringBuilder materialSB = new StringBuilder();
			StringBuilder dimSB = new StringBuilder();
			while(rs.next()) {
				String type = rs.getString("inv_type");
				if (type.equals(sorter)) {
					idSB.append(rs.getString("inv_id") + "\n");
					typeSB.append(rs.getString("inv_type") + "\n");
					priceSB.append(rs.getString("inv_price") + "\n");
					materialSB.append(rs.getString("inv_material") + "\n");
					dimSB.append(rs.getString("inv_dimensions") + "\n");
				}		
				
			}
			modifyTable(idSB.toString(), typeSB.toString(), priceSB.toString(), 
					materialSB.toString(), dimSB.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnectDB();
	}
	
	public void modifyTable(String ids, String types, String prices, String materials, String dims) {
		setidText(ids);
		settypeText(types);
		setpriceText(prices);
		setmaterialText(materials);
		setdimText(dims);
	}
	
	
	public void setidText(String input) {
		idText.setText(input);
	}
	
	public void settypeText(String input) {
		typeText.setText(input);
	}
	
	public void setpriceText(String input) {
		priceText.setText(input);
	}
	
	public void setmaterialText(String input) {
		materialText.setText(input);
	}
	
	public void setdimText(String input) {
		dimText.setText(input);
	}
	
	public String getinvChoice() {
		String input = invChoice.getText();
		invChoice.clear();
		return input;
	}
	
	public Stage showInventoryDirectView(String currentInv) { //Passing an argument to a controller
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InventoryDirectView.fxml"));
		Stage stage = new Stage();
		 try {
			stage.setScene(
					    new Scene(
					      (Pane) loader.load()
					    )
					  );
		} catch (IOException e) {
			e.printStackTrace();
		}
		 InventoryDirectViewController controller = 
				    loader.<InventoryDirectViewController>getController();
				  controller.initialize(currentInv);
		stage.show();
		return stage;
		
	}	

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
	@FXML public void exit() {
		Platform.exit();
	}

}
