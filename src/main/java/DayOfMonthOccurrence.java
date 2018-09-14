import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayOfMonthOccurrence implements DateOccurrence {
	private final int dayOfMonth;

	@Override
	public LocalDate from(LocalDate date) {
		return date.withDayOfMonth(dayOfMonth);
	}
}
