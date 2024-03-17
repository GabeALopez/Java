import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.util.Collections;

/**
 * @author G. Lopez
 * Date: 3/15/24
 * White circle that turns to black with mouse click
 * It also moves with arrow keys
 */
public class Main extends Application {
    double speed = 5;
    Circle circle;


    @Override
    public void start(Stage primaryStage) {

        //Create UI
        Pane pane = new Pane();
        Circle circle = new Circle(100, 100, 50);
        pane.getChildren().add(circle);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

       circle.setOnMousePressed(mouseEvent -> {

           circle.setFill(Color.BLACK);

       });

       circle.setOnMouseReleased(mouseEvent -> {
           circle.setFill(Color.WHITE);
       });






        Scene scene = new Scene(pane, 400, 250);

        scene.setOnKeyPressed(event -> {

            switch (event.getCode()) {
                case UP:
                    circle.setCenterY(circle.getCenterY() - speed);
                    break;
                case DOWN:
                    circle.setCenterY(circle.getCenterY() + speed);
                    break;
                case LEFT:
                    circle.setCenterX(circle.getCenterX() - speed);
                    break;
                case RIGHT:
                    circle.setCenterX(circle.getCenterX() + speed);
                    break;
                default:
                    break;

            }
        });

        primaryStage.setTitle("Lopez Lab 3");
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }

}
