import java.time.LocalDate;
import event.EventOccurrence;
import event.OccurrenceInterval;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecurringTimeExpression extends TimeExpression {
	private final EventOccurrence eventOccurrence;
	private final OccurrenceInterval occurrenceInterval;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		return occurrenceInterval.and(eventOccurrence).test(date);
	}
}
