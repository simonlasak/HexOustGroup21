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

import static javafx.scene.paint.Color.*;

/**
 * Controller class for the HexOust game user interface.
 * Handles UI events, animations, and game state management for the hexagonal board game.
 */
public class hexOustUIController {

    @FXML
    public Polygon hex154;

    @FXML
    private Polygon hex0;

    @FXML
    private Polygon hex05;

    @FXML
    private Polygon hex1;

    @FXML
    private Polygon hex16;

    @FXML
    private Polygon hex19111;

    @FXML
    private Polygon hex191111;

    @FXML
    private Polygon hex1911111;

    @FXML
    private Polygon hex19111111;

    @FXML
    private Polygon hex191111111;

    @FXML
    private Polygon hex1911111111;

    @FXML
    private Polygon hex19111111111;

    @FXML
    private Polygon hex191111111111;

    @FXML
    private Polygon hex1911111112;

    @FXML
    private Polygon hex19111111121;

    @FXML
    private Polygon hex191111112;

    @FXML
    private Polygon hex191111113;

    @FXML
    private Polygon hex19111112;

    @FXML
    private Polygon hex191112;

    @FXML
    private Polygon hex1911121;

    @FXML
    private Polygon hex19111211;

    @FXML
    private Polygon hex191112111;

    @FXML
    private Polygon hex1911122;

    @FXML
    private Polygon hex19111221;

    @FXML
    private Polygon hex191113;

    @FXML
    private Polygon hex191114;

    @FXML
    private Polygon hex19112;

    @FXML
    private Polygon hex1912111;

    @FXML
    private Polygon hex19121111;

    @FXML
    private Polygon hex191211111;

    @FXML
    private Polygon hex1912111111;

    @FXML
    private Polygon hex19121111111;

    @FXML
    private Polygon hex191211111111;

    @FXML
    private Polygon hex1912111111111;

    @FXML
    private Polygon hex19121111111111;

    @FXML
    private Polygon hex191211111111111;

    @FXML
    private Polygon hex1912111111112;

    @FXML
    private Polygon hex19121111111121;

    @FXML
    private Polygon hex191211111112;

    @FXML
    private Polygon hex191211111113;

    @FXML
    private Polygon hex19121111112;

    @FXML
    private Polygon hex19121112;

    @FXML
    private Polygon hex191211121;

    @FXML
    private Polygon hex1912111211;

    @FXML
    private Polygon hex19121112111;

    @FXML
    private Polygon hex191211121111;

    @FXML
    private Polygon hex1912111211111;

    @FXML
    private Polygon hex19121112111111;

    @FXML
    private Polygon hex191211121112;

    @FXML
    private Polygon hex1912111211121;

    @FXML
    private Polygon hex19121112112;

    @FXML
    private Polygon hex19121112113;

    @FXML
    private Polygon hex1912111212;

    @FXML
    private Polygon hex1912112;

    @FXML
    private Polygon hex19121121;

    @FXML
    private Polygon hex191211211;

    @FXML
    private Polygon hex1912112111;

    @FXML
    private Polygon hex19121121112;

    @FXML
    private Polygon hex191211211121;

    @FXML
    private Polygon hex1912112111211;

    @FXML
    private Polygon hex19121121112111;

    @FXML
    private Polygon hex191211211121111;

    @FXML
    private Polygon hex1912112111211111;

    @FXML
    private Polygon hex19121121112112;

    @FXML
    private Polygon hex191211211121121;

    @FXML
    private Polygon hex1912112111212;

    @FXML
    private Polygon hex1912112111213;

    @FXML
    private Polygon hex191211211122;

    @FXML
    private Polygon hex19121122;

    @FXML
    private Polygon hex191211221;

    @FXML
    private Polygon hex1912112212;

    @FXML
    private Polygon hex19121122121;

    @FXML
    private Polygon hex191211221211;

    @FXML
    private Polygon hex1912112212111;

    @FXML
    private Polygon hex19121122121111;

    @FXML
    private Polygon hex1912112212112;

    @FXML
    private Polygon hex19121122121121;

    @FXML
    private Polygon hex191211221212;

    @FXML
    private Polygon hex191211221213;

    @FXML
    private Polygon hex19121122122;

    @FXML
    private Polygon hex19121123;

    @FXML
    private Polygon hex191211231;

    @FXML
    private Polygon hex1912113;

    @FXML
    private Polygon hex19121131;

    @FXML
    private Polygon hex191211311;

    @FXML
    private Polygon hex1912113111;

    @FXML
    private Polygon hex19121131111;

    @FXML
    private Polygon hex191211311111;

    @FXML
    private Polygon hex1912113111111;

    @FXML
    private Polygon hex19121131112;

    @FXML
    private Polygon hex191211311121;

    @FXML
    private Polygon hex1912113112;

    @FXML
    private Polygon hex1912113113;

