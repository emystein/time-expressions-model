package event;

import java.time.LocalDate;

public class SpecificDateOccurrence implements EventOccurrence {
	@Override
	public LocalDate adjust(LocalDate date) {
		return date;
	}
}
