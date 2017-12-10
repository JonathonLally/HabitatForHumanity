package control;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddItemViewController extends Application{
	@FXML private TextField typeField;
	@FXML private TextField pictureField;
	@FXML private TextField dimField;
	@FXML private TextField priceField;
	@FXML private TextField matField;
	@FXML private TextArea descriptionArea;
	@FXML private ChoiceBox<String> choicebox;
	@FXML private Button pictureButton;
	@FXML public void addButton() {
		addInventory();
	}
	@FXML public void choosePictureFile() {
		choosePicture();
	}
	
	private Connection con;
	private FileChooser filechooser;
	
	public void initialize() { //Inits
		connectDB();
		setupChoiceBox();
		setupFileChooser();
		disconnectDB();
	}
	
	private void setupFileChooser() {
		filechooser = new FileChooser();
		
	}

	public void choosePicture() {
		File file = filechooser.showOpenDialog(null);
		if (file!=null) {
			savePicture(file);
		}
	}
	
	private void savePicture(File file) {
		System.out.println(file.getPath());
		setPictureField(file.getPath());
		try {
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void setupChoiceBox() {
		choicebox.setItems(FXCollections.observableArrayList(
				"Door", "Window", "Furniture", "Electrical", "Plumbing", "Hardware", "Lighting")
				);
	}
	
	public void addInventory() {
		System.out.println("Starting add Inventory");
		connectDB();
		String invtype = getChoiceBox();
		String invpicture = getPictureField();
		String invdimensions = getDimField();
		String invprice = getPriceField();
		String invdescription = getDescription();
		String invmaterial = getMatField();
		try {			
			System.out.println(invtype+invpicture+invdimensions+invprice+invdescription+invmaterial);
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO habitatsql.inventory"
					+ "(inv_type, inv_picture, inv_dimensions, inv_price, inv_description, inv_material"
					+ ") VALUES('" + invtype + "','" + invpicture + "','" + invdimensions + "','"
							+ invprice + "','" + invdescription + "','" + invmaterial + "')";
			System.out.println("SQL STATEMENT IS CURRENTLY:");
			System.out.println(sql);
			stmt.execute(sql);
			
		} catch (Exception e) {
			System.out.println("Something wrong in addInventory");
			e.printStackTrace();
		}
		disconnectDB();
	}
	
	public String getItem() {
		StringBuilder output = new StringBuilder();
		
		
		return output.toString();
	}
	
	public String getChoiceBox() {
		String output = choicebox.getValue();
		return output;
	}
	
	public String getTypeField() {
		String output = typeField.getText();
		typeField.clear();
		return output;
	}
	
	public String getDimField() {
		String output = dimField.getText();
		dimField.clear();
		return output;
	}
	
	public String getPriceField() {
		String output = priceField.getText();
		priceField.clear();
		return output;
	}
	
	public String getMatField() {
		String output = matField.getText();
		matField.clear();
		return output;
	}
	
	public String getDescription() {
		String output = descriptionArea.getText();
		descriptionArea.clear();
		return output;
	}
	
	public void setPictureField(String field) {
		pictureField.setText(field);
	}
	
	public String getPictureField() {
		String output = pictureField.getText();
		pictureField.clear();
		return output;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
