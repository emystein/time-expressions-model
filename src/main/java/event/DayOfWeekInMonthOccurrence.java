package event;

import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayOfWeekInMonthOccurrence implements EventOccurrence {
	private final int numberOfWeek;
	private final DayOfWeek dayOfWeek;

	@Override
	public LocalDate adjust(LocalDate date) {
		return date.withDayOfMonth(1).with(dayOfWeekInMonth(numberOfWeek, dayOfWeek));
	}
}
