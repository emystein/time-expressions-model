package arithmetic;

import java.time.LocalDate;

public interface PeriodLength {
	long between(LocalDate from, LocalDate to);
}
