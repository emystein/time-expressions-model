import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class MonthlyEveryOnFromOnwardsTimeExpression extends TimeExpression {
	private final DateStepMatcher dateStepMatcher;
	private final LocalDate startDate;

	MonthlyEveryOnFromOnwardsTimeExpression(int step, int aDayInMonth, YearMonth anYear) {
		this.dateStepMatcher = new DateStepMatcher(step, ChronoUnit.MONTHS);
		this.startDate = LocalDate.of(anYear.getYear(), anYear.getMonth(), aDayInMonth);
	}

	@Override
	public boolean isRecurringOn(LocalDate aDate) {
		return dateStepMatcher.apply(startDate, aDate);
	}
}
