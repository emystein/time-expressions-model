package arithmetic;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class DailyPeriodLengthTest {
	private LocalDate januaryFirst2011 = LocalDate.of(2011, 1, 1);
	private LocalDate januarySecond2011 = LocalDate.of(2011, 1, 2);
	private LocalDate februaryFirst2011 = LocalDate.of(2011, 2, 1);
	private LocalDate december312011 = LocalDate.of(2011, 12, 31);
	private LocalDate januaryFirst2012 = LocalDate.of(2012, 1, 1);
	private PeriodLength length = new DailyPeriodLength();

	@Test
	public void dailyPeriodLengthBetweenJanuaryFirstAndJanuaryFirstShouldBe0() {
		assertEquals(0, length.between(januaryFirst2011, januaryFirst2011));
	}

	@Test
	public void dailyPeriodLengthBetweenJanuaryFirstAndJanuarySecondShouldBe1() {
		assertEquals(1, length.between(januaryFirst2011, januarySecond2011));
	}

	@Test
	public void dailyPeriodLengthBetweenJanuaryFirstAndFebruaryFirstShouldBe31() {
		assertEquals(31, length.between(januaryFirst2011, februaryFirst2011));
	}

	@Test
	public void dailyPeriodLengthBetweenJanuaryFirst2011AndDecember31ShouldBe364() {
		assertEquals(364, length.between(januaryFirst2011, december312011));
	}

	@Test
	public void dailyPeriodLengthBetweenJanuaryFirst2012AndJanuaryFirst2013ShouldBe365() {
		assertEquals(365, length.between(januaryFirst2011, januaryFirst2012));
	}
}
