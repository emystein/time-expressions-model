package arithmetic;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class YearlyPeriodLengthTest {
	private LocalDate januaryFirst2012 = LocalDate.of(2012, 1, 1);
	private LocalDate februaryFirst2013 = LocalDate.of(2013, 2, 1);
	private PeriodLength length = new YearlyPeriodLength();

	@Test
	public void yearlyPeriodLengthBetweenJanuaryFirst2012AndFebruaryFirst2013ShouldBeOne() {
		assertEquals(1, length.between(januaryFirst2012, februaryFirst2013));
	}

	@Test
	public void yearlyPeriodLengthBetweenJanuaryFirst2012AndMarchFirst2014ShouldBeTwo() {
		LocalDate marchFirst2014 = LocalDate.of(2014, 3, 1);

		assertEquals(2, length.between(januaryFirst2012, marchFirst2014));
	}

	@Test
	public void yearlyPeriodLengthBetweenDecemberTwentyEight2012AndFebruaryFirst2013ShouldBeOne() {
		LocalDate februaryTwentyEight2012 = LocalDate.of(2012, 12, 28);

		assertEquals(1, length.between(februaryTwentyEight2012, februaryFirst2013));
	}
}
