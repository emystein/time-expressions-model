package progress;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
// TODO: replace with object that calculates the period between startDate and date using given granularity (monthly, yearly) and then check the period modulo step to be 0
public class OccurrenceAdvance {
	private final int step;
	private final OccurrenceAdvanceCommand occurrenceAdvanceCommand;

	public LocalDate next(LocalDate startDate, LocalDate date) {
		LocalDate lastStepDate = step > 1 ? startDate : date;

		while (lastStepDate.isBefore(date)) {
			lastStepDate = occurrenceAdvanceCommand.execute(lastStepDate, step);
		}

		return lastStepDate;
	}
}
