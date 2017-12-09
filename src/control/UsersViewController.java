package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsersViewController extends Application{
	
	@FXML private TextArea usernameArea;
	@FXML private TextArea userpassArea;
	@FXML private TextArea usertypeArea;
	
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
	
	@FXML
	void addUserFXML() {
		checkInput();
		connectDB();
		buildTable();
		disconnectDB();
		
	}
	@FXML void removeUserFXML() {
		removeUser(getUserName());
	}
	
	private Connection con;
	private StringBuilder users;
	private StringBuilder pass;
	private StringBuilder types;

	@Override
	public void start(Stage arg0) throws Exception {
	
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
		buildTable();
		disconnectDB();
	}
	
	public String getUserName() {
		String user;
		user = username_field.getText();
		username_field.clear();
		return user;
	}
	
	public String getUserPass() {
		String pass;
		pass = userpass_field.getText();
		userpass_field.clear();
		return pass;
	}
	
	public int getUserType() {
		if (choicebox.getValue().equals("Customer")) {
			return 1;
		} else if (choicebox.getValue().equals("Employee")) {
			return 2;
		} else if (choicebox.getValue().equals("Manager")) {
			return 3;
		} else {
			return 0;
		}
	}
	
	public void checkInput() {  //Check if the new user input fields have valid types
		String newuser = getUserName();
		String newpass = getUserPass();
		int newType = getUserType();
		if (newuser != null) {
			if (newpass != null) {
				if (newType > 0) {
					addUser(newuser, newpass, newType);
				} else {
					System.out.println("No valid user type");
				}
			} else {
				System.out.println("Password field empty");
			}
		} else {
			System.out.println("Userfield empty");
		}
	}
	
	public void addUser(String user, String pass, int type) {
		connectDB();
		try {
			Statement stmt = con.createStatement();
			System.out.println("Attempting to add : " + user + " " + pass + " " + type);			
			String sql = "INSERT INTO habitatsql.users"
					+ "(user_name, user_password, user_type)" + " VALUES('" +
					user + "','" + pass + "'," + type + ")";
			stmt.executeUpdate(sql);
			System.out.println(sql);
		} catch (Exception e) {
			
		}
		disconnectDB();
	}
	
	public void removeUser(String user) {
		connectDB();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while(rs.next()) {
				String dbuser = rs.getString("user_name");
				if (user.equals(dbuser)) {					
					System.out.println("Found : " + user +"Attempting to remove");				
					PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE user_name = ?");
					st.setString(1, user);
					st.executeUpdate();
				} else {
					System.out.println("User not found, cannot remove");
				}
			}
		} catch (Exception e) {
			
		}
		buildTable();
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
			users = new StringBuilder();
			pass = new StringBuilder();
			types = new StringBuilder();
			while(rs.next()) {
				System.out.println(rs.getString("user_name"));				
				users.append(rs.getString("user_name") + "\n");
				pass.append(rs.getString("user_password") + "\n");
				if (rs.getString("user_type").equals("1")) {
					types.append("Customer" + "\n");
				} else if (rs.getString("user_type").equals("2")) {
					types.append("Employee" + "\n");
				} else if (rs.getString("user_type").equals("3")) {
					types.append("Manager" + "\n");
				}				
			}
			usernameArea.setText(users.toString());
			userpassArea.setText(pass.toString());
			usertypeArea.setText(types.toString());
			
		} catch (SQLException e) {
			System.out.println("Something wrong with building table from sql");
		}
	}
}
