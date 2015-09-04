package architecture1;

import java.util.Map;

public abstract class Pump {
	public Pipe output;
	public Map<String, String[]> data;
	
    public Pump(Map<String, String[]> data, Pipe output) {
    	this.data = data;
        this.output = output;
    }
    
    public void start() {
        generateInto(output);
    }

	public abstract void generateInto(Pipe pipe);
}