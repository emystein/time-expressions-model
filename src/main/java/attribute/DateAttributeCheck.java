package attribute;

import java.time.LocalDate;

public interface DateAttributeCheck {
	boolean matches(LocalDate date, LocalDate checkDate);
}
