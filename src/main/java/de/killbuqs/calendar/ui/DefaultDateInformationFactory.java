package de.killbuqs.calendar.ui;

import de.killbuqs.calendar.intf.WeekDay;
import de.killbuqs.calendar.model.CalendarDateInformation;
import de.killbuqs.calendar.model.CalendarMonthYear;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

/**
 * Implementation for showing values for a calendar in a table column.
 */
public class DefaultDateInformationFactory implements
		Callback<CellDataFeatures<CalendarMonthYear, CalendarDateInformation>, ObservableValue<CalendarDateInformation>> {
	/** 1-based index of the column. */
	private final int columnIndex;

	/**   */
	private final WeekDay weekDay;

	/**
	 * Constructor.
	 *
	 * @param theColumnIndex
	 *            given 1-based index of the column.
	 * @param theWeekDay
	 *            the given week day.
	 */
	public DefaultDateInformationFactory(final int theColumnIndex, final WeekDay theWeekDay) {
		columnIndex = theColumnIndex;
		weekDay = theWeekDay;
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ObservableValue<CalendarDateInformation> call(
			final CellDataFeatures<CalendarMonthYear, CalendarDateInformation> c) {
		final Integer value = c.getValue().getDayForIndex(columnIndex);
		if (value != null) {
			final CalendarDateInformation dateInformation = createDateInformation(c.getValue(), value);
			return new ReadOnlyObjectWrapper<>(dateInformation);
		}
		return null;
	}

	/**
	 * Create a {@link CalendarDateInformation} for the given parameters.
	 * 
	 * @param calendarMonthYear
	 *            given {@link CalendarMonthYear}
	 * @param date
	 *            given date of the given {@link CalendarMonthYear}
	 * @return Returns the created {@link CalendarDateInformation}
	 */
	public CalendarDateInformation createDateInformation(
			final CalendarMonthYear calendarMonthYear,
			final Integer date) {
		return new CalendarDateInformation(calendarMonthYear, date, null);
	}


}