import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class TimeExpression {

	public static TimeExpression on(LocalDate aDate) {
		return new OnSpecificDateTimeExpression(aDate);
	}

	public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate aDate) {
		return new EveryOnFromOnwardsTimeExpression(new DateStepMatcher(anAmountOfDays, ChronoUnit.DAYS), aDate);
	}

	public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth yearMonth) {
		DatePoint datePoint = new DayOfMonthPoint(aDayInMonth);
		LocalDate startDate = datePoint.from(yearMonth.atDay(1));
		return new OccurrenceTimeExpression(startDate, datePoint, new MonthlyStep(anAmountOfMonths));
	}

	public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, YearMonth yearMonth, DatePoint datePoint) {
		LocalDate startDate = datePoint.from(yearMonth.atDay(1));
		return new OccurrenceTimeExpression(startDate, datePoint, new MonthlyStep(anAmountOfMonths));
	}

	public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());
		return new EveryOnFromOnwardsTimeExpression(new DateStepMatcher(anAmountOfYears, ChronoUnit.YEARS), startDate);
	}

	public boolean isRecurringOn(LocalDate aDate) {
		return false;
	}
}
