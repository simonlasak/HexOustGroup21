package UIPackage;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javafx.scene.paint.Color.*;

/**
 * Controller class for the HexOust game user interface.
 * Handles UI events, animations, and game state management for the hexagonal board game.
 */
public class hexOustUIController {

    @FXML
    private Polygon exit0;
    @FXML
    private Polygon turn0;
    @FXML
    private Polygon reset0;

    // Hexagon board elements
    @FXML
    public Polygon hex154, hex0, hex05, hex1, hex19111, hex191111, hex1911111, hex19111111,
            hex191111111, hex1911111111, hex19111111111, hex191111111111, hex19111111121,
            hex191111112, hex191111113, hex19111112, hex191112, hex1911121, hex19111211, hex191112111,
            hex1911122, hex19111221, hex191113, hex191114, hex19112, hex1912111, hex19121111,
            hex191211111, hex1912111111, hex19121111111, hex191211111111, hex1912111111111,
            hex19121111111111, hex191211111111111, hex1912111111112, hex19121111111121, hex191211111112,
            hex191211111113, hex19121111112, hex19121112, hex191211121, hex1912111211, hex19121112111,
            hex191211121111, hex1912111211111, hex19121112111111, hex191211121112, hex1912111211121,
            hex19121112112, hex19121112113, hex1912111212, hex1912112, hex19121121, hex191211211,
            hex1912112111, hex19121121112, hex191211211121, hex1912112111211, hex19121121112111,
            hex191211211121111, hex1912112111211111, hex19121121112112, hex191211211121121,
            hex1912112111212, hex1912112111213, hex191211211122, hex19121122, hex191211221, hex1912112212,
            hex19121122121, hex191211221211, hex1912112212111, hex19121122121111, hex1912112212112,
            hex19121122121121, hex191211221212, hex191211221213, hex19121122122, hex19121123, hex191211231,
            hex1912113, hex19121131, hex191211311, hex1912113111, hex19121131111, hex191211311111,
            hex1912113111111, hex19121131112, hex191211311121, hex1912113112, hex1912113113, hex191211312,
            hex191212, hex1912121, hex19121212, hex191212121, hex1912121211, hex19121212111, hex191212121111,
            hex1912121211111, hex19121212111111, hex191212121112, hex19121212112, hex191213, hex1912131,
            hex19121311, hex1912131112, hex19121311121, hex191213111211, hex19121311121111, hex191213113,
            hex1912131131, hex19121311311, hex191213113111, hex191213113112, hex1912131131121, hex19121311312,
            hex19121311313, hex1912132, hex19121321, hex191213211, hex1912132111, hex191214, hex2, hex3, hex4;

    // UI control labels
    @FXML
    private Label turnIndicator, exitText, resetText;

    @FXML
    private AnchorPane hexagonPane;

    /**
     * Base color for unoccupied hexagon tiles.
     */
    private static final Color baseColor = new Color(0.8627, 0.8627, 0.8627, 1.0);

    /**
     * Semi-transparent blue color used for hover effects.
     */
    private final Color blueFade = new Color(0, 0, 1, 0.3);

    /**
     * Semi-transparent red color used for hover effects.
     */
    private final Color redFade = new Color(1, 0, 0, 0.3);

    /**
     * Duration for bounce animation effects on hexagons.
     */
    private static final Duration BOUNCE_DURATION = Duration.millis(169);

    /**
     * Flag to track if an animation is currently in progress.
     */
    private boolean animationInProgress = false;

    /**
     * Static reference to the controller instance.
     */
    private static hexOustUIController instance;

    /**
     * Flag tracking which player's turn it is (true = Red, false = Blue).
     */
    private boolean isRedTurn = true;

    /**
     * Initializes the UI components and sets up event handlers and initial state.
     */
    @FXML
    public void initialize() {
        instance = this;
        updateTurnIndicator();
    }

    /**
     * Repaints a hexagon at the specified layout position to the base color.
     *
     * @param layoutX The x-coordinate of the hexagon to repaint
     * @param layoutY The y-coordinate of the hexagon to repaint
     */
    public static void repaintToBase(int layoutX, int layoutY) {
        for (var node : instance.hexagonPane.getChildren()) {
            if (node instanceof Polygon poly) {
                if (poly.getLayoutX() == layoutX && poly.getLayoutY() == layoutY) {
                    poly.setFill(baseColor);
                    return;
                }
            }
        }
    }

    /**
     * Converts mouse event coordinates to hex cube coordinates.
     *
     * @param event The mouse event containing click coordinates
     * @return A HexCube object representing the clicked hexagon
     */
    private HexCube getCube(MouseEvent event) {
        double clickX = event.getSceneX();
        double clickY = event.getSceneY();
        double eventX = -event.getY();
        double eventY = event.getX();
        int centerX = (int) (clickX - eventX/2.0);
        int centerY = (int) (clickY - eventY/2.0);

        Point p = new Point(centerX, centerY);
        return new HexCube(p);
    }

    /**
     * Displays an alert dialog when a player attempts an invalid move.
     */
    private void invalidAlert() {
        Stage parentStage = (Stage) hexagonPane.getScene().getWindow();
        CustomErrorDialog.show("You cannot place a hex here!", parentStage, isRedTurn);
    }

