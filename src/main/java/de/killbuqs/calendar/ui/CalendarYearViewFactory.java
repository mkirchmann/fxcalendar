package de.killbuqs.calendar.ui;

import java.util.Calendar;
import java.util.List;

import de.killbuqs.calendar.intf.WeekDay;
import de.killbuqs.calendar.model.CalendarDateInformation;
import de.killbuqs.calendar.model.CalendarMonthYear;
import javafx.beans.property.ReadOnlyStringWrapper;
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
	 * create the cellfactory and set it to the given tablecolumn.
	 * 
	 * @param tablecolumn
	 *            given tablecolumn.
	 * @param theWeekDay
	 *            given weekday as {@link Calendar#MONDAY} ,
	 *            {@link Calendar#TUESDAY}, {@link Calendar#WEDNESDAY},
	 *            {@link Calendar#THURSDAY}, {@link Calendar#FRIDAY},
	 *            {@link Calendar#SATURDAY} or {@link Calendar#SUNDAY}.
	 */
	protected void createCell(final TableColumn<CalendarMonthYear, CalendarDateInformation> tablecolumn,
			final WeekDay theWeekDay) {
		tablecolumn.setCellFactory(x -> {
			return new CalendarTableCell(theWeekDay);
		});
	}

}