    @FXML
    private Polygon hex191211312;

    @FXML
    private Polygon hex191212;

    @FXML
    private Polygon hex1912121;

    @FXML
    private Polygon hex19121212;

    @FXML
    private Polygon hex191212121;

    @FXML
    private Polygon hex1912121211;

    @FXML
    private Polygon hex19121212111;

    @FXML
    private Polygon hex191212121111;

    @FXML
    private Polygon hex1912121211111;

    @FXML
    private Polygon hex19121212111111;

    @FXML
    private Polygon hex191212121112;

    @FXML
    private Polygon hex19121212112;

    @FXML
    private Polygon hex191213;

    @FXML
    private Polygon hex1912131;

    @FXML
    private Polygon hex19121311;

    @FXML
    private Polygon hex1912131112;

    @FXML
    private Polygon hex19121311121;

    @FXML
    private Polygon hex191213111211;

    @FXML
    private Polygon hex19121311121111;

    @FXML
    private Polygon hex191213113;

    @FXML
    private Polygon hex1912131131;

    @FXML
    private Polygon hex19121311311;

    @FXML
    private Polygon hex191213113111;

    @FXML
    private Polygon hex191213113112;

    @FXML
    private Polygon hex1912131131121;

    @FXML
    private Polygon hex19121311312;

    @FXML
    private Polygon hex19121311313;

    @FXML
    private Polygon hex1912132;

    @FXML
    private Polygon hex19121321;

    @FXML
    private Polygon hex191213211;

    @FXML
    private Polygon hex1912132111;

    @FXML
    private Polygon hex191214;

    @FXML
    private Polygon hex2;

    @FXML
    private Polygon hex3;

    @FXML
    private Polygon hex4;

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
     * Reference to the main pane containing all hexagon tiles.
     */
    @FXML
    private AnchorPane hexagonPane;

    /**
     * Static reference to the controller instance.
     */
    private static hexOustUIController instance;

    /**
     * Label displaying the current player's turn.
     */
    @FXML
    private Label turnIndicator;

    /**
     * Flag tracking which player's turn it is (true = Red, false = Blue).
     */
    private boolean isRedTurn = true;

    /**
     * Circle that indicates current player's turn.
     */
    @FXML
    private Circle turnIndicatorCircle;

    /**
     * Initialize the controller when the FXML is loaded.
     */
    @FXML
    public void initialize() {
        instance = this;
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
     * Updates the turn indicator to show current player.
     */
    private void updateTurnIndicator() {
        if (!isRedTurn) {
            turnIndicator.setText("Blue Player's Turn");
            turnIndicatorCircle.setFill(Color.BLUE);
        } else {
            turnIndicator.setText("Red Player's Turn");
            turnIndicatorCircle.setFill(Color.RED);
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
        Button exitButton = (Button) event.getSource();
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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
     *
     * @param isRedWinner Whether red player is the winner
     */
    private void playWaveVictoryAnimation(boolean isRedWinner) {
        Circle waveCircle = createVictoryWaveCircle(isRedWinner);
        hexagonPane.getChildren().add(waveCircle);

        Timeline waveExpansion = createWaveExpansionAnimation(waveCircle);

        ParallelTransition parallelAnimations = new ParallelTransition();
        parallelAnimations.getChildren().add(waveExpansion);

        List<Polygon> allHexes = prepareHexagonsForVictoryAnimation();

        SequentialTransition revealTiles = createRevealTilesAnimation(allHexes, isRedWinner);
        parallelAnimations.getChildren().add(revealTiles);

        Text victoryText = createVictoryText(isRedWinner);
        hexagonPane.getChildren().add(victoryText);

        ParallelTransition textAnimation = createVictoryTextAnimation(victoryText);
        parallelAnimations.getChildren().add(textAnimation);

        // Pass isRedWinner to button creation methods
        Button resetButton = createResetButton(waveCircle, victoryText, isRedWinner);
        Button quitButton = createQuitButton(isRedWinner);

        hexagonPane.getChildren().addAll(resetButton, quitButton);

        ParallelTransition buttonAnimation = createButtonAnimations(resetButton, quitButton);

        SequentialTransition fullAnimation = new SequentialTransition();
        fullAnimation.getChildren().add(parallelAnimations);
        fullAnimation.getChildren().add(buttonAnimation);

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
     * Creates the reset button for the victory screen.
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
                        "-fx-background-radius: 60;" + // Rounded corners
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
            resetGame();
            hexagonPane.getChildren().removeAll(
                    resetButton,
                    hexagonPane.lookup("#quitButton"),
                    victoryText,
                    waveCircle
            );
        });

        return resetButton;
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
    private void resetGame() {
        BoardLogic.clearBoard();

        for (var node : hexagonPane.getChildren()) {
            if (node instanceof Polygon poly) {
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
