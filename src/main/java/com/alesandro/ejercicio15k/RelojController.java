package com.alesandro.ejercicio15k;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase que controla los eventos de la ventana
 */
public class RelojController implements Initializable {
    @FXML // fx:id="hora1"
    private ImageView hora1; // Value injected by FXMLLoader

    @FXML // fx:id="hora2"
    private ImageView hora2; // Value injected by FXMLLoader

    @FXML // fx:id="min1"
    private ImageView min1; // Value injected by FXMLLoader

    @FXML // fx:id="min2"
    private ImageView min2; // Value injected by FXMLLoader

    @FXML // fx:id="seg1"
    private ImageView seg1; // Value injected by FXMLLoader

    @FXML // fx:id="seg2"
    private ImageView seg2; // Value injected by FXMLLoader

    /**
     * Diccionario con los números del reloj
     */
    public static final HashMap<Integer,String> NUMBERS = new HashMap<Integer,String>();
    static {
        NUMBERS.put(0,"ZERO");
        NUMBERS.put(1,"ONE");
        NUMBERS.put(2,"TWO");
        NUMBERS.put(3,"THREE");
        NUMBERS.put(4,"FOUR");
        NUMBERS.put(5,"FIVE");
        NUMBERS.put(6,"SIX");
        NUMBERS.put(7,"SEVEN");
        NUMBERS.put(8,"EIGHT");
        NUMBERS.put(9,"NINE");
    }

    /**
     * Función que devuelve la imagen del número pasado
     *
     * @param number número
     * @return imagen
     */
    private Image getImage(int number) {
        Image imagen = new Image(getClass().getResourceAsStream("/imagenes/" + NUMBERS.get(number) + ".png"));
        return imagen;
    }

    /**
     * Función que se ejecuta cuando se inicia la ventana. Configura el timer del reloj
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer timer = new Timer("Reloj");
        timer.scheduleAtFixedRate(new TimerTask() {
            /**
             * Función que se ejecuta cuando se lanza la actividad
             */
            @Override
            public void run() {
                LocalTime ahora = LocalTime.now();
                // Horas
                int hora = ahora.getHour();
                int h1 = hora / 10;
                hora1.setImage(getImage(h1));
                int h2 = hora % 10;
                hora2.setImage(getImage(h2));
                // Minutos
                int minuto = ahora.getMinute();
                int m1 = minuto / 10;
                min1.setImage(getImage(m1));
                int m2 = minuto % 10;
                min2.setImage(getImage(m2));
                // Segundos
                int segundo = ahora.getSecond();
                int s1 = segundo / 10;
                seg1.setImage(getImage(s1));
                int s2 = segundo % 10;
                seg2.setImage(getImage(s2));
            }
        }, 0, 1000);
    }

}