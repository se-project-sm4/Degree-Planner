package Model;
import Model.DegreePlan;

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
}
