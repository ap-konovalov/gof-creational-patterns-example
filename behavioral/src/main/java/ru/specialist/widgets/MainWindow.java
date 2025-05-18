package ru.specialist.widgets;

public class MainWindow extends CompositeControl {

	public MainWindow(String text) {
		super(text);
	}

	@Override
	public void drawLineFinish() {
		super.drawLineFinish();
		System.out.println();
	}
}
