import java.time.LocalDate;
import arithmetic.DailyPeriodLength;
import arithmetic.MonthlyPeriodLength;
import arithmetic.PeriodLength;
import arithmetic.YearlyPeriodLength;
import event.DayOfMonthOccurrence;
import event.EventOccurrence;
import event.SameDateOccurrence;

public class RecurringTimeExpressionBuilder {
	private LocalDate startDate;
	private EventOccurrence eventOccurrence = new SameDateOccurrence();
	private int recurrenceStep;
	private PeriodLength periodLength;

	public RecurringTimeExpressionBuilder startingOn(LocalDate startDate) {
		this.startDate = startDate;
		return this;
	}

	public RecurringTimeExpressionBuilder onDayOfMonth(int aDayInMonth) {
		eventOccurrence = new DayOfMonthOccurrence(aDayInMonth);
		return this;
	}

	public RecurringTimeExpressionBuilder occurring(EventOccurrence eventOccurrence) {
		this.eventOccurrence = eventOccurrence;
		return this;
	}

	public RecurringTimeExpressionBuilder every(int recurrenceStep) {
		this.recurrenceStep = recurrenceStep;
		return this;
	}

	public RecurringTimeExpressionBuilder days() {
		periodLength = new DailyPeriodLength();
		return this;
	}

	public RecurringTimeExpressionBuilder months() {
		periodLength = new MonthlyPeriodLength();
		return this;
	}

	public RecurringTimeExpressionBuilder years() {
		periodLength = new YearlyPeriodLength();
		return this;
	}

	public TimeExpression build() {
		// TODO: add checks for all parameters set (startDate, eventOccurrence, periodLength, recurrenceStep) before calling this method
		return new RecurringTimeExpression(startDate, eventOccurrence, periodLength, recurrenceStep);
	}
}
