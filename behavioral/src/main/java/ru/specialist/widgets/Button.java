package ru.specialist.widgets;

import ru.specialist.events.Event;
import ru.specialist.events.EventType;

import static java.lang.System.out;

public class Button extends BaseUIElement {

    final static char BUTTON_FRAME = '*';

    public Button(String text) {
        super(text);
    }

    private void printBorder() {
        for (int i = 0; i < getText().length(); i++)
            out.print(BUTTON_FRAME);
    }

    @Override
    public boolean draw(int line) {
        if (line == 0 || line == 2) {
            out.print(BUTTON_FRAME);
            printBorder();
            out.print(BUTTON_FRAME);
            return true;
        }
        if (line == 1) {
            out.print(BUTTON_FRAME);
            out.print(getText());
            out.print(BUTTON_FRAME);
            return true;
        }
        return false;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int getWidth() {
        return getText().length() + 2;
    }

    // событие
    public void press() {
        out.println("Button " + getText() + " pressed");
        handleEvent(new Event(EventType.CLICK));
    }

    @Override
    public void onEvent(Event event) {
    }
}
