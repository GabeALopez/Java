package solarsystem;

import exceptions.InvalidCelestialBodyException;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * <p>
 * This class handles defining a planet
 */
public class Planet extends CelestialBody implements IOrbit {

    private CelestialBody orbits;


    /**
     * @param name
     * @param orbits
     * @throws InvalidCelestialBodyException Definition of the planet class
     */
    public Planet(String name, CelestialBody orbits) throws InvalidCelestialBodyException {
        super(name, "Planet");

        if (orbits.getType().equals("Star")) {
            this.orbits = orbits;
        } else {
            throw new InvalidCelestialBodyException("A planet must orbit a star");
        }
    }


    /**
     * print out what the planet is orbiting
     */
    @Override
    public void getOrbit() {

        System.out.println(this.getName() + " is orbiting the " + this.orbits.getType() + " " + this.orbits.getName());

    }


}
