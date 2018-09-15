import java.time.LocalDate;
import attribute.DateAttributeCheck;
import lombok.RequiredArgsConstructor;
import progress.DateStep;

@RequiredArgsConstructor
public class PeriodicityCheck {
	private final LocalDate startDate;
	private final DateStep dateStep;
	private final DateAttributeCheck dateAttributeCheck;

	public boolean matches(LocalDate date) {
		LocalDate nextDate = dateStep.next(startDate, date);
		return dateAttributeCheck.matches(date, nextDate);
	}
}
