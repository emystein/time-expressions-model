import java.time.LocalDate;
import arithmetic.PeriodLength;
import event.EventOccurrence;
import event.EventRecurrence;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class RecurringTimeExpression extends TimeExpression {
	private final EventOccurrence eventOccurrence;
	private final EventRecurrence eventRecurrence;

	// TODO: remove constructor
	public RecurringTimeExpression(LocalDate startDate, EventOccurrence eventOccurrence, PeriodLength periodLength, int periodStep) {
		this(eventOccurrence, new EventRecurrence(startDate, periodLength, periodStep));
	}

	// TODO: remove constructor
	public RecurringTimeExpression(LocalDate startDate, EventOccurrence eventOccurrence, PeriodLength periodLength, int periodStep, LocalDate endDate) {
		this(eventOccurrence, new EventRecurrence(startDate, periodLength, periodStep, endDate));
	}

	@Override
	public boolean isRecurringOn(LocalDate date) {
		return eventOccurrence.and(eventRecurrence).test(date);
	}
}
