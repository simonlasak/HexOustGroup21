package UIPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

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

    @FXML
    private AnchorPane hexagonPane; // Reference to the Pane from SceneBuilder

    private static hexOustUIController instance; // Static reference

    @FXML
    public void initialize() {
        instance = this; // Store the instance when JavaFX initializes
    }

    // Method to repaint a hexagon at a given layout position
    public static void repaintToBase(int layoutX, int layoutY) {
        //System.out.println("x: " + layoutX + ", y:" + layoutY);
        for (var node : instance.hexagonPane.getChildren()) {
            if (node instanceof Polygon poly) {
                //System.out.println("polyX: " + poly.getLayoutX() + ", polyY" + poly.getLayoutY());
                if (poly.getLayoutX() == layoutX && poly.getLayoutY() == layoutY) {
                    //System.out.println(layoutX + " " + layoutY);
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


    @FXML
    void getHexID(MouseEvent event) {
        HexCube c = getCube(event);

        if (!BoardLogic.isValidMove(c, isRedTurn)) {
            invalidAlert();
            return;
        }

        BoardLogic.addToList(c, isRedTurn);
        BoardLogic.printLists();

        //this should probably be put in its own method
        Polygon hexagon = (Polygon) event.getSource();
        if (hexagon.getFill() != RED && hexagon.getFill() != BLUE) {
            //only allow move if hexagon is not occupied
            Color permanentColor = isRedTurn ? RED : BLUE;
            hexagon.setFill(permanentColor);
            hexagon.setStroke(BLACK);
            hexagon.setStrokeWidth(3);

            //remove the hover behavior for occupied hexagons
            hexagon.setOnMouseExited(null);

            if (isRedTurn) {
                turnIndicator.setText("Blue Player's Turn");
                turnIndicatorCircle.setFill(Color.BLUE);
            } else {
                turnIndicator.setText("Red Player's Turn");
                turnIndicatorCircle.setFill(Color.RED);
            }
            isRedTurn = !isRedTurn; //switch turn
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



    @FXML
    private Label turnIndicator;
    private boolean isRedTurn = true; // Start with Red Player
    @FXML
    private Circle turnIndicatorCircle;
}
