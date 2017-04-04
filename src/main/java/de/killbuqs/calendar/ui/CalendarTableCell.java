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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A cell which paints a a calendar cell.
 */

public class CalendarTableCell extends TableCell<CalendarMonthYear, CalendarDateInformation> {

    /**
     * Constructor.
     *
     * @param theWeekDay
     */
    public CalendarTableCell(final WeekDay theWeekDay) {
        weekDay = theWeekDay;
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

    /**
     * Red for sunday, grey for saturday.
     *
     * @return Returns the background.
     */
    private Background computeBackground() {
        return computeBackground(this.weekDay);
    }

    private Background computeBackground(final WeekDay weekDay) {
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
        final Background bg = new Background(new BackgroundFill(bgColor, null, null));
        return bg;
    }

    private final Label bottomLabel;

    private final Label centerLabel;

    private final Background defaultBackground;
    private final BorderPane graphics;

    private final WeekDay weekDay;
}
