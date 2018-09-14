import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DateStep {
	private final int step;
	private final StepCommand stepCommand;

	public LocalDate next(LocalDate startDate, LocalDate date) {
		// TODO: use polymorphism to model Monthly(1) and Monthly(x > 1) cases
		LocalDate lastStepDate = step > 1 ? startDate : date;

		while (lastStepDate.isBefore(date)) {
			lastStepDate = stepCommand.execute(lastStepDate, step);
		}

		return lastStepDate;
	}
}
