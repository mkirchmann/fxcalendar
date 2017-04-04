package de.killbuqs.calendar.intf;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Weekday enumeration.
 */

public enum WeekDay {
    FRIDAY(Calendar.FRIDAY, 5), MONDAY(Calendar.MONDAY, 1), SATURDAY(Calendar.SATURDAY, 6), SUNDAY(Calendar.SUNDAY,
            7), THURSDAY(Calendar.THURSDAY, 4), TUESDAY(Calendar.TUESDAY, 2), WEDNESDAY(Calendar.WEDNESDAY, 3);

    /**
     *
     * @param theDayOfWeek
     * @return
     */
    public static WeekDay forCalendarEquivalent(final int theDayOfWeek) {
        final WeekDay[] values = values();
        for (final WeekDay weekDay : values) {
            if (weekDay.getCalendarEquivalent() == theDayOfWeek) {
                return weekDay;
            }
        }
        throw new IllegalArgumentException("WeekDay not found for CalendarDowEquivalent " + theDayOfWeek);
    }

    public static List<WeekDay> valuesInOrder() {
        return Arrays.asList(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY);
    }

    WeekDay(final int theCalendarEquivalent, final int theDayOfWeekIndex) {
        dayOfWeekIndex = theDayOfWeekIndex;
        this.calendarEquivalent = theCalendarEquivalent;

    }

    /**
     * @return the {@link #calendarEquivalent}
     */
    public int getCalendarEquivalent() {
        return calendarEquivalent;
    }

    /**
     * @return the {@link #dayOfWeekIndex}
     */
    public int getDayOfWeekIndex() {
        return dayOfWeekIndex;
    }

    /**
     * @return Returns a short string
     */
    public String toShortString() {
        return name().substring(0, 1);
    }

    private final int calendarEquivalent;

    private final int dayOfWeekIndex;
}
