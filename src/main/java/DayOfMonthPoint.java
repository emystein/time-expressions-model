import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DayOfMonthPoint implements DatePoint {
	private final int dayOfMonth;

	@Override
	public LocalDate from(LocalDate startingDate) {
		return startingDate.withDayOfMonth(dayOfMonth);
	}
}
