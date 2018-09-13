import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class YearlyEveryOnFromOnwardsTimeExpression extends TimeExpression {
	private final DateStepMatcher dateStepMatcher;
	private final LocalDate startDate;

	YearlyEveryOnFromOnwardsTimeExpression(int step, MonthDay aDayInMonth, int anYear) {
		this.dateStepMatcher = new DateStepMatcher(step, ChronoUnit.YEARS);
		this.startDate = LocalDate.of(anYear, aDayInMonth.getMonth(), aDayInMonth.getDayOfMonth());
	}

	@Override
	public boolean isRecurringOn(LocalDate aDate) {
		return dateStepMatcher.apply(startDate, aDate);
	}
}
