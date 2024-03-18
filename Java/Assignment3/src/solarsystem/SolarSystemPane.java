package solarsystem;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SolarSystemPane {

    public Pane pane;

    SolarSystemPane(){

        pane = new Pane();
        Scene scene = new Scene(pane, 300, 300, Color.BLACK);

    }

    public void addStar(Star star){
        Circle circle = new Circle(0,0, star.getRadius());
        circle.setFill(Color.YELLOW);
        pane.getChildren().add(circle);
    }

    public void addPlanet(Planet planet, double distance){


        double planetX = 0, planetY = 0;
        planetX = distance * Math.cos((3*Math.PI)/2);
        planetY = distance * Math.sin((3*Math.PI)/2);

        Circle circlePlanet = new Circle(planetX, planetY, planet.getRadius());
        Circle orbit = new Circle(0,0, distance);
        orbit.setFill(Color.TRANSPARENT);

        pane.getChildren().add(circlePlanet);
        pane.getChildren().add(orbit);

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
