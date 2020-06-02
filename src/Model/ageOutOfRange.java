package Model;

public class ageOutOfRange extends Exception {
	private String exceptionExplenation;
	
	public ageOutOfRange(String exceptionExplenation ) {
		this.exceptionExplenation=exceptionExplenation;
	}
	
	public String toString() {
		return super.toString()+" ageOutOfRange " + exceptionExplenation;
	}
	
	public String getExplenation() {
		return exceptionExplenation;
	}
}
