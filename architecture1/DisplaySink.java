package architecture1;

import java.util.Map;


public class DisplaySink extends Sink<Object, Object> {

    public DisplaySink() {
		super();
	}

	public void receive(Map<String, String[]> data){
		for (String sentence : data.get("titles"))
		    System.out.println(sentence);
    }
}