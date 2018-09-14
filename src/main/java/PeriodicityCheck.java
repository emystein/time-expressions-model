import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PeriodicityCheck {
	private final LocalDate startDate;
	private final DateStep dateStep;
	private final DateComponentCheck dateComponentCheck;

	public boolean matches(LocalDate date) {
		LocalDate nextDate = dateStep.next(startDate, date);
		return dateComponentCheck.matches(date, nextDate);
	}
}
