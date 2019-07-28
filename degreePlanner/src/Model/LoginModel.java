package Model;
import java.util.ArrayList;
import java.util.List;
import Model.Student;
import Model.ModelEvent;

public class LoginModel extends AbstractModel {
	private List<Student> students = new ArrayList<>();
	
	public boolean login(String username, String password){
		if (students.contains(new Student(username, password))){
			ModelEvent me = new ModelEvent(this, 1, "", 0);
			notifyChanged(me);
			return true;
		}else{
			ModelEvent me = new ModelEvent(this, 1, "", 1);
			notifyChanged(me);
			return false;
		}
	}

	public boolean register(String username, String password){
		if(!students.isEmpty()) {
			for(int i = 0; i < students.size(); ++i)
				if (students.contains(new Student(username, password))) {
					ModelEvent me = new ModelEvent(this, 1, "", 3);
					notifyChanged(me);
					return false;
				}
		}
		
		students.add(new Student(username, password));
		ModelEvent me = new ModelEvent(this, 1, "", 2);
		notifyChanged(me);
		//add to file
		return true;
	}
}
