package architecture1;

import java.util.Map;

public class Pipe implements Pipable {
    public Map<String, String[]> data;
	public Pipable next;

	public Pipe(Pipable next) {
        this.next = next;
        System.err.println("Pipe instantiated.");
    }	
	
    public void forward() {
    	System.err.println("Pipe forwarding data.");
    	next.receive(data);
    }

	@Override
	public void receive(Map<String, String[]> data) {
		System.err.println("Pipe receiving data.");
		this.data = data;
		forward();
	}
}