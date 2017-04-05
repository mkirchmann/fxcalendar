package de.killbuqs.calendar.ui;

import de.killbuqs.calendar.intf.WeekDay;
import javafx.scene.paint.Color;

/**
 * Factory to create a color for the Weekday.
 * 
 * @author Michael
 *
 */
public class DayOfWeekColorFactory {

	/**
	 * Create a color for the given weekday.
	 * 
	 * @param weekDay
	 *            given Weekday
	 * @return Returns the color.
	 */
	public Color createBackgroundColor(final WeekDay weekDay) {
		final Color bgColor;
		final double opacity = 0.6;
		if (weekDay == WeekDay.SUNDAY) {
			// paint it red
			bgColor = new Color(1.0, 0.3, 0.3, opacity);
		} else if (weekDay == WeekDay.SATURDAY) {
			// paint it gray
			bgColor = new Color(0.95, 0.95, 0.95, opacity);
		} else {
			// paint it white
			bgColor = new Color(1.0, 1.0, 1.0, opacity);
		}
		return bgColor;
	}
}
