package event;

import java.time.LocalDate;

public interface EventOccurrence {
	LocalDate forDate(LocalDate date);
}
