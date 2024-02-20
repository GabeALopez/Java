package solarsystem;

import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;

public class SolarSystem {

   public static void main(String[] args) {

      //TODO: comment everything. Yes everything. Put JavaDocs too if you are so inclined ಠ_ಠ.

      try {

         Star sun = new Star("Sun", 5778);

         //Poor pluto :(
         Planet mercury = new Planet("Mercury", sun);
         Planet venus = new Planet("Venus", sun);
         Planet earth = new Planet("Earth", sun);
         Planet mars = new Planet("Mars", sun);
         Planet jupiter = new Planet("Jupiter", sun);
         Planet saturn = new Planet("Saturn", sun);
         Planet uranus = new Planet("Uranus", sun);
         Planet neptune = new Planet("Neptune", sun);

         sun.add(mercury);
         sun.add(venus);
         sun.add(earth);
         sun.add(mars);
         sun.add(jupiter);
         sun.add(saturn);
         sun.add(uranus);
         sun.add(neptune);

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
