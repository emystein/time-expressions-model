import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DailyEveryFromOnwardsTimeExpression extends TimeExpression {
	private final DateStepMatcher dateStepMatcher;
	private final LocalDate startDate;

	DailyEveryFromOnwardsTimeExpression(int dayStep, LocalDate startDate) {
		this.dateStepMatcher = new DateStepMatcher(dayStep, ChronoUnit.DAYS);
		this.startDate = startDate;
	}

	@Override
	public boolean isRecurringOn(LocalDate aDate) {
		return dateStepMatcher.apply(startDate, aDate);
	}
}
