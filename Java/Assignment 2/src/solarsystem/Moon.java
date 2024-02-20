package solarsystem;

import exceptions.InvalidCelestialBodyException;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * <p>
 * This class handles defining a Moon object
 */
public class Moon extends CelestialBody implements IOrbit {

    private CelestialBody orbits;

    /**
     * @param name
     * @param orbits
     * @throws InvalidCelestialBodyException Define Moon object and set its type to "Moon"
     */
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
