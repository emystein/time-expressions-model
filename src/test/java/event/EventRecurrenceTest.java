package event;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Test;
import arithmetic.MonthlyPeriodLength;

public class EventRecurrenceTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate month2Date = LocalDate.of(2012, 2, 1);
	private LocalDate month3Date = LocalDate.of(2012, 3, 1);
	private LocalDate month4Date = LocalDate.of(2012, 4, 1);
	private LocalDate month5Date = LocalDate.of(2012, 5, 1);
	private EventRecurrence recurrence;
	private LocalDate noEndDate = null;

	@Test
	public void monthlyIntervalShouldMatchStartDate() {
		recurrence = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 1, noEndDate);

		assertTrue(recurrence.test(firstOfJanuary2012));
	}

	@Test
	public void monthlyIntervalShouldMatchDateInTheSameMonthThanStartDate() {
		LocalDate date = firstOfJanuary2012.plusWeeks(1);

		recurrence = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 1, noEndDate);

		assertTrue(recurrence.test(date));
	}

	@Test
	public void biMonthlyIntervalShouldMatchDatesEveryTwoMonths() {
		recurrence = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 2, noEndDate);

		assertFalse(recurrence.test(month2Date));
		assertTrue(recurrence.test(month3Date));
		assertFalse(recurrence.test(month4Date));
		assertTrue(recurrence.test(month5Date));
	}

	@Test
	public void biMonthlyIntervalShouldNotMatchDatesWithLessThanAMonthOfDifference() {
		LocalDate januarySix2012 = LocalDate.of(2012, 1, 6);
		LocalDate februaryThree2012 = LocalDate.of(2012, 2, 3);

		recurrence = new EventRecurrence(januarySix2012, new MonthlyPeriodLength(), 2, noEndDate);

		assertFalse(recurrence.test(februaryThree2012));
	}

	@Test
	public void everyMonthUntilAnEndDate() {
		LocalDate endDate = firstOfJanuary2012.plusMonths(3);

		recurrence = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 1, endDate);

		assertTrue(recurrence.test(firstOfJanuary2012));
		assertTrue(recurrence.test(firstOfJanuary2012.plusMonths(1)));
		assertTrue(recurrence.test(firstOfJanuary2012.plusMonths(2)));
		assertTrue(recurrence.test(firstOfJanuary2012.plusMonths(3)));
		assertFalse(recurrence.test(firstOfJanuary2012.plusMonths(4)));
	}
}
