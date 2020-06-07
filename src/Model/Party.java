package Model;

import java.util.Vector;

public class Party {
	public enum Faction {
		Right, Left, Center;
	}
	private Faction side;
	private String name;
	private String date;
	private Vector<Candidate> candidateList;
	private int currentCandidates = 0;
	private int placeInParty = 1;
	private int numberOfVotes = 0;

	public Party(String name, String faction, String date) {
		this.name = name;
		setFaction(faction);
		this.date = date;
		candidateList = new Vector<>();
	}

	private boolean setFaction(String faction) { 
		this.side = Faction.valueOf(faction);
		return true;
	}

	public String getName() {
		return this.name;
	}

	public boolean setNumberOfVoters(int number) { 
		this.numberOfVotes = number + this.numberOfVotes;
		return true;
	}

	public int getNumberOfVoters() {
		return numberOfVotes;
	}

	public <T extends Candidate> void addCandidate(T candidate) {
		candidateList.add(candidate);
		candidate.setPlaceInParty(placeInParty); // (pointing at each other)
		currentCandidates++;
		placeInParty++;
	}

	public Candidate addCandidate(String name, int ID, int year) throws ageOutOfRange, IDOutOfRange {
		try {
			Candidate temp = new Candidate(name, ID, year, this);
			candidateList.add(temp);
			temp.setPlaceInParty(placeInParty);
			currentCandidates++;
			placeInParty++;
			return temp;
		} catch (ageOutOfRange notBigEnough) {
			return null;
		}
	}

	public SickCandidate addSickCandidate(String name, int ID, int year, int sickDays) throws ageOutOfRange, IDOutOfRange {
		try {
			SickCandidate temp = new SickCandidate(name, ID, year, this, sickDays);
			candidateList.add(temp);
			temp.setPlaceInParty(placeInParty);
			currentCandidates++;
			placeInParty++;
			return temp;
		} catch (ageOutOfRange notBigEnough) {
			return null;
		}
	}

	@Override
	public boolean equals(Object obj) {
		Party party = (Party) obj;
		if (party != null) {
			if (this.name.equals(party.name)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuffer makeAstring = new StringBuffer(name + ",in faction " + side + ", was founded in " + date);
		if (currentCandidates == 0) {
			makeAstring.append(" and has no candidates.\n");
		} else
			makeAstring.append("\nThe candidates in this party:\n");
		for (int i = 0; i < candidateList.size(); i++) {
			makeAstring.append(candidateList.get(i).getName() + "\n");
		}
		return makeAstring.toString();
	}
}
