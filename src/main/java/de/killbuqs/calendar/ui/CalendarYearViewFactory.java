package de.killbuqs.calendar.ui;

import java.util.List;

import de.killbuqs.calendar.intf.WeekDay;
import de.killbuqs.calendar.model.CalendarDateInformation;
import de.killbuqs.calendar.model.CalendarMonthYear;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CalendarYearViewFactory {
	/**
	 * Create the table view for this year.
	 * 
	 * @return Returns the created {@link TableView}.
	 */
	public CalendarYearView createTableView() {
		final TableView<CalendarMonthYear> tableView = new TableView<>();
		final TableColumn<CalendarMonthYear, String> tc = new TableColumn<>("Month");
		tc.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getNameForMonth()));
		tableView.getColumns().add(tc);

		final List<WeekDay> valuesInOrder = WeekDay.valuesInOrder();

		int columnIndex = 1; // 1-based
		for (int i = 0; i < 6; i++) {
			for (final WeekDay weekDay : valuesInOrder) {
				final TableColumn<CalendarMonthYear, CalendarDateInformation> tcWeekday = new TableColumn<>(
						weekDay.toShortString());
				createCell(tcWeekday, weekDay);
				tableView.getColumns().add(tcWeekday);
				tcWeekday.setCellValueFactory(createCellValueFactory(columnIndex++, weekDay));
				if (columnIndex > 37) {
					break;
				}
			}
		}
		return new CalendarYearView(tableView);
	}

	/**
	 * Creates a {@link DefaultDateInformationFactory} for the given data.
	 * 
	 * @param columnIndex
	 *            given Column Index.
	 * @param weekDay
	 *            given Weekday.
	 * @return Returns the created {@link DefaultDateInformationFactory}
	 */
	public DefaultDateInformationFactory createCellValueFactory(int columnIndex, final WeekDay weekDay) {
		return new DefaultDateInformationFactory(columnIndex, weekDay);
	}

	/**
	 * Create the cellfactory and set it to the given tablecolumn.
	 * 
	 * @param tablecolumn
	 *            given tablecolumn.
	 * @param theWeekDay
	 *            given {@link WeekDay}.
	 */
	protected void createCell(final TableColumn<CalendarMonthYear, CalendarDateInformation> tablecolumn,
			final WeekDay theWeekDay) {
		tablecolumn.setCellFactory(x -> {
			return createTableCellForWeekDay(theWeekDay);
		});
	}

	/**
	 * Create a {@link TableCell} that can deal with {@link CalendarMonthYear}
	 * as row and {@link CalendarDateInformation} as value.
	 * 
	 * @param theWeekDay
	 *            given
	 * @return returns an implementation of {@link TableCell}
	 */
	public TableCell<CalendarMonthYear, CalendarDateInformation> createTableCellForWeekDay(final WeekDay theWeekDay) {
		return new CalendarTableCell(theWeekDay);
	}

}
