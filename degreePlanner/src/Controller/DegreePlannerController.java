package Controller;
import Model.DegreePlannerModel;
import View.DegreePlannerView;
import View.JFrameView;
import Controller.LoginController;

public class DegreePlannerController extends AbstractController {
	public DegreePlannerController(String username){
		setModel(new DegreePlannerModel(username));
		setView(new DegreePlannerView((DegreePlannerModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
	
	public void operation(String option, int id){
		if (option == DegreePlannerView.CREATE_PLAN){
			((DegreePlannerModel)getModel()).createPlan();
		} else if (option == DegreePlannerView.CLEAR_PLAN){
				((DegreePlannerModel)getModel()).clearPlan();
		} else if (option == DegreePlannerView.ADD_COURSE){
			((DegreePlannerModel)getModel()).addCourse(id);
		} else if (option == DegreePlannerView.REMOVE_COURSE){
			((DegreePlannerModel)getModel()).removeCourse(id);
		} else if (option == DegreePlannerView.ADD_MAJOR){
			((DegreePlannerModel)getModel()).addMajor();
		} else if (option == DegreePlannerView.REMOVE_MAJOR){
			((DegreePlannerModel)getModel()).removeMajor();
		} else if (option == DegreePlannerView.ADD_MINOR){
			((DegreePlannerModel)getModel()).addMinor();
		} else if (option == DegreePlannerView.REMOVE_MINOR){
			((DegreePlannerModel)getModel()).removeMinor();
		} else {
			new LoginController();
		}
	}
}
