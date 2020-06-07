package Model;

import java.util.Scanner;
import java.util.Vector;

public class Candidate extends Citizen {
	private Ballot<Candidate> ballot;
	protected Party affiliationToParty;
	protected int placeInParty;

	public Candidate(String name, int ID, int year, Party party) throws ageOutOfRange, IDOutOfRange {
		super(name, ID, year);
		try {
		party.addCandidate(this);
		checkAge();
		this.affiliationToParty = party;
		}catch(ageOutOfRange notBigEnough) {
			throw new ageOutOfRange("Not legal to be a candidate yet");
		}
	}

	public Candidate(Scanner scan, Party party) throws ageOutOfRange, IDOutOfRange {
		super(scan);
		try {
			this.affiliationToParty = party;
			checkAge();
		}catch (ageOutOfRange notBigEnough) {
			int year = 0;
			do {
				System.out.println("We are sorry, the age of a Candidate less 18, please re-enter year");
				year = scan.nextInt();
			} while (ElectionRound.ELECTION_YEAR -year<18);
			this.birthYear = year;
			setAge();
		}

	}

	public Party getAffiliationToParty() {
		return affiliationToParty;
	}

	protected void checkAge() throws ageOutOfRange {
		if (this.getAge() < 18) {
			throw new ageOutOfRange("Not legal to vote yet");
		}
	}

	public int getPlaceInParty() {
		return placeInParty;
	}

	public boolean setPlaceInParty(int placeInParty) { // boolean since it says so in the task
		this.placeInParty = placeInParty;
		return true;
	}

	@Override
	public boolean equals(Object candidate) {
		return (super.equals(candidate));
	}

	public String toString() {
		String str= super.toString() + ". He is also a Candidate, his party is " + affiliationToParty.getName();
		if (ballot != null) {
			str = str + ", votes at ballot number " + ballot.getId() +".";
		}
		return str;
	}

	public void vote(String selectedParty) {
		this.ballot.vote(selectedParty, this);
	}

	public boolean setBallot(Ballot<? extends Citizen> ballot) throws ageOutOfRange { // boolean since it says so un the taks
		try {
			checkAge();
			this.ballot = (Ballot<Candidate>) ballot;
			return true;
		} catch (ageOutOfRange notBigEnough) {
			return false;
		}
	}
	public void vote(String party,boolean vote) {
		if (vote) {
			this.vote(party);
			isVoting = true;
		} else {
			isVoting = false;
		}
	}
}
