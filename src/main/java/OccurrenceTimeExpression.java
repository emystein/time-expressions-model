import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OccurrenceTimeExpression extends TimeExpression {
	private final TimeOccurrence timeOccurrence;

	@Override
	public boolean isRecurringOn(LocalDate aDate) {
		return timeOccurrence.matches(aDate);
	}
}
