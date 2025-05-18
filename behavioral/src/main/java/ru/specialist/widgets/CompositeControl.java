package ru.specialist.widgets;

import ru.specialist.events.Event;
import ru.specialist.events.EventType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class CompositeControl extends BaseUIElement {

    protected final static char COMPOSITE_FRAME = '+';
    protected List<BaseUIElement> children = new ArrayList<>();

    public CompositeControl(String text) {
        super(text);
    }

    public CompositeControl add(BaseUIElement uiElement) {
        children.add(uiElement);
        uiElement.setParent(this);
        uiElement.addListener(this);
        return this;
    }

    public void remove(BaseUIElement c) {
        children.remove(c);
    }

    public List<BaseUIElement> getChildren() {
        return children;
    }

    public void draw() {
        for (int i = 0; i < getHeight(); i++)
            draw(i);
    }

    private void printBorder() {
        for (int i = 0; i < getWidth() - 1; i++)
            out.print(COMPOSITE_FRAME);
    }

    @Override
    public boolean draw(int line) {
        if (line == 0 || line == getHeight() - 1) {
            printBorder();
            drawLineFinish();
            return true;
        }
        if (line > 0 && line < getHeight() - 1) {
            out.print(COMPOSITE_FRAME);
            for (BaseUIElement c : children)
                if (!c.draw(line - 1))
                    for (int i = 0; i < c.getWidth(); i++)
                        out.print(' ');
            drawLineFinish();
            return true;
        }
        return false;
    }

    public void drawLineFinish() {
        out.print(COMPOSITE_FRAME);
    }

    @Override
    public int getHeight() {
        int max = 0;
        for (BaseUIElement c : children)
            if (c.getHeight() > max)
                max = c.getHeight();
        return max + 2;
    }

    @Override
    public int getWidth() {
        int summa = 0;
        for (BaseUIElement c : children)
            summa += c.getWidth();
        return summa + 2;
    }

    public void setParent(BaseUIElement parent) {
        this.parent = parent;
    }

    @Override
    public void onEvent(Event event) {
        if(event.getType().equals(EventType.CLICK) && getClass().getSimpleName().equals("MainWindow")){
            out.println("Выполнился специальный обработчик события CLICK для класса MainWindow");
        } else {
            out.println("Обработка события " + event.getType() + " не предусмотрена в классе " + getClass().getSimpleName());
        }

    }
}
