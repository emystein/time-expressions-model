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
import event.SameDateOccurrence;

public class RecurringTimeExpressionBuilderTest {
	private LocalDate startDate = LocalDate.of(2012, 1, 1);
	private TimeExpression actual;
	private TimeExpression expected;

	@Test
	public void dailyEveryFromOnwards() {
		int anAmountOfDays = 14;

		actual = TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.every(anAmountOfDays)
				.days()
				.build();

		expected = new RecurringTimeExpression(startDate, new SameDateOccurrence(), new DailyPeriodLength(), anAmountOfDays);

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

		expected = new RecurringTimeExpression(startDate, new DayOfMonthOccurrence(aDayInMonth), new MonthlyPeriodLength(), anAmountOfMonths);

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

		expected = new RecurringTimeExpression(startDate, theFirstFriday, new MonthlyPeriodLength(), anAmountOfMonths);

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

		expected = new RecurringTimeExpression(startDate, new SameDateOccurrence(), new YearlyPeriodLength(), anAmountOfYears);

		assertEquals(expected, actual);
	}
}
