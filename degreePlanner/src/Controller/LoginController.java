package Controller;
import Model.LoginModel;
import View.LoginView;
import View.JFrameView;

public class LoginController extends AbstractController {
	public LoginController(){
		setModel(new LoginModel());
		setView(new LoginView((LoginModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
	
	public void operation(String option, String username, String password){
		if(option == LoginView.LOGIN){
			if (((LoginModel)getModel()).login(username, password)) {
				//log in
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
