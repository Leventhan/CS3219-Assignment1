package architecture1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class circularShiftFilter extends Filter {
	public circularShiftFilter(Pipe output) {
		super(output);
	}

	@Override
	public Map<String, String[]> transform(Map<String, String[]> data) {
		System.err.println("Circular Shifting sentences.");
		List<String> newTitles = new ArrayList<String>();
		for (String sentence : data.get("titles")) {
			List<String> newSentences = shift(sentence);
		    newTitles.addAll(newSentences);
		}

		data.put("titles", newTitles.toArray(new String[newTitles.size()]));
		return data;
	}
	
	public List<String> shift(String sentence){
		List<String> sentences = new ArrayList<String>();
		String[] words = sentence.split("\\s+");
		for (String word : words) {
			sentences.add(sentence);
			String removedWord = sentence.substring(0, sentence.indexOf(' '));
			sentence = sentence.substring(sentence.indexOf(' ') + 1);
			sentence = sentence + " " + removedWord;
		}
		
		return sentences;
	}
}