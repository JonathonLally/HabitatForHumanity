package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainViewFX.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets()
					.add(getClass().getResource("/view/material-fx-v0_3.css").toExternalForm());
			primaryStage.setTitle("Habitat for Humanity App");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
