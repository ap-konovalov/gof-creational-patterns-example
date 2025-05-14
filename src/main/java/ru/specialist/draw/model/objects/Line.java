package ru.specialist.draw.model.objects;

import java.util.Objects;

public class Line extends GraphObject implements Cloneable {

    private Point start;
    private Point end;
    private String colour;

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.colour = DEFAULT_COLOUR;
    }

    public Line(Line line) {
        this(line.start, line.end);
    }

    @Override
    public void draw() {
        System.out.println("Draw line: " + start + " " + end + " " + colour);
    }

    @Override
    public Line clone() {
        return new Line(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end) && Objects.equals(colour,
                                                                                                    line.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, colour);
    }
}
