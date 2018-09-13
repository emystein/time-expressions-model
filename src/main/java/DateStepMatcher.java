import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DateStepMatcher implements BiFunction<LocalDate, LocalDate, Boolean> {
	private final int step;
	private final ChronoUnit chronoUnit;

	@Override
	public Boolean apply(LocalDate startDate, LocalDate endDate) {
		return chronoUnit.between(startDate, endDate) % step == 0;
	}
}
