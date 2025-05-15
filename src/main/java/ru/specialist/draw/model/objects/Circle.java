package ru.specialist.draw.model.objects;

import java.util.Objects;

public class Circle   implements Cloneable, GraphObject {

    private final Point center;
    private final int radius;
    private String colour;

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.colour = DEFAULT_COLOUR;
    }

    public Circle(Circle circle) {
        this(circle.center, circle.radius);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw circle: %s, radus = %s, colour = %s", center, radius,  colour));
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(center, circle.center) && Objects.equals(colour, circle.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, colour);
    }
}
