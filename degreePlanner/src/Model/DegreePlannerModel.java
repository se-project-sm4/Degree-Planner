package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.DegreePlan;
import Model.CourseCatalog;
import Model.DisciplineCatalog;

public class DegreePlannerModel  extends AbstractModel{
	private CourseCatalog catalog = new CourseCatalog();
	private DisciplineCatalog disciplines = new DisciplineCatalog();
	private DegreePlan plan = new DegreePlan();
	private String fileName;
	
	public DegreePlannerModel(String username) {
		for(int i = 0; i < 12; ++i) {
			addSemester();
		}
		try {
			fileName = username + ".bin";
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			plan = (DegreePlan)ois.readObject();
			ois.close();
			fis.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + fileName + "\" not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("class \"DegreePlan\" not found");
			e.printStackTrace();
		}
	}
	
	public void login() {
		ModelEvent me = new ModelEvent(this, 1, "", 0, getPlanForView());
		notifyChanged(me);
	}

	public void showCourseCatalog() {
		ModelEvent me = new ModelEvent(this, 1, "", 1, getCourseCatalogForView());
		notifyChanged(me);
		return;
	}

	public void showDisciplineCatalog() {
		ModelEvent me = new ModelEvent(this, 1, "", 2, getDisciplineCatalogForView());
		notifyChanged(me);
		return;
	}
	
	public void showPlan() {
		ModelEvent me = new ModelEvent(this, 1, "", 3, getPlanForView());
		notifyChanged(me);
	}
	
	public void createPlan(){
		if(plan.getMajors().size() == 0) {
			ModelEvent me = new ModelEvent(this, 1, "", 3, getPlanForView());
			notifyChanged(me);
			return;
		}
		plan.setSemesters(new ArrayList<Semester>());
		addSemester();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < plan.getMajors().size(); ++i)
			for(int j = 0; j < plan.getMajors().get(i).getRequirements().size(); ++j) 
				if(map.get(plan.getMajors().get(i).getRequirements().get(j).getSubject()) == null)
					map.put(plan.getMajors().get(i).getRequirements().get(j).getSubject(), plan.getMajors().get(i).getRequirements().get(j).getNumHour());
				else
					map.put(plan.getMajors().get(i).getRequirements().get(j).getSubject(), Math.max(map.get(plan.getMajors().get(i).getRequirements().get(j).getSubject()), plan.getMajors().get(i).getRequirements().get(j).getNumHour()));

		for(int i = 0; i < plan.getMinors().size(); ++i)
			for(int j = 0; j < plan.getMinors().get(i).getRequirements().size(); ++j) 
				if(map.get(plan.getMinors().get(i).getRequirements().get(j).getSubject()) == null)
					map.put(plan.getMinors().get(i).getRequirements().get(j).getSubject(), plan.getMinors().get(i).getRequirements().get(j).getNumHour());
				else
					map.put(plan.getMinors().get(i).getRequirements().get(j).getSubject(), Math.max(map.get(plan.getMinors().get(i).getRequirements().get(j).getSubject()), plan.getMinors().get(i).getRequirements().get(j).getNumHour()));
		
		for(int i = 0; i < disciplines.getDefaultRequirements().size(); ++i)
			if(map.get(disciplines.getDefaultRequirements().get(i).getSubject()) == null)
				map.put(disciplines.getDefaultRequirements().get(i).getSubject(), disciplines.getDefaultRequirements().get(i).getNumHour());
			else
				map.put(disciplines.getDefaultRequirements().get(i).getSubject(), Math.max(map.get(disciplines.getDefaultRequirements().get(i).getSubject()), disciplines.getDefaultRequirements().get(i).getNumHour()));
		
		for (String key: map.keySet()) {
			for(int i = 0; i < catalog.getCatalog().get(catalog.getMap().get(key)).size() && map.get(key) > 0; ++i){
				if(catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getPrerequisite() == null) {
					if(plan.getSemesters().get(0).getHours() + catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getHours() <= plan.getSemesters().get(0).getMaxHours()) {
						map.put(key, map.get(key) - catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getHours());
						plan.getSemesters().get(0).addCourse(catalog.getCatalog().get(catalog.getMap().get(key)).get(i));
					}else{
						int semesterNumber = 0;
						while(plan.getSemesters().get(semesterNumber).getHours() + catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getHours() > plan.getSemesters().get(semesterNumber).getMaxHours()) {
							if(plan.getSemesters().size() == ++semesterNumber){
								addSemester();
							}
						}
						map.put(key, map.get(key) - catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getHours());
						plan.getSemesters().get(semesterNumber).addCourse(catalog.getCatalog().get(catalog.getMap().get(key)).get(i));
					}
				}else{
					for(int j = 0; j < plan.getSemesters().size(); ++j) {
						if(plan.getSemesters().get(j).getCourses().contains(catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getPrerequisite())) {
							if(plan.getSemesters().size() <= ++j) {
								addSemester();
							}
							while(plan.getSemesters().get(j).getHours() + catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getHours() > plan.getSemesters().get(j).getMaxHours()) {
								if(plan.getSemesters().size() == ++j){
									addSemester();
								}
							}
							map.put(key, map.get(key) - catalog.getCatalog().get(catalog.getMap().get(key)).get(i).getHours());
							plan.getSemesters().get(j).addCourse(catalog.getCatalog().get(catalog.getMap().get(key)).get(i));
						}
					}
				}
			}
		}
		ModelEvent me = new ModelEvent(this, 1, "", 3, getPlanForView());
		notifyChanged(me);
		save();
	}

	public void addCourse(String courseName){
		String[] split = courseName.split("\\s+");
		if(split.length != 3) {
			ModelEvent me = new ModelEvent(this, 1, "", 5, getPlanForView());
			notifyChanged(me);
			return;
		}
		String subject = split[0];
		try {
			int id = Integer.parseInt(split[1]);
			int semester = Integer.parseInt(split[2]) - 1;
			Course course = catalog.findCourse(id, subject);
			if(course == null){
				ModelEvent me = new ModelEvent(this, 1, "", 5, getPlanForView());
				notifyChanged(me);
				return;
			}
			for(int i = 0; i < plan.getSemesters().size(); ++i) {
				if(plan.getSemesters().get(i).getCourses().contains(new Course(id, subject, null, 0, null, null, false))){
					ModelEvent me = new ModelEvent(this, 1, "", 5, getPlanForView());
					notifyChanged(me);
					return;
				}
			}
			for(int i = plan.getSemesters().size(); i <= semester; ++i) {
					addSemester();
			}
			if(plan.getSemesters().get(semester).getMaxHours() < plan.getSemesters().get(semester).getHours() + course.getHours()){
				ModelEvent me = new ModelEvent(this, 1, "", 5, getPlanForView());
				notifyChanged(me);
				return;
			}
			if(plan.getSemesters().get(semester).getCourses().add(course)) {
				save();
				ModelEvent me = new ModelEvent(this, 1, "", 4, getPlanForView());
				notifyChanged(me);
				return;
			}
		}catch(NumberFormatException e){
			ModelEvent me = new ModelEvent(this, 1, "", 5, getPlanForView());
			notifyChanged(me);
			return;
		}
		ModelEvent me = new ModelEvent(this, 1, "", 5, getPlanForView());
		notifyChanged(me);
		return;
	}

	public void removeCourse(String course){
		String[] split = course.split("\\s+");
		if(split.length != 3) {
			ModelEvent me = new ModelEvent(this, 1, "", 7, getPlanForView());
			notifyChanged(me);
			return;
		}
		String subject = split[0];
		try {
			int id = Integer.parseInt(split[1]);
			int semester = Integer.parseInt(split[2]) - 1;
			if(plan.getSemesters().get(semester).getCourses().remove(new Course(id, subject, null, 0, null, null, false))) {
				save();
				ModelEvent me = new ModelEvent(this, 1, "", 6, getPlanForView());
				notifyChanged(me);
				return;
			}
		}catch(NumberFormatException e) {
			ModelEvent me = new ModelEvent(this, 1, "", 7, getPlanForView());
			notifyChanged(me);
			return;
		}
		ModelEvent me = new ModelEvent(this, 1, "", 7, getPlanForView());
		notifyChanged(me);
		return;
	}

	public void addMajor(String major){
		Major m = new Major();
		m = disciplines.findMajor(major);
		if(m == null){
			ModelEvent me = new ModelEvent(this, 1, "", 9, getPlanForView());
			notifyChanged(me);
			return;
		}
		if(!plan.getMajors().contains(m)) {
			if(plan.getMajors().add(m)) {
				save();
				ModelEvent me = new ModelEvent(this, 1, "", 8, getPlanForView());
				notifyChanged(me);
				return;
			}
		}
		ModelEvent me = new ModelEvent(this, 1, "", 9, getPlanForView());
		notifyChanged(me);
		return;
	}

	public void removeMajor(String major){
		if(plan.getMajors().remove(disciplines.findMajor(major))) {
			save();
			ModelEvent me = new ModelEvent(this, 1, "", 10, getPlanForView());
			notifyChanged(me);
			return;
		}
		ModelEvent me = new ModelEvent(this, 1, "", 11, getPlanForView());
		notifyChanged(me);
		return;
	}

	public void addMinor(String minor){
		Minor m = new Minor();
		m = disciplines.findMinor(minor);
		if(m == null){
			ModelEvent me = new ModelEvent(this, 1, "", 13, getPlanForView());
			notifyChanged(me);
			return;
		}
		if(!plan.getMinors().contains(m)) {
			if(plan.getMinors().add(m)) {
				save();
				ModelEvent me = new ModelEvent(this, 1, "", 12, getPlanForView());
				notifyChanged(me);
				return;
			}
		}
		ModelEvent me = new ModelEvent(this, 1, "", 13, getPlanForView());
		notifyChanged(me);
		return;
	}

	public void removeMinor(String minor){
		if(plan.getMinors().remove(disciplines.findMinor(minor))) {
			save();
			ModelEvent me = new ModelEvent(this, 1, "", 14, getPlanForView());
			notifyChanged(me);
			return;
		}
		ModelEvent me = new ModelEvent(this, 1, "", 15, getPlanForView());
		notifyChanged(me);
		return;
	}
	
	public void removeSemester(String semester){
		String[] split = semester.split("\\s+");
		if(split.length != 1) {
			ModelEvent me = new ModelEvent(this, 1, "", 17, getPlanForView());
			notifyChanged(me);
			return;
		}
		try {
			int index = Integer.parseInt(split[0]) - 1;
			int numSemesters = plan.getSemesters().size();
			if(numSemesters > 0 && numSemesters > index)
				plan.setSemesters(new ArrayList<Semester>(plan.getSemesters().subList(0, Math.max(0, index))));
			else {
				ModelEvent me = new ModelEvent(this, 1, "", 17, getPlanForView());
				notifyChanged(me);
				return;
			}
			save();
			ModelEvent me = new ModelEvent(this, 1, "", 16, getPlanForView());
			notifyChanged(me);
			return;
		}catch(NumberFormatException e) {
			ModelEvent me = new ModelEvent(this, 1, "", 17, getPlanForView());
			notifyChanged(me);
			return;
		}
	}
	
	public void logout() {
		save();
	}
	
	private void addSemester(){
		if(plan.getSemesters().size() % 3 == 2) {
			plan.addSemester(new Semester(16));
		}else {
			plan.addSemester(new Semester(18));
		}
	}
	
	private void save() {
		System.out.println(plan);
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(plan);
			oos.flush();
			oos.close();
			fos.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + fileName + "\"not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}
	}

	private List<List<String>> getPlanForView(){
		List<List<String>> semestersStringArr = new ArrayList<List<String>>();
		List<String> tempArr = new ArrayList<String>();
		for(int i = 0, numMajors = plan.getMajors().size(); i < numMajors; ++i) {
			tempArr.add(plan.getMajors().get(i).getMajorName());
			String tempString = new String("<html>");
			for(int j = 0, numSubjects = plan.getMajors().get(i).getRequirements().size(); j < numSubjects; ++j) {
				tempString += "<p>" + plan.getMajors().get(i).getRequirements().get(j).getNumHour() + " hours of " + plan.getMajors().get(i).getRequirements().get(j).getSubject() + " " + "</p>";
			}
			tempArr.add(tempString + "</html>");
		}
		semestersStringArr.add(tempArr);

		tempArr = new ArrayList<String>();
		for(int i = 0, numMajors = plan.getMinors().size(); i < numMajors; ++i) {
			tempArr.add(plan.getMinors().get(i).getMinorName());
			String tempString = new String("<html>");
			for(int j = 0, numSubjects = plan.getMinors().get(i).getRequirements().size(); j < numSubjects; ++j) {
				tempString += "<p>" + plan.getMinors().get(i).getRequirements().get(j).getNumHour() + " hours of " + plan.getMinors().get(i).getRequirements().get(j).getSubject() + " " + "</p>";
			}
			tempArr.add(tempString + "</html>");
		}
		semestersStringArr.add(tempArr);
		
		for(int i = 0, numSems = plan.getSemesters().size(); i < numSems; ++i) {
			tempArr = new ArrayList<String>();
			for(int j = 0, numCourses = plan.getSemesters().get(i).getCourses().size() ; j < numCourses; ++j) {
				tempArr.add(plan.getSemesters().get(i).getCourses().get(j).getSubject() + " " + plan.getSemesters().get(i).getCourses().get(j).getCourseID());
				if(plan.getSemesters().get(i).getCourses().get(j).getPrerequisite() == null) {
					tempArr.add("<html><p>Class Name: " + plan.getSemesters().get(i).getCourses().get(j).getClassName() + 
					"</p><p>Description: " + plan.getSemesters().get(i).getCourses().get(j).getClassDescription() + 
					"</p><p>Prerequisite: none" + 
					"</p><p>Hours: " + Integer.valueOf(plan.getSemesters().get(i).getCourses().get(j).getHours()) + 
					"</p><p>Writing Intensive: " + plan.getSemesters().get(i).getCourses().get(j).getWritingIntensive() + "</p></html>");
				}else {
					tempArr.add("<html><p>Class Name: " + plan.getSemesters().get(i).getCourses().get(j).getClassName() + 
					"</p><p>Description: " + plan.getSemesters().get(i).getCourses().get(j).getClassDescription() + 
					"</p><p>Prerequisite: " + plan.getSemesters().get(i).getCourses().get(j).getPrerequisite().getSubject() + " " + plan.getSemesters().get(i).getCourses().get(j).getPrerequisite().getCourseID() +
					"</p><p>Hours: " + Integer.valueOf(plan.getSemesters().get(i).getCourses().get(j).getHours()) + 
					"</p><p>Writing Intensive: " + plan.getSemesters().get(i).getCourses().get(j).getWritingIntensive() + "</p></html>");
				}
			}
			semestersStringArr.add(tempArr);
		}
		return semestersStringArr;
	}
	
	private List<List<String>> getCourseCatalogForView(){
		List<List<String>> catalogStringArr = new ArrayList<List<String>>();
		for(int i = 0, numSubjects = catalog.getCatalog().size(); i < numSubjects; ++i) {
			List<String> tempArr = new ArrayList<String>();
			for(int j = 0, numCourses = catalog.getCatalog().get(i).size() ; j < numCourses; ++j) {
				tempArr.add(catalog.getCatalog().get(i).get(j).getSubject() + " " + catalog.getCatalog().get(i).get(j).getCourseID());
				if(catalog.getCatalog().get(i).get(j).getPrerequisite() == null) {
					tempArr.add("<html><p>Class Name: " + catalog.getCatalog().get(i).get(j).getClassName() + 
					"</p><p>Description: " + catalog.getCatalog().get(i).get(j).getClassDescription() + 
					"</p><p>Prerequisite: none" + 
					"</p><p>Hours: " + Integer.valueOf(catalog.getCatalog().get(i).get(j).getHours()) + 
					"</p><p>Writing Intensive: " + catalog.getCatalog().get(i).get(j).getWritingIntensive() + "</p></html>");
				}else {
					tempArr.add("<html><p>Class Name: " + catalog.getCatalog().get(i).get(j).getClassName() + 
					"</p><p>Description: " + catalog.getCatalog().get(i).get(j).getClassDescription() + 
					"</p><p>Prerequisite: " + catalog.getCatalog().get(i).get(j).getPrerequisite().getSubject() + " " + catalog.getCatalog().get(i).get(j).getPrerequisite().getCourseID() +
					"</p><p>Hours: " + Integer.valueOf(catalog.getCatalog().get(i).get(j).getHours()) + 
					"</p><p>Writing Intensive: " + catalog.getCatalog().get(i).get(j).getWritingIntensive() + "</p></html>");
				}
			}
			catalogStringArr.add(tempArr);
		}
		return catalogStringArr;
	}

	private List<List<String>> getDisciplineCatalogForView(){
		List<List<String>> catalogStringArr = new ArrayList<List<String>>();
		List<String> tempArr = new ArrayList<>();
		tempArr.add("Minimum Requirements");
		tempArr.add("Hover to see minimum requirements");
		String tempString = new String("<html>");
		for(int i = 0, numSubjects = disciplines.getDefaultRequirements().size(); i < numSubjects; ++i) {
			tempString += "<p>" + disciplines.getDefaultRequirements().get(i).getNumHour() + " hours of " + disciplines.getDefaultRequirements().get(i).getSubject() + " " + "</p>";
		}
		tempArr.add(tempString + "</html>");
		catalogStringArr.add(tempArr);

		tempArr = new ArrayList<>();
		tempArr.add("Majors");
		for(int i = 0, numMajors = disciplines.getMajors().size(); i < numMajors; ++i) {
			tempArr.add(disciplines.getMajors().get(i).getMajorName());
			tempString = "<html>";
			for(int j = 0, numSubjects = disciplines.getMajors().get(i).getRequirements().size(); j < numSubjects; ++j) {
				tempString += "<p>" + disciplines.getMajors().get(i).getRequirements().get(j).getNumHour() + " hours of " + disciplines.getMajors().get(i).getRequirements().get(j).getSubject() + " " + "</p>";
			}
			tempArr.add(tempString + "</html>");
		}
		catalogStringArr.add(tempArr);

		tempArr = new ArrayList<>();
		tempArr.add("Minors");
		for(int i = 0, numMajors = disciplines.getMinors().size(); i < numMajors; ++i) {
			tempArr.add(disciplines.getMinors().get(i).getMinorName());
			tempString = "<html>";
			for(int j = 0, numSubjects = disciplines.getMinors().get(i).getRequirements().size(); j < numSubjects; ++j) {
				tempString += "<p>" + disciplines.getMinors().get(i).getRequirements().get(j).getNumHour() + " hours of " + disciplines.getMinors().get(i).getRequirements().get(j).getSubject() + " " + "</p>";
			}
			tempArr.add(tempString + "</html>");
		}
		catalogStringArr.add(tempArr);
		return catalogStringArr;
	}
}