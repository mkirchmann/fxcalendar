package de.killbuqs.calendar.ui;

import java.util.ArrayList;
import java.util.List;

import de.killbuqs.calendar.intf.Month;
import de.killbuqs.calendar.model.CalendarMonthYear;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;

/**
 * Calendar View holding a table to display a year in very compact way.
 * 
 * @author Michael
 *
 */
public class CalendarYearView {
	public CalendarYearView(TableView<CalendarMonthYear> theTableView) {
		tableView = theTableView;
	}

	private final TableView<CalendarMonthYear> tableView;

	public TableView<CalendarMonthYear> getTableView() {
		return tableView;
	}

	private List<CalendarMonthYear> createListOfMonth(final int year) {
		final List<CalendarMonthYear> values = new ArrayList<>();
		for (Month m : Month.listAllMonth()) {
			values.add(new CalendarMonthYear(year, m));
		}
		return values;
	}

	/**
	 * Set the year for the table to the given year.
	 * 
	 * @param year
	 *            given year.
	 */
	public void setYear(final int year) {
		final List<CalendarMonthYear> listOfMonth = createListOfMonth(year);
		tableView.setItems(FXCollections.observableList(listOfMonth));
		tableView.getColumns().get(0).setText(Integer.toString(year));
	}
}
