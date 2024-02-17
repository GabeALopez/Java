package votingsystem;

import exceptions.MissingCandidatesException;

import java.util.ArrayList;

public class VotingMachine {

    public ArrayList<Canidate> candidates;

    public VotingMachine (ArrayList<Canidate> candidates) throws MissingCandidatesException {
        this.candidates = candidates;

        if(candidates.isEmpty()){
            throw new MissingCandidatesException("The candidate list cannot be null or empty");
        }
    }

    public void vote(Voter v, Canidate c){

        if (!v.hasVoted()){
            v.voted();
        }

        //TODO:Throw exception if candidate is not in the race

    }

    public void tally(){
        //TODO:Print out winner of race
    }

}
