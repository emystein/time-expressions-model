package event;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayOfMonthOccurrence implements EventOccurrence {
	private final int dayOfMonth;

	@Override
	public LocalDate adjust(LocalDate date) {
		return date.withDayOfMonth(dayOfMonth);
	}
}
