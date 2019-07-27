package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Requirement;

public class Minor {
	private String minorName;
	private ArrayList<Requirement> requirements;
	private int writingIntensiveHours;
	
	public void setMinorName(String m) {
		minorName = m;
	}
	
	public String getMinorName() {
		return minorName;
	}

	public void setMajor(ArrayList<Requirement> r) {
		requirements = r;
	}
	
	public ArrayList<Requirement> getMajors() {
		return requirements;
	}
	
	public void addMajor(Requirement r) {
		requirements.add(r);
	}
	
	public void removeMajor(Requirement r) {
		requirements.remove(r);
	}
	
	public void setWritingIntensiveHours(int w) {
		writingIntensiveHours = w;
	}
	
	public int getWritingIntensiveHours() {
		return writingIntensiveHours;
	}
}