    public void ButtonHover(MouseEvent mouseEvent) {
        Polygon button = (Polygon) mouseEvent.getSource();
        final Color previousFill = (Color) button.getFill();

        button.setStroke(BLACK);
        button.setStrokeWidth(4);

        if(Objects.equals(button.getId(), "exit0")){
            exitText.setTextFill(WHITESMOKE);
        }
        else{
            resetText.setTextFill(WHITESMOKE);
        }

        button.setFill(isRedTurn ? RED : BLUE);

        button.setOnMouseExited(exitEvent -> {
            button.setStroke(BLACK);
            button.setFill(previousFill);
            button.setStrokeWidth(2);
            exitText.setTextFill(BLACK);
            resetText.setTextFill(BLACK);
        });

    }

    /**
     * Custom error dialog for the HexOust game.
     * Provides a styled alternative to the standard JavaFX Alert dialog.
     * Colors adjust based on the current player's turn.
     */
    public class CustomErrorDialog {

        /**
         * Shows a custom error dialog with the specified message.
         *
         * @param message The error message to display
         * @param parentStage The parent stage for this dialog
         * @param isRedTurn Flag indicating if it's red player's turn
         */
        public static void show(String message, Stage parentStage, boolean isRedTurn) {
            // Define theme colors based on current player
            Color playerColor = isRedTurn ? Color.RED : Color.BLUE;
            Color playerColorDark = isRedTurn ? Color.color(0.7, 0, 0) : Color.color(0, 0, 0.7);

            // Convert colors to hex format for CSS
            String hexColor = String.format("#%02X%02X%02X",
                    (int)(playerColor.getRed() * 255),
                    (int)(playerColor.getGreen() * 255),
                    (int)(playerColor.getBlue() * 255));

            String darkHexColor = String.format("#%02X%02X%02X",
                    (int)(playerColorDark.getRed() * 255),
                    (int)(playerColorDark.getGreen() * 255),
                    (int)(playerColorDark.getBlue() * 255));

            // Define button styles for normal and hover states
            String buttonStyleNormal = "-fx-background-color: " + hexColor + ";" +
                    "-fx-text-fill: white;" +
                    "-fx-font-weight: bold;" +
                    "-fx-font-size: 14px;" +
                    "-fx-background-radius: 15;" +
                    "-fx-border-color: white;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-radius: 15;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);";

            String buttonStyleHover = "-fx-background-color: " + darkHexColor + ";" +
                    "-fx-text-fill: white;" +
                    "-fx-font-weight: bold;" +
                    "-fx-font-size: 14px;" +
                    "-fx-background-radius: 15;" +
                    "-fx-border-color: white;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-radius: 15;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 8, 0.0, 0, 2);";

            // Create a new stage for the dialog
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.TRANSPARENT);
            dialogStage.initOwner(parentStage);

            // Create a hexagon shape as background decoration
            Polygon hexBackground = createHexBackground(playerColor);

            // Create the error icon (or use a hexagon as error icon)
            Polygon errorIcon = createErrorIcon(playerColor);

            // Create the message label
            Label messageLabel = new Label(message);
            messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            messageLabel.setTextFill(BLACK);
            messageLabel.setWrapText(true);
            messageLabel.setMaxWidth(250);
            messageLabel.setAlignment(Pos.CENTER);
            messageLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

            // Create the OK button with enhanced styling
            Button okButton = new Button("OK");
            okButton.setStyle(buttonStyleNormal);
            okButton.setPrefWidth(100);
            okButton.setPrefHeight(30);

            // Add hover effects
            okButton.setOnMouseEntered(e -> okButton.setStyle(buttonStyleHover));
            okButton.setOnMouseExited(e -> okButton.setStyle(buttonStyleNormal));

            okButton.setOnAction(e -> dialogStage.close());

            // Create the content layout using VBox
            VBox content = new VBox(15);
            content.setAlignment(Pos.CENTER);
            content.setStyle("-fx-background-color: transparent;");
            content.setPadding(new javafx.geometry.Insets(10, 15, 10, 15));
            content.getChildren().addAll(errorIcon, messageLabel, okButton);

            // Create main layout that includes the hex background and content
            javafx.scene.layout.StackPane layout = new javafx.scene.layout.StackPane();
            layout.getChildren().addAll(hexBackground, content);
            layout.setStyle("-fx-background-color: transparent;");

            // Create and configure the scene
            Scene scene = new Scene(layout, 300, 300);
            scene.setFill(Color.TRANSPARENT);

            // Configure and show the dialog
            dialogStage.setScene(scene);

            // Center on parent stage
            dialogStage.setOnShown(e -> {
                dialogStage.setX(parentStage.getX() + parentStage.getWidth()/2 - dialogStage.getWidth()/2);
                dialogStage.setY(parentStage.getY() + parentStage.getHeight()/2 - dialogStage.getHeight()/2);

                // Play entry animation
                playEntryAnimation(layout);
            });

            dialogStage.showAndWait();
        }

        /**
         * Creates a hexagon shape for the dialog background.
         *
         * @param playerColor The current player's color
         * @return The styled hexagon polygon
         */
        private static Polygon createHexBackground(Color playerColor) {
            Polygon hexagon = new Polygon();
            double centerX = 150;
            double centerY = 100;
            double radius = 120;

            for (int i = 0; i < 6; i++) {
                double angle = 2.0 * Math.PI / 6 * i;
                hexagon.getPoints().add(centerX + radius * Math.cos(angle));
                hexagon.getPoints().add(centerY + radius * Math.sin(angle));
            }

            hexagon.setFill(Color.color(1, 1, 1, 0.9));
            hexagon.setStroke(playerColor);
            hexagon.setStrokeWidth(4);

            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.color(0, 0, 0, 0.7));
            dropShadow.setRadius(20);
            hexagon.setEffect(dropShadow);

