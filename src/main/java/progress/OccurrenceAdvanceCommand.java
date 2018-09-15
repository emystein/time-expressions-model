package progress;

import java.time.LocalDate;

public interface OccurrenceAdvanceCommand {
	LocalDate execute(LocalDate date, int step);
}
