package degreePlanner.View;
import degreePlanner.Model.Model;
import degreePlanner.Controller.Controller;

public interface View {
	Controller getController();
	void setController(Controller controller);
	Model getModel();
	void setModel(Model model);
}
