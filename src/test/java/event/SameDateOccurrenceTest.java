package event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Test;

public class SameDateOccurrenceTest {
	private LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
	private LocalDate januaryTwo2012 = LocalDate.of(2012, 1, 2);
	private EventOccurrence sameDateOccurrence = new SameDateOccurrence();

	@Test
	public void getDate() {
		assertEquals(firstOfJanuary2012, sameDateOccurrence.nextFor(firstOfJanuary2012));
	}

	@Test
	public void checkDateMatchesOccurrence() {
		assertTrue(sameDateOccurrence.test(firstOfJanuary2012));
		assertTrue(sameDateOccurrence.test(januaryTwo2012));
	}
}
