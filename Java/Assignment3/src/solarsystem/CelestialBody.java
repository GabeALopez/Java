package solarsystem;

import exceptions.DuplicateCelestialBodyException;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * This class handles defining a celestial body
 * This is the main parent class
 */
public abstract class CelestialBody {


    private String name;
    private String type;
    private double radius;
    private Color color;
    private final ArrayList<CelestialBody> Children = new ArrayList<CelestialBody>();

    /**
     * @param name
     * @param type CelestialBody definition
     */
    public CelestialBody(String name, String type, Color color, double radius) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.radius = radius;

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

    public double getRadius(){
        return radius;
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


    public Color getColor() {
        return color;
    }
}
