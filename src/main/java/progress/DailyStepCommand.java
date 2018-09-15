package progress;

import java.time.LocalDate;

public class DailyStepCommand implements StepCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusDays(step);
	}
}
