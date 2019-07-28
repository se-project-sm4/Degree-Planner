package Model;
import java.awt.event.ActionEvent;

public class ModelEvent extends ActionEvent {
	private int type;
	
	public ModelEvent(Object obj, int id, String message, int t){
		super(obj, id, message);
		type = t;
	}
	
	public int getType(){
		return type;
	}
}
