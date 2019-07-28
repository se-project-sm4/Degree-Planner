package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.Requirement;

public class Minor implements Serializable{
	private static final long serialVersionUID = 1L;
	private String minorName;
	private List<Requirement> requirements = new ArrayList<>();
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
	
	public List<Requirement> getMajors() {
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
	
    @Override
    public String toString() { 
        return minorName + " " + requirements + Integer.toString(writingIntensiveHours);
    } 
}
