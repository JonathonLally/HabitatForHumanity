package control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeViewController {

    @FXML void launchAddItem() {
		try {
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/AddItemView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/material-fx-v0_3.css").toExternalForm());
			secondaryStage.setTitle("AddItem");
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @FXML void launchRemoveItem() {
		try {
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/RemoveItemView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/material-fx-v0_3.css").toExternalForm());
			secondaryStage.setTitle("RemoveItem");
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML void launchInventory() {
    	try {
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/InventoryViewFX.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/material-fx-v0_3.css").toExternalForm());
			secondaryStage.setTitle("InventoryView");
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML void launchSellItem() {
    	
    }

}
