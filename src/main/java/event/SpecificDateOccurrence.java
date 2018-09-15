package event;

import java.time.LocalDate;

public class SpecificDateOccurrence extends EventOccurrence {
	@Override
	public LocalDate forDate(LocalDate date) {
		return date;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SpecificDateOccurrence;
	}
}
