package components;
import java.util.StringTokenizer;
import java.util.Vector;

import model.ObservedLineStorage;

public class CircularShifter implements Observer {
	private ObservedLineStorage source, target;
	private String ignoreList;
	public CircularShifter(ObservedLineStorage a, ObservedLineStorage b, String ignoreList) {
		source = a;
		target = b;
		source.addObserver(this);
	}
	
	public void update() {
		circularShift(source.getLine());
		
	}
	
	private void circularShift(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		int count = 0;
		Vector<Vector<String>> buffer = new Vector<Vector<String>>();
		while (tokenizer.hasMoreTokens()) {
			String current = tokenizer.nextToken();
			if (ignoreList.contains(current)) {
				for (int i = 0; i < count; i++) {
					buffer.get(i).add(current);
				}
				continue;
			}
			count++;
			buffer.add(new Vector<String>());
			for (int j = 0; j < count; j++) {
				buffer.get(j).add(current);
			}
		}
		for (int k = 1; k < buffer.size(); k++) {
			int amount = buffer.get(0).size() - buffer.get(k).size();
			for (int l = 0; l < amount; l++) {
				buffer.get(k).add(buffer.get(0).get(l));
			}
		}
		for (int x = 0; x < buffer.size(); x++) {
			String shiftedLine = "";
			for (int y = 0; y < buffer.get(x).size(); y++) {
				shiftedLine = shiftedLine.concat(" " + buffer.get(x).get(y));
			}
			shiftedLine = shiftedLine.substring(1);
			target.insertLine(shiftedLine);
		}
	}
}
