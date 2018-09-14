import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class SpecificDatePointTest {
	@Test
	public void getDate() {
		DatePoint datePoint = new SpecificDatePoint();
		LocalDate date = LocalDate.of(2012, 1, 27);
		assertEquals(date, datePoint.from(date));
	}
}
