package ru.specialist.draw.model.factories;

import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.Line;
import ru.specialist.draw.model.objects.Point;
import ru.specialist.draw.model.objects.TriangleAdapter;

public abstract class AbstractGraphObjectFactory {

    public abstract Point createPoint();

    public abstract Line createLine();

    public abstract Circle createCircle();

    public abstract TriangleAdapter createTriangle();
}
