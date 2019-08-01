package test.Model;

import degreePlanner.Model.LoginModel;

import org.junit.jupiter.api.Test;

public class LoginModelTest {
	/*
		public LoginModel();
		public boolean login(String username, String password);
		public boolean register(String username, String password);
	 */

	@Test
	void test() {
		LoginModel loginModel = new LoginModel();
		boolean login = loginModel.login("username", "password");
		boolean register = loginModel.register("username", "password");
	}
}
