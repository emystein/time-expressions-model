package event;

import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class DayOfMonthOccurrence extends EventOccurrence {
	private final int dayOfMonth;

	@Override
	public LocalDate nextFor(LocalDate date) {
		return date.withDayOfMonth(dayOfMonth);
	}
}
