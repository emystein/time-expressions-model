package event;

import java.time.LocalDate;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventOccurrenceCondition implements Predicate<LocalDate> {
	private final EventOccurrence eventOccurrence;

	public boolean test(LocalDate date) {
		LocalDate occurrenceDate = eventOccurrence.forDate(date);

		return date.isEqual(occurrenceDate);
	}
}
