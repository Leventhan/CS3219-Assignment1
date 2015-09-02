package architecture2.components;

import architecture2.model.ObservedLineStorage;

public class InputController {
	private ObservedLineStorage lineStorage;
	
	public InputController(ObservedLineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}
	
	public void input(String[] titles) {
		for (int i = 0; i < titles.length; i++) {
			lineStorage.insertLine(titles[i]);
		}
	}
}