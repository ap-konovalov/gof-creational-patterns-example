package ru.specialist.draw.model.objects;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements GraphObject {

    private List<GraphObject> children = new ArrayList<>();
    ;

    public List<GraphObject> getChildren() {
        return children;
    }

    public CompositeShape add(GraphObject object) {
        children.add(object);
        return this;
    }

    public void remove(GraphObject object) {
        children.remove(object);
    }

    @Override
    public void draw() {
        children.stream().peek(o -> o.draw());
    }

    @Override
    public CompositeShape clone() {
        CompositeShape cloned = new CompositeShape();
        children.stream().peek(o -> cloned.add((GraphObject) o.clone()));
        return cloned;
    }

    @Override
    public void setColour(String colour) {
        children.forEach(o -> o.setColour(colour));
    }
}
