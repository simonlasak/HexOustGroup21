package UIPackage;

/**
 * Launcher class for the HexOust game.
 *
 * This class provides the main entry point for starting the HexOust game.
 * It exists as a separate launcher class to simplify the execution process
 * and acts as a delegate to the actual application class.
 */
public class Launcher {

    /**
     * This method delegates to the hexOustUIApplication's main method
     * to initialize and launch the JavaFX application.
     *
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        hexOustUIApplication.main(args);
    }
}