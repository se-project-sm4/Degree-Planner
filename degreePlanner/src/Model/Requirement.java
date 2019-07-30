package Model;

import java.io.Serializable;

public class Requirement implements Serializable{
	private static final long serialVersionUID = 1L;
	private String subject;
	private int numHours;
	
	public Requirement() {
		
	}
	public Requirement(String s, int n) {
		subject = s;
		numHours = n;
	}
	public void setSubject(String s) {
		subject = s;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setNumHour(int n) {
		numHours = n;
	}
	
	public int getNumHour() {
		return numHours;
	}
	
    @Override
    public String toString() { 
        return "[subject=" + subject + ", numHours=" + Integer.toString(numHours) + "]";
    } 
}
