package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UsersViewController extends Application{
	
	@FXML
	private TableView<String> tableview;
	
	@FXML TableColumn<String, String> userCol;
	@FXML TableColumn<String, String> userPass;
	@FXML TableColumn<?, ?> userType;
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button removeButton;
	
	@FXML
	private TextField username_field;
	
	@FXML
	private TextField userpass_field;
	
	@FXML
	private ChoiceBox<String> choicebox;
	
	private Connection con;
	private ObservableList<String> row;

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
	//	connectDB();
		//setupChoiceBox();
		//con.close();
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
	
	public void initialize() {
		connectDB();
		setupChoiceBox();
		//buildColumns();
		buildTable();
		buildColumns();
		disconnectDB();
	}
	
	public void setupChoiceBox() {
		choicebox.setItems(FXCollections.observableArrayList(
				"Customer", "Employee", "Manager")
				);
	}
	
	public void buildTable() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			//System.out.println(rs);
			while(rs.next()) {
				System.out.println(rs.getString("user_name"));				
				row.add(rs.getString("user_name"));
			}
			
		} catch (SQLException e) {
			System.out.println("Something wrong with building table from sql");
		}
	}
	
	public void buildColumns() {
		userCol.setCellValueFactory(
				new PropertyValueFactory<String, String>("user_name"));
		tableview.setItems(row);
	}

}
