package solarsystem;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.security.PublicKey;

public class SolarSystemPane {

    public Pane pane;

    SolarSystemPane(){

        pane = new Pane();

    }

    public void addStar(Star star){
        Circle circle = new Circle(0,0, star.getRadius());
        circle.setFill(star.getColor());
        pane.getChildren().add(circle);


    }

    public void addPlanet(Planet planet, double distance){


        double planetX = 0, planetY = 0;
        planetX = distance * Math.cos((Math.PI)/5);
        planetY = distance * Math.sin((Math.PI)/5);

        Circle circlePlanet = new Circle(planetX, planetY, planet.getRadius());
        circlePlanet.setFill(planet.getColor());
        Circle orbit = new Circle(0,0, distance);
        orbit.setFill(Color.TRANSPARENT);
        orbit.setStroke(Color.WHITE);

        pane.getChildren().add(orbit);
        pane.getChildren().add(circlePlanet);

    }

    public void addMoon(Moon moon, double distance){

        double moonX = 0, moonY = 0;
        moonX = distance * Math.cos((3*Math.PI)/2);
        moonY = distance * Math.sin((3*Math.PI)/2);

        Circle circleMoon = new Circle(moonX, moonY, moon.getRadius());
        Circle orbit = new Circle(0,0, distance);
        orbit.setFill(Color.TRANSPARENT);

        pane.getChildren().add(circleMoon);
        pane.getChildren().add(orbit);
    }



}
