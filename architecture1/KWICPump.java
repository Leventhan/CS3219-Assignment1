package architecture1;

import java.util.Map;

public class KWICPump extends Pump {

	public KWICPump(Map<String, String[]> data, Pipe output) {
		super(data, output);
	}

	@Override
	public void generateInto(Pipe pipe) {
		System.err.println("Pump forwarding to Pipe.");
		pipe.receive(data);
	}
}