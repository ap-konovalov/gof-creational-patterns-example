package ru.specialist.handlers;

import ru.specialist.events.Event;
import ru.specialist.events.EventListener;
import ru.specialist.events.EventType;

public class FormSubmitHandler implements EventListener {

    @Override
    public void onEvent(Event event) {
        if (event.getType().equals(EventType.CLICK)) {
            System.out.println(getClass().getSimpleName() + " обрабатывает событие " + event.getType());
            System.out.println("✅ Форма отправлена");
        }
    }
}
