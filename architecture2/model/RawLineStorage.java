package architecture2.model;
import java.util.Vector;

import architecture2.components.Observer;

public class RawLineStorage implements ObservedLineStorage {
	private Vector<String> lineStore;
	private Vector<Observer> observers;
	
	public RawLineStorage() {
		lineStore = new Vector<String>();
		observers = new Vector<Observer>();
	}
	
	public void insertLine(String line) {
		lineStore.add(line);
		notifyObservers();
	}
	
	public String getLine() {
		return lineStore.remove(0);
	}
	
	public Vector<String> getLines() {
		return lineStore;
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	private void notifyObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}
}
