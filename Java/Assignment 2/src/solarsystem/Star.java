package solarsystem;

public class Star extends CelestialBody {

    private int surfaceTemp;


    public Star(String name, String type, int surfaceTemp) {
        super(name, type);
        //TODO: might need to fix this
        type = "Star";
        this.surfaceTemp = surfaceTemp;
    }

    public int getSurfaceTemp() {
        return surfaceTemp;
    }

    //TODO: implement this
    public void getOrbit(){

    }

}
