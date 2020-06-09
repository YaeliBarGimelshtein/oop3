package Model;

public class Soldier extends Citizen {
	protected boolean carryWeapon;
	private Ballot<Soldier> ballot;


	public Soldier(String name, int ID, int year,boolean weapon)  {
		super(name,ID,year);
		setAge();
		this.carryWeapon=weapon;
	}


	public boolean getCarryWeapon() {
		return this.carryWeapon;
	}
	
	public String toString() {
		String str= super.toString()+". He is also a Soldier. Is carring a weapon= "+this.carryWeapon;
		if (ballot != null) {
		str = str + ", votes at ballot number " + ballot.getId() + ". ";
		}
		return str;
	}
	
	@Override
	public boolean equals(Object obj) {
		Soldier other= (Soldier) obj;
		return (carryWeapon==other.carryWeapon && super.equals(other));
	}
	
//	protected void checkAge() throws ageOutOfRange {
//		if (this.getAge() < 18) {
//			throw new ageOutOfRange("Not legal to vote yet");
//		}
//	}
	
	public void vote(String selectedParty) {
		this.ballot.vote(selectedParty, this);
	}
	
	public boolean setBallot(Ballot<? extends Citizen> ballot) throws ageOutOfRange { // boolean since it says so un the taks
		try {
			checkAge();
			this.ballot = (Ballot<Soldier>) ballot;
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
