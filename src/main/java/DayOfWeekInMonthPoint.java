import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayOfWeekInMonthPoint implements DatePoint {
	private final int numberOfWeek;
	private final DayOfWeek dayOfWeek;

	@Override
	public LocalDate from(LocalDate date) {
		return date.withDayOfMonth(1).with(dayOfWeekInMonth(numberOfWeek, dayOfWeek));
	}
}
