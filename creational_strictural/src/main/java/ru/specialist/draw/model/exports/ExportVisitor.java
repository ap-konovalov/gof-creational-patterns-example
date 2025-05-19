package ru.specialist.draw.model.exports;

import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.Point;

public interface ExportVisitor {

    void exportPoint(Point p);

    void exportCircle(Circle c);
}
