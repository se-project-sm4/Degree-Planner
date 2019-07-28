package Model;

public class Course {
	private int courseID;
	private String subject;
	private int prerequisite;
	private int hours;
	private String className;
	private String classDescription;
	private boolean writingIntensive;
	
	public Course(int i, String s, int p, int h, String n, String d, boolean w) {
		courseID = i;
		subject = s;
		prerequisite = p;
		hours = h;
		className = n;
		classDescription = d;
		writingIntensive = w;
	}
	
	public void setCourseID(int c) {
		courseID = c;
	}
	
	public int getCourseID() {
		return courseID;
	}
	
	public void setSubject(String s) {
		subject = s;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setPrerequisite(int p) {
		prerequisite = p;
	}
	
	public int getPrerequisite() {
		return prerequisite;
	}
	
	public void setHours(int h) {
		hours = h;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setClassName(String c) {
		className = c;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassDescription(String c) {
		classDescription = c;
	}
	
	public String getClassDescription() {
		return classDescription;
	}
	
	public void setWritingIntensive(boolean w) {
		writingIntensive = w;
	}
	
	public boolean getWritingIntensive() {
		return writingIntensive;
	}
}
