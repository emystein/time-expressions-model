import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DailyStep implements DateStep {
	private final int step;

	@Override
	public LocalDate next(LocalDate startDate, LocalDate date) {
		// TODO: use polymorphism to model Monthly(1) and Monthly(x > 1) cases
		LocalDate lastStepDate = step > 1 ? startDate : date;

		while (lastStepDate.isBefore(date)) {
			lastStepDate = lastStepDate.plusDays(step);
		}

		return lastStepDate;
	}
}
