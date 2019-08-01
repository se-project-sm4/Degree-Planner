package degreePlanner.Controller;
import degreePlanner.Model.Model;
import degreePlanner.View.View;

public abstract class AbstractController implements Controller {
	private View view;
	private Model model;
	
	public void setModel(Model model){this.model = model;}
	
	public Model getModel(){return model;}
	
	public View getView(){return view;}
	
	public void setView(View view){this.view = view;}

}
