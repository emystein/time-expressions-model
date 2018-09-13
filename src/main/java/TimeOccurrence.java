import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TimeOccurrence {
	private final LocalDate startDate;
	private final DatePoint startPoint;
	private final DateStep timeStep;

	public boolean matches(LocalDate date) {
		LocalDate lastStepDate = startDate;

		while (lastStepDate.isBefore(date)) {
			lastStepDate = timeStep.next(lastStepDate);
		}

		LocalDate adjustedDate = startPoint.from(lastStepDate);

//		return date.isEqual(startDate) || date.isEqual(adjustedDate);
		return date.isEqual(adjustedDate);
	}
}
