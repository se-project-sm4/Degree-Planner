package Model;

public class Student {
	private String username;
	private String password;
	
	public Student(String u, String p) {
		username = u;
		password = p;
	}
	
	public void setUsername(String s) {
		username = s;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String s) {
		password = s;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Student student = (Student) obj;
	    if (this.getUsername() == student.getUsername())
	    	return true;
	    return false;
	}
}
