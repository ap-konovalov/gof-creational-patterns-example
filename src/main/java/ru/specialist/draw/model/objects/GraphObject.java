package ru.specialist.draw.model.objects;

public abstract class GraphObject implements Cloneable {

    protected static final String DEFAULT_COLOUR = "black";

    public abstract void draw();

    @Override
    public GraphObject clone() {
        try {
            return (GraphObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
