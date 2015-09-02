package architecture2.model;

import java.util.Vector;

import architecture2.components.Observer;

public interface ObservedLineStorage {
	public void insertLine(String line);
	public Vector<String> getLines();
	public String getLine();
	public void addObserver(Observer o);
}
