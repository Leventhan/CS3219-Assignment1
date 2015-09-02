package architecture2.components;

import architecture2.model.ProcessedLineStorage;
import architecture2.model.RawLineStorage;

public class MasterControl {
	public MasterControl(String[] titles, String[] ignored) {
		ProcessedLineStorage processed = new ProcessedLineStorage();
		RawLineStorage raw = new RawLineStorage();
		CircularShifter shift = new CircularShifter(raw, processed, ignored);
		Alphabetizer alpha = new Alphabetizer(processed);
		InputController input = new InputController(raw);
		OutputController output = new OutputController(processed);
		
		input.input(titles);
		output.output();
	}
	
}
