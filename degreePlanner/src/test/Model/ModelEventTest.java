package test.Model;

import degreePlanner.Model.ModelEvent;

import static org.junit.Assert.assertEquals;

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
	void testConstructor() {
		ModelEvent modelEvent = new ModelEvent(null, 0, null, 0, null);
		assertEquals(0, modelEvent.getType());
		assertEquals(null, modelEvent.getArray());
		List<List<String>> arr2d = new ArrayList<List<String>>();
		List<String> arr1 = new ArrayList<String>();
		arr1.add("string 1");
		arr1.add("string 2");
		List<String> arr2 = new ArrayList<String>();
		arr2.add("string 3");
		arr2.add("string 4");
		arr2d.add(arr1);
		arr2d.add(arr2);
		ModelEvent modelEvent1 = new ModelEvent(null, 0, null, 1, arr2d);
		assertEquals(1, modelEvent1.getType());
		assertEquals(arr2d, modelEvent1.getArray());
	}
}
