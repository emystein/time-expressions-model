package arithmetic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MonthlyPeriodLength implements PeriodLength {
	@Override
	public long between(LocalDate from, LocalDate to) {
		return ChronoUnit.MONTHS.between(from.withDayOfMonth(1), to.withDayOfMonth(1));
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof MonthlyPeriodLength;
	}
}
