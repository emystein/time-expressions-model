import java.time.LocalDate;

public class MonthCheck implements DateComponentCheck {
	@Override
	public boolean matches(LocalDate date, LocalDate checkDate) {
		return date.getMonth().equals(checkDate.getMonth());
	}
}
