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
		Vector<Vector<String>> buffer = new Vector<Vector<String>>();
		processShiftedLines(tokenizer, buffer);
		insertShiftedLines(buffer);
	}

	private void insertShiftedLines(Vector<Vector<String>> buffer) {
		for (int x = 0; x < buffer.size(); x++) {
			String shiftedLine = "";
			if (isIgnored(buffer.get(x).get(0), ignoredList)) {
				continue;
			}
			for (int y = 0; y < buffer.get(x).size(); y++) {
				if (y == 0) {
					shiftedLine = shiftedLine.concat(" " + buffer.get(x).get(y).toUpperCase());
				}
				else {
					shiftedLine = shiftedLine.concat(" " + buffer.get(x).get(y).toLowerCase());
				}
			}
			shiftedLine = shiftedLine.substring(1);
			target.insertLine(shiftedLine);
		}
	}

	private void processShiftedLines(StringTokenizer tokenizer,
			Vector<Vector<String>> buffer) {
		int count = 0;
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			count++;
			buffer.add(new Vector<String>());
			addWord(count, buffer, word);
		}
		for (int k = 1; k < buffer.size(); k++) {
			int amount = buffer.get(0).size() - buffer.get(k).size();
			for (int l = 0; l < amount; l++) {
				buffer.get(k).add(buffer.get(0).get(l));
			}
		}
	}

	private boolean isIgnored(String word, List<String> ignoredList) {
		String lowerCaseWord = word.toLowerCase();
		String upperCaseWord = word.toUpperCase();
		String capitalWord = word.substring(0,1).toUpperCase().concat(word.substring(1));
		
		if (ignoredList.contains(word) || ignoredList.contains(lowerCaseWord) || 
				ignoredList.contains(capitalWord) || ignoredList.contains(upperCaseWord)) {
			return true;
		}
		return false;
	}

	private void addWord(int count, Vector<Vector<String>> buffer, String word) {
		for (int i = 0; i < count; i++) {
			buffer.get(i).add(word);
		}
	}
}
