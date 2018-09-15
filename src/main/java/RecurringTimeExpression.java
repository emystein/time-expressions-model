import java.time.LocalDate;
import event.EventOccurrence;
import lombok.RequiredArgsConstructor;
import progress.OccurrenceAdvance;

@RequiredArgsConstructor
public class RecurringTimeExpression extends TimeExpression {
	private final LocalDate startDate;
	private final EventOccurrence eventOccurrence;
	private final OccurrenceAdvance dateStep;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		LocalDate stepDate = dateStep.next(startDate, date);
		LocalDate adjustedDate = eventOccurrence.adjust(stepDate);
		return date.isEqual(adjustedDate);
	}
}
