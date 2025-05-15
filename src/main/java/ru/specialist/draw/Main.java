package ru.specialist.draw;

import ru.specialist.draw.model.GraphObjectPrototypeRegistry;
import ru.specialist.draw.model.SceneBuilder;
import ru.specialist.draw.model.factories.BWGraphObjectFactory;
import ru.specialist.draw.model.Scene;
import ru.specialist.draw.model.objects.CompositeShape;


public class Main {


    public static void main(String[] args) {

        System.out.println("########### Builder ###########");
        Scene scene = new SceneBuilder()
                .withBWPoint()
                .withColourCircle()
                .build();
        scene.draw();
        scene.reset();

        System.out.println("########### Factory ###########");
        BWGraphObjectFactory bwGraphObjectFactory = new BWGraphObjectFactory();
        scene.add(bwGraphObjectFactory.createPoint());
        scene.add(bwGraphObjectFactory.createTriangle());
        scene.draw();
        scene.reset();

        System.out.println("########### Prototype ###########");
        GraphObjectPrototypeRegistry registry = GraphObjectPrototypeRegistry.initPrototypes();
        scene.add(registry.getGraphObject("line"));
        scene.draw();
        scene.reset();

        System.out.println("########### Composite ###########");
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.add(bwGraphObjectFactory.createTriangle())
                      .add(bwGraphObjectFactory.createPoint())
                      .setColour("white");
        scene.add(compositeShape);
        scene.draw();
    }
}