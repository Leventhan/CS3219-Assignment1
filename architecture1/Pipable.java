package architecture1;

import java.util.Map;

public interface Pipable {
    public void receive(Map<String, String[]> data);
}