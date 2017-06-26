package de.killbuqs.calendar.intf;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Enumeration with a value for each month of a year.
 * 
 * @author Michael
 *
 */
public enum Month {
	JANUARY(Calendar.JANUARY, java.time.Month.JANUARY, 1), //
	FEBURARY(Calendar.FEBRUARY, java.time.Month.FEBRUARY, 2), //
	MARCH(Calendar.MARCH, java.time.Month.MARCH, 3), //
	APRIL(Calendar.APRIL, java.time.Month.APRIL, 4), //
	MAY(Calendar.MAY, java.time.Month.MAY, 5), //
	JUNE(Calendar.JUNE, java.time.Month.JUNE, 6), //
	JULY(Calendar.JULY, java.time.Month.JULY, 7), //
	AUGUST(Calendar.AUGUST, java.time.Month.AUGUST, 8), //
	SEPTEMBER(Calendar.SEPTEMBER, java.time.Month.SEPTEMBER, 9), //
	OCTOBER(Calendar.OCTOBER, java.time.Month.OCTOBER, 10), //
	NOVEMBER(Calendar.NOVEMBER, java.time.Month.NOVEMBER, 11), //
	DECEMBER(Calendar.DECEMBER, java.time.Month.DECEMBER, 12) //
	;
	private final int javaCalendarOffset;
	private final int officialMonthIndex;
	private final java.time.Month javaTimeMonth;

	Month(int theJavaCalendarOffset, java.time.Month theJavaTimeMonth, int theOfficialMonthIndex) {
		javaCalendarOffset = theJavaCalendarOffset;
		javaTimeMonth = theJavaTimeMonth;
		officialMonthIndex = theOfficialMonthIndex;
	}

	public int getJavaCalendarOffset() {
		return javaCalendarOffset;
	}

	public int getOfficialMonthIndex() {
		return officialMonthIndex;
	}

	public java.time.Month getJavaTimeMonth() {
		return javaTimeMonth;
	}

	/**
	 * List of month, in order of appearance each year.
	 * 
	 * @return Returns an unmodifiable list of months.
	 */
	public static List<Month> listAllMonth() {
		List<Month> asList = Arrays.asList(JANUARY, FEBURARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER,
				NOVEMBER, DECEMBER);
		return Collections.unmodifiableList(asList);
	}
}
