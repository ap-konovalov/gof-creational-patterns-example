package ru.specialist.draw.model.objects;

public class Triangle {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final int x3;
    private final int y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public String getCoordinates() {
        return String.format("A(%s,%s), B(%s,%s),C(%s,%s)", x1,y1,x2,y2,x3,y3);
    }
}
