package event;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;
import event.DateEventDescriptor;
import event.SpecificDateDescriptor;

public class SpecificDateEventDescriptorTest {
	@Test
	public void getDate() {
		DateEventDescriptor dateEventDescriptor = new SpecificDateDescriptor();
		LocalDate date = LocalDate.of(2012, 1, 27);
		assertEquals(date, dateEventDescriptor.from(date));
	}
}
