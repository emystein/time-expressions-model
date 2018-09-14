import java.time.LocalDate;

public class SpecificDateOccurrence implements DateOccurrence {
	@Override
	public LocalDate from(LocalDate date) {
		return date;
	}
}
