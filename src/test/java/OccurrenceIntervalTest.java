import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Test;
import arithmetic.MonthlyPeriodLength;

public class OccurrenceIntervalTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate month2Date = LocalDate.of(2012, 2, 1);
	private LocalDate month3Date = LocalDate.of(2012, 3, 1);
	private LocalDate month4Date = LocalDate.of(2012, 4, 1);
	private LocalDate month5Date = LocalDate.of(2012, 5, 1);
	private OccurrenceInterval interval;

	@Test
	public void monthlyIntervalShouldMatchStartDate() {
		interval = new OccurrenceInterval(firstOfJanuary2012, new MonthlyPeriodLength(), 1);

		assertTrue(interval.matches(firstOfJanuary2012));
	}

	@Test
	public void monthlyIntervalShouldMatchDateInTheSameMonthThanStartDate() {
		LocalDate date = firstOfJanuary2012.plusWeeks(1);

		interval = new OccurrenceInterval(firstOfJanuary2012, new MonthlyPeriodLength(), 1);

		assertTrue(interval.matches(date));
	}

	@Test
	public void biMonthlyIntervalShouldMatchDatesEveryTwoMonths() {
		interval = new OccurrenceInterval(firstOfJanuary2012, new MonthlyPeriodLength(), 2);

		assertFalse(interval.matches(month2Date));
		assertTrue(interval.matches(month3Date));
		assertFalse(interval.matches(month4Date));
		assertTrue(interval.matches(month5Date));
	}

	@Test
	public void biMonthlyIntervalShouldNotMatchDatesWithLessThanAMonthOfDifference() {
		LocalDate januarySix2012 = LocalDate.of(2012, 1, 6);
		LocalDate februaryThree2012 = LocalDate.of(2012, 2, 3);

		interval = new OccurrenceInterval(januarySix2012, new MonthlyPeriodLength(), 2);

		assertFalse(interval.matches(februaryThree2012));
	}
}
