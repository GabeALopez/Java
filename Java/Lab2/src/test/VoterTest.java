package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VoterTest {

	@Test
	void getVoterId_returns_1() {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getVoterId(), 1);
	}

	@Test
	void getVoterId_returns_2() {
		Voter v1 = new Voter(2, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getVoterId(), 2);
	}

	@Test
	void getAge_returns_20() {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getAge(), 20);
	}

	@Test
	void getAge_returns_30() {
		Voter v1 = new Voter(1, 30, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getAge(), 30);
	}

	@Test
	void gender_setsto_M() {
		Voter v1 = new Voter(1, 30, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getGender(), 'M');
	}
	
	@Test
	void getFullName_returns_JohnSmith() {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertEquals(v1.getFullName(), "John Smith");
	}
	
	@Test
	void hasVoted_returns_false() {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		assertFalse(v1.hasVoted());
	}
	
	@Test
	void hasVoted_returns_true() {
		Voter v1 = new Voter(1, 20, 'M', "John", "Smith", "Non-Affiliate");
		v1.voted();
		assertTrue(v1.hasVoted());
	}

}
