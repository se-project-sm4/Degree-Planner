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
			((LoginModel)getModel()).login(username, password);
		}else {
			((LoginModel)getModel()).register(username, password);
		}
	}
}
