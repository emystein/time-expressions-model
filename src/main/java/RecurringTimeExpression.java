import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecurringTimeExpression extends TimeExpression {
	private final LocalDate startDate;
	// TODO rename DateEventDescriptor
	private final DateEventDescriptor matchDateEventDescriptor;
	private final DateStep timeStep;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		LocalDate stepDate = timeStep.next(startDate, date);
		LocalDate adjustedDate = matchDateEventDescriptor.from(stepDate);
		return date.isEqual(adjustedDate);
	}
}
