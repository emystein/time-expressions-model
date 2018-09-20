import java.time.LocalDate;
import event.EventOccurrence;
import event.EventRecurrence;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class RecurringTimeExpression extends TimeExpression {
	private final EventOccurrence eventOccurrence;
	private final EventRecurrence eventRecurrence;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		return eventOccurrence.and(eventRecurrence).test(date);
	}
}
