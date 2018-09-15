package event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class DayOfWeekInMonthOccurrenceTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);
	private LocalDate secondFridayOfJanuary2012 = LocalDate.of(2012, 1, 13);

	private EventOccurrence firstFridayOccurrence = new DayOfWeekInMonthOccurrence(1, DayOfWeek.FRIDAY);

	@Test
	public void firstFridayOfJanuary() {
		assertEquals(firstFridayOfJanuary2012, firstFridayOccurrence.nextFor(firstOfJanuary2012));
	}

	@Test
	public void checkDateMatchesOccurrence() {
		assertFalse(firstFridayOccurrence.test(firstOfJanuary2012));
		assertTrue(firstFridayOccurrence.test(firstFridayOfJanuary2012));
		assertFalse(firstFridayOccurrence.test(secondFridayOfJanuary2012));
	}
}
