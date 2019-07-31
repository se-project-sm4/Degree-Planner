package Model;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ModelEvent extends ActionEvent {
	private static final long serialVersionUID = 1L;
	private int type;
	private List<List<String>> semesters = new ArrayList<List<String>>();
	
	public ModelEvent(Object obj, int id, String message, int t, List<List<String>> s){
		super(obj, id, message);
		type = t;
		semesters = s;
	}
	
	public int getType(){
		return type;
	}
	
	public List<List<String>> getSemesters(){
		return semesters;
	}
}
