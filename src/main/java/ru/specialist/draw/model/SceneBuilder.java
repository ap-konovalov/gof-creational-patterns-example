package ru.specialist.draw.model;

import ru.specialist.draw.model.factories.BWGraphObjectFactory;
import ru.specialist.draw.model.factories.ColourGraphObjectFactory;
import ru.specialist.draw.model.interfaces.Builder;

public class SceneBuilder implements Builder {

    private static final ColourGraphObjectFactory COLOUR_GRAPH_OBJECT_FACTORY = new ColourGraphObjectFactory();
    private static final BWGraphObjectFactory BW_GRAPH_OBJECT_FACTORY = new BWGraphObjectFactory();

    @Override
    public SceneBuilder withBWPoint() {
        BW_GRAPH_OBJECT_FACTORY.createPoint();
        return this;
    }

    @Override
    public SceneBuilder withColourPoint() {
        COLOUR_GRAPH_OBJECT_FACTORY.createPoint();
        return this;
    }

    @Override
    public SceneBuilder withBWLine() {
        BW_GRAPH_OBJECT_FACTORY.createLine();
        return this;
    }

    @Override
    public SceneBuilder withColourLine() {
        COLOUR_GRAPH_OBJECT_FACTORY.createLine();
        return this;
    }

    @Override
    public SceneBuilder withBWCircle() {
        BW_GRAPH_OBJECT_FACTORY.createCircle();
        return this;
    }

    @Override
    public SceneBuilder withColourCircle() {
        COLOUR_GRAPH_OBJECT_FACTORY.createCircle();
        return this;
    }

    @Override
    public void reset() {
        Scene.getInstance().reset();
    }

    @Override
    public Scene build() {
        return Scene.getInstance();
    }
}
