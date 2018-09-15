import java.time.LocalDate;
import event.EventOccurrence;
import event.EventOccurrenceCondition;
import event.OccurrenceInterval;

public class RecurringTimeExpression extends TimeExpression {
	private final OccurrenceInterval occurrenceInterval;
	private final EventOccurrenceCondition occurrenceCondition;

	public RecurringTimeExpression(EventOccurrence eventOccurrence, OccurrenceInterval occurrenceInterval) {
		this.occurrenceInterval = occurrenceInterval;
		this.occurrenceCondition = new EventOccurrenceCondition(eventOccurrence);
	}

	@Override
	public boolean isRecurringOn(LocalDate date) {
		return occurrenceInterval.and(occurrenceCondition).test(date);
	}
}
