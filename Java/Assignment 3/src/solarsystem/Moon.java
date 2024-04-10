package solarsystem;

import exceptions.InvalidCelestialBodyException;

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
 * This class handles defining a Moon object
 */
public class Moon extends CelestialBody implements IOrbit {

    private CelestialBody orbits;

    /**
     * @param name
     * @param orbits
     * @throws InvalidCelestialBodyException Define Moon object and set its type to "Moon"
     */
    public Moon(String name, CelestialBody orbits, Color color, double radius) throws InvalidCelestialBodyException {
        super(name, "Moon", color, radius);

        if (orbits.getType().equals("Planet")) {

            this.orbits = orbits;

        } else {
            throw new InvalidCelestialBodyException("A moon must orbit a planet");
        }
    }

    @Override
    public CelestialBody getOrbit() {

        //System.out.println(this.getName() + " is orbiting the " + this.orbits.getType() + " " + this.orbits.getName());
        return orbits;

    }

    public void getOrbitInformation(){
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
}
