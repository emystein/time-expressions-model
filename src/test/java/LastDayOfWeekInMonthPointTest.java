import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class LastDayOfWeekInMonthPointTest {
	@Test
	public void getLastFriday() {
		DatePoint datePoint = new LastDayOfWeekInMonthPoint(DayOfWeek.FRIDAY);

		assertEquals(LocalDate.of(2012, 1, 27), datePoint.from(LocalDate.of(2012, 1, 26)));
	}
}