            return hexagon;
        }

        /**
         * Creates a smaller hexagon to use as an error icon.
         *
         * @param playerColor The current player's color
         * @return The styled error icon hexagon
         */
        private static Polygon createErrorIcon(Color playerColor) {
            Polygon errorHex = new Polygon();
            double centerX = 0;
            double centerY = 0;
            double radius = 30;

            for (int i = 0; i < 6; i++) {
                double angle = 2.0 * Math.PI / 6 * i;
                errorHex.getPoints().add(centerX + radius * Math.cos(angle));
                errorHex.getPoints().add(centerY + radius * Math.sin(angle));
            }

            errorHex.setFill(playerColor);
            errorHex.setStroke(Color.BLACK);
            errorHex.setStrokeWidth(2);

            return errorHex;
        }

        /**
         * Creates and plays an entry animation for the dialog.
         *
         * @param node The node to animate
         */
        private static void playEntryAnimation(javafx.scene.Node node) {
            ScaleTransition scale = new ScaleTransition(Duration.millis(200), node);
            scale.setFromX(0.1);
            scale.setFromY(0.1);
            scale.setToX(1.0);
            scale.setToY(1.0);

            FadeTransition fade = new FadeTransition(Duration.millis(200), node);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);

            ParallelTransition parallel = new ParallelTransition(scale, fade);
            parallel.play();
        }
    }

    /**
     * Applies a bounce animation effect to a hexagon when it's clicked.
     *
     * @param hexagon The hexagon polygon to animate
     */
    private void applyBounceEffect(Polygon hexagon) {
        if (animationInProgress) return;
        animationInProgress = true;

        ScaleTransition scaleDown = createScaleTransition(hexagon, 0.40);
        ScaleTransition scaleUp = createScaleTransition(hexagon, 0.5);
        scaleUp.setInterpolator(Interpolator.EASE_OUT);

        ScaleTransition scaleOvershoot = createScaleTransition(hexagon, 0.55);
        scaleOvershoot.setDuration(BOUNCE_DURATION.divide(2));

        ScaleTransition scaleSettle = createScaleTransition(hexagon, 0.5);
        scaleSettle.setDuration(BOUNCE_DURATION.divide(2));

        SequentialTransition bounceEffect = new SequentialTransition(
                scaleDown, scaleUp, scaleOvershoot, scaleSettle);

        bounceEffect.setOnFinished(e -> animationInProgress = false);
        bounceEffect.play();
    }

    /**
     * Helper method to create a scale transition.
     *
     * @param node The node to animate
     * @param scale The target scale value
     * @return The configured scale transition
     */
    private ScaleTransition createScaleTransition(javafx.scene.Node node, double scale) {
        ScaleTransition transition = new ScaleTransition(BOUNCE_DURATION, node);
        transition.setToX(scale);
        transition.setToY(scale);
        return transition;
    }

    /**
     * Handles mouse click events on hexagon tiles.
     *
     * @param event The mouse event
     */
    @FXML
    void getHexID(MouseEvent event) {
        HexCube c = getCube(event);

        if (!BoardLogic.isValidMove(c, isRedTurn)) {
            invalidAlert();
            return;
        }

        Polygon hexagon = (Polygon) event.getSource();
        if (hexagon.getFill() == RED || hexagon.getFill() == BLUE) {
            return;
        }

        int oppColorSize = BoardLogic.listSize(isRedTurn);
        BoardLogic.addToList(c, isRedTurn);

        applyMoveToUI(hexagon);
        applyBounceEffect(hexagon);

        boolean captureHappened = oppColorSize != BoardLogic.listSize(isRedTurn);
        checkVictoryAndAnimate(isRedTurn);

        if (!captureHappened) {
            isRedTurn = !isRedTurn;
        }

        updateTurnIndicator();
    }

    /**
     * Applies visual changes to a hexagon after a move.
     *
     * @param hexagon The hexagon to update
     */
    private void applyMoveToUI(Polygon hexagon) {
        Color permanentColor = isRedTurn ? RED : BLUE;
        hexagon.setFill(permanentColor);
        hexagon.setStroke(BLACK);
        hexagon.setStrokeWidth(3);
        hexagon.setOnMouseExited(null);
    }

    /**
     * Updates the turn indicator hexagons to reflect the current player's turn.
     * This method extends the existing updateTurnIndicator method.
     */
    private void updateTurnIndicator() {
        // Update the text and circle indicator
        if (!isRedTurn) {
            turnIndicator.setText("Blue Player's\n" + "     Turn");
            turnIndicator.setTextFill(WHITESMOKE);
            turn0.setFill(BLUE);
        } else {
            turnIndicator.setText("Red Player's\n" + "     Turn");
            turnIndicator.setTextFill(BLACK);
            turn0.setFill(RED);
        }
    }

    /**
     * Applies hover effect to hexagons when mouse enters.
     *
     * @param event The mouse event
     */
    @FXML
    void hover(MouseEvent event) {
        Polygon hexagon = (Polygon) event.getSource();

        if (hexagon.getFill() == RED || hexagon.getFill() == BLUE) {
            return;
        }

        HexCube c = getCube(event);
        if (BoardLogic.isValidMove(c, isRedTurn)) {
            applyHoverEffect(hexagon);
        }
    }

    /**
     * Applies the appropriate hover effect to a hexagon.
     *
     * @param hexagon The hexagon to apply effects to
     */
    private void applyHoverEffect(Polygon hexagon) {
        final Color previousFill = (Color) hexagon.getFill();

        hexagon.setStroke(WHITESMOKE);
        hexagon.setStrokeWidth(5);

        hexagon.setFill(isRedTurn ? redFade : blueFade);

        hexagon.setOnMouseExited(exitEvent -> {
            hexagon.setStroke(BLACK);
            hexagon.setFill(previousFill);
            hexagon.setStrokeWidth(3);
        });
    }

    /**
     * Handles exit button click event.
     *
     * @param event The mouse event
     */
    @FXML
    void exit(MouseEvent event) {
        Polygon exitButton = (Polygon) event.getSource();
        Stage stage = (Stage) exitButton.getScene().getWindow();

        // Create a confirmation dialog before exiting
        confirmExit(stage);
    }

    /**
     * Shows an exit confirmation dialog.
     *
     * @param parentStage The parent stage for the dialog
     */
    private void confirmExit(Stage parentStage) {
        // Define theme colors based on current player
        Color playerColor = isRedTurn ? Color.RED : Color.BLUE;
        Color playerColorDark = isRedTurn ? Color.color(0.7, 0, 0) : Color.color(0, 0, 0.7);

        // Convert colors to hex format for CSS
        String hexColor = String.format("#%02X%02X%02X",
                (int)(playerColor.getRed() * 255),
                (int)(playerColor.getGreen() * 255),
                (int)(playerColor.getBlue() * 255));

        String darkHexColor = String.format("#%02X%02X%02X",
                (int)(playerColorDark.getRed() * 255),
                (int)(playerColorDark.getGreen() * 255),
                (int)(playerColorDark.getBlue() * 255));

        // Define button styles
        String buttonStyleNormal = "-fx-background-color: " + hexColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 15;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);";

        String buttonStyleHover = "-fx-background-color: " + darkHexColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 15;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 8, 0.0, 0, 2);";

        // Create a new stage for the dialog
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initStyle(StageStyle.TRANSPARENT);
        dialogStage.initOwner(parentStage);

        // Create a hexagon shape as background
        Polygon hexBackground = createDialogHexBackground(playerColor);

        // Create the message label
        Label messageLabel = new Label("Are you sure you want to\nexit the game?");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        messageLabel.setTextFill(BLACK);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(250);
        messageLabel.setAlignment(Pos.CENTER);
        messageLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        // Create the Yes button
        Button yesButton = new Button("Yes");
        yesButton.setStyle(buttonStyleNormal);
        yesButton.setPrefWidth(80);
        yesButton.setPrefHeight(30);

        // Add hover effects
        yesButton.setOnMouseEntered(e -> yesButton.setStyle(buttonStyleHover));
        yesButton.setOnMouseExited(e -> yesButton.setStyle(buttonStyleNormal));

        // Create the No button
        Button noButton = new Button("No");
        noButton.setStyle(buttonStyleNormal);
        noButton.setPrefWidth(80);
        noButton.setPrefHeight(30);

        // Add hover effects
        noButton.setOnMouseEntered(e -> noButton.setStyle(buttonStyleHover));
        noButton.setOnMouseExited(e -> noButton.setStyle(buttonStyleNormal));

        // Set actions
        yesButton.setOnAction(e -> {
            dialogStage.close();
            parentStage.close(); // Close the main application window
        });

        noButton.setOnAction(e -> dialogStage.close());

        // Create button layout
        javafx.scene.layout.HBox buttonBox = new javafx.scene.layout.HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(yesButton, noButton);

        // Create the content layout
        VBox content = new VBox(20);
        content.setAlignment(Pos.CENTER);
        content.setStyle("-fx-background-color: transparent;");
        content.setPadding(new javafx.geometry.Insets(15, 15, 15, 15));
        content.getChildren().addAll(messageLabel, buttonBox);

        // Create main layout
        javafx.scene.layout.StackPane layout = new javafx.scene.layout.StackPane();
        layout.getChildren().addAll(hexBackground, content);
        layout.setStyle("-fx-background-color: transparent;");

        // Create and configure the scene
        Scene scene = new Scene(layout, 300, 300);
        scene.setFill(Color.TRANSPARENT);

        // Configure and show the dialog
        dialogStage.setScene(scene);

        // Center on parent stage
        dialogStage.setOnShown(e -> {
            dialogStage.setX(parentStage.getX() + parentStage.getWidth()/2 - dialogStage.getWidth()/2);
            dialogStage.setY(parentStage.getY() + parentStage.getHeight()/2 - dialogStage.getHeight()/2);

            // Play entry animation
            playDialogEntryAnimation(layout);
        });

        dialogStage.showAndWait();
    }

    /**
     * Handles reset button click event.
     *
     * @param event The mouse event
     */
    @FXML
    void reset(MouseEvent event) {
        // Create a confirmation dialog before resetting
        Stage parentStage = (Stage) hexagonPane.getScene().getWindow();

        // Create a confirmation dialog with styling based on current player
        confirmReset(parentStage);
    }

    /**
     * Shows a reset confirmation dialog.
     *
     * @param parentStage The parent stage for the dialog
     */
    private void confirmReset(Stage parentStage) {
        // Define theme colors based on current player
        Color playerColor = isRedTurn ? Color.RED : Color.BLUE;
        Color playerColorDark = isRedTurn ? Color.color(0.7, 0, 0) : Color.color(0, 0, 0.7);

        // Convert colors to hex format for CSS
        String hexColor = String.format("#%02X%02X%02X",
                (int)(playerColor.getRed() * 255),
                (int)(playerColor.getGreen() * 255),
                (int)(playerColor.getBlue() * 255));

        String darkHexColor = String.format("#%02X%02X%02X",
                (int)(playerColorDark.getRed() * 255),
                (int)(playerColorDark.getGreen() * 255),
                (int)(playerColorDark.getBlue() * 255));

        // Define button styles
        String buttonStyleNormal = "-fx-background-color: " + hexColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 15;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);";

        String buttonStyleHover = "-fx-background-color: " + darkHexColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 15;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 8, 0.0, 0, 2);";

        // Create a new stage for the dialog
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initStyle(StageStyle.TRANSPARENT);
        dialogStage.initOwner(parentStage);

        // Create a hexagon shape as background
        Polygon hexBackground = createDialogHexBackground(playerColor);

        // Create the message label
        Label messageLabel = new Label("Are you sure you want to\nreset the game?");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        messageLabel.setTextFill(BLACK);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(250);
        messageLabel.setAlignment(Pos.CENTER);
        messageLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        // Create the Yes button
        Button yesButton = new Button("Yes");
        yesButton.setStyle(buttonStyleNormal);
        yesButton.setPrefWidth(80);
        yesButton.setPrefHeight(30);

        // Add hover effects
        yesButton.setOnMouseEntered(e -> yesButton.setStyle(buttonStyleHover));
        yesButton.setOnMouseExited(e -> yesButton.setStyle(buttonStyleNormal));

        // Create the No button
        Button noButton = new Button("No");
        noButton.setStyle(buttonStyleNormal);
        noButton.setPrefWidth(80);
        noButton.setPrefHeight(30);

        // Add hover effects
        noButton.setOnMouseEntered(e -> noButton.setStyle(buttonStyleHover));
        noButton.setOnMouseExited(e -> noButton.setStyle(buttonStyleNormal));

        // Set actions
        yesButton.setOnAction(e -> {
            resetGame();
            dialogStage.close();
        });

        noButton.setOnAction(e -> dialogStage.close());

        // Create button layout
        javafx.scene.layout.HBox buttonBox = new javafx.scene.layout.HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(yesButton, noButton);

        // Create the content layout
        VBox content = new VBox(20);
        content.setAlignment(Pos.CENTER);
        content.setStyle("-fx-background-color: transparent;");
        content.setPadding(new javafx.geometry.Insets(15, 15, 15, 15));
        content.getChildren().addAll(messageLabel, buttonBox);

        // Create main layout
        javafx.scene.layout.StackPane layout = new javafx.scene.layout.StackPane();
        layout.getChildren().addAll(hexBackground, content);
        layout.setStyle("-fx-background-color: transparent;");

        // Create and configure the scene
        Scene scene = new Scene(layout, 300, 300);
        scene.setFill(Color.TRANSPARENT);

        // Configure and show the dialog
        dialogStage.setScene(scene);

        // Center on parent stage
        dialogStage.setOnShown(e -> {
            dialogStage.setX(parentStage.getX() + parentStage.getWidth()/2 - dialogStage.getWidth()/2);
            dialogStage.setY(parentStage.getY() + parentStage.getHeight()/2 - dialogStage.getHeight()/2);

            // Play entry animation
            playDialogEntryAnimation(layout);
        });

        dialogStage.showAndWait();
    }

    /**
     * Creates a hexagon shape for dialog backgrounds.
     *
     * @param playerColor The current player's color
     * @return The styled hexagon polygon
     */
    private Polygon createDialogHexBackground(Color playerColor) {
        Polygon hexagon = new Polygon();
        double centerX = 150;
        double centerY = 100;
        double radius = 120;

        for (int i = 0; i < 6; i++) {
            double angle = 2.0 * Math.PI / 6 * i;
            hexagon.getPoints().add(centerX + radius * Math.cos(angle));
            hexagon.getPoints().add(centerY + radius * Math.sin(angle));
        }

        hexagon.setFill(Color.color(1, 1, 1, 0.9));
        hexagon.setStroke(playerColor);
        hexagon.setStrokeWidth(4);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.color(0, 0, 0, 0.7));
        dropShadow.setRadius(20);
        hexagon.setEffect(dropShadow);

        return hexagon;
    }

    /**
     * Creates and plays an entry animation for dialogs.
     *
     * @param node The node to animate
     */
    private void playDialogEntryAnimation(javafx.scene.Node node) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(200), node);
        scale.setFromX(0.1);
        scale.setFromY(0.1);
        scale.setToX(1.0);
        scale.setToY(1.0);

        FadeTransition fade = new FadeTransition(Duration.millis(200), node);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);

        ParallelTransition parallel = new ParallelTransition(scale, fade);
        parallel.play();
    }

    /**
     * Checks if the current move resulted in victory and triggers animation if needed.
     *
     * @param isRedTurn Whether it's red player's turn
     */
    private void checkVictoryAndAnimate(boolean isRedTurn) {
        boolean gameWon = BoardLogic.checkGameWon(isRedTurn);
        if (gameWon) {
            playWaveVictoryAnimation(isRedTurn);
        }
    }

    /**
     * Plays the victory animation when a player wins.
     * Enhanced version that fades out UI elements during animation.
     *
     * @param isRedWinner Whether red player is the winner
     */
    private void playWaveVictoryAnimation(boolean isRedWinner) {
        // Create wave circle for victory animation
        Circle waveCircle = createVictoryWaveCircle(isRedWinner);
        hexagonPane.getChildren().add(waveCircle);

        // Create wave expansion animation
        Timeline waveExpansion = createWaveExpansionAnimation(waveCircle);

        // Create parallel animations container
        ParallelTransition parallelAnimations = new ParallelTransition();
        parallelAnimations.getChildren().add(waveExpansion);

        // Prepare hexagons for victory animation
        List<Polygon> allHexes = prepareHexagonsForVictoryAnimation();

        // Create sequential animation to reveal tiles
        SequentialTransition revealTiles = createRevealTilesAnimation(allHexes, isRedWinner);
        parallelAnimations.getChildren().add(revealTiles);

        // Create victory text
        Text victoryText = createVictoryText(isRedWinner);
        hexagonPane.getChildren().add(victoryText);

        // Create victory text animation
        ParallelTransition textAnimation = createVictoryTextAnimation(victoryText);
        parallelAnimations.getChildren().add(textAnimation);

        // Create fade-out animation for UI control elements
        ParallelTransition fadeOutControls = createControlsFadeOutAnimation();
        parallelAnimations.getChildren().add(fadeOutControls);

        // Create buttons for victory screen
        Button resetButton = createResetButton(waveCircle, victoryText, isRedWinner);
        Button quitButton = createQuitButton(isRedWinner);
        hexagonPane.getChildren().addAll(resetButton, quitButton);

        // Create button animations
        ParallelTransition buttonAnimation = createButtonAnimations(resetButton, quitButton);

        // Create full animation sequence
        SequentialTransition fullAnimation = new SequentialTransition();
        fullAnimation.getChildren().add(parallelAnimations);
        fullAnimation.getChildren().add(buttonAnimation);

        // Play the animation
        fullAnimation.play();
    }

    /**
     * Creates a circle for the wave victory animation.
     *
     * @param isRedWinner Whether red player is the winner
     * @return The configured circle
     */
    private Circle createVictoryWaveCircle(boolean isRedWinner) {
        Circle waveCircle = new Circle();
        waveCircle.setCenterX(300);
        waveCircle.setCenterY(300);
        waveCircle.setRadius(0);

        Color baseColor = isRedWinner ? Color.RED : Color.BLUE;

        RadialGradient gradient = new RadialGradient(
                0, 0, 0.5, 0.5, 1.0, true, CycleMethod.NO_CYCLE,
                new Stop(0.0, new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.0)),
                new Stop(0.7, new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.5)),
                new Stop(1.0, new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.0))
        );

        waveCircle.setFill(gradient);
        return waveCircle;
    }

    /**
     * Creates the wave expansion animation.
     *
     * @param waveCircle The circle to animate
     * @return The configured animation
     */
    private Timeline createWaveExpansionAnimation(Circle waveCircle) {
        return new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(waveCircle.radiusProperty(), 0)),
                new KeyFrame(Duration.millis(1300), new KeyValue(waveCircle.radiusProperty(), 500, Interpolator.EASE_OUT))
        );
    }

    /**
     * Prepares all hexagons for the victory animation.
     *
     * @return List of sorted hexagons by distance from center
     */
    private List<Polygon> prepareHexagonsForVictoryAnimation() {
        List<Polygon> allHexes = new ArrayList<>();
        for (var node : hexagonPane.getChildren()) {
            if (node instanceof Polygon hex) {
                String polyId = hex.getId();
                if (!(polyId.equals("exit0") || polyId.equals("reset0") || polyId.equals("turn0"))) {
                    hex.setStroke(BLACK);
                    hex.setStrokeWidth(3);

                    if (hex.getFill() == redFade || hex.getFill() == blueFade) {
                        hex.setFill(baseColor);
                    }

                    hex.setOnMouseEntered(null);
                    hex.setOnMouseExited(null);
                    hex.setOnMouseClicked(null);

                    allHexes.add(hex);
                }
            }
        }

        allHexes.sort((a, b) -> {
            double distA = Math.sqrt(Math.pow(a.getLayoutX() - 300, 2) + Math.pow(a.getLayoutY() - 300, 2));
            double distB = Math.sqrt(Math.pow(b.getLayoutX() - 300, 2) + Math.pow(b.getLayoutY() - 300, 2));
            return Double.compare(distA, distB);
        });

        return allHexes;
    }

    /**
     * Creates the animation that reveals tiles in sequence.
     *
     * @param allHexes List of hexagons to animate
     * @param isRedWinner Whether red player is the winner
     * @return The configured animation
     */
    private SequentialTransition createRevealTilesAnimation(List<Polygon> allHexes, boolean isRedWinner) {
        SequentialTransition revealTiles = new SequentialTransition();
        Color finalColor = isRedWinner ? RED : BLUE;

        for (Polygon hex : allHexes) {
            if ((isRedWinner && hex.getFill() != RED) || (!isRedWinner && hex.getFill() != BLUE)) {
                FillTransition fillTransition = new FillTransition(
                        Duration.millis(10),
                        hex,
                        (Color) hex.getFill(),
                        finalColor
                );

                revealTiles.getChildren().add(fillTransition);
            }
        }

        return revealTiles;
    }

    /**
     * Creates the victory text element.
     *
     * @param isRedWinner Whether red player is the winner
     * @return The configured text element
     */
    private Text createVictoryText(boolean isRedWinner) {
        Text victoryText = new Text();
        victoryText.setText(isRedWinner ? "RED WINS!" : "BLUE WINS!");
        victoryText.setFont(new Font("Arial Bold", 80));
        victoryText.setFill(Color.WHITE);
        victoryText.setStroke(isRedWinner ? Color.RED.darker() : Color.BLUE.darker());
        victoryText.setStrokeWidth(2);

        victoryText.setLayoutX(300 - victoryText.getBoundsInLocal().getWidth() / 2);
        victoryText.setLayoutY(330);
        victoryText.setOpacity(0);

        return victoryText;
    }

    /**
     * Creates the animation for the victory text.
     *
     * @param victoryText The text to animate
     * @return The configured animation
     */
    private ParallelTransition createVictoryTextAnimation(Text victoryText) {
        FadeTransition textFade = new FadeTransition(Duration.millis(800), victoryText);
        textFade.setFromValue(0);
        textFade.setToValue(1);

        ScaleTransition textScale = new ScaleTransition(Duration.millis(800), victoryText);
        textScale.setFromX(0.5);
        textScale.setFromY(0.5);
        textScale.setToX(1.0);
        textScale.setToY(1.0);
        textScale.setInterpolator(Interpolator.EASE_OUT);

        return new ParallelTransition(textFade, textScale);
    }

    /**
     * Creates fade-out animations for UI control elements (turn indicator, reset button, exit button).
     *
     * @return The configured parallel transition containing all fade-out animations
     */
    private ParallelTransition createControlsFadeOutAnimation() {
        ParallelTransition fadeOutTransitions = new ParallelTransition();

        // Find each control element by its ID
        Polygon exitButton = exit0;
        Polygon resetButton = reset0;
        Polygon turnButton = turn0;

        // Add fade-out animation for exit button and its text
        FadeTransition exitButtonFade = new FadeTransition(Duration.millis(600), exitButton);
        exitButtonFade.setFromValue(1.0);
        exitButtonFade.setToValue(0.0);
        fadeOutTransitions.getChildren().add(exitButtonFade);

        FadeTransition exitTextFade = new FadeTransition(Duration.millis(600), exitText);
        exitTextFade.setFromValue(1.0);
        exitTextFade.setToValue(0.0);
        fadeOutTransitions.getChildren().add(exitTextFade);

        // Add fade-out animation for reset button and its text
        FadeTransition resetButtonFade = new FadeTransition(Duration.millis(600), resetButton);
        resetButtonFade.setFromValue(1.0);
        resetButtonFade.setToValue(0.0);
        fadeOutTransitions.getChildren().add(resetButtonFade);

        FadeTransition resetTextFade = new FadeTransition(Duration.millis(600), resetText);
        resetTextFade.setFromValue(1.0);
        resetTextFade.setToValue(0.0);
        fadeOutTransitions.getChildren().add(resetTextFade);

        // Add fade-out animation for turn indicator and its text
        FadeTransition turnIndicatorFade = new FadeTransition(Duration.millis(600), turnButton);
        turnIndicatorFade.setFromValue(1.0);
        turnIndicatorFade.setToValue(0.0);
        fadeOutTransitions.getChildren().add(turnIndicatorFade);

        FadeTransition turnTextFade = new FadeTransition(Duration.millis(600), turnIndicator);
        turnTextFade.setFromValue(1.0);
        turnTextFade.setToValue(0.0);
        fadeOutTransitions.getChildren().add(turnTextFade);

        return fadeOutTransitions;
    }

    /**
     * Creates the reset button for the victory screen.
     * Enhanced version with additional UI element restoration.
     *
     * @param waveCircle The wave circle to remove when resetting
     * @param victoryText The victory text to remove when resetting
     * @param isRedWinner Whether red player is the winner
     * @return The configured button
     */
    private Button createResetButton(Circle waveCircle, Text victoryText, boolean isRedWinner) {
        Button resetButton = new Button("Play Again");

        // Set positioning
        resetButton.setLayoutX(250);
        resetButton.setLayoutY(350);
        resetButton.setOpacity(0);

        // Set size
        resetButton.setPrefWidth(100);
        resetButton.setPrefHeight(30);

        // Set styling based on winner's color
        Color buttonColor = isRedWinner ? Color.RED : Color.BLUE;
        String hexColor = String.format("#%02X%02X%02X",
                (int)(buttonColor.getRed() * 255),
                (int)(buttonColor.getGreen() * 255),
                (int)(buttonColor.getBlue() * 255));

        // Apply styled CSS
        resetButton.setStyle(
                "-fx-background-color: " + "white" + ";" +
                        "-fx-text-fill: black;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 60;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);"
        );

        // Add hover effect
        resetButton.setOnMouseEntered(e -> resetButton.setStyle(
                "-fx-background-color: " + hexColor + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 60;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 8, 0.0, 0, 2);"
        ));

        resetButton.setOnMouseExited(e -> resetButton.setStyle(
                "-fx-background-color: " + "white" + ";" +
                        "-fx-text-fill: black;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 60;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);"
        ));

        // Set action
        resetButton.setOnAction(event -> {
            // First remove UI elements from victory screen
            hexagonPane.getChildren().removeAll(
                    resetButton,
                    hexagonPane.lookup("#quitButton"),
                    victoryText,
                    waveCircle
            );

            // Then reset the game
            BoardLogic.clearBoard();

            // Reset game hexagons, but exclude control polygons
            for (var node : hexagonPane.getChildren()) {
                if (node instanceof Polygon poly) {
                    // Skip control polygons (exit, reset, turn indicator)
                    String polyId = poly.getId();
                    if (polyId != null && (polyId.equals("exit0") || polyId.equals("reset0") || polyId.equals("turn0"))) {
                        continue;
                    }

                    resetHexagon(poly);
                }
            }

            // Reset UI control elements to be visible again
            resetUIControlVisibility();

            isRedTurn = true;
            updateTurnIndicator();
        });

        return resetButton;
    }

    /**
     * Restores visibility of UI control elements after victory animation.
     */
    private void resetUIControlVisibility() {
        // Restore exit button and text
        exit0.setOpacity(1.0);
        exitText.setOpacity(1.0);

        // Restore reset button and text
        reset0.setOpacity(1.0);
        resetText.setOpacity(1.0);

        // Restore turn indicator and text
        turn0.setOpacity(1.0);
        turnIndicator.setOpacity(1.0);
    }

    /**
     * Creates the quit button for the victory screen with enhanced styling.
     *
     * @param isRedWinner Whether red player is the winner
     * @return The configured button
     */
    private Button createQuitButton(boolean isRedWinner) {
        Button quitButton = new Button("Quit");
        quitButton.setId("quitButton");

        // Set positioning - adjusted to be centered horizontally
        quitButton.setLayoutX(250);
        quitButton.setLayoutY(390);
        quitButton.setOpacity(0);

        // Set size
        quitButton.setPrefWidth(100);
        quitButton.setPrefHeight(30);

        // Set styling based on winner's color
        Color buttonColor = isRedWinner ? Color.RED : Color.BLUE;
        String hexColor = String.format("#%02X%02X%02X",
                (int)(buttonColor.getRed() * 255),
                (int)(buttonColor.getGreen() * 255),
                (int)(buttonColor.getBlue() * 255));

        // Apply styled CSS
        quitButton.setStyle(
                "-fx-background-color: " + "white" + ";" +
                        "-fx-text-fill: black;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 60;" + // Rounded corners
                        "-fx-border-color: black;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);"
        );

        // Add hover effect
        quitButton.setOnMouseEntered(e -> quitButton.setStyle(
                "-fx-background-color: " + hexColor + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 60;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 8, 0.0, 0, 2);"
        ));

        quitButton.setOnMouseExited(e -> quitButton.setStyle(
                "-fx-background-color: " + "white" + ";" +
                        "-fx-text-fill: black;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 60;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);"
        ));

        // Set action
        quitButton.setOnAction(event -> {
            Stage stage = (Stage) quitButton.getScene().getWindow();
            stage.close();
        });

        return quitButton;
    }

    /**
     * Creates animations for the victory screen buttons.
     *
     * @param resetButton The reset button to animate
     * @param quitButton The quit button to animate
     * @return The configured animations
     */
    private ParallelTransition createButtonAnimations(Button resetButton, Button quitButton) {
        FadeTransition resetFade = new FadeTransition(Duration.millis(600), resetButton);
        resetFade.setFromValue(0);
        resetFade.setToValue(1);

        FadeTransition quitFade = new FadeTransition(Duration.millis(600), quitButton);
        quitFade.setFromValue(0);
        quitFade.setToValue(1);

        return new ParallelTransition(resetFade, quitFade);
    }

    /**
     * Resets the game to initial state.
     */
    @FXML
    private void resetGame() {
        BoardLogic.clearBoard();

        for (var node : hexagonPane.getChildren()) {
            if (node instanceof Polygon poly) {
                // Skip control polygons (exit, reset, turn indicator)
                String polyId = poly.getId();
                if (polyId != null && (polyId.equals("exit0") || polyId.equals("reset0") || polyId.equals("turn0"))) {
                    continue;
                }

                resetHexagon(poly);
            }
        }

        isRedTurn = true;
        updateTurnIndicator();
    }

    /**
     * Resets a single hexagon to its initial state.
     *
     * @param hex The hexagon to reset
     */
    private void resetHexagon(Polygon hex) {
        hex.setFill(baseColor);
        hex.setEffect(null);
        hex.setScaleX(.5);
        hex.setScaleY(.5);
        hex.setStroke(BLACK);
        hex.setStrokeWidth(3);

        hex.setOnMouseEntered(this::hover);
        hex.setOnMouseExited(event -> {
            hex.setStroke(BLACK);
            hex.setFill(baseColor);
            hex.setStrokeWidth(3);
        });
        hex.setOnMouseClicked(this::getHexID);
    }
}
