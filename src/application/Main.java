package application;

import constants.ImageHolder;
import gui.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		SceneManager.getInstance().setPrimaryStage(primaryStage);
		SceneManager.getInstance().switchScene(0);
		SceneManager.getInstance().getPrimaryStage().sizeToScene();
		SceneManager.getInstance().getPrimaryStage().getIcons().add(ImageHolder.knightSprite);
		SceneManager.getInstance().getPrimaryStage().setResizable(false);
		SceneManager.getInstance().getPrimaryStage().setTitle("The Fellow Knight");
		SceneManager.getInstance().getPrimaryStage().show();
	}

}
