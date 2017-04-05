package de.killbuqs.calendar.ui;

import de.killbuqs.calendar.intf.WeekDay;
import de.killbuqs.calendar.model.CalendarDateInformation;
import de.killbuqs.calendar.model.CalendarMonthYear;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * A cell which paints a a calendar cell.
 */

public class CalendarTableCell extends TableCell<CalendarMonthYear, CalendarDateInformation> {

	private DayOfWeekColorFactory dayOfWeekColorFactory;

	public CalendarTableCell(final WeekDay weekDay) {
		this(weekDay, new DayOfWeekColorFactory());
	}
    /**
     * Constructor.
     *
     * @param theWeekDay
     */
	/**
	 * Constructor.
	 * 
	 * @param theWeekDay
	 *            the given weekday.
	 * @param dayOfWeekColorFactory
	 *            the given color factory.
	 */
	public CalendarTableCell(final WeekDay theWeekDay, DayOfWeekColorFactory dayOfWeekColorFactory) {
        weekDay = theWeekDay;
		this.dayOfWeekColorFactory = dayOfWeekColorFactory;
        defaultBackground = computeBackground();
        centerLabel = new Label();
        bottomLabel = new Label();
        bottomLabel.setFont(Font.font(8.0));
        final Node top = null;
        final Node right = null;
        final Node bottom = bottomLabel;
        final Node left = null;
        graphics = new BorderPane(centerLabel, top, right, bottom, left);
        setGraphic(graphics);
    }

    /**
     * {@inheritDoc}.
     *
     * @see javafx.scene.control.Cell#updateItem(java.lang.Object, boolean)
     */
    @Override
    protected void updateItem(final CalendarDateInformation theItem, final boolean theEmpty) {
        super.updateItem(theItem, theEmpty);
        String dateAsText;
        Background background;
        if (theItem != null) {
            dateAsText = Integer.toString(theItem.getDate());
            if (theItem.containsPublicHoliday()) {
				background = computeBackground(WeekDay.SUNDAY);
            } else {
                background = defaultBackground;
            }
        } else {
            dateAsText = "";
            background = defaultBackground;
        }
        bottomLabel.setText(dateAsText);
        setBackground(background);
    }

	private Background computeBackground(WeekDay wd) {
		Paint bgColor = dayOfWeekColorFactory.createBackgroundColor(wd);
		final Background bg = new Background(new BackgroundFill(bgColor, null, null));
		return bg;
	}

    /**
     * Red for sunday, grey for saturday.
     *
     * @return Returns the background.
     */
    private Background computeBackground() {
        return computeBackground(this.weekDay);
    }

    private final Label bottomLabel;

    private final Label centerLabel;

    private final Background defaultBackground;
    private final BorderPane graphics;

    private final WeekDay weekDay;
}
