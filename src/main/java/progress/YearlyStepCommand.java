package progress;

import java.time.LocalDate;

public class YearlyStepCommand implements StepCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusYears(step);
	}
}
