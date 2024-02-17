package solarsystem;

//package exceptions;
//package solarsystem;

import java.util.ArrayList;

public abstract class CelestialBody {



    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    public CelestialBody(String name, String type) {
        this.name = name;
        this.type = type;
    }

    //Getters and Setter
    public String getName(){ return name;}
    public String getType(){return type;}
    public ArrayList<CelestialBody> getChildren(){return Children;}

    public void add(CelestialBody child){

       for(CelestialBody celestialBody : getChildren())
       {
           if (celestialBody.getType().equals(child.getType())){
               Throw DuplicateCelestialBodyException("The " + child.getType() + " " + child.getName() + " is already in the collection");
           }
       }

       this.getChildren().add(child);
       //TODO:Fix this so that "Sun" is an object array
       System.out.println("The " + child.getType() + " " + child.name + " was successfully added to " + "Sun");

    }

     /*
        ArrayList<CelestialBody> temp = getChildren();
        temp.add(child);

        //TODO: Make sure to override toString method
        System.out.println("Planet " + child.toString() + " added");

     */

}
