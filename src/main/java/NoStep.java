import java.time.LocalDate;

public class NoStep implements DateStep {
	@Override
	public LocalDate next(LocalDate startDate, LocalDate date) {
		return date;
	}
}
