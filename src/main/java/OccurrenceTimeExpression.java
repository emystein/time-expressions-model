import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OccurrenceTimeExpression extends TimeExpression {
	private final LocalDate startDate;
	// TODO rename DatePoint
	private final DatePoint matchDatePoint;
	private final DateStep timeStep;

	@Override
	public boolean isRecurringOn(LocalDate date) {
		LocalDate stepDate = timeStep.next(startDate, date);
		LocalDate adjustedDate = matchDatePoint.from(stepDate);
		return date.isEqual(adjustedDate);
	}
}
