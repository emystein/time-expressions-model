package event;

import java.time.LocalDate;
import java.util.function.Predicate;
import arithmetic.PeriodLength;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class RecurrenceDateMatch implements Predicate<LocalDate> {
	private final LocalDate startDate;
	private final PeriodLength periodLength;
	private final int recurrenceStep;

	@Override
	public boolean test(LocalDate date) {
		return periodLength.between(startDate, date) % recurrenceStep == 0;
	}
}
