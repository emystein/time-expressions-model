package arithmetic;

import java.time.LocalDate;
import java.time.Period;

public class YearlyPeriodLength implements PeriodLength {
	@Override
	public long between(LocalDate from, LocalDate to) {
		int length = Period.between(from, to).getYears();

		if (length == 0 && (from.getYear() < to.getYear())) {
			length = 1;
		}

		return length;
	}
}
