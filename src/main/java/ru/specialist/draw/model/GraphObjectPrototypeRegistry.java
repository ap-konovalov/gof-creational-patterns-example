package ru.specialist.draw.model;

import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.interfaces.GraphObject;
import ru.specialist.draw.model.objects.Line;
import ru.specialist.draw.model.objects.Point;

import java.util.HashMap;
import java.util.Map;

// Prototype pattern
public class GraphObjectPrototypeRegistry {

    private final Map<String, GraphObject> prototypes = new HashMap<>();

    public void addGraphObject(String key, GraphObject graphObject) {
        prototypes.put(key, graphObject);
    }

    public GraphObject getGraphObject(String key) {
        GraphObject graphObject = prototypes.get(key);
        if (graphObject == null) {
            throw new IllegalArgumentException("Фигура не найдена");
        }
        return (GraphObject) graphObject.clone();
    }

    public static GraphObjectPrototypeRegistry initPrototypes() {
        GraphObjectPrototypeRegistry registry = new GraphObjectPrototypeRegistry();
        registry.addGraphObject("point", new Point(0, 0));
        registry.addGraphObject("line", new Line(new Point(0, 0), new Point(14, 17)));
        registry.addGraphObject("circle", new Circle(new Point(5, 5), 5));
        return registry;
    }
}
