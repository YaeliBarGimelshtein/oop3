package Model;

import java.util.Scanner;
import java.util.Vector;

import View.View;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class ElectionRound implements Menuable {
	public static int ELECTION_YEAR;

	private boolean hasHappened;

	private int electionMonth;
	private int electionYear;

	private Set<Citizen> citizens;
	private Set<SickCitizen> sickCitizens;

	private Set<Candidate> candidatesVoters;
	private Set<SickCandidate> sickCandidatesVoters;
	private Vector<Citizen> citizensVoters;
	private Set<Soldier> SoldiersVoters;
	private Vector<SickCitizen> SickCitizensVoters;
	private Set<SickSoldier> SickSoldiersVoters;

	private Vector<Party> runningParties;
	private Vector<Citizen> allVoters;

	private Vector<Ballot<Citizen>> citizenBallot;
	private Vector<Ballot<SickCitizen>> sickCitizenBallot;
	private Vector<Ballot<Soldier>> soldierBallot;
	private Vector<Ballot<SickSoldier>> sickSoldierBallot;
	private Vector<Ballot<Candidate>> candidateBallot;
	private Vector<Ballot<SickCandidate>> sickCandidateBallot;

	private int ActualNumberOfVoters;
	private int numberOfvoters;
	private int voterNumber;
	
	private Citizen currentVoter;

	public ElectionRound(int electionMonth, int electionYear) {
		setElectionMonth(electionMonth);
		setElectionYear(electionYear);
		ELECTION_YEAR = electionYear;
		citizens = new Set<>();
		SoldiersVoters = new Set<>();
		SickCitizensVoters = new Vector<>();
		SickSoldiersVoters = new Set<>();
		runningParties = new Vector<>();
		sickCitizens = new Set<>();
		citizensVoters = new Vector<>();
		allVoters=new Vector<Citizen>();
		voterNumber=0;
	}

	public boolean setCitizens(Set<Citizen> citizens) { // boolean since it says
														// so in the task
		this.citizens = citizens;
		return true;
	}

	public Vector<String> getRunningParties(){
		Vector<String> parties = new Vector<String>();
		for (int i = 0; i < runningParties.size(); i++) {
			parties.add(runningParties.get(i).getName());
		}
		return parties;
	}

	public boolean setSickCitizens(Set<SickCitizen> SickCitizen) { // boolean
																	// since it
																	// says so
																	// in the
																	// task
		this.sickCitizens = SickCitizen;
		return true;
	}

	public boolean setSoldiersVoters(Set<Soldier> Soldiers) { // boolean since
																// it says so in
																// the task
		this.SoldiersVoters = Soldiers;
		this.numberOfvoters += Soldiers.getSetLenght();
		return true;
	}

	public boolean setSickSoldiersVoters(Set<SickSoldier> SickSoldiers) { // boolean
																			// since
																			// it
																			// says
																			// so
																			// in
																			// the
																			// task
		this.SickSoldiersVoters = SickSoldiers;
		this.numberOfvoters += SickSoldiers.getSetLenght();
		return true;
	}

	public boolean setCandidatesVoters(Set<Candidate> candidates) {
		this.candidatesVoters = candidates;
		this.numberOfvoters += candidates.getSetLenght();
		return true;

	}

	public boolean setSickCandidatesVoters(Set<SickCandidate> sickCandidates) {
		this.sickCandidatesVoters = sickCandidates;
		this.numberOfvoters += sickCandidates.getSetLenght();
		return true;
	}

	public boolean setCitizensVoters() {
		for (int i = 0; i < citizens.getSetLenght(); i++) {
			try {
				checkVotingException(citizens.getObjectAtIndex(i));
				this.citizensVoters.add(citizens.getObjectAtIndex(i));
				numberOfvoters++;
			} catch (ageOutOfRange notBigEnough) {
				return false;
			}
		}
		return true;
	}

	public boolean setSickCitizensVoters() {
		for (int i = 0; i < sickCitizens.getSetLenght(); i++) {
			try {
				checkVotingException(sickCitizens.getObjectAtIndex(i));
				this.SickCitizensVoters.add(sickCitizens.getObjectAtIndex(i));
				numberOfvoters++;
			} catch (ageOutOfRange notBigEnough) {
				return false;
			}
		}
		return true;
	}

	public <T extends Citizen> void checkVotingException(T object) throws ageOutOfRange {
		if (object.getAge() < 18) {
			throw new ageOutOfRange("Not legal to vote yet");
		}
	}

	public boolean setRunningParties(Vector<Party> runningParties) {
		this.runningParties = runningParties;
		return true;
	}

	public void setCitizenBallot(Vector<Ballot<Citizen>> citizenBallot) {
		this.citizenBallot = citizenBallot;
	}

	public void setSickCitizenBallot(Vector<Ballot<SickCitizen>> sickCitizenBallot) {
		this.sickCitizenBallot = sickCitizenBallot;
	}

	public void setSoldierBallot(Vector<Ballot<Soldier>> soldierBallot) {
		this.soldierBallot = soldierBallot;
	}

	public void setSickSoldierBallot(Vector<Ballot<SickSoldier>> sickSoldierBallot) {
		this.sickSoldierBallot = sickSoldierBallot;
	}

	public void setCandidatesBallot(Vector<Ballot<Candidate>> candidateBallot) {
		this.candidateBallot = candidateBallot;
	}

	public void setSickCandidatesBallot(Vector<Ballot<SickCandidate>> sickCandidateBallot) {
		this.sickCandidateBallot = sickCandidateBallot;

	}

	public boolean setElectionMonth(int electionMonth) { // boolean since it
															// says so in the
															// task
		if (this.electionMonth > 12 || electionMonth < 1) {
			this.electionMonth = 1;
			return false;
		} else
			this.electionMonth = electionMonth;
		return true;
	}

	public boolean setElectionYear(int electionYear) { // boolean since it says
														// so in the task
		if (electionYear <= 0) {
			this.electionYear = 2020;
			return false;
		} else
			this.electionYear = electionYear;
		return true;
	}

	public int getElectionYear() {
		return this.electionYear;
	}

	public void setHasHappened(boolean happened) {
		this.hasHappened = happened;
	}

	public boolean getHasHappened() {
		return this.hasHappened;
	}

	public String toString() {
		return "Election Round on " + electionMonth + "/" + electionYear;
	}

	@Override
	public boolean equals(Object obj) {
		ElectionRound other = (ElectionRound) obj;
		return (electionMonth == other.electionMonth && electionYear != other.electionYear);
	}

	public boolean setBallotsAndVoters() throws ageOutOfRange {
		for (int i = 0; i < citizensVoters.size(); i++) {
			citizensVoters.get(i).setBallot(citizenBallot.get(0));
			citizenBallot.get(0).addVoter(citizensVoters.get(i));
		}

		for (int i = 0; i < SickCitizensVoters.size(); i++) {
			SickCitizensVoters.get(i).setBallot(sickCitizenBallot.get(0));
			sickCitizenBallot.get(0).addVoter(SickCitizensVoters.get(i));
		}

		for (int i = 0; i < SoldiersVoters.getSetLenght(); i++) {
			SoldiersVoters.getObjectAtIndex(i).setBallot(soldierBallot.get(0));
			soldierBallot.get(0).addVoter(SoldiersVoters.getObjectAtIndex(i));
		}

		for (int i = 0; i < SickSoldiersVoters.getSetLenght(); i++) {
			SickSoldiersVoters.getObjectAtIndex(i).setBallot(sickSoldierBallot.get(0));
			sickSoldierBallot.get(0).addVoter(SickSoldiersVoters.getObjectAtIndex(i));
		}

		for (int i = 0; i < candidatesVoters.getSetLenght(); i++) {
			candidatesVoters.getObjectAtIndex(i).setBallot(candidateBallot.get(0));
			candidateBallot.get(0).addVoter(candidatesVoters.getObjectAtIndex(i));
		}

		for (int i = 0; i < sickCandidatesVoters.getSetLenght(); i++) {
			sickCandidatesVoters.getObjectAtIndex(i).setBallot(sickCandidateBallot.get(0));
			sickCandidateBallot.get(0).addVoter(sickCandidatesVoters.getObjectAtIndex(i));
		}
		return true;
	}

	public <T extends Citizen> boolean setBallotAndASingleCitizen(T temp) throws ageOutOfRange {
		try {
			checkVotingException(temp);
			matchBallotAndCitizen(temp);
		} catch (ageOutOfRange notBigEnough) {
			return false;
		}
		return true;
	}

	private boolean matchBallotAndCitizen(Citizen citizen) throws ageOutOfRange {
		if (citizen.getClass() == Soldier.class) {
			citizen.setBallot(this.soldierBallot.get(0));
		} else if (citizen.getClass() == SickSoldier.class) {
			citizen.setBallot(this.sickSoldierBallot.get(0));
		} else if (citizen.getClass() == Citizen.class) {
			citizen.setBallot(this.citizenBallot.get(0));
		} else if (citizen.getClass() == SickCitizen.class) {
			citizen.setBallot(this.sickCitizenBallot.get(0));
		} else if (citizen.getClass() == Candidate.class) {
			citizen.setBallot(this.candidateBallot.get(0));
		} else if (citizen.getClass() == SickCandidate.class) {
			citizen.setBallot(this.sickCandidateBallot.get(0));
		}
		return true;
	}

	private double calculateTotalVotingPercent() {
		if (numberOfvoters == 0) {
			return 0;
		} else {
			double votingPercent = ((double) ActualNumberOfVoters) / ((double) numberOfvoters) * 100;
			votingPercent = votingPercent * 100;
			votingPercent = Math.round(votingPercent);
			votingPercent = votingPercent / 100;
			return votingPercent;
		}
	}

	private int calculateActualVoters() {
		for (int i = 0; i < citizens.getSetLenght(); i++) {
			if (citizens.getObjectAtIndex(i).getIsVoting()) {
				ActualNumberOfVoters++;
			}
		}
		for (int i = 0; i < sickCitizens.getSetLenght(); i++) {
			if (sickCitizens.getObjectAtIndex(i).getIsVoting()) {
				ActualNumberOfVoters++;
			}
		}
		for (int i = 0; i < SoldiersVoters.getSetLenght(); i++) {
			if (SoldiersVoters.getObjectAtIndex(i).getIsVoting()) {
				ActualNumberOfVoters++;
			}
		}
		for (int i = 0; i < SickSoldiersVoters.getSetLenght(); i++) {
			if (SickSoldiersVoters.getObjectAtIndex(i).getIsVoting()) {
				ActualNumberOfVoters++;
			}
		}
		for (int i = 0; i < candidatesVoters.getSetLenght(); i++) {
			if (candidatesVoters.getObjectAtIndex(i).getIsVoting()) {
				ActualNumberOfVoters++;
			}
		}
		for (int i = 0; i < sickCandidatesVoters.getSetLenght(); i++) {
			if (sickCandidatesVoters.getObjectAtIndex(i).getIsVoting()) {
				ActualNumberOfVoters++;
			}
		}

		return ActualNumberOfVoters;
	}

	private boolean setNumberOfVotersPerParty() { // boolean since it says so in
													// the task
		for (int i = 0; i < citizenBallot.size(); i++) {
			Vector<BallotsResults> temp = citizenBallot.get(i).getResults();
			setNumbers(temp);
		}
		for (int i = 0; i < sickCitizenBallot.size(); i++) {
			Vector<BallotsResults> temp = sickCitizenBallot.get(i).getResults();
			setNumbers(temp);
		}
		for (int i = 0; i < soldierBallot.size(); i++) {
			Vector<BallotsResults> temp = soldierBallot.get(i).getResults();
			setNumbers(temp);
		}

		for (int i = 0; i < sickSoldierBallot.size(); i++) {
			Vector<BallotsResults> temp = sickSoldierBallot.get(i).getResults();
			setNumbers(temp);
		}

		for (int i = 0; i < candidateBallot.size(); i++) {
			Vector<BallotsResults> temp = candidateBallot.get(i).getResults();
			setNumbers(temp);
		}

		for (int i = 0; i < sickCandidateBallot.size(); i++) {
			Vector<BallotsResults> temp = sickCandidateBallot.get(i).getResults();
			setNumbers(temp);
		}
		return true;
	}

	private void setNumbers(Vector<BallotsResults> temp) {
		for (int j = 0; j < temp.size(); j++) {
			for (int k = 0; k < runningParties.size(); k++) {
				if (temp.get(j).getParty().equals(runningParties.get(k))) {
					runningParties.get(k).setNumberOfVoters(temp.get(j).getVotesNumber());
				}
			}
		}
	}

	// from menu:
	// here needs to be connected to gui!!
	public void addABallot(String kind, String adress) {
		switch (kind) {
		case "Sick Citizen Ballot":
			sickCitizenBallot.add(new Ballot<SickCitizen>(adress, runningParties));
			break;
		case "Soldier Ballot":
			soldierBallot.add(new Ballot<Soldier>(adress, runningParties));
			break;
		case "Citizen Ballot":
			citizenBallot.add(new Ballot<Citizen>(adress, runningParties));
			break;
		case "Sick Soldier Ballot":
			sickSoldierBallot.add(new Ballot<SickSoldier>(adress, runningParties));
			break;
		case "Candidate Ballot":
			candidateBallot.add(new Ballot<Candidate>(adress, runningParties));
			break;
		case "Sick Candidate Ballot":
			sickCandidateBallot.add(new Ballot<SickCandidate>(adress, runningParties));
		}
	}

	public boolean addACitizen(String kind, String name, int ID, int year, boolean carryWeapon, int sickDays)
			throws IDOutOfRange, ageOutOfRange {
		boolean notTheSamePerson;
		boolean isAbleToVote = false;
		switch (kind) {
		case "Sick Citizen":
			SickCitizen temp = new SickCitizen(name, ID, year, sickDays);
			notTheSamePerson = sickCitizens.add(temp);
			if (!notTheSamePerson) {
				return false;
			}
			isAbleToVote = setBallotAndASingleCitizen(temp);
			if (isAbleToVote) {
				SickCitizensVoters.add(temp);
				this.sickCitizenBallot.get(0).addVoter(temp);
			}
			break;

		case "Soldier":
			Soldier temp2 = new Soldier(name, ID, year, carryWeapon);
			notTheSamePerson = SoldiersVoters.add(temp2);
			if (!notTheSamePerson) {
				return false;
			}
			isAbleToVote = setBallotAndASingleCitizen(temp2);
			this.soldierBallot.get(0).addVoter(temp2);
			break;

		case "Citizen":
			Citizen temp3 = new Citizen(name, ID, year);
			notTheSamePerson = citizens.add(temp3);
			if (!notTheSamePerson) {
				return false;
			}

			isAbleToVote = setBallotAndASingleCitizen(temp3);
			if (isAbleToVote) {
				citizensVoters.add(temp3);
				citizenBallot.get(0).addVoter(temp3);
			}
			break;

		case "Sick Soldier":
			SickSoldier temp4 = new SickSoldier(name, ID, year, carryWeapon, sickDays);
			notTheSamePerson = SickSoldiersVoters.add(temp4);
			if (!notTheSamePerson) {
				return false;
			}

			isAbleToVote = setBallotAndASingleCitizen(temp4);
			sickSoldierBallot.get(0).addVoter(temp4);
			break;
		}

		return true;
	}

	public void addAParty(String partyName, String partyFaction, String partyDate) {
		runningParties.add(new Party(partyName, partyFaction, partyDate));
	}

	public boolean addACandidateToParty(String kind, String name, int ID, int year, int sickDays, String party)
			throws ageOutOfRange, IDOutOfRange {
		boolean notTheSamePerson;
		if (kind == "Candidate") {
			Candidate temp = null;
			for (int i = 0; i < runningParties.size(); i++) {
				if (runningParties.get(i).equals(party)) {
					temp = (Candidate) runningParties.get(i).addCandidate(name, ID, year);
				}
			}

			if (temp != null) {
				matchBallotAndCitizen(temp);
				notTheSamePerson = candidatesVoters.add(temp);
				if (!notTheSamePerson) {
					return false;

				}

			} else if (kind == "Sick Candidate") {
				SickCandidate temp2 = null;
				for (int i = 0; i < runningParties.size(); i++) {
					if (runningParties.get(i).equals(party)) {
						temp2 = (SickCandidate) runningParties.get(i).addSickCandidate(name, ID, year, sickDays);
					}
				}
				if (temp2 != null) {
					matchBallotAndCitizen(temp2);
					notTheSamePerson = sickCandidatesVoters.add(temp2);
					if (!notTheSamePerson) {
						return false;
					}
				}
			}

		}
		return true;
	}

	public String showAllBallots() {
		StringBuffer str = new StringBuffer("Here are all the ballots in this election:\n");
		if (citizenBallot.size() > 0) {
			str.append("Citizen's ballots:\n");
			for (int i = 0; i < citizenBallot.size(); i++) {
				str.append(citizenBallot.get(i).toString() + "\n");
			}
		}
		str.append("\n");
		if (sickCitizenBallot.size() > 0) {
			str.append("Sick Citizens Ballots: \n");
			for (int i = 0; i < sickCitizenBallot.size(); i++) {
				str.append(sickCitizenBallot.get(i).toString() + "\n");
			}
		}
		str.append("\n");
		if (soldierBallot.size() > 0) {
			str.append("Soldiers Ballots: \n");
			for (int i = 0; i < soldierBallot.size(); i++) {
				str.append(soldierBallot.get(i).toString() + "\n");
			}
		}
		str.append("\n");
		if (sickSoldierBallot.size() > 0) {
			str.append("Sick Soldiers ballots: \n");
			for (int i = 0; i < sickSoldierBallot.size(); i++) {
				str.append(sickSoldierBallot.get(i).toString() + "\n");
			}
		}
		str.append("\n");
		if (candidateBallot.size() > 0) {
			str.append("Candidates ballots: \n");
			for (int i = 0; i < candidateBallot.size(); i++) {
				str.append(candidateBallot.get(i).toString() + "\n");
			}
		}
		str.append("\n");
		if (sickCandidateBallot.size() > 0) {
			str.append("Sick Candidates ballots: \n");
			for (int i = 0; i < sickCandidateBallot.size(); i++) {
				str.append(sickCandidateBallot.get(i).toString() + "\n");
			}
		}
		str.append("\n");
		return str.toString();
	}

	public String showAllCitizens() {
		StringBuffer str = new StringBuffer("Here are all the citizens in this election:\n");

		for (int i = 0; i < citizens.getSetLenght(); i++) {
			str.append(citizens.getObjectAtIndex(i) + "\n");
		}
		for (int i = 0; i < sickCitizens.getSetLenght(); i++) {
			str.append(sickCitizens.getObjectAtIndex(i) + "\n");
		}
		for (int i = 0; i < SoldiersVoters.getSetLenght(); i++) {
			str.append(SoldiersVoters.getObjectAtIndex(i) + "\n");
		}
		for (int i = 0; i < SickSoldiersVoters.getSetLenght(); i++) {
			str.append(SickSoldiersVoters.getObjectAtIndex(i) + "\n");
		}

		for (int i = 0; i < candidatesVoters.getSetLenght(); i++) {
			str.append(candidatesVoters.getObjectAtIndex(i) + "\n");
		}

		for (int i = 0; i < sickCandidatesVoters.getSetLenght(); i++) {
			str.append(sickCandidatesVoters.getObjectAtIndex(i) + "\n");
		}
		str.append("\n");
		return str.toString();
	}

	public String showAllParties() {
		StringBuffer str = new StringBuffer("Here are all the parties in this election:\n");
		for (int i = 0; i < runningParties.size(); i++) {
			str.append(runningParties.get(i) + "\n");
		}
		str.append("\n");
		return str.toString();
	}

	public void elections(String party,boolean vote) {
		currentVoter.vote(party,vote);
//		for (int i = 0; i < citizensVoters.size(); i++) {
//			theView.getVoterInfo(citizensVoters.get(i).name,citizensVoters.get(i).ID);
//			citizensVoters.get(i).vote(party,vote);
//		}
//		for (int i = 0; i < SoldiersVoters.getSetLenght(); i++) {
//			theView.getVoterInfo(SoldiersVoters.getObjectAtIndex(i).name,SoldiersVoters.getObjectAtIndex(i).ID);
//			SoldiersVoters.getObjectAtIndex(i).vote(party,vote);
//		}
//		for (int i = 0; i < SickCitizensVoters.size(); i++) {
//			theView.getVoterInfo(SickCitizensVoters.get(i).name,SickCitizensVoters.get(i).ID);
//			SickCitizensVoters.get(i).vote(party,vote);
//		}
//		for (int i = 0; i < SickSoldiersVoters.getSetLenght(); i++) {
//			theView.getVoterInfo(SickSoldiersVoters.getObjectAtIndex(i).name,SickSoldiersVoters.getObjectAtIndex(i).ID);
//			SickSoldiersVoters.getObjectAtIndex(i).vote(party,vote);
//		}
//		for (int i = 0; i < candidatesVoters.getSetLenght(); i++) {
//			theView.getVoterInfo(candidatesVoters.getObjectAtIndex(i).name,candidatesVoters.getObjectAtIndex(i).ID);
//			candidatesVoters.getObjectAtIndex(i).vote(party,vote);
//		}
//		for (int i = 0; i < sickCandidatesVoters.getSetLenght(); i++) {
//			theView.getVoterInfo(sickCandidatesVoters.getObjectAtIndex(i).name,sickCandidatesVoters.getObjectAtIndex(i).ID);
//			sickCandidatesVoters.getObjectAtIndex(i).vote(party,vote);
//		}
	}

	public void ShowElectionResults() {
		System.out.println(this.toString() + " is over.");
		System.out.println("The number of voters is " + calculateActualVoters() + " out of " + this.numberOfvoters
				+ " Potential voters. " + "The voting percent of the election round: " + calculateTotalVotingPercent()
				+ "%\n");
		for (int i = 0; i < citizenBallot.size(); i++) {
			citizenBallot.get(i).showResults();
		}
		for (int i = 0; i < sickCitizenBallot.size(); i++) {
			sickCitizenBallot.get(i).showResults();
		}
		for (int i = 0; i < soldierBallot.size(); i++) {
			soldierBallot.get(i).showResults();

		}
		for (int i = 0; i < sickSoldierBallot.size(); i++) {
			sickSoldierBallot.get(i).showResults();
		}
		for (int i = 0; i < candidateBallot.size(); i++) {
			candidateBallot.get(i).showResults();
		}
		for (int i = 0; i < sickCandidateBallot.size(); i++) {
			sickCandidateBallot.get(i).showResults();
		}
		setNumberOfVotersPerParty();
		System.out.println("The number of votes that each party got is: ");
		for (int i = 0; i < runningParties.size(); i++) {
			System.out.println("The party: " + runningParties.get(i).getName() + " got "
					+ runningParties.get(i).getNumberOfVoters() + " votes.");
		}
		System.out.println();
	}
	
	public Vector<Citizen> getCitizensVoters(){
		return this.citizensVoters;
	}
	
	public boolean nextVoter() {
		if(voterNumber<allVoters.size()) {
			currentVoter=allVoters.get(voterNumber);
			voterNumber++;
			return true;
		}
		return false;
	}

	public String getVoterName() {
		return currentVoter.getName();
	}
	
	public String getVoterID() {
		return ""+currentVoter.getID();
	}

	public void createVoters() {
		for (int i = 0; i < citizensVoters.size(); i++) {
			allVoters.add(citizensVoters.get(i));
		}
		for (int i = 0; i < SoldiersVoters.getSetLenght(); i++) {
			allVoters.add(SoldiersVoters.getObjectAtIndex(i));
		}
		for (int i = 0; i < SickSoldiersVoters.getSetLenght(); i++) {
			allVoters.add(SickSoldiersVoters.getObjectAtIndex(i));
		}
		for (int i = 0; i < candidatesVoters.getSetLenght(); i++) {
			allVoters.add(candidatesVoters.getObjectAtIndex(i));
		}
		for (int i = 0; i < sickCandidatesVoters.getSetLenght(); i++) {
			allVoters.add(sickCandidatesVoters.getObjectAtIndex(i));
		}
		for (int i = 0; i < SickCitizensVoters.size(); i++) {
			allVoters.add(SickCitizensVoters.get(i));
		}
	}

}