package degreePlanner.Controller;
import degreePlanner.Model.Model;
import degreePlanner.View.View;

public interface Controller {
	void setModel(Model model);
	Model getModel();
	View getView();
	void setView(View view);
}
