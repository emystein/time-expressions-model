import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import event.EventOccurrence;
import event.DayOfMonthOccurrence;
import event.SpecificDateOccurrence;
import progress.DailyAdvanceCommand;
import progress.OccurrenceAdvance;
import progress.MonthlyAdvanceCommand;
import progress.YearlyAdvanceCommand;

public class TimeExpression {

	public static TimeExpression on(LocalDate aDate) {
		return new OnSpecificDateTimeExpression(aDate);
	}

	public static TimeExpression dailyEveryFromOnwards(int anAmountOfDays, LocalDate startDate) {
		return new RecurringTimeExpression(startDate, new SpecificDateOccurrence(), new OccurrenceAdvance(anAmountOfDays, new DailyAdvanceCommand()));
	}

	public static TimeExpression monthlyEveryOnFromOnwards(int anAmountOfMonths, int aDayInMonth, YearMonth yearMonth) {
		EventOccurrence eventOccurrence = new DayOfMonthOccurrence(aDayInMonth);
		LocalDate startDate = eventOccurrence.adjust(yearMonth.atDay(1));
		return new RecurringTimeExpression(startDate, eventOccurrence, new OccurrenceAdvance(anAmountOfMonths, new MonthlyAdvanceCommand()));
	}

	public static TimeExpression monthlyEveryOnOfFromOnwards(int anAmountOfMonths, YearMonth yearMonth, EventOccurrence eventOccurrence) {
		LocalDate startDate = eventOccurrence.adjust(yearMonth.atDay(1));
		return new RecurringTimeExpression(startDate, eventOccurrence, new OccurrenceAdvance(anAmountOfMonths, new MonthlyAdvanceCommand()));
	}

	public static TimeExpression yearlyEveryOnFromOnwards(int anAmountOfYears, MonthDay aMonthDay, int anYear) {
		LocalDate startDate = LocalDate.of(anYear, aMonthDay.getMonth(), aMonthDay.getDayOfMonth());
		return new RecurringTimeExpression(startDate, new SpecificDateOccurrence(), new OccurrenceAdvance(anAmountOfYears, new YearlyAdvanceCommand()));
	}

	public boolean isRecurringOn(LocalDate aDate) {
		return false;
	}
}
