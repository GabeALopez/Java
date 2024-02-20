package votingsystem;

import exceptions.CandidateNotFoundException;
import exceptions.MinimumAgeException;
import exceptions.MissingCandidatesException;

import java.util.ArrayList;

/**
 *
 *    @author : Gabriel Lopez
 *    @date : 2/19/24
 *    This class handles creating and running the election
 *    The class also contains the main method.
 */
public class Election {

    /**
     * This is the main method creating candidates and voters.
     * The main method also handles creating the voting machine and running the election.
     * @param args
     */
    public static void main(String[] args){

        try{
            Candidate republican = new Candidate(30, 'm', "John", "Doe","Republican");
            Candidate democrat = new Candidate(40, 'f', "Jane", "Doe", "Democrat");
            Candidate nonAffiliate = new Candidate(50, 'm', "John", "Doe jr.", "Non-Affiliate");

            ArrayList<Candidate> candidateArrayList = new ArrayList<Candidate>();

            //Add voters to the array list
            candidateArrayList.add(republican);
            candidateArrayList.add(democrat);
            candidateArrayList.add(nonAffiliate);

            Voter voter1 = new Voter(111, 20, 'm', "Joel", "Chair", "Republican");
            Voter voter2 = new Voter(222, 25, 'f', "Jane", "Doe jr.", "Democrat");
            Voter voter3 = new Voter(333, 30, 'm', "Johnathan", "Spencer", "Republican");

            //Collecting votes
            VotingMachine votingMachine = new VotingMachine(candidateArrayList);
            votingMachine.vote(voter1,republican);
            votingMachine.vote(voter2,republican);
            votingMachine.vote(voter3, democrat);

            votingMachine.tally();


        }catch (MinimumAgeException | MissingCandidatesException | CandidateNotFoundException e){

           e.printStackTrace();

        }

    }

}
