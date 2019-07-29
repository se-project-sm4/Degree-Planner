package Model;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import Model.ModelEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class LoginModel extends AbstractModel {
	private Map<String, String> students = new LinkedHashMap<String, String>();
	private String fileName = "students.bin";
	
	@SuppressWarnings("unchecked")
	public LoginModel() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			students = (Map<String, String>)ois.readObject();
			ois.close();
			fis.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + fileName + "\" not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("class \"Map<String, String>\"not found");
			e.printStackTrace();
		}
	}

	public boolean login(String username, String password){
		try {
			if(students.get(username).contentEquals(password)) {
				ModelEvent me = new ModelEvent(this, 1, "", 0);
				notifyChanged(me);
				return true;
			}
		}catch(NullPointerException e) {
			//not actually a problem
		}
		ModelEvent me = new ModelEvent(this, 1, "", 1);
		notifyChanged(me);
		return false;
	}

	public boolean register(String username, String password){
		//make sure file can be created by username
		if (students.containsKey(username)) {
			ModelEvent me = new ModelEvent(this, 1, "", 3);
			notifyChanged(me);
			return false;
		}
		students.put(username, password);
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(students);
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
		DegreePlan plan = new DegreePlan();
		try {
			FileOutputStream fos = new FileOutputStream(username + ".bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(plan);
			oos.flush();
			oos.close();
			fos.close();
		}catch(FileNotFoundException e) {
			System.out.println("file \"" + username + ".bin\"not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("io exception");
			e.printStackTrace();
		}
		ModelEvent me = new ModelEvent(this, 1, "", 2);
		notifyChanged(me);
		return true;
	}
}
