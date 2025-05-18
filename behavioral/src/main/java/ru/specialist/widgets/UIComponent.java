package ru.specialist.widgets;

import java.util.ArrayList;
import java.util.List;

import ru.specialist.events.EventRequest;
import ru.specialist.events.Handler;
import ru.specialist.events.PressListener;

// ����� ����� ��c������ � ���� BaseHandler
public abstract class UIComponent implements Handler{
	
	private Handler nextHandler;
	
	private List<PressListener> listeners =
			new ArrayList<PressListener>();
	
	public abstract boolean draw(int line);
	public abstract int getHeight();
	public abstract int getWidth();
	
	@Override
	public void setNextHandler(Handler next) {
		nextHandler = next;
	}
	
	public void addPressListener(PressListener l) {
		listeners.add(l);
	}
	
	public void removePressListener(PressListener l) {
		listeners.remove(l);
	}
	
	@Override
	public void handle(EventRequest request) {
		//System.out.printf("Handle event in %s\n", this);

		
		// raise event
		for(PressListener l : listeners) {
			if (request.isHandled()) return;

			l.press(this, request);
		}
		
		if (nextHandler != null)
			nextHandler.handle(request);
			
	}

}
