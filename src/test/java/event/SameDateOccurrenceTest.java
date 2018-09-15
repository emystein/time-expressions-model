package event;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class SameDateOccurrenceTest {
	@Test
	public void getDate() {
		EventOccurrence sameDateOccurrence = new SameDateOccurrence();

		LocalDate date = LocalDate.of(2012, 1, 27);

		assertEquals(date, sameDateOccurrence.nextFor(date));
	}
}
