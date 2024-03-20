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
            Planet mercury = new Planet("Mercury", sun, Color.BROWN, 50);
            Planet venus = new Planet("Venus", sun, Color.BEIGE, 60);
            Planet earth = new Planet("Earth", sun, Color.BLUE, 60);
            Planet mars = new Planet("Mars", sun, Color.RED, 50);
            Planet jupiter = new Planet("Jupiter", sun, Color.BEIGE, 100);
            Planet saturn = new Planet("Saturn", sun, Color.BEIGE, 100);
            Planet uranus = new Planet("Uranus", sun, Color.LIGHTBLUE, 70);
            Planet neptune = new Planet("Neptune", sun, Color.BLUEVIOLET, 80);

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
            Moon moon = new Moon("Moon", earth, Color.WHITE, 2);
            Moon phobos = new Moon("Phobos", mars, Color.RED, 1);
            Moon deimos = new Moon("Deimos", mars, Color.RED, 1);

            earth.add(moon);
            mars.add(phobos);
            mars.add(deimos);

            SolarSystemPane solarSystemPane = new SolarSystemPane();

            solarSystemPane.addStar(sun);
            solarSystemPane.addPlanet(mercury,500);

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
