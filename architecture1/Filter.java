package architecture1;

import java.util.Map;

public abstract class Filter implements Pipable{
	public Pipe output;
	
    public Filter(Pipe output) {
        this.output = output;
        System.err.println("Filter instantiated.");
    }
    
    public void receive(Map<String, String[]> data){
    	System.err.println("Filter received data.");
    	forward(transform(data));
    }
    
    public void forward(Map<String, String[]> data) {
    	System.err.println("Filter forwarding transformed data.");
    	output.receive(data);
    }

    public abstract Map<String, String[]> transform(Map<String, String[]> data);
}