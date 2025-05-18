package ru.specialist.widgets;

import ru.specialist.events.Event;

public class Label extends BaseUIElement {

    public Label(String text) {
        super(text);
    }

    @Override
    public boolean draw(int line) {
        if (line == 0) {
            System.out.printf(" %s ", getText());
            return true;
        }
        return false;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return getText().length() + 2;
    }

    @Override
    public void onEvent(Event event) {
    }
}
