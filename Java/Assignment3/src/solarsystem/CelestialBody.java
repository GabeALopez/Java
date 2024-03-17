package solarsystem;

import exceptions.DuplicateCelestialBodyException;

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
 * This class handles defining a celestial body
 * This is the main parent class
 */
public abstract class CelestialBody {


    private String name;
    private String type;
    private final ArrayList<CelestialBody> Children = new ArrayList<CelestialBody>();

    /**
     * @param name
     * @param type CelestialBody definition
     */
    public CelestialBody(String name, String type, Color color, double radius) {
        this.name = name;
        this.type = type;

       Circle circle = new Circle(radius, color);

       circle.setOnMouseClicked(mouseEvent -> {
           getInformation();
       });

    }

    //Getters and Setters

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    public void getInformation(){
        System.out.println("This is the " + type + " " + name);
    }

    /**
     * @return Children
     */
    public ArrayList<CelestialBody> getChildren() {
        return Children;
    }

    /**
     * @param child
     * @throws DuplicateCelestialBodyException Print out what celestial body orbits what
     */
    public void add(CelestialBody child) throws DuplicateCelestialBodyException {

        if (!Children.contains(child)) {

            Children.add(child);
            System.out.println("The " + child.getType() + " " + child.getName() + " was successfully added to " + this.getName());

        } else {
            throw new DuplicateCelestialBodyException("The " + child.getType() + " " + child.getName() + " is already in the collection");
        }


    }


}
