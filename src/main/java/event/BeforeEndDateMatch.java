package event;

import java.time.LocalDate;
import java.util.function.Predicate;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class BeforeEndDateMatch implements Predicate<LocalDate> {
	private final LocalDate endDate;

	@Override
	public boolean test(LocalDate date) {
		return endDate == null || date.isBefore(endDate) || date.isEqual(endDate);
	}
}
