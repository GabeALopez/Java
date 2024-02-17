package solarsystem;

public class Planet extends CelestialBody{

    private CelestialBody orbits;


    public Planet(String name, String type, CelestialBody orbits) {
        super(name, type);
        //TODO: might need to fix this
        type = "Planet";
        this.orbits = orbits;

        if(orbits.getType().equals("Star")){
            //TODO:implement exception
            throw InvalidCelestialBodyException("A planet must orbit a star");
        }
    }


}
