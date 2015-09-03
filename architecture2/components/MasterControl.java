package architecture2.components;

import architecture2.model.ProcessedLineStorage;
import architecture2.model.RawLineStorage;

public class MasterControl {
	private String[] titles;
	private String[] ignored;
	private InputController input;
	private OutputController output;

	public MasterControl(String[] titles, String[] ignored) {
		this.titles = titles;
		this.ignored = ignored;
		initialize();
	}
	
	public void process() {
		input.input(titles);
		output.output();
	}
	
	private void initialize() {
		ProcessedLineStorage processed = new ProcessedLineStorage();
		RawLineStorage raw = new RawLineStorage();
		CircularShifter shift = new CircularShifter(raw, processed, ignored);
		Alphabetizer alpha = new Alphabetizer(processed);
		input = new InputController(raw);
		output = new OutputController(processed);
	}
}
