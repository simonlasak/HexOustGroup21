package UIPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the HexOust game.
 *
 * This class extends JavaFX's Application class and is responsible for:
 * - Loading the FXML UI layout
 * - Creating and configuring the main application window
 * - Starting the JavaFX application lifecycle
 */
public class hexOustUIApplication extends Application {

    /**
     * Initializes the application window and loads the UI.
     *
     * This method is called by the JavaFX platform when the application
     * is launched. It loads the FXML layout, sets up the primary stage
     * (window), and displays it to the user.
     *
     * @param stage The primary stage provided by the JavaFX platform
     * @throws IOException If the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(hexOustUIApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Group 21");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
