import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MonthlyStep implements DateStep {
	private final int step;

	@Override
	public LocalDate next(LocalDate date) {
		return date.plusMonths(step);
	}
}
