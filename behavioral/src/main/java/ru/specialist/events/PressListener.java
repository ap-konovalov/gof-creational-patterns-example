package ru.specialist.events;

@FunctionalInterface
public interface PressListener {
	
	void press(Object sender, EventRequest e);

}
