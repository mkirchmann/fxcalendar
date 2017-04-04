package de.killbuqs.calendar.model;

import org.junit.Assert;
import org.junit.Test;

import de.killbuqs.calendar.model.CalendarMonthYear;

/**
 * Test for {@link CalendarMonthYear}.
 */

public class CalendarMonthYearTest {

    /**
     * Constructor.
     */
    public CalendarMonthYearTest() {
    }

    @Test
    public void testApril() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 4);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }

    @Test
    public void testAugust2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 8);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testDecember2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 12);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2000() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2000, 2);
        Assert.assertEquals(29, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2001() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2001, 2);
        Assert.assertEquals(28, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2004() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2004, 2);
        Assert.assertEquals(29, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 2);
        Assert.assertEquals(28, calendarMonthYear.getDays());
    }

    @Test
    public void testJanuary2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 1);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testJuly2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 7);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testJune2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 6);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }

    @Test
    public void testMarch2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 3);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testMay2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 3);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testNovember2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 11);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }

    @Test
    public void testOctober2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 10);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testSeptember2017() {
        final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, 9);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }
}
