package event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Test;

public class DayOfMonthOccurrenceTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate eightOfJanuary2012 = LocalDate.of(2012, 1, 8);

	private EventOccurrence eightOfMonthOccurrence = new DayOfMonthOccurrence(8);

	@Test
	public void eightOfMonth() {
		assertEquals(eightOfJanuary2012, eightOfMonthOccurrence.nextFor(firstOfJanuary2012));
	}

	@Test
	public void checkDateMatchesOccurrence() {
		assertFalse(eightOfMonthOccurrence.test(firstOfJanuary2012));
		assertTrue(eightOfMonthOccurrence.test(eightOfJanuary2012));
	}
}