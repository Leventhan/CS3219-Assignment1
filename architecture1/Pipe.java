package architecture1;

import java.util.Map;

public class Pipe implements Pipable {
    public Map<String, String[]> data;
	public Pipable next;

	public Pipe(Pipable next) {
        this.next = next;
    }	
	
    public void forward() {
    	next.receive(data);
    }

	@Override
	public void receive(Map<String, String[]> data) {
		this.data = data;
		forward();
	}
}