package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Major;
import Model.Minor;
import Model.Semester;

public class DegreePlan {
	private List<Major> majors = new ArrayList<>();
	private List<Minor> minors = new ArrayList<>();
	private List<Semester> semesters = new ArrayList<>();
	
	public void setMajor(ArrayList<Major> m) {
		majors = m;
	}
	
	public List<Major> getMajors() {
		return majors;
	}
	
	public void addMajor(Major m) {
		majors.add(m);
	}
	
	public void removeMajor(Major m) {
		majors.remove(m);
	}

	public void setMinors(ArrayList<Minor> m) {
		minors = m;
	}

	public List<Minor> getMinors() {
		return minors;
	}
	
	public void addMinor(Minor m) {
		minors.add(m);
	}
	
	public void removeMinor(Minor m) {
		minors.remove(m);
	}

	public void setSemesters(ArrayList<Semester> s) {
		semesters = s;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}
	
	public void addSemester(Semester s) {
		semesters.add(s);
	}
	
	public void removeSemester(Semester s) {
		semesters.remove(s);
	}
}
