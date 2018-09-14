import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DateStep {
	private final int step;
	private final StepCommand stepCommand;

	public LocalDate next(LocalDate startDate, LocalDate date) {
		LocalDate lastStepDate = step > 1 ? startDate : date;

		// TODO: use the granularity defined by the StepCommand: monthly, yearly in the condition?
		while (lastStepDate.isBefore(date)) {
			lastStepDate = stepCommand.execute(lastStepDate, step);
		}

		return lastStepDate;
	}
}
