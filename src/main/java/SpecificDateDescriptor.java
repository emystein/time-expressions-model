import java.time.LocalDate;

public class SpecificDateDescriptor implements DateEventDescriptor {
	@Override
	public LocalDate from(LocalDate date) {
		return date;
	}
}
