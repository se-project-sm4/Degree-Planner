package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Student;

public class LoginModel extends AbstractModel {
	private List<Student> students = new ArrayList<>();
	
	public LoginModel() {
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
