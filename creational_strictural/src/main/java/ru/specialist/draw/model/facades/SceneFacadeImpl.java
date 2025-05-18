package ru.specialist.draw.model.facades;

import ru.specialist.draw.model.Scene;
import ru.specialist.draw.model.objects.Point;

public class SceneFacadeImpl implements SceneFacade {

    private final static Scene SCENE = Scene.getInstance();

    @Override
    public void drawNewScene(String... graphicObjects) {
        SCENE.reset();
        for (String object : graphicObjects) {
            String[] params = object.split(" ");
            String objectType = params[0];
            switch (objectType) {
                case "P":
                    int x = Integer.parseInt(params[1]);
                    int y = Integer.parseInt(params[2]);
                    Point p = new Point(x, y);
                    SCENE.add(p);
                    break;
                default:
                    System.out.println("Object not supported: " + object);
            }
        }
        SCENE.draw();
    }
}
