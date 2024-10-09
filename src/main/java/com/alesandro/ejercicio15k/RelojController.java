package com.alesandro.ejercicio15k;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RelojController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}