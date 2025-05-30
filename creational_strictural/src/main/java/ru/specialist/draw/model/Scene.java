package ru.specialist.draw.model;

import ru.specialist.draw.model.exports.ExportVisitor;
import ru.specialist.draw.model.exports.Exportable;
import ru.specialist.draw.model.interfaces.GraphObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Singleton pattern
// Facade pattern
public class Scene {

    private static Set<GraphObject> graphObjects;
    private volatile static Scene instance;

    private Scene() {
        graphObjects = new HashSet<>();
    }

    public void reset() {
        graphObjects = new HashSet<>();
    }

    public void add(GraphObject object) {
        graphObjects.add(object);
    }

    public static Scene getInstance() {
        if (instance == null) {
            synchronized (Scene.class) {
                if (instance == null) {
                    instance = new Scene();
                }
            }
        }
        return instance;
    }

    public void draw() {
        graphObjects.forEach(GraphObject::draw);
    }

    public void export(ExportVisitor visitor) {
        Iterator<GraphObject> iterator = graphObjects.iterator();
        System.out.println("<Scene>");
        while (iterator.hasNext()) {
            GraphObject g = iterator.next();
            if (g instanceof Exportable) {
                ((Exportable) g).accept(visitor);
            }
        }
        System.out.println("</Scene>");
    }
}
