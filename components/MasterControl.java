package components;

import model.ProcessedLineStorage;
import model.RawLineStorage;

public class MasterControl {
	public MasterControl() {
		String ignoreList = "";
		InputController input = new InputController();
		OutputController output = new OutputController();
		ProcessedLineStorage processed = new ProcessedLineStorage();
		RawLineStorage raw = new RawLineStorage();
		CircularShifter shift = new CircularShifter(raw, processed, ignoreList);
		Alphabetizer alpha = new Alphabetizer(processed);
	}
	
	
}
