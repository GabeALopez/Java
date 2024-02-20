package votingsystem;

import exceptions.MinimumAgeException;

/**
 *
 *    @author : Gabriel Lopez
 *    @date : 2/19/24
 *    This class handles creating the candidates
 */
public class Candidate extends Person{


    private int voteCount = 0; //Default count to zero

    /**
     *
     * @param age
     * @param gender
     * @param firstName
     * @param lastName
     * @param politicalParty
     * @throws MinimumAgeException
     *
     * Candidate constructor and checks if the candidate is less than 25 years old
     */
    public Candidate(int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);
        this.voteCount = 0;

        if(age < 25){
            throw new MinimumAgeException("Candidate's age cannot be less than 25");
        }
    }

    /**
     *
     * @return voteCount
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     * increase candidate vote count
     */
    public void incrementVoteCount(){
        voteCount++;
    }


    /**
     *
     * @return firstName & lastName
     *
     * Method gets full name and prints out party affiliation with it
     */
    @Override
    public String getFullName(){

        if(super.politicalParty.equals("Democrat")){

            return firstName+ " " + lastName + " - D";

        } else if(super.politicalParty.equals("Republican")){

            return firstName+ " " + lastName + " - R";

        } else if(super.politicalParty.equals("Non-Affiliate")){

            return firstName+ " " + lastName + " - NA";

        }
        else {

           return firstName + " " + lastName;

        }

    }
}
