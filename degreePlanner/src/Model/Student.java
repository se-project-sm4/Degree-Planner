package Model;
import Model.DegreePlan;

public class Student {
	private DegreePlan degreePlan;
	private String username;
	private String password;
	
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
	
	public void setDegreePlan(DegreePlan d) {
		degreePlan = d;
	}
	
	public DegreePlan getDegreePlan() {
		return degreePlan;
	}
}
