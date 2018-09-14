import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class SpecificDateOccurrenceTest {
	@Test
	public void getDate() {
		DateOccurrence dateOccurrence = new SpecificDateOccurrence();
		LocalDate date = LocalDate.of(2012, 1, 27);
		assertEquals(date, dateOccurrence.from(date));
	}
}
