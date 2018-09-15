package progress;

import java.time.LocalDate;

public class MonthlyAdvanceCommand implements OccurrenceAdvanceCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusMonths(step);
	}
}
