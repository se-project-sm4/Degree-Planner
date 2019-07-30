package Controller;
import Model.DegreePlannerModel;
import View.DegreePlannerView;
import View.JFrameView;
import Model.LoginModel;
import View.LoginView;

public class MainController extends AbstractController {
	public MainController(){
		setModel(new LoginModel());
		setView(new LoginView((LoginModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}

	public void login(String username, String password){
		if(((LoginModel)getModel()).login(username, password)) {
			setModel(new DegreePlannerModel(username));
			((LoginView)getView()).dispose();
			setView(new DegreePlannerView((DegreePlannerModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);
		}
	}
	
	public void register(String username, String password){
		((LoginModel)getModel()).register(username, password);
	}

	public void createPlan() {
		((DegreePlannerModel)getModel()).createPlan();
	}
	
	public void clearPlan(String semester) {
		((DegreePlannerModel)getModel()).removeSemester(semester);
	}
	
	public void addCourse(String course) {
		((DegreePlannerModel)getModel()).addCourse(course);
	}
	
	public void removeCourse(String course) {
		((DegreePlannerModel)getModel()).removeCourse(course);
	}
	
	public void addMajor(String major) {
		((DegreePlannerModel)getModel()).addMajor(major);
	}
	
	public void removeMajor(String major) {
		((DegreePlannerModel)getModel()).removeMajor(major);
	}
	
	public void addMinor(String minor) {
		((DegreePlannerModel)getModel()).addMinor(minor);
	}
	
	public void removeMinor(String minor) {
		((DegreePlannerModel)getModel()).removeMinor(minor);
	}
	
	public void logout() {
		((DegreePlannerModel)getModel()).logout();
		setModel(new LoginModel());
		((DegreePlannerView)getView()).dispose();
		setView(new LoginView((LoginModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
}
