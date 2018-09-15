import java.time.LocalDate;
import event.EventOccurrence;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecurringTimeExpression extends TimeExpression {
	private final EventOccurrence eventOccurrence;
	private final OccurrenceInterval occurrenceInterval;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		LocalDate adjustedDate = eventOccurrence.adjust(date);
		return occurrenceInterval.matches(date) && date.isEqual(adjustedDate);
	}
}
