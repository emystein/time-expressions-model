package event;

import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayOfWeekInMonthOccurrence implements EventOccurrence {
	private final int ordinal;
	private final DayOfWeek dayOfWeek;

	@Override
	public LocalDate forDate(LocalDate date) {
		return date.withDayOfMonth(1).with(dayOfWeekInMonth(ordinal, dayOfWeek));
	}
}
