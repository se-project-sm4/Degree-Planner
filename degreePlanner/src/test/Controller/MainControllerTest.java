package test.Controller;

import degreePlanner.Controller.MainController;
import degreePlanner.Model.LoginModel;
import degreePlanner.View.LoginView;

import org.junit.jupiter.api.Test;

public class MainControllerTest {
	/*
		MainController();
		public void login(String username, String password);
	 	public void register(String username, String password);
	 	public void showCourseCatalog();
	 	public void showDisciplineCatalog();
	 	public void showPlan();
	 	public void createPlan();
	 	public void removeSemester(String semester);
	 	public void addCourse(String course);
	 	public void removeCourse(String course);
	 	public void addMajor(String major);
	 	public void removeMajor(String major);
	 	public void addMinor(String minor);
	 	public void removeMinor(String minor);
	 	public void logout();
		public void setModel(Model model);
		public Model getModel();
		public View getView();
		public void setView(View view);
	*/
	@Test
	void test() {
		//need to add asserts
		MainController mainController = new MainController();
		mainController.register("2", "");
		mainController.login("2", "");
		mainController.showCourseCatalog();
		mainController.showDisciplineCatalog();
		mainController.showPlan();
		mainController.createPlan();
		mainController.removeSemester("1");
		mainController.addCourse("CS 1428 1");
		mainController.removeCourse("CS 1428 1");
		mainController.addMajor("Computer Science");
		mainController.removeMajor("Computer Science");
		mainController.addMinor("Mathematics");
		mainController.removeMinor("Mathematics");
		mainController.logout();
		mainController.setModel(new LoginModel());
		mainController.getModel();
		mainController.setView(new LoginView((LoginModel)mainController.getModel(), mainController));
		mainController.getView();
	}
}
