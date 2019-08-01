package test.Model;

import degreePlanner.Model.LoginModel;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class LoginModelTest {
	/*
		public LoginModel();
		public boolean login(String username, String password);
		public boolean register(String username, String password);
	 */

	@Test
	void testAll() {
		LoginModel loginModel = new LoginModel();
		String username = "user10";
		assertEquals(false, loginModel.login(username, "password"));
		assertEquals(true, loginModel.register(username, "password"));
		assertEquals(false, loginModel.register(username, "password"));
		assertEquals(false, loginModel.register(username, "password1"));
		assertEquals(false, loginModel.register(username, ""));
		assertEquals(false, loginModel.login(username, "password1"));
		assertEquals(false, loginModel.login(username, ""));
		assertEquals(true, loginModel.login(username, "password"));
		
		assertEquals(false, loginModel.register("?", "password"));
		assertEquals(false, loginModel.register("?", ""));

		assertEquals(false, loginModel.register("", "password"));
		assertEquals(false, loginModel.register("", ""));
	}
}
