package Model;

public class Candidate extends Citizen {
	private Ballot<Candidate> ballot;
	protected Party affiliationToParty;
	protected int placeInParty;

	public Candidate(String name, int ID, int year, Party party) {
		super(name, ID, year);
		party.addCandidate(this);
		this.affiliationToParty = party;
	}

	public Party getAffiliationToParty() {
		return affiliationToParty;
	}

//	protected void checkAge() throws ageOutOfRange {
//		if (this.getAge() < 18) {
//			throw new ageOutOfRange("Not legal to vote yet");
//		}
//	}

	public int getPlaceInParty() {
		return placeInParty;
	}

	public boolean setPlaceInParty(int placeInParty) { 
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

	public boolean setBallot(Ballot<? extends Citizen> ballot) throws ageOutOfRange { 
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
