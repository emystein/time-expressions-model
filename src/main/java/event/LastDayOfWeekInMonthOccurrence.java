package event;

import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.DayOfWeek;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LastDayOfWeekInMonthOccurrence implements EventOccurrence {
	private final DayOfWeek dayOfWeek;

	@Override
	public LocalDate forDate(LocalDate date) {
		return date.withDayOfMonth(date.lengthOfMonth()).with(previousOrSame(dayOfWeek));
	}
}
