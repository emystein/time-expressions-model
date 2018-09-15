import java.time.LocalDate;
import arithmetic.DailyPeriodLength;
import arithmetic.MonthlyPeriodLength;
import arithmetic.PeriodLength;
import arithmetic.YearlyPeriodLength;
import event.DayOfMonthOccurrence;
import event.EventOccurrence;
import event.SpecificDateOccurrence;

public class RecurringTimeExpressionBuilder {
	private LocalDate startDate;
	private EventOccurrence eventOccurrence = new SpecificDateOccurrence();
	private int recurrenceStep;
	private PeriodLength periodLength;

	public RecurringTimeExpressionBuilder() {
		// empty
	}

	private RecurringTimeExpressionBuilder(LocalDate startDate) {
		this.startDate = startDate;
	}

	public RecurringTimeExpressionBuilder startingOn(LocalDate startDate) {
		return new RecurringTimeExpressionBuilder(startDate);
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
		return new RecurringTimeExpression(startDate, eventOccurrence, periodLength, recurrenceStep);
	}
}
