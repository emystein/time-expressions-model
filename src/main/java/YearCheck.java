import java.time.LocalDate;

public class YearCheck implements DateComponentCheck {
	@Override
	public boolean matches(LocalDate date, LocalDate checkDate) {
		return date.getYear() == checkDate.getYear();
	}
}
