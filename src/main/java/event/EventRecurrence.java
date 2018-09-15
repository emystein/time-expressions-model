package event;

import java.time.LocalDate;
import java.util.function.Predicate;
import arithmetic.PeriodLength;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class EventRecurrence implements Predicate<LocalDate> {
	private final LocalDate startDate;
	private final PeriodLength length;
	private final int step;

	public boolean test(LocalDate date) {
		return length.between(startDate, date) % step == 0;
	}
}
