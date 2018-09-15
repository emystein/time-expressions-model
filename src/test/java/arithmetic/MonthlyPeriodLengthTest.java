package arithmetic;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class MonthlyPeriodLengthTest {
	private LocalDate januaryFirst2012 = LocalDate.of(2012, 1, 1);
	private LocalDate februaryFirst2012 = LocalDate.of(2012, 2, 1);
	private LocalDate marchFirst2012 = LocalDate.of(2012, 3, 1);
	private LocalDate februaryFirst2013 = LocalDate.of(2013, 2, 1);
	private PeriodLength length = new MonthlyPeriodLength();

	@Test
	public void monthlyPeriodLengthBetweenJanuaryFirstAndFebruaryFirstShouldBeOne() {
		assertEquals(1, length.between(januaryFirst2012, februaryFirst2012));
	}

	@Test
	public void monthlyPeriodLengthBetweenJanuaryFirstAndMarchFirstShouldBeTwo() {
		assertEquals(2, length.between(januaryFirst2012, marchFirst2012));
	}

	@Test
	public void monthlyPeriodLengthBetweenJanuaryTwentyEightAndFebruaryFirstShouldBeTwo() {
		LocalDate januaryTwentyEight2012 = LocalDate.of(2012, 1, 28);

		assertEquals(1, length.between(januaryTwentyEight2012, februaryFirst2012));
	}

	@Test
	public void monthlyPeriodLengthBetweenJanuaryFirstAndFebruaryFirstNextYearShouldBeThirteen() {
		assertEquals(13, length.between(januaryFirst2012, februaryFirst2013));
	}
}
