package event;

import java.time.LocalDate;
import java.util.function.Predicate;
import arithmetic.PeriodLength;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EventRecurrence implements Predicate<LocalDate> {
	private final RecurrenceDateMatch recurrenceDateMatch;
	private final BeforeEndDateMatch beforeEndDateMatch;

	public EventRecurrence(LocalDate startDate, PeriodLength periodLength, int step) {
		this(startDate, periodLength, step, null);
	}

	public EventRecurrence(LocalDate startDate, PeriodLength periodLength, int recurrenceStep, LocalDate endDate) {
		this.recurrenceDateMatch = new RecurrenceDateMatch(startDate, periodLength, recurrenceStep);
		this.beforeEndDateMatch = new BeforeEndDateMatch(endDate);
	}

	public boolean test(LocalDate date) {
		return recurrenceDateMatch.and(beforeEndDateMatch).test(date);
	}
}
