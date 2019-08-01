package degreePlanner.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import degreePlanner.Model.Requirement;

public class Major implements Serializable{
	private static final long serialVersionUID = 1L;
	private String majorName;
	private List<Requirement> requirements = new ArrayList<>();
	private int writingIntensiveHours;

	public Major() {
		majorName = null;
		requirements = null;
		writingIntensiveHours = 0;
	}
	
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

	public void setRequirements(ArrayList<Requirement> r) {
		requirements = r;
	}
	
	public List<Requirement> getRequirements() {
		return requirements;
	}
	
	public void addRequirements(Requirement r) {
		requirements.add(r);
	}
	
	public void removeRequirements(Requirement r) {
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
        return "[majorName=" + majorName + ", requirements=" + requirements + ", writingIntensiveHours=" + Integer.toString(writingIntensiveHours) + "]";
    } 
	
    @Override
    public boolean equals(Object obj) { 
    	if (obj == this) { 
    		return true; 
    	} 
    	if (obj == null || obj.getClass() != this.getClass()) { 
    		return false; 
    	}
    	if(((Major)obj).getMajorName() == (this.getMajorName())) {
    		return true;
    	}
    	return false;
    } 
}
