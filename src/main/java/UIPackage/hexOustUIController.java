package UIPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;

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

    private static final Color baseColor = new Color(0.8627, 0.8627, 0.8627, 1.0);
    private final Color blueFade = new Color(0, 0, 1, 0.3);
    private final Color redFade = new Color(1, 0, 0, 0.3);
    public static int centerX;
    public static int centerY;
    private static final Duration BOUNCE_DURATION = Duration.millis(169);
    private List<Polygon> winningHexagons = new ArrayList<>();

    // Field to track if an animation is in progress
    private boolean animationInProgress = false;

    @FXML
    private AnchorPane hexagonPane; // Reference to the Pane from SceneBuilder

    private static hexOustUIController instance; // Static reference

    @FXML
    public void initialize() {
        instance = this; // Store the instance when JavaFX initializes
    }

    // Method to repaint a hexagon at a given layout position
    public static void repaintToBase(int layoutX, int layoutY) {
        for (var node : instance.hexagonPane.getChildren()) {
            if (node instanceof Polygon poly) {
                if (poly.getLayoutX() == layoutX && poly.getLayoutY() == layoutY) {
                    poly.setFill(baseColor); // Change color
                    return;
                }
            }
        }
    }


    private HexCube getCube (MouseEvent event) {
        //get centerpoint of hexagon clicked
        double clickX = event.getSceneX();
        double clickY = event.getSceneY();
        double eventX = - event.getY();
        double eventY = event.getX();
        centerX = (int) (clickX - eventX/2.0);
        centerY = (int) (clickY - eventY/2.0);

        //turn the center point into a Point p
        Point p = new Point(centerX, centerY);

        //create hexagon with that point p
        return new HexCube(p);
    }

    private void invalidAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Move");
        alert.setHeaderText(null);
        alert.setContentText("You cannot place a hex here!");
        alert.showAndWait();
    }

    // Modified applyBounceEffect with no callback needed
    private void applyBounceEffect(Polygon hexagon) {
        // Prevent multiple animations running at once
        if (animationInProgress) return;

        animationInProgress = true;

        // Create scale down animation
        ScaleTransition scaleDown = new ScaleTransition(BOUNCE_DURATION, hexagon);
        scaleDown.setToX(0.40);
        scaleDown.setToY(0.40);

        // Create scale back up animation
        ScaleTransition scaleUp = new ScaleTransition(BOUNCE_DURATION, hexagon);
        scaleUp.setToX(0.5);
        scaleUp.setToY(0.5);
        scaleUp.setInterpolator(Interpolator.EASE_OUT);

        // Create slight overshoot for more natural bounce
        ScaleTransition scaleOvershoot = new ScaleTransition(BOUNCE_DURATION.divide(2), hexagon);
        scaleOvershoot.setToX(0.55);
        scaleOvershoot.setToY(0.55);

        // Final settle
        ScaleTransition scaleSettle = new ScaleTransition(BOUNCE_DURATION.divide(2), hexagon);
        scaleSettle.setToX(0.5);
        scaleSettle.setToY(0.5);

        // Chain the animations
        SequentialTransition bounceEffect = new SequentialTransition(
                scaleDown, scaleUp, scaleOvershoot, scaleSettle);

        // Set up completion handler
        bounceEffect.setOnFinished(e -> {
            animationInProgress = false;
        });

        // Play the animation
        bounceEffect.play();
    }

    @FXML
    void getHexID(MouseEvent event) {
        HexCube c = getCube(event);

        if (!BoardLogic.isValidMove(c, isRedTurn)) {
            invalidAlert();
            return;
        }

        // Get the hexagon that was clicked
        Polygon hexagon = (Polygon) event.getSource();

        // If the hexagon is already occupied, do nothing
        if (hexagon.getFill() == RED || hexagon.getFill() == BLUE) {
            return;
        }

        // This gets the number of opposite color hexagons
        int oppColorSize = BoardLogic.listSize(isRedTurn);

        // Add to the board logic immediately
        BoardLogic.addToList(c, isRedTurn);

        // Set the permanent color immediately
        Color permanentColor = isRedTurn ? RED : BLUE;
        hexagon.setFill(permanentColor);
        hexagon.setStroke(BLACK);
        hexagon.setStrokeWidth(3);

        // Remove hover behavior for occupied hexagons
        hexagon.setOnMouseExited(null);

        // Start the bounce animation without any callback
        applyBounceEffect(hexagon);

        // Check if a capture happened
        boolean captureHappened = oppColorSize != BoardLogic.listSize(isRedTurn);

        // Check for victory immediately
        checkVictoryAndAnimate(isRedTurn);

        // Only switch turns if no capture happened - do this immediately
        if (!captureHappened) {
            isRedTurn = !isRedTurn;
        }

        // Update turn indicator immediately
        if (!isRedTurn) {
            turnIndicator.setText("Blue Player's Turn");
            turnIndicatorCircle.setFill(Color.BLUE);
        } else {
            turnIndicator.setText("Red Player's Turn");
            turnIndicatorCircle.setFill(Color.RED);
        }
    }

    @FXML
    void hover(MouseEvent event) {
        Polygon hexagon = (Polygon) event.getSource();

        //skip hover effects for already occupied hexagons
        if (hexagon.getFill() == RED || hexagon.getFill() == BLUE) {
            return;
        }

        HexCube c = getCube(event);
        if (BoardLogic.isValidMove(c, isRedTurn)) {
            final Color previousFill = (Color) hexagon.getFill();

            hexagon.setStroke(WHITESMOKE);
            hexagon.setStrokeWidth(5);

            //set the appropriate hover color
            if (isRedTurn) {
                hexagon.setFill(redFade);
            } else {
                hexagon.setFill(blueFade);
            }

            //set the onMouseExited to restore the previous state
            hexagon.setOnMouseExited(exitEvent -> {
                hexagon.setStroke(BLACK);
                hexagon.setFill(previousFill);
                hexagon.setStrokeWidth(3);
            });
        }
    }

    @FXML
    void exit(MouseEvent event) {
        Button exitButton = (Button) event.getSource();
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private void checkVictoryAndAnimate(boolean isRedTurn) {
        boolean gameWon = BoardLogic.checkGameWon(isRedTurn);

        if (gameWon) {
            playWaveVictoryAnimation(isRedTurn);
        }
    }

    private void playWaveVictoryAnimation(boolean isRedWinner) {
        // Create wave effect container
        Circle waveCircle = new Circle();
        waveCircle.setCenterX(300); // Center of the board
        waveCircle.setCenterY(300);
        waveCircle.setRadius(0);

        // Define base color for winner
        Color baseColor = isRedWinner ? Color.RED : Color.BLUE;
        Color finalColor = isRedWinner ? RED : BLUE;

        // Create a radial gradient with faded edges
        RadialGradient gradient = new RadialGradient(
                0, 0, 0.5, 0.5, 1.0, true, CycleMethod.NO_CYCLE,
                new Stop(0.0, new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.0)),
                new Stop(0.7, new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.5)),
                new Stop(1.0, new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.0))
        );

        // Set gradient fill
        waveCircle.setFill(gradient);

        // Add wave to board
        hexagonPane.getChildren().add(waveCircle);

        // Create expanding wave animation
        Timeline waveExpansion = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(waveCircle.radiusProperty(), 0)),
                new KeyFrame(Duration.millis(1300), new KeyValue(waveCircle.radiusProperty(), 500, Interpolator.EASE_OUT))
        );

        // Prepare hexagon animations
        ParallelTransition parallelAnimations = new ParallelTransition();

        // Add wave animation to parallel animations
        parallelAnimations.getChildren().add(waveExpansion);

        List<Polygon> allHexes = new ArrayList<>();
        for (var node : hexagonPane.getChildren()) {
            if (node instanceof Polygon hex) {
                // Clear any hover effects
                hex.setStroke(BLACK);
                hex.setStrokeWidth(3);

                // If it's showing a hover color, reset it to the appropriate color
                if (hex.getFill() == redFade || hex.getFill() == blueFade) {
                    hex.setFill(baseColor);
                }

                // Disable all mouse events
                hex.setOnMouseEntered(null);
                hex.setOnMouseExited(null);
                hex.setOnMouseClicked(null);

                // Add to our list for animation
                allHexes.add(hex);
            }
        }

        // Sort hexagons by distance from center
        allHexes.sort((a, b) -> {
            double distA = Math.sqrt(Math.pow(a.getLayoutX() - 300, 2) + Math.pow(a.getLayoutY() - 300, 2));
            double distB = Math.sqrt(Math.pow(b.getLayoutX() - 300, 2) + Math.pow(b.getLayoutY() - 300, 2));
            return Double.compare(distA, distB);
        });

        // Create a sequence of reveal animations that will run in parallel with the wave
        SequentialTransition revealTiles = new SequentialTransition();

        // Create a slightly faster sequence to match the wave expansion timing
        for (int i = 0; i < allHexes.size(); i++) {
            Polygon hex = allHexes.get(i);

            // Only animate non-winner colored hexagons
            if ((isRedWinner && hex.getFill() != RED) || (!isRedWinner && hex.getFill() != BLUE)) {
                FillTransition fillTransition = new FillTransition(
                        Duration.millis(10),  // Keep this fast for rapid sequential effect
                        hex,
                        (Color) hex.getFill(),
                        finalColor
                );

                revealTiles.getChildren().add(fillTransition);
            }
        }

        // Add the reveal tiles animation to the parallel group
        parallelAnimations.getChildren().add(revealTiles);

        // Create victory text
        Text victoryText = new Text();
        victoryText.setText(isRedWinner ? "RED WINS!" : "BLUE WINS!");
        victoryText.setFont(new Font("Arial Bold", 80));
        victoryText.setFill(Color.WHITE);
        victoryText.setStroke(isRedWinner ? Color.RED.darker() : Color.BLUE.darker());
        victoryText.setStrokeWidth(2);

        // Center the text
        victoryText.setLayoutX(300 - victoryText.getBoundsInLocal().getWidth() / 2);
        victoryText.setLayoutY(330);
        victoryText.setOpacity(0);

        // Add text to the pane
        hexagonPane.getChildren().add(victoryText);

        // Create text animation
        FadeTransition textFade = new FadeTransition(Duration.millis(800), victoryText);
        textFade.setFromValue(0);
        textFade.setToValue(1);

        ScaleTransition textScale = new ScaleTransition(Duration.millis(800), victoryText);
        textScale.setFromX(0.5);
        textScale.setFromY(0.5);
        textScale.setToX(1.0);
        textScale.setToY(1.0);
        textScale.setInterpolator(Interpolator.EASE_OUT);

        ParallelTransition textAnimation = new ParallelTransition(textFade, textScale);


        // Create buttons
        Button quitButton = new Button("Quit");
        quitButton.setLayoutX(280);
        quitButton.setLayoutY(380);
        quitButton.setOpacity(0);
        quitButton.setOnAction(event -> {
            Stage stage = (Stage) quitButton.getScene().getWindow();
            stage.close();
        });

        Button resetButton = new Button("Play Again");
        resetButton.setLayoutX(262.5);
        resetButton.setLayoutY(350);
        resetButton.setOpacity(0);
        resetButton.setOnAction(event -> {
            resetGame();
            hexagonPane.getChildren().removeAll(resetButton, quitButton, victoryText, waveCircle);
        });

        // Add buttons to pane but make them invisible initially
        hexagonPane.getChildren().addAll(resetButton, quitButton);

        // Create button animations
        FadeTransition resetFade = new FadeTransition(Duration.millis(600), resetButton);
        resetFade.setFromValue(0);
        resetFade.setToValue(1);

        FadeTransition quitFade = new FadeTransition(Duration.millis(600), quitButton);
        quitFade.setFromValue(0);
        quitFade.setToValue(1);

        ParallelTransition buttonAnimation = new ParallelTransition(resetFade, quitFade);

        // Create the full animation sequence
        SequentialTransition fullAnimation = new SequentialTransition();

        // First, run the wave, hexagon and text animations in parallel
        parallelAnimations.getChildren().add(textAnimation);

        fullAnimation.getChildren().add(parallelAnimations);

        // Finally, after the text appears, show the buttons
        fullAnimation.getChildren().addAll(buttonAnimation);

        // Play the entire animation sequence
        fullAnimation.play();
    }

    /**
     * Reset the game
     */
    private void resetGame() {
        // Reset the board logic
        BoardLogic.clearBoard();

        // Reset all hexagons to base color
        for (var node : hexagonPane.getChildren()) {
            if (node instanceof Polygon poly) {
                // Reset visual properties
                poly.setFill(baseColor);
                poly.setEffect(null);
                poly.setScaleX(.5);
                poly.setScaleY(.5);
                poly.setStroke(BLACK);
                poly.setStrokeWidth(3);

                // Re-enable all mouse event handlers by re-assigning them
                poly.setOnMouseEntered(this::hover);
                poly.setOnMouseExited(event -> {
                    poly.setStroke(BLACK);
                    poly.setFill(baseColor);
                    poly.setStrokeWidth(3);
                });
                poly.setOnMouseClicked(this::getHexID);
            }
        }

        // Reset turn indicator
        isRedTurn = true;
        turnIndicator.setText("Red Player's Turn");
        turnIndicatorCircle.setFill(Color.RED);
    }



    @FXML
    private Label turnIndicator;
    private boolean isRedTurn = true; // Start with Red Player
    @FXML
    private Circle turnIndicatorCircle;
}
