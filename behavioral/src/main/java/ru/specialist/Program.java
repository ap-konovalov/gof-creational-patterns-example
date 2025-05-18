package ru.specialist;

import ru.specialist.widgets.Button;
import ru.specialist.widgets.CompositeControl;
import ru.specialist.widgets.Label;
import ru.specialist.widgets.MainWindow;

public class Program {

    public static void main(String[] args) {

        CompositeControl mainWin = new MainWindow();
        CompositeControl frame1 = new CompositeControl();
        CompositeControl frame2 = new CompositeControl();
        frame1.add(new Label("Login")).add(new Button("OK"));
        frame2.add(new Label("Password")).add(new Button("Verify"));
        Button printButton = new Button("Print");
        mainWin.add(frame1).add(frame2).add(new CompositeControl().add(printButton));

        mainWin.addPressListener(
                (s, e) -> System.out.println("MainWin handler"));
        printButton.addPressListener(
                (s, e) ->
                {
                    System.out.println("Button press first handler");
                });

        // ��������� ����
        mainWin.draw();
        printButton.addPressListener(
                (s, e) -> System.out.println("Button press second handler"));

        printButton.press();
    }
}
