package solarsystem;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SolarSystemPane {

    SolarSystemPane(){

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300, Color.BLACK);

    }

    public void addStar(Star star){
        //TODO: Add stars to pane and draw orbit path
    }

    public void addPlanet(Planet planet, double distance){

        //TODO: Add planet to pane and draw orbit path

    }

    public void addMoon(Moon moon, double distance){
        //TODO: Add moon to pane and draw orbit path
    }

}
