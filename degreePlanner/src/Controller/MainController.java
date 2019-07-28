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
	
	public void operation(String option, String username, String password, String id){
		if(getView().getClass() == DegreePlannerView.class) {
			if (option == DegreePlannerView.CREATE_PLAN){
				((DegreePlannerModel)getModel()).createPlan();
			} else if (option == DegreePlannerView.CLEAR_PLAN){
					((DegreePlannerModel)getModel()).clearPlan();
			} else if (option == DegreePlannerView.ADD_COURSE){
				((DegreePlannerModel)getModel()).addCourse(Integer.parseInt(id));
			} else if (option == DegreePlannerView.REMOVE_COURSE){
				((DegreePlannerModel)getModel()).removeCourse(Integer.parseInt(id));
			} else if (option == DegreePlannerView.ADD_MAJOR){
				((DegreePlannerModel)getModel()).addMajor();
			} else if (option == DegreePlannerView.REMOVE_MAJOR){
				((DegreePlannerModel)getModel()).removeMajor();
			} else if (option == DegreePlannerView.ADD_MINOR){
				((DegreePlannerModel)getModel()).addMinor();
			} else if (option == DegreePlannerView.REMOVE_MINOR){
				((DegreePlannerModel)getModel()).removeMinor();
			} else {
				setModel(new LoginModel());
				((DegreePlannerView)getView()).dispose();
				setView(new LoginView((LoginModel)getModel(), this));
				((JFrameView)getView()).setVisible(true);
			}
		}else {
			if(option == LoginView.LOGIN){
				if (((LoginModel)getModel()).login(username, password)) {
					setModel(new DegreePlannerModel(username));
					((LoginView)getView()).dispose();
					setView(new DegreePlannerView((DegreePlannerModel)getModel(), this));
					((JFrameView)getView()).setVisible(true);
				} else {
					// don't log in
				}
			}else {
				if (((LoginModel)getModel()).register(username, password)) {
					//register
				} else {
					//don't register
				}
			}
		}
	}
}
