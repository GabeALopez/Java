package votingsystem;

import exceptions.MinimumAgeException;

public class Voter extends Person {

    private int voterID;
    private boolean voted;

    public Voter(int age, char gender, String firstName, String lastName, String politicalParty, int voterID, boolean voted) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);
        this.voterID = voterID;
        this.voted = voted;

        if(super.getAge() < 18){

            throw new MinimumAgeException("Voter's age cannot be less than 18");

        }

    }

    public int getVoterID() {
        return voterID;
    }

    public boolean hasVoted() {
        return voted;
    }

    public void voted(){
        this.voted = true;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
