package Model;

import java.util.Scanner;
import java.util.Vector;

public class SickSoldier extends Soldier implements Sickable{
	private Ballot<SickSoldier> ballot;
	private int numOfSickDays;

	public SickSoldier(String name, int ID, int year,boolean weapon,int days) throws IDOutOfRange  {
		super(name,ID,year,weapon);
		numOfSickDays=days;
	}
	
	public SickSoldier(Scanner scan) throws IDOutOfRange, ageOutOfRange {
		super(scan);
		System.out.println("please let us know how many days you are sick:");
		numOfSickDays=scan.nextInt();
		System.out.println("feel better!");
	}
	
	public String toString() {
		String str= super.toString()+". He is also sick for "+numOfSickDays;
		if (ballot != null) {
			str = str + ", votes at ballot number " + ballot.getId() + ". ";
		}
		return str;
	}


	public int getNumOfSickDays() {
		return this.numOfSickDays;
	}
	
	@Override
	public boolean equals(Object obj) {
		SickSoldier other= (SickSoldier) obj;
		return (super.equals(other));
	}
	
	public void vote(String selectedParty) {
		this.ballot.vote(selectedParty, this);
	}
	
	public boolean setBallot(Ballot<? extends Citizen> ballot) throws ageOutOfRange { // boolean since it says so un the taks
		try {
			checkAge();
			this.ballot = (Ballot<SickSoldier>) ballot;
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
