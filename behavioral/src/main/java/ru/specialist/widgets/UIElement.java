package ru.specialist.widgets;

import ru.specialist.events.Event;
import ru.specialist.events.EventListener;

public interface UIElement {

    void addListener(EventListener listener);

    void removeListener(EventListener listener);

    void handleEvent(Event event);
}