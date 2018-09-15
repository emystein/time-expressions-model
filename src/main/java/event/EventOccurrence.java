package event;

import java.time.LocalDate;
import java.util.function.Predicate;

public abstract class EventOccurrence implements Predicate<LocalDate> {
	public abstract LocalDate nextFor(LocalDate date);

	@Override
	public boolean test(LocalDate date) {
		LocalDate occurrenceDate = this.nextFor(date);
		return date.isEqual(occurrenceDate);
	}
}
