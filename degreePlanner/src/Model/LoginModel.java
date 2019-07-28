package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Student;

public class LoginModel extends AbstractModel {
	private ArrayList<Student> students;
	
	public LoginModel() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Username", "Password"));
		//read from file
	}
	
	public boolean login(String username, String password){
		Student temp = new Student(username, password);
		if (students.contains(temp)){
			return true;
		}else{
			return false;
		}
	}

	public boolean register(String username, String password){
		for(int i = 0; i < students.size(); ++i)
			if (username == students.get(i).getUsername())
				return false;
		
		students.add(new Student(username, password));
		//add to file
		return true;
	}
}
