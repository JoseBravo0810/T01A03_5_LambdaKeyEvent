/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t01a03_5_lambdakeyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jose
 */
public class T01A03_5_LambdaKeyEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creamos el texto en la posicion X = 20, Y = 20 y contenido "A"
        Text texto = new Text(20, 20, "A");
        // Le damos el foco al campo de texto, se lo pasamos del stage al text
        texto.setFocusTraversable(true);
        
        // Funcion lambda que se ejecutará cuando se presione una tecla del teclado
        texto.setOnKeyPressed(e ->{
            // Si el codigo de laletra pulsada es un letra o un digito...
            if(e.getCode().isLetterKey() || e.getCode().isDigitKey())
            {
                //... , esa letra o digito pasa a ser el texto del campo text
                texto.setText(e.getText());
            }
            // Si es alguna flecha de movimiento, mueve el texto 10 posiciones hacia la direccion indicada
            else if(e.getCode() == KeyCode.UP)
                texto.setY(texto.getY() - 10);
            else if(e.getCode() == KeyCode.DOWN)
                texto.setY(texto.getY() + 10);
            else if(e.getCode() == KeyCode.RIGHT)
                texto.setX(texto.getX() + 10);
            else if(e.getCode() == KeyCode.LEFT)
                texto.setX(texto.getX() - 10);
        });
        
        Pane root = new Pane();
        root.getChildren().add(texto);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Lambda KeyEvents");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
