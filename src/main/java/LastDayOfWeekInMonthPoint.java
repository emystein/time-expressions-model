import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.DayOfWeek;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LastDayOfWeekInMonthPoint implements DatePoint {
	private final DayOfWeek dayOfWeek;

	@Override
	public LocalDate from(LocalDate date) {
		return date.withDayOfMonth(date.lengthOfMonth()).with(previousOrSame(dayOfWeek));
	}
}
