package Model;

public class SickCandidate extends Candidate implements Sickable {
	private int numOfSickDays;
	private Ballot<SickCandidate> ballot;

	public SickCandidate(String name, int ID, int year, Party party, int days) throws ageOutOfRange, IDOutOfRange {
		super(name, ID, year, party);
		setNumOfSickDays(days);
	}

	public int getNumOfSickDays() {
		return numOfSickDays;
	}

	private void setNumOfSickDays(int days) {
		if (days >= 0) {
			numOfSickDays = days;
		} else {
			numOfSickDays = 1;
		}
	}

	public boolean setPlaceInParty(int placeInParty) { 
		this.placeInParty = placeInParty;
		return true;
	}

	public String toString() {
		String str = super.toString() + ". He is also sick for " + this.numOfSickDays + " days";
		if (ballot != null) {
			str = str + ", votes at ballot number " + ballot.getId() + ". ";
		}
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		SickCandidate other = (SickCandidate) obj;
		return (numOfSickDays == other.numOfSickDays && super.equals(other));
	}

	public void vote(String selectedParty) {
		this.ballot.vote(selectedParty, this);
	}

	public boolean setBallot(Ballot<? extends Citizen> ballot) throws ageOutOfRange { 
		try {
			checkAge();
			this.ballot = (Ballot<SickCandidate>) ballot;
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
