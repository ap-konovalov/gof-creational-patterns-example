package ru.specialist.events;

@FunctionalInterface
public interface EventListener {
    void onEvent(Event event);
}