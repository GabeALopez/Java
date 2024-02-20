package test;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VotingMachineTest {
	
	@Test
	void VotingMachine_Initializes_Candiates() {
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		
		Candidate candidates[] = {janeDoe, johnSmith, fredJohnson}; 
		
		VotingMachine vm = new VotingMachine(candidates);
		
		assertEquals(vm.candidates, candidates);
	}

	@Test
	void vote_counts_if_voter_has_not_voted() {
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		
		Candidate candidates[] = {janeDoe, johnSmith, fredJohnson}; 
		
		VotingMachine vm = new VotingMachine(candidates);

		assertEquals(janeDoe.getVoteCount(), 0);
		
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		vm.vote(v1, janeDoe);

		assertEquals(janeDoe.getVoteCount(), 1);
	}

	@Test
	void vote_does_not_counts_if_voter_has_voted() {
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		
		Candidate candidates[] = {janeDoe, johnSmith, fredJohnson}; 
		
		VotingMachine vm = new VotingMachine(candidates);

		assertEquals(janeDoe.getVoteCount(), 0);
		
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		vm.vote(v1, janeDoe);

		assertEquals(janeDoe.getVoteCount(), 1);
		
		vm.vote(v1, janeDoe); // Votes again
		assertEquals(janeDoe.getVoteCount(), 1);
	}

	@Test
	void tally_prints_correct_message() {
		// Set up to capture tally() print to terminal
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
		// Define candidates for test
		Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
		Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
		Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
		
		Candidate candidates[] = {janeDoe, johnSmith, fredJohnson}; 
		
		VotingMachine vm = new VotingMachine(candidates);

		assertEquals(janeDoe.getVoteCount(), 0);
        
		Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
		vm.vote(v1, janeDoe);
		vm.tally();
	    assertEquals("Jane Doe - R has 1 votes.\r\n" + 
	    		"John Smith - D has 0 votes.\r\n" + 
	    		"Fred Johnson - NA has 0 votes.\r\n" + 
	    		"Jane Doe - R won with 1 votes.\r\n", outContent.toString());
	}
}
