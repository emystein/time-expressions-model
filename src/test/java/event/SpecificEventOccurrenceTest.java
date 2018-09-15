package event;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class SpecificEventOccurrenceTest {
	@Test
	public void getDate() {
		EventOccurrence eventOccurrence = new SpecificDateOccurrence();
		LocalDate date = LocalDate.of(2012, 1, 27);
		assertEquals(date, eventOccurrence.adjust(date));
	}
}
