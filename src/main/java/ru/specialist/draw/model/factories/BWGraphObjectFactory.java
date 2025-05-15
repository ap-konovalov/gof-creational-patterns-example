package ru.specialist.draw.model.factories;

import ru.specialist.draw.model.Scene;
import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.Line;
import ru.specialist.draw.model.objects.Point;
import ru.specialist.draw.model.objects.Triangle;
import ru.specialist.draw.model.objects.TriangleAdapter;

public class BWGraphObjectFactory extends AbstractGraphObjectFactory {

    private static final Scene SCENE = Scene.getInstance();

    @Override
    public Point createPoint() {
        Point blackPoint = new Point(10, 5);
        SCENE.add(blackPoint); // hook
        return blackPoint;
    }

    @Override
    public Line createLine() {
        Line blackLine = new Line(new Point(4,6), new Point(6,10));
        SCENE.add(blackLine); // hook
        return blackLine;
    }

    @Override
    public Circle createCircle() {
        Circle blackCircle = new Circle(new Point(10,5), 6);
        SCENE.add(blackCircle); // hook
        return blackCircle;
    }

    @Override
    public TriangleAdapter createTriangle() {
        TriangleAdapter triangle = new TriangleAdapter(new Triangle(1, 1, 5, 6, 7, 12));
        SCENE.add(triangle);
        return triangle;
    }
}
