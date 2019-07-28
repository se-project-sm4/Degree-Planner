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
	
	public void clearPlan() {
		((DegreePlannerModel)getModel()).clearPlan();
	}
	
	public void addCourse(int id) {
		((DegreePlannerModel)getModel()).addCourse(id);
	}
	
	public void removeCourse(int id) {
		((DegreePlannerModel)getModel()).removeCourse(id);
	}
	
	public void addMajor(String name) {
		((DegreePlannerModel)getModel()).addMajor(name);
	}
	
	public void removeMajor(String name) {
		((DegreePlannerModel)getModel()).removeMajor(name);
	}
	
	public void addMinor(String name) {
		((DegreePlannerModel)getModel()).addMinor(name);
	}
	
	public void removeMinor(String name) {
		((DegreePlannerModel)getModel()).removeMinor(name);
	}
	
	public void logout() {
		setModel(new LoginModel());
		((DegreePlannerView)getView()).dispose();
		setView(new LoginView((LoginModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
}
