import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;
import arithmetic.DailyPeriodLength;
import arithmetic.MonthlyPeriodLength;
import arithmetic.YearlyPeriodLength;
import event.DayOfMonthOccurrence;
import event.DayOfWeekInMonthOccurrence;
import event.EventOccurrence;
import event.EventRecurrence;
import event.SameDateOccurrence;

public class RecurringTimeExpressionBuilderTest {
	private LocalDate startDate = LocalDate.of(2012, 1, 1);
	private TimeExpression actual;
	private TimeExpression expected;
	private LocalDate noEndDate = null;

	@Test
	public void dailyEveryFromOnwards() {
		int anAmountOfDays = 14;

		actual = TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.every(anAmountOfDays)
				.days()
				.build();

		expected = new RecurringTimeExpression(new SameDateOccurrence(), new EventRecurrence(startDate, new DailyPeriodLength(), anAmountOfDays, noEndDate));

		assertEquals(expected, actual);
	}

	@Test
	public void monthlyEveryOnFromOnwards() {
		int aDayInMonth = 6;
		int anAmountOfMonths = 3;

		actual = TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.onDayOfMonth(aDayInMonth)
				.every(anAmountOfMonths)
				.months()
				.build();

		expected = new RecurringTimeExpression(new DayOfMonthOccurrence(aDayInMonth), new EventRecurrence(startDate, new MonthlyPeriodLength(), anAmountOfMonths, noEndDate));

		assertEquals(expected, actual);
	}

	@Test
	public void monthlyEveryOnOfFromOnwardsFirstFriday() {
		int anAmountOfMonths = 3;

		EventOccurrence theFirstFriday = new DayOfWeekInMonthOccurrence(1, DayOfWeek.FRIDAY);

		actual = TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.occurring(theFirstFriday)
				.every(anAmountOfMonths)
				.months()
				.build();

		expected = new RecurringTimeExpression(theFirstFriday, new EventRecurrence(startDate, new MonthlyPeriodLength(), anAmountOfMonths, noEndDate));

		assertEquals(expected, actual);
	}

	@Test
	public void yearlyEveryOnFromOnwards() {
		int anAmountOfYears = 3;

		actual = TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.every(anAmountOfYears)
				.years()
				.build();

		expected = new RecurringTimeExpression(new SameDateOccurrence(), new EventRecurrence(startDate, new YearlyPeriodLength(), anAmountOfYears, noEndDate));

		assertEquals(expected, actual);
	}


	@Test
	public void untilEndDate() {
		int anAmountOfMonths = 3;

		LocalDate endDate = startDate.plusMonths(3);
		actual = TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.every(anAmountOfMonths)
				.months()
				.until(endDate)
				.build();

		expected = new RecurringTimeExpression(new SameDateOccurrence(), new EventRecurrence(startDate, new MonthlyPeriodLength(), anAmountOfMonths, endDate));

		assertEquals(expected, actual);
	}
}
