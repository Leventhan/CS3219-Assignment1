package architecture1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class titleizeFilter extends Filter {

	public titleizeFilter(Pipe output) {
		super(output);
	}

	@Override
	public Map<String, String[]> transform(Map<String, String[]> data) {
		List<String> newTitles = new ArrayList<String>();
		for (String sentence : data.get("titles")) {
		    newTitles.add(titleize(sentence));
		}

		data.put("titles", newTitles.toArray(new String[newTitles.size()]));
		return data;
	}

	public String titleize(String str){
		int spaceIndex = str.indexOf(' ');
		return str.substring(0, spaceIndex).toUpperCase() + str.substring(spaceIndex).toLowerCase();
	}
}
