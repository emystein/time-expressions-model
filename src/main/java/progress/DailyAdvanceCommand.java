package progress;

import java.time.LocalDate;

public class DailyAdvanceCommand implements OccurrenceAdvanceCommand {
	@Override
	public LocalDate execute(LocalDate date, int step) {
		return date.plusDays(step);
	}
}
