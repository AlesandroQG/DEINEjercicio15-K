module com.alesandro.ejercicio15k {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alesandro.ejercicio15k to javafx.fxml;
    exports com.alesandro.ejercicio15k;
}