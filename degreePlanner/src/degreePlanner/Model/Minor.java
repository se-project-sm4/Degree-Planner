package degreePlanner.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import degreePlanner.Model.Requirement;

public class Minor implements Serializable{
	private static final long serialVersionUID = 1L;
	private String minorName;
	private List<Requirement> requirements = new ArrayList<>();
	private int writingIntensiveHours;

	public Minor() {
		
	}
	
	public Minor(String m, List<Requirement> r, int w ) {
		minorName = m;
		requirements = r;
		writingIntensiveHours = w;
	}
	
	public String getMinorName() {
		return minorName;
	}
	
	public void setMinorName(String n) {
		minorName = n;
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
        return "[minorName=" + minorName + ", requirements=" + requirements + ", writingIntensiveHours=" + Integer.toString(writingIntensiveHours) + "]";
    } 
	
    @Override
    public boolean equals(Object obj) { 
    	if (obj == this) { 
    		return true; 
    	} 
    	if (obj == null || obj.getClass() != this.getClass()) { 
    		return false; 
    	}
    	if(((Minor)obj).getMinorName().equals(this.getMinorName())) {
    		return true;
    	}
    	return false;
    } 
}