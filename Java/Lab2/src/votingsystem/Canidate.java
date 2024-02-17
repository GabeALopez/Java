package votingsystem;

import exceptions.MinimumAgeException;

public class Canidate extends Person{


    private int voteCount = 0; //Default count to zero

    public Canidate(int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);
        this.voteCount = 0;

        if(age < 25){
            throw new MinimumAgeException("Candidate's age cannot be less than 25");
        }
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void incrementVoteCount(){
        voteCount++;
    }

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
