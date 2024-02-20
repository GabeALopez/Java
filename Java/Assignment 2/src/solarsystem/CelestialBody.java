package solarsystem;

import java.util.ArrayList;

import exceptions.DuplicateCelestialBodyException;

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
    public CelestialBody(String name, String type) {
        this.name = name;
        this.type = type;
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
