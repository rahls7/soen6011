
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * View Layer of the Calculator application.
 * Loads the ui.fxml using Javafx
 * Reference: https://www.youtube.com/watch?v=ZQ-mII_pL0M
 * Note: For calculating functions with negative exponents please use AppText.java
 * @author rahls7
 *
 */
public class App extends Application {
	/**
	 *  Start function to load ui.fxml
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	 /**
	  * Main function to launch the UI
	  * @param args
	  */
	public static void main(String[] args) {
		launch(args);
	}
}
