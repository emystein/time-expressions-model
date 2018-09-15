import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import event.EventOccurrence;

public class TimeExpression {

	public static TimeExpression on(LocalDate aDate) {
		return TimeExpressionBuilder.once().on(aDate);
	}

	public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate startDate) {
		return TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.every(anAmountOfDays)
				.days()
				.build();
	}

	public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth yearMonth) {
		return TimeExpressionBuilder.recurring()
				.startingOn(yearMonth.atDay(aDayInMonth))
				.onDayOfMonth(aDayInMonth)
				.every(anAmountOfMonths)
				.months()
				.build();
	}

	public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, YearMonth yearMonth, EventOccurrence eventOccurrence) {
		return TimeExpressionBuilder.recurring()
				.startingOn(yearMonth.atDay(1))
				.occurring(eventOccurrence)
				.every(anAmountOfMonths)
				.months()
				.build();
	}

	public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());

		return TimeExpressionBuilder.recurring()
				.startingOn(startDate)
				.every(anAmountOfYears)
				.years()
				.build();
	}

	public boolean isRecurringOn(LocalDate aDate) {
		return false;
	}
}
