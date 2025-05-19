package ru.specialist.draw.model.exports;

import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.Point;

public class XMLExportVisitor implements ExportVisitor {

    @Override
    public void exportPoint(Point p) {
        System.out.println(String.format("<Point x=\"%d\" y=\"%d\" color=\"%s\" />", p.getX(), p.getY(), p.getColor()));
    }

    @Override
    public void exportCircle(Circle c) {
        System.out.println(String.format("<Circle cx=\"%d\" cy=\"%d\" radius=\"%d\" color=\"%s\" />",
                                         c.getCenter().getX(), c.getCenter().getY(), c.getRadius(), c.getColour()));
    }
}
