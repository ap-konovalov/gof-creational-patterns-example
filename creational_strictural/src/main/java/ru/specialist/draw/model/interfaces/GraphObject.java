package ru.specialist.draw.model.interfaces;

public interface GraphObject<T> {

    String DEFAULT_COLOUR = "black";

    void draw();

    T clone();

    void setColour(String colour);
}
