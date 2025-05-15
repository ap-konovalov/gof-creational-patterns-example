package ru.specialist.draw.model.objects;

public class TriangleAdapter implements GraphObject {

    private final Triangle triangle;
    private String colour;

    public TriangleAdapter(Triangle triangle) {
        this.triangle = triangle;
        this.colour = DEFAULT_COLOUR;
    }

    public TriangleAdapter(TriangleAdapter triangleAdapter) {
        this(triangleAdapter.triangle);
    }

    @Override
    public TriangleAdapter clone() {
        return new TriangleAdapter(this);
    }

    @Override
    public void draw() {
        System.out.println("Draw triangle " + triangle.getCoordinates() + " colour = " + colour);
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }
}
