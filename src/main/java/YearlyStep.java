import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class YearlyStep implements DateStep {
	private final int step;

	@Override
	public LocalDate next(LocalDate startDate, LocalDate date) {
		LocalDate lastStepDate = step > 1 ? startDate : date;

		while (lastStepDate.isBefore(date)) {
			lastStepDate = lastStepDate.plusYears(step);
		}

		return lastStepDate;
	}
}
