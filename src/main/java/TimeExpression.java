import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;

public class TimeExpression {

	public static TimeExpression on(LocalDate aDate) {
		return new OnSpecificDateTimeExpression(aDate);
	}

	public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate startDate) {
		return new RecurringTimeExpression(startDate, new SpecificDateDescriptor(), new DateStep(anAmountOfDays, new DailyStepCommand()));
	}

	public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth yearMonth) {
		DateEventDescriptor dateEventDescriptor = new DayOfMonthDescriptor(aDayInMonth);
		LocalDate startDate = dateEventDescriptor.from(yearMonth.atDay(1));
		return new RecurringTimeExpression(startDate, dateEventDescriptor, new DateStep(anAmountOfMonths, new MonthlyStepCommand()));
	}

	public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, YearMonth yearMonth, DateEventDescriptor dateEventDescriptor) {
		LocalDate startDate = dateEventDescriptor.from(yearMonth.atDay(1));
		return new RecurringTimeExpression(startDate, dateEventDescriptor, new DateStep(anAmountOfMonths, new MonthlyStepCommand()));
	}

	public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());
		return new RecurringTimeExpression(startDate, new SpecificDateDescriptor(), new DateStep(anAmountOfYears, new YearlyStepCommand()));
	}

	public boolean isRecurringOn(LocalDate aDate) {
		return false;
	}
}
