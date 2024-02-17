package solarsystem;

import exceptions.InvalidCelestialBodyException;

public class Moon extends CelestialBody implements IOrbit {

    private CelestialBody orbits;

    public Moon(String name, CelestialBody orbits) throws InvalidCelestialBodyException {
        super(name, "Moon");

        if (orbits.getType().equals("Planet")) {

            this.orbits = orbits;

        } else {
            throw new InvalidCelestialBodyException("A moon must orbit a planet");
        }
    }

    @Override
    public void getOrbit() {

        System.out.println(this.getName() + " is orbiting the " + this.orbits.getType() + " " + this.orbits.getName());

    }
}
