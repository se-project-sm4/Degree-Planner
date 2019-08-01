package test.Model;

import degreePlanner.Model.ModelEvent;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ModelEventTest {
	/*
		public ModelEvent(Object obj, int id, String message, int t, List<List<String>> a);
		public int getType();
		public List<List<String>> getArray();
	*/

	@Test
	void test() {
		List<List<String>> strings = new ArrayList<List<String>>();
		ModelEvent modelEvent = new ModelEvent(null, 0, null, 1, strings);
		int type = modelEvent.getType();
		strings = (ArrayList<List<String>>) modelEvent.getArray();
	}
}
