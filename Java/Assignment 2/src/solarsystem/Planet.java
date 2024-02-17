package solarsystem;

import exceptions.InvalidCelestialBodyException;

public class Planet extends CelestialBody implements IOrbit {

    private CelestialBody orbits;


    public Planet(String name, CelestialBody orbits) throws InvalidCelestialBodyException {
        super(name, "Planet");

        if (orbits.getType().equals("Star")) {
            this.orbits = orbits;
        } else {
            throw new InvalidCelestialBodyException("A planet must orbit a star");
        }
    }


    @Override
    public void getOrbit() {

        System.out.println(this.getName() + " is orbiting the " + this.orbits.getType() + " " + this.orbits.getName());

    }


}
