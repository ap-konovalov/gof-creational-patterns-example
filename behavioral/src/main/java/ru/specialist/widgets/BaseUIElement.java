package ru.specialist.widgets;

import ru.specialist.events.Event;
import ru.specialist.events.EventListener;
import ru.specialist.events.EventType;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseUIElement implements EventListener, UIElement {

    private List<EventListener> listeners = new ArrayList<>();
    protected BaseUIElement parent;
    private String text;

    public BaseUIElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setParent(BaseUIElement parent) {
        this.parent = parent;
    }

    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void handleEvent(Event event) {
        EventType eventType = event.getType();
        System.out.println(
                "Событие: " + eventType + " обрабатывается обработчиком " + getClass().getSimpleName() + " \"" + getText() + "\"");

        for (EventListener listener : listeners) {
            System.out.println("У подписчика " + listener.getClass().getSimpleName() + " вызван метод onEvent с событием " + eventType);
            listener.onEvent(event);
        }

        System.out.println("Оповещение подписчиков окончено.");
        System.out.println("Пытаемся передать событие в обработку родительскому классу.");

        if (parent != null) {
            System.out.println("У элемента есть родитель: " + parent.getText() + ". Передаем ему на обработку событие " + eventType);
            parent.handleEvent(event);
        } else {
            System.out.println("У элемента нет родителей. Обработка события завершена.");
        }
    }

    public abstract boolean draw(int line);

    public abstract int getHeight();

    public abstract int getWidth();
}
