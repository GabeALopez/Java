package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CandidateTest {

	@Test
	void getAge_returns_35() {
		Candidate c1 = new Candidate(35, 'M', "Some", "Candidate", "Non-Affiliate");
		assertEquals(c1.getAge(), 35);
	}

	@Test
	void getVoteCount_returns_0() {
		Candidate c1 = new Candidate(20, 'M', "Some", "Candidate", "Non-Affiliate");
		assertEquals(c1.getVoteCount(), 0);
	}

	@Test
	void getVoteCount_returns_1() {
		Candidate c1 = new Candidate(20, 'M', "Some", "Candidate", "Non-Affiliate");
		c1.incrementVoteCount();
		assertEquals(c1.getVoteCount(), 1);
	}

	@Test
	void gender_setsto_F() {
		Candidate c1 = new Candidate(20, 'F', "Some", "Candidate", "Non-Affiliate");
		c1.incrementVoteCount();
		assertEquals(c1.getGender(), 'F');
	}
	
	@Test
	void getFullName_returns_SomeSmithR() {
		Candidate c1 = new Candidate(31, 'M', "Some", "Smith", "Republican");
		assertEquals(c1.getFullName(), "Some Smith - R");
	}

	@Test
	void getFullName_returns_JohnCandidateD() {
		Candidate c1 = new Candidate(20, 'M', "John", "Candidate", "Democrat");
		assertEquals(c1.getFullName(), "John Candidate - D");
	}
	

	@Test
	void getFullName_returns_JohnSmithNA() {
		Candidate c1 = new Candidate(20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(c1.getFullName(), "John Smith - NA");
	}

}
