import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Test;

public class PeriodicityCheckTest {
	LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	LocalDate month2Date = LocalDate.of(2012, 2, 1);
	LocalDate month3Date = LocalDate.of(2012, 3, 1);
	LocalDate month4Date = LocalDate.of(2012, 4, 1);
	LocalDate month5Date = LocalDate.of(2012, 5, 1);

	@Test
	public void givenADateAndAMonthlyPeriodicityWhenCheckingPeriodicityThenPeriodicityShouldMatch() {
		LocalDate date = firstOfJanuary2012.plusWeeks(1);

		PeriodicityCheck periodicityCheck = new PeriodicityCheck(firstOfJanuary2012, new DateStep(1, new MonthlyStepCommand()), new MonthCheck());

		assertTrue(periodicityCheck.matches(date));
	}

	@Test
	public void givenADateAndAMonthlyPeriodicityWithSameStartAsGivenDateWhenCheckingPeriodicityThenPeriodicityShouldMatch() {
		PeriodicityCheck periodicityCheck = new PeriodicityCheck(firstOfJanuary2012, new DateStep(1, new MonthlyStepCommand()), new MonthCheck());

		assertTrue(periodicityCheck.matches(firstOfJanuary2012));
	}

	@Test
	public void givenADateTwoMonthsAheadOfStartDateAndAnEveryTwoMonthsPeriodicityWhenCheckingPeriodicityThenPeriodicityShouldMatch() {
		PeriodicityCheck periodicityCheck = new PeriodicityCheck(firstOfJanuary2012, new DateStep(2, new MonthlyStepCommand()), new MonthCheck());

		assertFalse(periodicityCheck.matches(month2Date));
		assertTrue(periodicityCheck.matches(month3Date));
		assertFalse(periodicityCheck.matches(month4Date));
		assertTrue(periodicityCheck.matches(month5Date));
	}
}
