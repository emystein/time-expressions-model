package arithmetic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DailyPeriodLength implements PeriodLength {
	@Override
	public long between(LocalDate from, LocalDate to) {
		return ChronoUnit.DAYS.between(from, to);
	}
}
