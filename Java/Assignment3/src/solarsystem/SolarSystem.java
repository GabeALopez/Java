package solarsystem;

import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import static javafx.application.Application.launch;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * <p>
 * This class handles creating and displaying celestial objects
 * This class also holds the main method
 */
public class SolarSystem extends Application {

    public void start(Stage primaryStage) {

        try {

            //Create sun
            Star sun = new Star("Sun", 5778, Color.YELLOW, 200);

            //Poor pluto :(
            //Create planets
            Planet mercury = new Planet("Mercury", sun, Color.BROWN, 25);
            Planet venus = new Planet("Venus", sun, Color.BEIGE, 30);
            Planet earth = new Planet("Earth", sun, Color.BLUE, 30);
            Planet mars = new Planet("Mars", sun, Color.RED, 25);
            Planet jupiter = new Planet("Jupiter", sun, Color.BEIGE, 50);
            Planet saturn = new Planet("Saturn", sun, Color.BEIGE, 50);
            Planet uranus = new Planet("Uranus", sun, Color.LIGHTBLUE, 35);
            Planet neptune = new Planet("Neptune", sun, Color.BLUEVIOLET, 40);

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
            Moon moon = new Moon("Moon", earth, Color.WHITE, 5);
            Moon phobos = new Moon("Phobos", mars, Color.RED, 3);
            Moon deimos = new Moon("Deimos", mars, Color.RED, 3);

            earth.add(moon);
            mars.add(phobos);
            mars.add(deimos);

            SolarSystemPane solarSystemPane = new SolarSystemPane();

            solarSystemPane.addStar(sun);
            solarSystemPane.addPlanet(mercury,300);
            solarSystemPane.addPlanet(venus, 400);
            solarSystemPane.addPlanet(earth, 500);
            solarSystemPane.addPlanet(mars, 650);
            solarSystemPane.addPlanet(jupiter, 800);
            solarSystemPane.addPlanet(saturn, 1000);
            solarSystemPane.addPlanet(uranus, 1100);
            solarSystemPane.addPlanet(neptune, 1200);

            solarSystemPane.setMoonCount(1);
            solarSystemPane.addMoon(moon, 500);

            solarSystemPane.setMoonCount(2);
            solarSystemPane.addMoon(phobos, 650);
            solarSystemPane.addMoon(deimos, 650);

            Scene scene = new Scene(solarSystemPane.pane, 1500, 700, Color.BLACK);
            primaryStage.setTitle("Solar System");
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (DuplicateCelestialBodyException | InvalidCelestialBodyException e) {
            e.printStackTrace();

        }

    }

    /**
     * @param args The main method handles creation and displaying celestial objects
     */
    public static void main(String[] args) {

        launch(args);


    }
}
