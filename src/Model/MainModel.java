package Model;


import java.util.Scanner;
import java.util.Vector;

public class MainModel {
	private ElectionRound firstRound;
	
	public MainModel() throws ageOutOfRange, IDOutOfRange {
		 firstRound = hardCode(); 
	}
	
	public void update(String button,Scanner scan) throws IDOutOfRange, ageOutOfRange { // when a new button is pressed- here needs to be the menu
		do {
		switch (button) {
		default:
			System.out.println("You have pressed a wrong key");
		case "Add a ballot":
			firstRound.addABallot(scan);
			break;
		case "Add a citizen":
			firstRound.addACitizen(scan);
			break;
		case "Add a party":
			firstRound.addAParty(scan);
			break;
		case "Add a candidate to a party":
			firstRound.addACandidateToParty(scan);
			break;
		case "Show all ballots":
			firstRound.showAllBallots();
			break;
		case "Show all citizens":
			firstRound.showAllCitizens();
			break;
		case "Show all parties":
			firstRound.showAllParties();
			break;
		case "Strat the election":
			if (!firstRound.getHasHappened()) {
				firstRound.elections(scan);
				firstRound.setHasHappened(true);
			} else
				System.out.println("The voting has already happened. please press 9 to see results");
			break;
		case "Show election results":
			if (!firstRound.getHasHappened()) {
				System.out.println("Can not show results until election started\n");
			} else {
				firstRound.ShowElectionResults();
			}
			break;
		case "EXIT":
			System.out.println("You have chose to exit, have a good day");
		}
	} while (!button.equals("EXIT"));
	scan.close();
	}

		
	public static ElectionRound hardCode() throws ageOutOfRange, IDOutOfRange {
		ElectionRound elections = new ElectionRound(9, 2020);
		
		Vector<Party> runningParties = new Vector<>(); // parties
		runningParties.add(new Party("Meretz", "Left", "09/08/1990"));
		runningParties.add(new Party("HaLikud", "Right", "14/05/1980"));
		runningParties.add(new Party("Kahol Lavan", "Center", "25/01/2018"));

		elections.setRunningParties(runningParties); // election has parties

		Set<Citizen> citizens = new Set<>();
		citizens.add(new Citizen("Yakir", 123456789, 1997));
		citizens.add(new Citizen("Ran", 303939155, 1996));
		elections.setCitizens(citizens); // election has citizens
		elections.setCitizensVoters(); //election has the voters that are citizens
		
		Set<Candidate> candidates= new Set<>();
		candidates.add(new Candidate("Benjamin Netanyahu", 251637285, 1949, runningParties.get(1)));
		candidates.add(new Candidate("Beny Gantz", 278492871, 1959,  runningParties.get(2)));
		candidates.add(new Candidate("Miri Regev", 274958637, 1959, runningParties.get(1)));
		candidates.add(new Candidate("Yair Lapid", 198365039, 1960, runningParties.get(2)));
		elections.setCandidatesVoters(candidates); 
		
		Set<SickCandidate> sickCandidates= new Set<>();
		sickCandidates.add(new SickCandidate("Amir Peretz", 362719835, 1958, runningParties.get(0),10));
		sickCandidates.add(new SickCandidate("Nitzan Horovitz", 284019372, 1962, runningParties.get(0),4));
		elections.setSickCandidatesVoters(sickCandidates);
		
		Set<SickCitizen> sickCitizens= new Set<>();
		sickCitizens.add(new SickCitizen("Rom", 208722719, 1997,8));
		elections.setSickCitizens(sickCitizens); // election has sick citizens
		elections.setSickCitizensVoters(); //election has the voters that are sick citizens
		
		Set<Soldier> soldiers= new Set<>();
		soldiers.add(new Soldier("Shir", 246123784, 2002,true));
		elections.setSoldiersVoters(soldiers); // election has soldiers + they are voters
		
		Set<SickSoldier> sickSoldiers= new Set<>();
		sickSoldiers.add(new SickSoldier("Or", 123567488, 2001,false,20));
		elections.setSickSoldiersVoters(sickSoldiers);// election has sick soldiers + they are voters
		
		Vector <Ballot <Soldier>> arrayB2= new Vector<>(); //election has ballots
		Ballot <Soldier> b2 = new Ballot <Soldier>("Beer Sheva", runningParties);
		arrayB2.add(b2);
		elections.setSoldierBallot(arrayB2);
		
		Vector <Ballot <SickSoldier>> arrayB4= new Vector<>();
		Ballot <SickSoldier> b4= new Ballot<SickSoldier>("Jerusalem", runningParties);
		arrayB4.add(b4);
		elections.setSickSoldierBallot(arrayB4);
		
		Vector <Ballot <Citizen>> arrayB3= new Vector<>();
		Ballot <Citizen> b3 = new Ballot <Citizen>("Tel aviv", runningParties);
		arrayB3.add(b3);
		elections.setCitizenBallot(arrayB3);
		
		Vector <Ballot <SickCitizen>> arrayB1= new Vector<>(); 	 
		Ballot <SickCitizen> b1= new Ballot<SickCitizen>("Haifa", runningParties);
		arrayB1.add(b1);
		elections.setSickCitizenBallot(arrayB1);
		
		Vector <Ballot <Candidate>> arrayB5 = new Vector<>();
		Ballot<Candidate> b5= new Ballot<Candidate>("Jerusalem", runningParties);
		arrayB5.add(b5);
		elections.setCandidatesBallot(arrayB5);
		
		Vector <Ballot <SickCandidate>> arrayB6 = new Vector<>();
		Ballot<SickCandidate> b6= new Ballot<SickCandidate>("Yaffo", runningParties);
		arrayB6.add(b6);
		elections.setSickCandidatesBallot(arrayB6);
		
		elections.setBallotsAndVoters(); // citizens get ballots && ballots get citizens
		return elections;
	}
}
