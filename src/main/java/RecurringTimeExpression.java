import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecurringTimeExpression extends TimeExpression {
	private final LocalDate startDate;
	// TODO rename DateOccurrence
	private final DateOccurrence matchDateOccurrence;
	private final DateStep timeStep;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		LocalDate stepDate = timeStep.next(startDate, date);
		LocalDate adjustedDate = matchDateOccurrence.from(stepDate);
		return date.isEqual(adjustedDate);
	}
}
