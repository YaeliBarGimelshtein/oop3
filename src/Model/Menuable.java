package Model;


public interface Menuable {
	void addABallot(String kind, String address);

	boolean addACitizen(String kind, String name, int ID, int year, boolean carryWeapon, int sickDays) throws IDOutOfRange, ageOutOfRange;

	void addAParty(String partyName, String partyFaction, String partyDate);

	boolean addACandidateToParty(String kind, String name, int ID, int year, int sickDays, String party) throws ageOutOfRange, IDOutOfRange;

	String showAllBallots();

	String showAllCitizens();

	String showAllParties();

	void elections(String party,boolean vote);

	String ShowElectionResults();

}
