package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	
	private static SceneManager instance = null;
	
	private Stage primaryStage;
	private Scene scene;
	private MainMenuPane mainMenuPane;
	private TutorialPane tutorialPane;
	private CreditPane creditPane;
	private PreGamePane preGamePane;

	
	private SceneManager() {
		mainMenuPane = new MainMenuPane();
		tutorialPane = new TutorialPane();
		creditPane = new CreditPane();
		preGamePane = new PreGamePane();
		scene = new Scene(mainMenuPane);
	}
	
	public static SceneManager getInstance() {
		if (instance==null) {
			instance = new SceneManager();
		}
		return instance;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void switchScene(int index) {
		switch (index) {
		case 0 : 
			scene.setRoot(mainMenuPane);
			break;
		case 1 : 
			MainMenuPane.menuTheme.stop();
			scene.setRoot(new GamePane());
			break;
		case 2 : 
			scene.setRoot(tutorialPane); 
			break;
		case 3 : 
			scene.setRoot(creditPane); 
			break;
		case 4 : 
			scene.setRoot(preGamePane); 
			break;
		case 5:
			scene.setRoot(new DefeatPane()); 
			break;
		case 6:
			scene.setRoot(new VictoryPane()); 
			break;
		}
		primaryStage.setScene(scene);
	}
	
	
}
