package hw4;

public class Scan {
	private int totalAgatstonScore;
	private int lmScore;
	private int ladScore;
	private int lcxScore;
	private int rcaScore;
	private int pdaScore;
	
	public Scan(int totalAgatstonScore, int lmScore, int ladScore, int lcxScore, int rcaScore, int pdaScore) {
		this.totalAgatstonScore = totalAgatstonScore;
		this.lmScore = lmScore;
		this.ladScore = ladScore;
		this.lcxScore = lcxScore;
		this.rcaScore = rcaScore;
		this.pdaScore = pdaScore;
	}
	
	//	Getters
	public int getTotalAgatstonScore() {
		return this.totalAgatstonScore;
	}
	
	public int getLMScore() {
		return this.lmScore;
	}
	
	public int getLADScore() {
		return this.ladScore;
	}
	
	public int getLCXScore() {
		return this.lcxScore;
	}
	
	public int getRCAScore() {
		return this.rcaScore;
	}
	
	public int getPDAScore() {
		return this.pdaScore;
	}
}
