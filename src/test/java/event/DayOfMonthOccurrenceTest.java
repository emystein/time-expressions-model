package event;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

public class DayOfMonthOccurrenceTest {
	@Test
	public void eightOfMonth() {
		EventOccurrence eightOfMonthOccurrence = new DayOfMonthOccurrence(8);

		LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
		LocalDate eightOfJanuary2012 = LocalDate.of(2012, 1, 8);

		assertEquals(eightOfJanuary2012, eightOfMonthOccurrence.nextFor(firstOfJanuary2012));
	}
}