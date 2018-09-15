package progress;

import java.time.LocalDate;

public class YearlyAdvanceCommand implements OccurrenceAdvanceCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusYears(step);
	}
}
