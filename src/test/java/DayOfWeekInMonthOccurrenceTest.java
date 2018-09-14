import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class DayOfWeekInMonthOccurrenceTest {
	@Test
	public void firstFridayOfJanuary() {
		LocalDate firstOfJanuary = LocalDate.of(2012, 1, 1);
		LocalDate firstFridayOfJanuary = LocalDate.of(2012, 1, 6);

		DateOccurrence firstFridayPoint = new DayOfWeekInMonthOccurrence(1, DayOfWeek.FRIDAY);

		assertEquals(firstFridayOfJanuary, firstFridayPoint.from(firstOfJanuary));
	}
}
