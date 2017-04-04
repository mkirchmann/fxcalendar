package de.killbuqs.calendar;

import de.killbuqs.calendar.ui.CalendarYearView;
import de.killbuqs.calendar.ui.CalendarYearViewFactory;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demo application for {@link CalendarYearView}
 * 
 * @author Michael
 *
 */
public class CalendarYearViewDemoApplication extends Application {
    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
		primaryStage.setTitle("Calendar Demo");

        final StackPane root = new StackPane();

		CalendarYearViewFactory calendarYearViewFactory = new CalendarYearViewFactory();
		final CalendarYearView tableView = calendarYearViewFactory.createTableView();
		tableView.setYear(year);
		Node center = tableView.getTableView();
		Node top = null;
		Button nextYear = new Button(">");
		nextYear.setOnAction(x -> tableView.setYear(++year));
		Node right = nextYear;

		Node bottom = null;
		Button previousYear = new Button("<");
		previousYear.setOnAction(x -> tableView.setYear(--year));
		Node left = previousYear;
		BorderPane borderPane = new BorderPane(center, top, right, bottom, left);
		root.getChildren().add(borderPane);
		primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

	int year = 2017;

}