package architecture1;

import java.util.Map;

public abstract class Filter implements Pipable{
	public Pipe output;
	
    public Filter(Pipe output) {
        this.output = output;
    }
    
    public void receive(Map<String, String[]> data){
    	forward(transform(data));
    }
    
    public void forward(Map<String, String[]> data) {
    	output.receive(data);
    }

    public abstract Map<String, String[]> transform(Map<String, String[]> data);
}