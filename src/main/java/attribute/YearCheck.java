package attribute;

import java.time.LocalDate;

public class YearCheck implements DateAttributeCheck {
	@Override
	public boolean matches(LocalDate date, LocalDate checkDate) {
		return date.getYear() == checkDate.getYear();
	}
}
