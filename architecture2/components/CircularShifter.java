package architecture2.components;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import architecture2.model.ObservedLineStorage;

public class CircularShifter implements Observer {
	private ObservedLineStorage source, target;
	private List<String> ignoredList;
	public CircularShifter(ObservedLineStorage a, ObservedLineStorage b, String[] ignored) {
		source = a;
		target = b;
		source.addObserver(this);
		ignoredList = Arrays.asList(ignored);
	}
	
	public void update() {
		circularShift(source.getLine());
	}
	
	private void circularShift(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		int count = 0;
		Vector<Vector<String>> buffer = new Vector<Vector<String>>();
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			String lowerCaseWord = word.toLowerCase();
			String upperCaseWord = word.toUpperCase();
			String capitalWord = word.substring(0,1).toUpperCase().concat(word.substring(1));
			if (ignoredList.contains(word) || ignoredList.contains(lowerCaseWord) || ignoredList.contains(capitalWord) || ignoredList.contains(upperCaseWord)) {
				for (int i = 0; i < count; i++) {
					buffer.get(i).add(word);
				}
				continue;
			}
			count++;
			buffer.add(new Vector<String>());
			for (int j = 0; j < count; j++) {
				buffer.get(j).add(word);
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
