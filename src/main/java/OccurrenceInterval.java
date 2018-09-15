import java.time.LocalDate;
import arithmetic.PeriodLength;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OccurrenceInterval {
	private final LocalDate startDate;
	private final PeriodLength length;
	private final int step;

	public boolean matches(LocalDate date) {
		return length.between(startDate, date) % step == 0;
	}
}
