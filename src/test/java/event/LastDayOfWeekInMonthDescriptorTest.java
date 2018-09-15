package event;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;
import event.DateEventDescriptor;
import event.LastDayOfWeekInMonthDescriptor;

public class LastDayOfWeekInMonthDescriptorTest {
	@Test
	public void getLastFriday() {
		DateEventDescriptor dateEventDescriptor = new LastDayOfWeekInMonthDescriptor(DayOfWeek.FRIDAY);

		assertEquals(LocalDate.of(2012, 1, 27), dateEventDescriptor.from(LocalDate.of(2012, 1, 26)));
	}
}
