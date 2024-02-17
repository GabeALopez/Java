package solarsystem;

import java.util.ArrayList;

import exceptions.DuplicateCelestialBodyException;

public abstract class CelestialBody {


    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    public CelestialBody(String name, String type) {
        this.name = name;
        this.type = type;
    }

    //Getters and Setter
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<CelestialBody> getChildren() {
        return Children;
    }

    public void add(CelestialBody child) throws DuplicateCelestialBodyException {

        if (!Children.contains(child)) {

            Children.add(child);
            System.out.println("The " + child.getType() + " " + child.getName() + " was successfully added to " + this.getName());

        } else {
            throw new DuplicateCelestialBodyException("The " + child.getType() + " " + child.getName() + " is already in the collection");
        }


    }


}
