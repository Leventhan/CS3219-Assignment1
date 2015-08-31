package components;
import java.util.Collections;
import java.util.Vector;

import model.ObservedLineStorage;

public class Alphabetizer implements Observer {
	private ObservedLineStorage target;
	public Alphabetizer(ObservedLineStorage o) {
		target = o;
		o.addObserver(this);
	}
	
	public void update() {
		alphabetize(target.getLines());
	}
	
	private void alphabetize(Vector<String> lines) {
		Collections.sort(lines);
	}
}
