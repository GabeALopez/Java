package votingsystem;

import exceptions.MinimumAgeException;

/**
 *
 *    @author : Gabriel Lopez
 *    @date : 2/19/24
 *    This class handles the definition of a voter.
 */
public class Voter extends Person {

    private int voterID;
    private boolean voted;

    /**
     *
     * @param voterID
     * @param age
     * @param gender
     * @param firstName
     * @param lastName
     * @param politicalParty
     * @throws MinimumAgeException
     *
     * Voter constructor and checks if the voter is less than 18
     */
    public Voter(int voterID, int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);
        this.voterID = voterID;
        this.voted = false;
        if(super.getAge() < 18){

            throw new MinimumAgeException("Voter's age cannot be less than 18");

        }

    }

    /**
     *
     * @return voterID
     */
    public int getVoterID() {
        return voterID;
    }

    /**
     *
     * @return voted
     */
    public boolean hasVoted() {
        return voted;
    }

    /**
     * set whether the voter has voted to true
     */
    public void voted(){
        this.voted = true;
    }

    /**
     *
     * @return firstName & lastName
     */
    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
