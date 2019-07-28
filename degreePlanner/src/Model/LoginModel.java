package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Student;
import Model.ModelEvent;

public class LoginModel extends AbstractModel {
	private List<Student> students = new ArrayList<>();
	
	public LoginModel() {
		students.add(new Student("Username", "Password"));
	}
	
	public boolean login(String username, String password){
		if (students.contains(new Student(username, password))){
			new ModelEvent(this, 1, "", 0);
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
