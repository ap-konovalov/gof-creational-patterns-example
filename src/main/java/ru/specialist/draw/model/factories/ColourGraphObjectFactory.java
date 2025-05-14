package ru.specialist.draw.model.factories;

import ru.specialist.draw.model.GraphObjectPrototypeRegistry;
import ru.specialist.draw.model.Scene;
import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.Line;
import ru.specialist.draw.model.objects.Point;

public class ColourGraphObjectFactory extends AbstractGraphObjectFactory {

    private static final Scene SCENE = Scene.getInstance();
    GraphObjectPrototypeRegistry registry = GraphObjectPrototypeRegistry.initPrototypes();

    @Override
    public Point createPoint() {
        Point redPoint = (Point) registry.getGraphObject("point");
        redPoint.setColour("red");
        SCENE.add(redPoint); // hook
        return redPoint;
    }

    @Override
    public Line createLine() {
        Line greenLine =  (Line) registry.getGraphObject("line");
        greenLine.setColour("green");
        SCENE.add(greenLine); // hook
        return greenLine;
    }

    @Override
    public Circle createCircle() {
        Circle orangeCircle = (Circle) registry.getGraphObject("circle");
        orangeCircle.setColour("orange");
        SCENE.add(orangeCircle); // hook
        return orangeCircle;
    }
}
