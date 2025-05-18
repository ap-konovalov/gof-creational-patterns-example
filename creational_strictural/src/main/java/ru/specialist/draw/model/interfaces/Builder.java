package ru.specialist.draw.model.interfaces;

import ru.specialist.draw.model.Scene;
import ru.specialist.draw.model.SceneBuilder;

public interface Builder {

    SceneBuilder withBWPoint();

    SceneBuilder withColourPoint();

    SceneBuilder withBWLine();

    SceneBuilder withColourLine();

    SceneBuilder withBWCircle();

    SceneBuilder withColourCircle();

    void reset();

    Scene build();
}
