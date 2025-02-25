package UIPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import static java.lang.Math.round;
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


@FXML
    void getHexID(MouseEvent event) {

    double clickX = event.getSceneX();
    double clickY = event.getSceneY();
    double eventX = - event.getY();
    double eventY = event.getX();
    int centerX = (int) (clickX - eventX/2.0);
    int centerY = (int) (clickY - eventY/2.0);

    int q = (centerX - 300) / 37;
    int r = ((centerY - 300)/ 22 - q) / 2;
    int s = -q-r;

    //System.out.println("x,y: "+ clickX + " + " + clickY);
    //System.out.println("hex xy: "+eventX + " + " + eventY);
    //System.out.println("res: " + centerX + " + " + centerY);
    System.out.println("q: " + q + ", r: " + r + ", s: " + s);



    Polygon hexagon = (Polygon) event.getSource();
        if (hexagon.getFill() != RED && hexagon.getFill() != BLUE) {
            // Only allow move if hexagon is not occupied
            if (isRedTurn) {
                hexagon.setFill(Color.RED);
                turnIndicator.setText("Blue Player's Turn");
                turnIndicatorCircle.setFill(Color.BLUE);
            } else {
                hexagon.setFill(Color.BLUE);
                turnIndicator.setText("Red Player's Turn");
                turnIndicatorCircle.setFill(Color.RED);
            }
            isRedTurn = !isRedTurn; // Switch turn
        }

    }

    @FXML
    void hover(MouseEvent event) {
        Polygon hexagon = (Polygon) event.getSource();
        hexagon.setStroke(LIGHTSTEELBLUE);
        hexagon.setStrokeWidth(5);
        hexagon.setOnMouseExited(Hoverevent -> {
            hexagon.setStroke(BLACK);
            hexagon.setStrokeWidth(3);// Revert to blue when mouse leaves
        });
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
