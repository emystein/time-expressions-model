import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

public class TimeExpression {

    public static TimeExpression on(LocalDate aDate) {
    	return new OnSpecificDateTimeExpression(aDate);
    }

    public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate aDate) {
		return new EveryOnFromOnwardsTimeExpression(new DateStepMatcher(anAmountOfDays, ChronoUnit.DAYS), aDate);
    }

    public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth anYear) {
		LocalDate startDate = LocalDate.of(anYear.getYear(), anYear.getMonth(), aDayInMonth);
		return new EveryOnFromOnwardsTimeExpression(new DateStepMatcher(anAmountOfMonths, ChronoUnit.MONTHS), startDate);
    }

    public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, DayOfWeek aDayOfWeek, int aWeekInMonth, YearMonth anYear) {
		LocalDate firstDayOfMonth = LocalDate.of(anYear.getYear(), anYear.getMonth(), 1 );

		LocalDate startDate = firstDayOfMonth
				.with(ChronoField.ALIGNED_WEEK_OF_MONTH, aWeekInMonth);
//				.with(ChronoField.DAY_OF_WEEK, aDayOfWeek.getValue());

		return new EveryOnFromOnwardsTimeExpression(new DateStepMatcher(anAmountOfMonths, ChronoUnit.MONTHS), startDate);
    }

    public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());
		return new EveryOnFromOnwardsTimeExpression(new DateStepMatcher(anAmountOfYears, ChronoUnit.YEARS), startDate);
    }

    public boolean isRecurringOn(LocalDate aDate) {
        return false;
    }
}
