package de.killbuqs.calendar.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import de.killbuqs.calendar.intf.Month;
import de.killbuqs.calendar.intf.WeekDay;

/**
 * Month and Year representation to fit into a table.
 */

public class CalendarMonthYear {

	private final int dayOfWeek;

	private final int days;

	private final Month month;

	private final String nameForMonth;

	private final WeekDay weekDayforCalendarEquivalent;

    /**
     *
     * @param theCalendar
     * @return
     */
    public static int getDaysForMonth(final Calendar theCalendar) {
        final Calendar cal = (Calendar) theCalendar.clone();
        final int month = cal.get(Calendar.MONTH);
        switch (month) {

        case Calendar.JANUARY:
        case Calendar.MARCH:
        case Calendar.MAY:
        case Calendar.JULY:
        case Calendar.AUGUST:
        case Calendar.OCTOBER:
        case Calendar.DECEMBER:
            return 31;
        case Calendar.APRIL:
        case Calendar.JUNE:
        case Calendar.SEPTEMBER:
        case Calendar.NOVEMBER:
            return 30;
        case Calendar.FEBRUARY:
            cal.set(Calendar.DATE, 1);
            cal.add(Calendar.MONTH, 1);
            cal.add(Calendar.DATE, -1);
            return cal.get(Calendar.DATE);
        default:
            throw new IllegalStateException("Unknown month: " + month);
        }
    }

    /**
     * Constructor.
     */
	public CalendarMonthYear(final int theYear, Month theMonth) {
        this.month = theMonth;
		final Calendar calendar = new GregorianCalendar(theYear, theMonth.getJavaCalendarOffset(), 1);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        weekDayforCalendarEquivalent = WeekDay.forCalendarEquivalent(dayOfWeek);
        nameForMonth = new SimpleDateFormat("MMM").format(calendar.getTime());
        days = getDaysForMonth(calendar);
    }

    /**
     * @return the {@link #dayOfWeek}
     */
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDays() {
        return days;
    }

    /**
	 * get the day for the given offset.
	 *
	 * @param offset
	 *            given offset.
	 * @return returns the day for this index.
	 */
	public Integer getDayForIndex(final int offset) {
        final int result = offset - weekDayforCalendarEquivalent.getDayOfWeekIndex() + 1;
        if (result > 0 && result <= getDays()) {
            return result;
        } else {
            return null;
        }
    }

	/**
	 * Get the name of this month.
	 * 
	 * @return the name of this month.
	 */
	public String getNameForMonth() {
        return nameForMonth;
    }

	public Month getMonth() {
		return month;
	}
}
