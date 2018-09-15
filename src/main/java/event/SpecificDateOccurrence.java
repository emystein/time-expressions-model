package event;

import java.time.LocalDate;

public class SpecificDateOccurrence implements EventOccurrence {
	@Override
	public LocalDate forDate(LocalDate date) {
		return date;
	}
}
