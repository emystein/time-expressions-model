package event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class LastDayOfWeekInMonthOccurrenceTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate lastFridayOfJanuary2012 = LocalDate.of(2012, 1, 27);

	private EventOccurrence lastFridayOfMonthOccurrence = new LastDayOfWeekInMonthOccurrence(DayOfWeek.FRIDAY);

	@Test
	public void getLastFriday() {
		assertEquals(lastFridayOfJanuary2012, lastFridayOfMonthOccurrence.nextFor(firstOfJanuary2012));
	}

	@Test
	public void checkDateMatchesOccurrence() {
		assertFalse(lastFridayOfMonthOccurrence.test(firstOfJanuary2012));
		assertTrue(lastFridayOfMonthOccurrence.test(lastFridayOfJanuary2012));
	}
}
