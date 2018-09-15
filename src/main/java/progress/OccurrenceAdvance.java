package progress;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OccurrenceAdvance {
	private final int step;
	private final OccurrenceAdvanceCommand occurrenceAdvanceCommand;

	public LocalDate next(LocalDate startDate, LocalDate date) {
		LocalDate lastStepDate = step > 1 ? startDate : date;

		// TODO: use the granularity defined by the progress.OccurrenceAdvanceCommand: monthly, yearly in the condition?
		while (lastStepDate.isBefore(date)) {
			lastStepDate = occurrenceAdvanceCommand.execute(lastStepDate, step);
		}

		return lastStepDate;
	}
}
