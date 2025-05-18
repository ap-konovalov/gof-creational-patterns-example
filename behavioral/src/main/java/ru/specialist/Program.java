package ru.specialist;

import ru.specialist.handlers.FormSubmitHandler;
import ru.specialist.widgets.Button;
import ru.specialist.widgets.CompositeControl;
import ru.specialist.widgets.Label;
import ru.specialist.widgets.MainWindow;

public class Program {

    public static void main(String[] args) {

        CompositeControl mainWindow = new MainWindow("Main window");
        CompositeControl loginFrame = new CompositeControl("Login frame");
        CompositeControl passwordFrame = new CompositeControl("Password frame");
        CompositeControl printFrame = new CompositeControl("Print frame");

        Label loginLabel = new Label("Login");
        Label passwordLabel = new Label("Password");
        Button okButton = new Button("OK");
        Button verifyButton = new Button("Verify");
        Button printButton = new Button("Print");

        loginFrame.add(loginLabel)
              .add(okButton);
        passwordFrame.add(passwordLabel)
              .add(verifyButton);
        printFrame.add(printButton);
        mainWindow.add(loginFrame)
                  .add(passwordFrame)
                  .add(printFrame);

        okButton.addListener(new FormSubmitHandler());

        mainWindow.draw();
        okButton.press();
    }
}
