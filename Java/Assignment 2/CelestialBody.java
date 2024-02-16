package solarsystem;

//package exceptions;
//package solarsystem;

import java.util.ArrayList;

public class CelestialBody {

    public CelestialBody(String pName, String pType){

        name = pName;
        type = pType;

    }

    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    //Getters and Setter
    public String getName(){ return name;}
    public String getType(){return type;}
    public ArrayList<CelestialBody> getChildren(){return Children;}

    public void add(CelestialBody child) {

        ArrayList<CelestialBody> temp = getChildren();
        temp.add(child);

        //TODO: Make sure to override toString method
        System.out.println("Planet " + child.toString() + " added");



    }

}
