package event;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class LastDayOfWeekInMonthOccurrenceTest {
	@Test
	public void getLastFriday() {
		EventOccurrence lastFridayOfMonthOccurrence = new LastDayOfWeekInMonthOccurrence(DayOfWeek.FRIDAY);

		assertEquals(LocalDate.of(2012, 1, 27), lastFridayOfMonthOccurrence.nextFor(LocalDate.of(2012, 1, 1)));
	}
}
