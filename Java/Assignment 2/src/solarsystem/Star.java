package solarsystem;

/**
 * @author Gabriel Lopez
 * @Date 2/20/24
 * <p>
 * This class handles defining a star object
 * Inherits from CelestialBody
 */
public class Star extends CelestialBody {

    private int surfaceTemp;


    /**
     * @param name
     * @param surfaceTemp Define a star object and name its type as "Star"
     */
    public Star(String name, int surfaceTemp) {
        super(name, "Star");
        this.surfaceTemp = surfaceTemp;
    }

    /**
     * @return surfaceTemp
     */
    public int getSurfaceTemp() {
        return surfaceTemp;
    }


}
