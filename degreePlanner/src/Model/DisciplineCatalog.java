package Model;

import java.util.ArrayList;
import java.util.List;
import Model.Major;
import Model.Minor;
import Model.Requirement;

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
		csMajorReqs.add(new Requirement("ENG", 3));
		csMajorReqs.add(new Requirement("MATH", 14));
		csMajorReqs.add(new Requirement("CS", 43));
		csMajorReqs.add(new Requirement("SCI", 16));
		csMajorReqs.add(new Requirement(null, 2));
		//add more
		
		majors.add(new Major("Computer Science", csMajorReqs, 9));
		//add more
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
}
