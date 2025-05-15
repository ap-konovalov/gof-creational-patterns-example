package ru.specialist.draw.model.objects;

public class PaintedOverDecorator implements GraphObject {

    private GraphObject graphObject;

    public PaintedOverDecorator(GraphObject object) {
        this.graphObject = object;
    }

    @Override
    public void draw() {
        graphObject.draw();
    }

    @Override
    public PaintedOverDecorator clone() {
        return new PaintedOverDecorator((GraphObject) graphObject.clone());
    }

    @Override
    public void setColour(String colour) {
        graphObject.setColour(colour);
    }

    public void paintOver() {
        System.out.println(graphObject.getClass().getSimpleName() + " painted over");
    }
}
