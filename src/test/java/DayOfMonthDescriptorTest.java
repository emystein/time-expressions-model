import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

public class DayOfMonthDescriptorTest {
	@Test
	public void eightOfMonth() {
		DateEventDescriptor eightOfMonthPoint = new DayOfMonthDescriptor(8);

		LocalDate firstOfJanuary2012 = LocalDate.of(2012, 1, 1);
		LocalDate eightOfJanuary2012 = LocalDate.of(2012, 1, 8);

		assertEquals(eightOfJanuary2012, eightOfMonthPoint.from(firstOfJanuary2012));
	}
}