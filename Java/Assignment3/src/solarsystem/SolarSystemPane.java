package solarsystem;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.security.PublicKey;

public class SolarSystemPane {

    public Pane pane;
    private int moonCount = 0;

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

        double orbitX = 0, orbitY = 0, moonX = 0, moonY = 0;
        orbitX = distance * Math.cos((Math.PI)/5);
        orbitY = distance * Math.sin((Math.PI)/5);

        int distanceCount = 50;

        for (int i = 0; i < moonCount; i++) {
            moonX = (distance + distanceCount) * Math.cos((Math.PI)/5);
            moonY = (distance + distanceCount) * Math.sin((Math.PI)/5);
            Circle circleMoon = new Circle(moonX, moonY, moon.getRadius());
            circleMoon.setFill(moon.getColor());
            pane.getChildren().add(circleMoon);

            Circle orbit = new Circle(orbitX,orbitY, distanceCount);
            orbit.setFill(Color.TRANSPARENT);
            orbit.setStroke(Color.WHITE);
            pane.getChildren().add(orbit);

            distanceCount += 15;

        }




    }


    public void setMoonCount(int moonCount) {
        this.moonCount = moonCount;
    }
}
