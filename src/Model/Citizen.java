package Model;

public class Citizen {
	protected String name;
	protected int ID;
	protected int birthYear;
	private Ballot<Citizen> ballot;
	protected int age;
	protected boolean isVoting;
	protected boolean idCorrect;

	public Citizen(String name, int ID, int year) {
		this.name = name;
		this.ID=ID;
		setYear(year);
		setAge();
	}

	protected boolean setAge() { 
		this.age = ElectionRound.ELECTION_YEAR - this.birthYear;
		return true;
	}

	public int getAge() {
		return this.age;
	}

	public Ballot<?> getBallot() {
		return this.ballot;
	}

	
	public boolean setBallot(Ballot<? extends Citizen> ballot) throws ageOutOfRange { // boolean since it says so un the
		try {
			checkAge();
			this.ballot = (Ballot<Citizen>) ballot;
			return true;
		} catch (ageOutOfRange notBigEnough) {
			return false;
		}
	}
	
	protected void checkAge() throws ageOutOfRange {
		if (this.getAge() < 18) {
			throw new ageOutOfRange("Not legal to vote yet");
		}
	}

	public int getID() {
		return this.ID;
	}

	public int getYear() {
		return this.birthYear;
	}


	private boolean setYear(int year) { 
		if (year > 0 && year < 2021) {
			this.birthYear = year;
			return true;
		} else {
			this.birthYear = 0;
			return false;
		}
	}

//	private boolean setID(int iD)throws IDOutOfRange { 
//		if(iD<100000000||iD>999999999) {
//			throw new IDOutOfRange("Illegal ID");
//		}else {
//		this.ID=iD;
//		return true;
//		}
//	}

	public String getName() {
		return this.name;
	}

	public boolean getIsVoting() {
		return this.isVoting;
	}

	
	public void vote(String selectedParty) {
		this.ballot.vote(selectedParty, this);
	}
	 

	@Override
	public boolean equals(Object obj) {
		Citizen other = (Citizen) obj;
		if (this.ID != other.ID) {
			return false;
		}
		return true;
	}

	public void vote(String party,boolean vote) {
		if (vote) {
			this.vote(party);
			isVoting = true;
		} else {
			isVoting = false;
		}
	}

	public String toString() {
		String str = name + " is " + age + " ,ID=" + ID + ", born in " + birthYear ;
		if (ballot != null) {
			str = str + ", votes at ballot number " + ballot.getId() + ". ";
		}
		return str;
	}
}
