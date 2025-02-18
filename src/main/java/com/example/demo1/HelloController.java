package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

import static javafx.scene.paint.Color.BLACK;

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
        Polygon hexagon = (Polygon) event.getSource();
        hexagon.setFill(BLACK);
    }

}
