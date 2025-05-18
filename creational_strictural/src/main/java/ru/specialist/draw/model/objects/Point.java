package ru.specialist.draw.model.objects;

import ru.specialist.draw.model.interfaces.GraphObject;

import java.util.Objects;

public class Point implements Cloneable, GraphObject {

    private final int x;
    private final int y;
    private String color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        color = DEFAULT_COLOUR;
    }

    public Point(Point point) {
        this(point.x, point.y);
    }

    public void setColour(String colour) {
        this.color = colour;
    }

    @Override
    public void draw() {
        System.out.println(this + String.format(", colour = %s", color));
    }

    @Override
    public Point clone() {
        return new Point(this);
    }

    @Override
    public String toString() {
        return String.format("Draw point x = %s, y = %s", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && Objects.equals(color, point.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }
}
