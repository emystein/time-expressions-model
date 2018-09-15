package event;

import java.time.LocalDate;
import java.util.function.Predicate;

public abstract class EventOccurrence implements Predicate<LocalDate> {
	public abstract LocalDate forDate(LocalDate date);

	@Override
	public boolean test(LocalDate date) {
		LocalDate occurrenceDate = this.forDate(date);
		return date.isEqual(occurrenceDate);
	}
}
