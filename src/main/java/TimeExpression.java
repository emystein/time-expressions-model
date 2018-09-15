import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import arithmetic.MonthlyPeriodLength;
import arithmetic.YearlyPeriodLength;
import event.DayOfMonthOccurrence;
import event.EventOccurrence;
import event.SpecificDateOccurrence;

public class TimeExpression {

	public static TimeExpression on(LocalDate aDate) {
		return TimeExpressionBuilder.once().on(aDate);
	}

	public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate startDate) {
//		 return new RecurringTimeExpression(startDate, new SpecificDateOccurrence(), new DailyPeriodLength(), anAmountOfDays);
		return TimeExpressionBuilder.recurring().startingOn(startDate).every(anAmountOfDays).days().build();
	}

	public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth yearMonth) {
//		EventOccurrence eventOccurrence = new DayOfMonthOccurrence(aDayInMonth);
//		LocalDate startDate = eventOccurrence.forDate(yearMonth.atDay(1));
//		return new RecurringTimeExpression(startDate, eventOccurrence, new MonthlyPeriodLength(), anAmountOfMonths);

		return TimeExpressionBuilder.recurring().startingOn(yearMonth.atDay(1)).onDayOfMonth(aDayInMonth).every(anAmountOfMonths).months().build();
	}

	public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, YearMonth yearMonth, EventOccurrence eventOccurrence) {
//		LocalDate startDate = eventOccurrence.forDate(yearMonth.atDay(1));
//		return new RecurringTimeExpression(startDate, eventOccurrence, new MonthlyPeriodLength(), anAmountOfMonths);

		return TimeExpressionBuilder.recurring().startingOn(yearMonth.atDay(1)).occurring(eventOccurrence).every(anAmountOfMonths).months().build();
	}

	public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());
//		return new RecurringTimeExpression(startDate, new SpecificDateOccurrence(), new YearlyPeriodLength(), anAmountOfYears);

		return TimeExpressionBuilder.recurring().startingOn(startDate).every(anAmountOfYears).years().build();
	}

	public boolean isRecurringOn(LocalDate aDate) {
		return false;
	}
}
