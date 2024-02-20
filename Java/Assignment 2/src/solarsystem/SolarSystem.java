package solarsystem;

import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * <p>
 * This class handles creating and displaying celestial objects
 * This class also holds the main method
 */
public class SolarSystem {

    /**
     * @param args The main method handles creation and displaying celestial objects
     */
    public static void main(String[] args) {

        //TODO: Make video demo

        try {

            //Create sun
            Star sun = new Star("Sun", 5778);

            //Poor pluto :(
            //Create planets
            Planet mercury = new Planet("Mercury", sun);
            Planet venus = new Planet("Venus", sun);
            Planet earth = new Planet("Earth", sun);
            Planet mars = new Planet("Mars", sun);
            Planet jupiter = new Planet("Jupiter", sun);
            Planet saturn = new Planet("Saturn", sun);
            Planet uranus = new Planet("Uranus", sun);
            Planet neptune = new Planet("Neptune", sun);

            //Add planets to sun's orbit
            sun.add(mercury);
            sun.add(venus);
            sun.add(earth);
            sun.add(mars);
            sun.add(jupiter);
            sun.add(saturn);
            sun.add(uranus);
            sun.add(neptune);

            //Create and add moons to planet orbits
            Moon moon = new Moon("Moon", earth);
            Moon phobos = new Moon("Phobos", mars);
            Moon deimos = new Moon("Deimos", mars);

            earth.add(moon);
            mars.add(phobos);
            mars.add(deimos);


        } catch (DuplicateCelestialBodyException | InvalidCelestialBodyException e) {
            e.printStackTrace();

        }

    }
}
