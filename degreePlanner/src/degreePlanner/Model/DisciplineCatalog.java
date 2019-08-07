package degreePlanner.Model;

import java.util.ArrayList;
import java.util.List;
import degreePlanner.Model.Major;
import degreePlanner.Model.Minor;
import degreePlanner.Model.Requirement;

public class DisciplineCatalog {
	private List<Major> majors = new ArrayList<>();
	private List<Minor> minors = new ArrayList<>();
	private List<Requirement> defaultRequirements = new ArrayList<>();
	
	public DisciplineCatalog() {
		defaultRequirements.add(new Requirement("ENG", 6));
		defaultRequirements.add(new Requirement("MATH", 3));
		defaultRequirements.add(new Requirement("SCI", 6));
		defaultRequirements.add(new Requirement("PHIL", 3));
		defaultRequirements.add(new Requirement("ART", 3));
		defaultRequirements.add(new Requirement("HIST", 6));
		defaultRequirements.add(new Requirement("POSI", 6));
		defaultRequirements.add(new Requirement("SOCI", 3));

		List<Requirement> csMajorReqs = new ArrayList<>();
		csMajorReqs.add(new Requirement("ENG", 9));
		csMajorReqs.add(new Requirement("MATH", 16));
		csMajorReqs.add(new Requirement("CS", 43));
		csMajorReqs.add(new Requirement("SCI", 16));
		
		List<Requirement> busMajorReqs = new ArrayList<>();
		busMajorReqs.add(new Requirement("BUS", 43));
		
		List<Requirement> mathMajorReqs = new ArrayList<>();
		mathMajorReqs.add(new Requirement("MATH", 36));
		
		List<Requirement> mathMinorReqs = new ArrayList<>();
		mathMinorReqs.add(new Requirement("MATH", 20));
		
		List<Requirement> artMinorReqs = new ArrayList<>();
		artMinorReqs.add(new Requirement("ART", 24));
		
		//add more
		
		majors.add(new Major("Computer Science", csMajorReqs, 0));
		majors.add(new Major("Business Administration", busMajorReqs, 0));
		majors.add(new Major("Mathematics", mathMajorReqs, 0));
		
		//add more
		
		minors.add(new Minor("Mathematics", mathMinorReqs, 0));
		minors.add(new Minor("Art", artMinorReqs, 0));
	}
	
	public Major findMajor(String major) {
		int index  = majors.indexOf(new Major(major, null, 0));
		if(index == -1) {
			return null;
		}
		return majors.get(index);
	}
	
	public Minor findMinor(String minor) {
		int index  = minors.indexOf(new Minor(minor, null, 0));
		if(index == -1) {
			return null;
		}
		return minors.get(index);
	}
	
	public List<Requirement> getDefaultRequirements(){
		return defaultRequirements;
	}
	
	public List<Major> getMajors(){
		return majors;
	}
	
	public List<Minor> getMinors(){
		return minors;
	}
}
