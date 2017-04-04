package de.killbuqs.calendar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.killbuqs.calendar.intf.ICalendarEntry;

/**
 * Information for one date in a calendar containing date and entries.
 */

public class CalendarDateInformation {
	private final List<ICalendarEntry> calendarEntries = new ArrayList<>();

	private final CalendarMonthYear calendarMonthYear;

	private final int day;

	/**
	 *
	 * Constructor.
	 *
	 * @param theCalendarMonthYear
	 *            given {@link CalendarMonthYear}
	 * @param theDay
	 *            given day.
	 * @param entries
	 *            given {@link Collection} of {@link ICalendarEntry}
	 */
	public CalendarDateInformation(final CalendarMonthYear theCalendarMonthYear, final int theDay,
			final Collection<ICalendarEntry> entries) {
		calendarMonthYear = theCalendarMonthYear;
		this.day = theDay;
		setEntries(entries);
	}

	/**
	 * Whether this item contains a public holiday.
	 *
	 * @return returns <code>true</code> if it contains a public holiday,
	 *         <code>false</code> otherwise.
	 */
	public boolean containsPublicHoliday() {
		return calendarEntries.stream().filter(ICalendarEntry::isPublicHoliday).findFirst().isPresent();
	}

	/**
	 * @return the {@link #calendarEntries}
	 */
	public List<ICalendarEntry> getCalendarEntries() {
		return Collections.unmodifiableList(calendarEntries);
	}

	/**
	 *
	 * @return
	 */
	public int getDate() {
		return day;
	}

	/**
	 *
	 * @param theEntries
	 */
	private void setEntries(final Collection<ICalendarEntry> theEntries) {
		calendarEntries.clear();
		if (theEntries != null) {
			calendarEntries.addAll(theEntries);
		}
	}

	public CalendarMonthYear getCalendarMonthYear() {
		return calendarMonthYear;
	}

}
