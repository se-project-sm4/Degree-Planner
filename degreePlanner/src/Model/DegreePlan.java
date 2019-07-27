package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Major;
import Model.Minor;
import Model.Semester;

public class DegreePlan {
	private ArrayList<Major> majors;
	private ArrayList<Minor> minors;
	private ArrayList<Semester> semesters;
	
	public void setMajor(ArrayList<Major> m) {
		majors = m;
	}
	
	public ArrayList<Major> getMajors() {
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

	public ArrayList<Minor> getMinors() {
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

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}
	
	public void addSemester(Semester s) {
		semesters.add(s);
	}
	
	public void removeSemester(Semester s) {
		semesters.remove(s);
	}
}
