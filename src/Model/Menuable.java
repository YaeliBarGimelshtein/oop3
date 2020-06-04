package Model;

import java.util.Scanner;

public interface Menuable {
	void addABallot(String kind, String address);

	void addACitizen(Scanner scan) throws IDOutOfRange, ageOutOfRange;

	void addAParty(Scanner scan);

	void addACandidateToParty(Scanner scan) throws ageOutOfRange, IDOutOfRange;

	void showAllBallots();

	void showAllCitizens();

	void showAllParties();

	void elections(Scanner scan);

	void ShowElectionResults();

}
