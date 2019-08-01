package degreePlanner.Model;

import java.io.Serializable;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	private int courseID;
	private String subject;
	private Course prerequisites;
	private int hours;
	private String className;
	private String classDescription;
	private boolean writingIntensive;
	
	public Course(int i, String s, Course p, int h, String n, String d, boolean w) {
		courseID = i;
		subject = s;
		prerequisites = p;
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
	
	public void setPrerequisite(Course p) {
		prerequisites = p;
	}
	
	public Course getPrerequisite() {
		return prerequisites;
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
	
    @Override
    public String toString() { 
        return "[courseID=" + Integer.toString(courseID) + ", subject=" + subject + ", prerequisites=" + prerequisites + ", hours=" + Integer.toString(hours) + ", className=" + className + ", classDescription=" + classDescription + ", writingIntensive=" + writingIntensive + "]";
    } 
	
    @Override
    public boolean equals(Object obj) { 
    	if (obj == this) { 
    		return true; 
    	} 
    	if (obj == null || obj.getClass() != this.getClass()) { 
    		return false; 
    	}
    	if(((Course)obj).getSubject() == null) {
    		return false;
    	}
    	if(((Course)obj).getCourseID() == this.getCourseID() && ((Course)obj).getSubject().equals(this.getSubject())) {
    		return true;
    	}
    	return false;
    } 
}
