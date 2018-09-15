package event;

import java.time.LocalDate;

public interface EventOccurrence {
	LocalDate adjust(LocalDate date);
}
