import java.time.LocalDate;
import arithmetic.PeriodLength;
import event.EventOccurrence;
import event.EventRecurrence;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class RecurringTimeExpression extends TimeExpression {
	private final LocalDate startDate;
	private final EventOccurrence eventOccurrence;
	private final EventRecurrence eventRecurrence;

	public RecurringTimeExpression(LocalDate startDate, EventOccurrence eventOccurrence, PeriodLength periodLength, int periodStep) {
		this(startDate, eventOccurrence, new EventRecurrence(startDate, periodLength, periodStep));
	}

	@Override
	public boolean isRecurringOn(LocalDate date) {
		return eventOccurrence.and(eventRecurrence).test(date);
	}
}
