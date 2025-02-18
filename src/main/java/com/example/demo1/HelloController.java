package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.LIGHTSTEELBLUE;

public class HelloController {

    @FXML
    private Polygon hex1;

    @FXML
    private Polygon hex10;

    @FXML
    private Polygon hex11;

    @FXML
    private Polygon hex12;

    @FXML
    private Polygon hex13;

    @FXML
    private Polygon hex14;

    @FXML
    private Polygon hex15;

    @FXML
    private Polygon hex16;

    @FXML
    private Polygon hex17;

    @FXML
    private Polygon hex18;

    @FXML
    private Polygon hex19;

    @FXML
    private Polygon hex2;

    @FXML
    private Polygon hex3;

    @FXML
    private Polygon hex4;

    @FXML
    private Polygon hex5;

    @FXML
    private Polygon hex6;

    @FXML
    private Polygon hex7;

    @FXML
    private Polygon hex8;

    @FXML
    private Polygon hex9;

    @FXML
    void getHexID(MouseEvent event) {
        RadialGradient paint = new RadialGradient(
                0.0, 0.0, 0.4956, 0.5066, 0.4908, true, CycleMethod.NO_CYCLE,
                new Stop(0.0, new Color(0.0, 0.0, 0.0, 1.0)),
                new Stop(1.0, new Color(1.0, 1.0, 1.0, 1.0)));

        Polygon hexagon = (Polygon) event.getSource();
        if (hexagon.getFill() != BLACK || hexagon.getFill() == paint) {
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
