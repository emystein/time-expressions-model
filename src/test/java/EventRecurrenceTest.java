import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Test;
import arithmetic.MonthlyPeriodLength;
import event.EventRecurrence;

public class EventRecurrenceTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate month2Date = LocalDate.of(2012, 2, 1);
	private LocalDate month3Date = LocalDate.of(2012, 3, 1);
	private LocalDate month4Date = LocalDate.of(2012, 4, 1);
	private LocalDate month5Date = LocalDate.of(2012, 5, 1);
	private EventRecurrence interval;

	@Test
	public void monthlyIntervalShouldMatchStartDate() {
		interval = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 1);

		assertTrue(interval.test(firstOfJanuary2012));
	}

	@Test
	public void monthlyIntervalShouldMatchDateInTheSameMonthThanStartDate() {
		LocalDate date = firstOfJanuary2012.plusWeeks(1);

		interval = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 1);

		assertTrue(interval.test(date));
	}

	@Test
	public void biMonthlyIntervalShouldMatchDatesEveryTwoMonths() {
		interval = new EventRecurrence(firstOfJanuary2012, new MonthlyPeriodLength(), 2);

		assertFalse(interval.test(month2Date));
		assertTrue(interval.test(month3Date));
		assertFalse(interval.test(month4Date));
		assertTrue(interval.test(month5Date));
	}

	@Test
	public void biMonthlyIntervalShouldNotMatchDatesWithLessThanAMonthOfDifference() {
		LocalDate januarySix2012 = LocalDate.of(2012, 1, 6);
		LocalDate februaryThree2012 = LocalDate.of(2012, 2, 3);

		interval = new EventRecurrence(januarySix2012, new MonthlyPeriodLength(), 2);

		assertFalse(interval.test(februaryThree2012));
	}
}
