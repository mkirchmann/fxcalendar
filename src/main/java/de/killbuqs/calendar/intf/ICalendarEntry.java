package de.killbuqs.calendar.intf;

/**
 * Interface for an entry in the calendar.
 */
public interface ICalendarEntry {
    /**
     * Gets the description of this calendar entry.
     *
     * @return Returns the description of this calendar entry.
     */
    String getDescription();

    /**
     * Gets the title of this calendar entry.
     *
     * @return Returns the title of this calendar entry.
     */
    String getTitle();

    /**
     * Whether this entry marks a public holiday.
     *
     * @return <code>true</code> if this is a public holiday, <code>false</code> otherwise.
     */
    boolean isPublicHoliday();

    /**
     * If the entry is effective for the whole day.
     *
     * @return <code>true</code> if it is a whole day, <code>false</code> otherwise.
     */
    boolean wholeDay();
}
