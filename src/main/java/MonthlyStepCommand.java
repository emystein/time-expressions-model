import java.time.LocalDate;

public class MonthlyStepCommand implements StepCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusMonths(step);
	}
}
