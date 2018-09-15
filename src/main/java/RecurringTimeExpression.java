import java.time.LocalDate;
import event.EventOccurrence;
import event.EventRecurrence;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecurringTimeExpression extends TimeExpression {
	private final EventOccurrence eventOccurrence;
	private final EventRecurrence eventRecurrence;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		return eventOccurrence.and(eventRecurrence).test(date);
	}
}
