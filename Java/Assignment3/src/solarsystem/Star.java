package solarsystem;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * <p>
 * This class handles defining a star object
 * Inherits from CelestialBody
 */
public class Star extends CelestialBody {

    private int surfaceTemp;


    /**
     * @param name
     * @param surfaceTemp Define a star object and name its type as "Star"
     */
    public Star(String name, int surfaceTemp, Color color, double raidus) {
        super(name, "Star", color, raidus);
        this.surfaceTemp = surfaceTemp;
    }

    /**
     * @return surfaceTemp
     */
    public int getSurfaceTemp() {
        return surfaceTemp;
    }


}
