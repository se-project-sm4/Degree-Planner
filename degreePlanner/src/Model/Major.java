package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Requirement;

public class Major {
	private String majorName;
	private ArrayList<Requirement> requirements;
	private int writingIntensiveHours;
	
	public void setMajorName(String m) {
		majorName = m;
	}
	
	public String getMajorName() {
		return majorName;
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
