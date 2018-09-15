import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import arithmetic.DailyPeriodLength;
import arithmetic.MonthlyPeriodLength;
import arithmetic.YearlyPeriodLength;
import event.EventOccurrence;
import event.DayOfMonthOccurrence;
import event.EventRecurrence;
import event.SpecificDateOccurrence;

public class TimeExpression {

	public static TimeExpression on(LocalDate aDate) {
		return new NonRecurringTimeExpression(aDate);
	}

	public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate startDate) {
		return new RecurringTimeExpression(new SpecificDateOccurrence(),
				new EventRecurrence(startDate, new DailyPeriodLength(), anAmountOfDays));
	}

	public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth yearMonth) {
		EventOccurrence eventOccurrence = new DayOfMonthOccurrence(aDayInMonth);
		LocalDate startDate = eventOccurrence.forDate(yearMonth.atDay(1));

		return new RecurringTimeExpression(eventOccurrence,
				new EventRecurrence(startDate, new MonthlyPeriodLength(), anAmountOfMonths));
	}

	public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, YearMonth yearMonth, EventOccurrence eventOccurrence) {
		LocalDate startDate = eventOccurrence.forDate(yearMonth.atDay(1));

		return new RecurringTimeExpression(eventOccurrence,
				new EventRecurrence(startDate, new MonthlyPeriodLength(), anAmountOfMonths));
	}

	public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());

		return new RecurringTimeExpression(new SpecificDateOccurrence(),
				new EventRecurrence(startDate, new YearlyPeriodLength(), anAmountOfYears));
	}

	public boolean isRecurringOn(LocalDate aDate) {
		return false;
	}
}
