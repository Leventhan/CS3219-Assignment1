package architecture2.components;

import java.util.Vector;

import architecture2.model.ObservedLineStorage;

public class OutputController {
	private ObservedLineStorage lineStorage;
	
	public OutputController(ObservedLineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}
	
	public void output() {
		Vector<String> lines = lineStorage.getLines();
		for (String line : lines) {
			System.out.println(line);
		}
	}

}