package control;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InventoryDirectViewController {
	@FXML TextArea idArea;
	@FXML TextArea typeArea;
	@FXML TextArea dimArea;
	@FXML TextArea priceArea;
	@FXML TextArea materialArea;
	@FXML TextArea descriptionArea;
	
	public void setidArea(String input) {
		idArea.setText(input);
	}
	public void settypeArea(String input) {
		typeArea.setText(input);
	}
	public void setdimArea(String input) {
		dimArea.setText(input);
	}
	public void setmaterialArea(String input) {
		materialArea.setText(input);
	}
	public void setdescriptionArea(String input) {
		descriptionArea.setText(input);
	}

}
