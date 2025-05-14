package ru.specialist.draw.model;

import ru.specialist.draw.model.factories.AbstractGraphObjectFactory;
import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.Line;
import ru.specialist.draw.model.objects.Point;

public class BlackGraphObjectFactory extends AbstractGraphObjectFactory {

    GraphObjectPrototypeRegistry registry = GraphObjectPrototypeRegistry.initPrototypes();

    @Override
    public Point createPoint() {
        Point redPoint = (Point) registry.getGraphObject("point");
        Scene.getInstance().add(redPoint);
        return redPoint;
    }

    @Override
    public Line createLine() {
        Line greenLine =  (Line) registry.getGraphObject("line");
        Scene.getInstance().add(greenLine);
        return greenLine;
    }

    @Override
    public Circle createCircle() {
        Circle orangeCircle = (Circle) registry.getGraphObject("circle");
        Scene.getInstance().add(orangeCircle);
        return orangeCircle;
    }
}
