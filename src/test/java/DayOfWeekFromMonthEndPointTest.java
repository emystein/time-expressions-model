import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class DayOfWeekFromMonthEndPointTest {
	@Test
	public void lastFridayOfJanuary() {
		LocalDate firstOfJanuary = LocalDate.of(2012, 1, 1);
		LocalDate lastFridayOfJanuary = LocalDate.of(2012, 1, 6);

		DatePoint lastFridayPoint = new DayOfWeekFromMonthEndPoint(1, DayOfWeek.FRIDAY);

		assertEquals(lastFridayOfJanuary, lastFridayPoint.from(firstOfJanuary));
	}
}
