package architecture1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class pruneIgnoredFilter extends Filter {

	public pruneIgnoredFilter(Pipe output) {
		super(output);
	}

	@Override
	public Map<String, String[]> transform(Map<String, String[]> data) {
		System.err.println("Pruning ignored sentences.");
		List<String> newTitles = new ArrayList<String>();
		String[] blacklist = data.get("ignored");
		
		for (String sentence : data.get("titles")) {
			String firstWord = sentence.substring(0, sentence.indexOf(' '));
			if(!Arrays.asList(blacklist).contains(firstWord.toLowerCase())) {
				newTitles.add(sentence);
			}
		}
		
		data.put("titles", newTitles.toArray(new String[newTitles.size()]));
		return data;
	}
}