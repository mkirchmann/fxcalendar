package de.killbuqs.calendar.model;

import org.junit.Assert;
import org.junit.Test;

import de.killbuqs.calendar.intf.Month;

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
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.APRIL);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }

    @Test
    public void testAugust2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.AUGUST);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testDecember2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.DECEMBER);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2000() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2000, Month.FEBURARY);
        Assert.assertEquals(29, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2001() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2001, Month.FEBURARY);
        Assert.assertEquals(28, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2004() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2004, Month.FEBURARY);
        Assert.assertEquals(29, calendarMonthYear.getDays());
    }

    @Test
    public void testFebruary2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.FEBURARY);
        Assert.assertEquals(28, calendarMonthYear.getDays());
    }

    @Test
    public void testJanuary2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.JANUARY);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testJuly2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.JULY);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testJune2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.JUNE);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }

    @Test
    public void testMarch2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.MARCH);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testMay2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.MAY);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testNovember2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.NOVEMBER);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }

    @Test
    public void testOctober2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.OCTOBER);
        Assert.assertEquals(31, calendarMonthYear.getDays());
    }

    @Test
    public void testSeptember2017() {
		final CalendarMonthYear calendarMonthYear = new CalendarMonthYear(2017, Month.SEPTEMBER);
        Assert.assertEquals(30, calendarMonthYear.getDays());
    }
}
