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
	
	public void operation(String option){
		if(option == LoginView.LOGIN){
			((LoginModel)getModel()).login();
		}else {
			((LoginModel)getModel()).register();
		}
	}
}
