import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EveryOnFromOnwardsTimeExpression extends TimeExpression {
	private final DateStepMatcher dateStepMatcher;
	private final LocalDate startDate;

	@Override
	public boolean isRecurringOn(LocalDate aDate) {
		return dateStepMatcher.apply(startDate, aDate);
	}
}
