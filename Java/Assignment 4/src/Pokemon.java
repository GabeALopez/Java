import java.io.Serializable;
import java.util.UUID;

public class Pokemon implements Serializable {

    //Private values
    private UUID pokemonID;
    private String pokemonType;
    private String name;
    private boolean checkedIn;

    /**
     *
     * @param pPokemonType
     * @param pName
     * Pokemon constructor
     */
    Pokemon(String pPokemonType, String pName){

        this.pokemonType = pPokemonType;
        this.name = pName;
        this.pokemonID = UUID.randomUUID();
    }

    /**
     * Change checked in to true or false
     */
    public void checkIn(){checkedIn = true;}
    public void checkOut(){checkedIn = false;}

    /**
     * Getters
     */
    public boolean isCheckedIn() {
        return checkedIn;
    }

    public UUID getPokemonID() {
        return pokemonID;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public String getName() {
        return name;
    }
}
