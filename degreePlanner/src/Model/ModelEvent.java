package Model;
import java.awt.event.ActionEvent;

public class ModelEvent extends ActionEvent {
	private static final long serialVersionUID = 1L;
	private int type;
	
	public ModelEvent(Object obj, int id, String message, int t){
		super(obj, id, message);
		type = t;
	}
	
	public int getType(){
		return type;
	}
}
