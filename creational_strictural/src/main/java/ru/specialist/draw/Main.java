package ru.specialist.draw;

import ru.specialist.draw.model.GraphObjectPrototypeRegistry;
import ru.specialist.draw.model.SceneBuilder;
import ru.specialist.draw.model.exports.XMLExportVisitor;
import ru.specialist.draw.model.facades.SceneFacadeImpl;
import ru.specialist.draw.model.factories.BWGraphObjectFactory;
import ru.specialist.draw.model.Scene;
import ru.specialist.draw.model.objects.Circle;
import ru.specialist.draw.model.objects.CompositeShape;
import ru.specialist.draw.model.objects.Point;
import ru.specialist.draw.model.objects.PaintedOverDecorator;


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
        scene.reset();

        System.out.println("########### Decorator ###########");
        PaintedOverDecorator circle = new PaintedOverDecorator(new Circle(new Point(3, 4), 4));
        circle.paintOver();

        System.out.println("########### Facade ###########");
        SceneFacadeImpl sceneFacade = new SceneFacadeImpl();
        sceneFacade.drawNewScene("P 0 0", "P 3 2");

        System.out.println("########### Visitor ###########");
        Scene.getInstance().export(new XMLExportVisitor());
    }
}