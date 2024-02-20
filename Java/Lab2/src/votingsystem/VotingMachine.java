package votingsystem;

import exceptions.CandidateNotFoundException;
import exceptions.MissingCandidatesException;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *    @author : Gabriel Lopez
 *    @date : 2/19/24
 *    This class handles the definition of the VotingMachine
 *    The class runs the election and provides the results
 */
public class VotingMachine {

    public ArrayList<Candidate> candidates;

    /**
     *
     * @param candidates
     * @throws MissingCandidatesException
     *
     * VotingMachine constructor
     */
    public VotingMachine (ArrayList<Candidate> candidates) throws MissingCandidatesException {
        this.candidates = candidates;

        if(candidates.isEmpty()){
            throw new MissingCandidatesException("The candidate list cannot be null or empty");
        }
    }

    /**
     *
     * @param v
     * @param c
     * @throws CandidateNotFoundException
     *
     * Handles vote count of each candidate
     */
    public void vote(Voter v, Candidate c) throws CandidateNotFoundException {

        if (!v.hasVoted()){
            v.voted();
        }

        if (!this.candidates.contains(c)){

            throw new CandidateNotFoundException("Candidate does not exist in the candidates collection");

        }

        c.incrementVoteCount();

    }

    /**
     * Returns the winner of election after tallying
     */
    public void tally(){

        Candidate winner = candidates.get(0);

        for (Candidate candidate : candidates){
            System.out.println(candidate.getFullName() + " has " + candidate.getVoteCount() + " votes.");

            if (candidate.getVoteCount() > winner.getVoteCount()){
                winner = candidate;
            }

        }

        System.out.println(winner.getFullName() + " has won with " + winner.getVoteCount());



    }

}
