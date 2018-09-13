import java.time.LocalDate;

public class SpecificDatePoint implements DatePoint {
	@Override
	public LocalDate from(LocalDate date) {
		return date;
	}
}
