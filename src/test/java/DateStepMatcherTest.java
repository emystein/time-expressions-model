import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateStepMatcherTest {
	@Parameter
	public int step;
	@Parameter(1)
	public ChronoUnit chronoUnit;
	@Parameter(2)
	public int amountToAdd;

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ 1, ChronoUnit.DAYS, 0 },
				{ 1, ChronoUnit.DAYS, 1 },
				{ 1, ChronoUnit.DAYS, 2 },
				{ 2, ChronoUnit.DAYS, 0 },
				{ 2, ChronoUnit.DAYS, 2 },
				{ 4, ChronoUnit.DAYS, 4 },
				{ 1, ChronoUnit.MONTHS, 0 },
				{ 1, ChronoUnit.MONTHS, 1 },
				{ 1, ChronoUnit.MONTHS, 2 },
				{ 2, ChronoUnit.MONTHS, 0 },
				{ 2, ChronoUnit.MONTHS, 2 },
				{ 4, ChronoUnit.MONTHS, 4 },
		};
		return Arrays.asList(data);
	}

	@Test
	public void matchExactMultipleChronoUnitDifference() {
		DateStepMatcher matcher = new DateStepMatcher(step, chronoUnit);

		LocalDate date = LocalDate.now();

		assertTrue(matcher.apply(date, date.plus(amountToAdd, chronoUnit)));
	}
}
