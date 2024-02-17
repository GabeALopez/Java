package solarsystem;

public class Moon extends CelestialBody{

    private CelestialBody orbits;

    public Moon(String name, String type, CelestialBody orbits) {
        super(name, type);
        //TODO:Fix this
        type = "Moon";
        this.orbits = orbits;

        if (orbits.getType().equals("Planet")){

            throw nvalidCelestialBodyException("A moon must orbit a planet");

        }
    }

    //TODO:implement this
    public void getOrbit(){

    }
}
