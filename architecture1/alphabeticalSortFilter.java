package architecture1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class alphabeticalSortFilter extends Filter {

	public alphabeticalSortFilter(Pipe output) {
		super(output);
	}

	@Override
	public Map<String, String[]> transform(Map<String, String[]> data) {
		System.err.println("Sorting sentences alphabetically.");
		List<String> newTitles = Arrays.asList(data.get("titles"));
		java.util.Collections.sort(newTitles);
		data.put("titles", newTitles.toArray(new String[newTitles.size()]));
		return data;
	}
}