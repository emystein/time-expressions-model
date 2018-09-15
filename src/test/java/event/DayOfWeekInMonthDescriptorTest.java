package event;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;
import event.DateEventDescriptor;
import event.DayOfWeekInMonthDescriptor;

public class DayOfWeekInMonthDescriptorTest {
	@Test
	public void firstFridayOfJanuary() {
		LocalDate firstOfJanuary = LocalDate.of(2012, 1, 1);
		LocalDate firstFridayOfJanuary = LocalDate.of(2012, 1, 6);

		DateEventDescriptor firstFridayPoint = new DayOfWeekInMonthDescriptor(1, DayOfWeek.FRIDAY);

		assertEquals(firstFridayOfJanuary, firstFridayPoint.from(firstOfJanuary));
	}
}
