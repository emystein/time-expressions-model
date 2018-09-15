package progress;

import java.time.LocalDate;
import progress.StepCommand;

public class MonthlyStepCommand implements StepCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusMonths(step);
	}
}
