package event;

import java.time.LocalDate;

public class SameDateOccurrence extends EventOccurrence {
	@Override
	public LocalDate nextFor(LocalDate date) {
		return date;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SameDateOccurrence;
	}
}
