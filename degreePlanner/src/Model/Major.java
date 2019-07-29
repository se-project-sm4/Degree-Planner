package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.Requirement;

public class Major implements Serializable{
	private static final long serialVersionUID = 1L;
	private String majorName;
	private List<Requirement> requirements = new ArrayList<>();
	private int writingIntensiveHours;
	
	public Major(String m, List<Requirement> r, int w ) {
		majorName = m;
		requirements = r;
		writingIntensiveHours = w;
	}
	
	public void setMajorName(String m) {
		majorName = m;
	}
	
	public String getMajorName() {
		return majorName;
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
        return majorName + " " + requirements + Integer.toString(writingIntensiveHours);
    } 
	
    @Override
    public boolean equals(Object obj) { 
    	if (obj == this) { 
    		return true; 
    	} 
    	if (obj == null || obj.getClass() != this.getClass()) { 
    		return false; 
    	}
    	if(((Major)obj).getMajorName().equals(this.getMajorName())) {
    		return true;
    	}
    	return false;
    } 
}
