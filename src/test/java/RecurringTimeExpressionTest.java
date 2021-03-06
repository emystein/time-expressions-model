import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;
import arithmetic.DailyPeriodLength;
import arithmetic.MonthlyPeriodLength;
import event.DayOfMonthOccurrence;
import event.DayOfWeekInMonthOccurrence;
import event.EventRecurrence;
import event.SameDateOccurrence;

public class RecurringTimeExpressionTest {
	private RecurringTimeExpression occurrence;
	private LocalDate startDate = LocalDate.of(2018, 9, 1);
	private LocalDate noEndDate = null;

	@Test
	public void everyEightDays() {
		occurrence = new RecurringTimeExpression(new SameDateOccurrence(),
													new EventRecurrence(startDate, new DailyPeriodLength(), 8, noEndDate));

		assertTrue(occurrence.isRecurringOn(startDate));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(1)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(2)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(3)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(4)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(5)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(6)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(7)));
		assertTrue(occurrence.isRecurringOn(startDate.plusDays(8)));
		assertFalse(occurrence.isRecurringOn(startDate.plusDays(9)));
		assertTrue(occurrence.isRecurringOn(startDate.plusDays(16)));
	}

	@Test
	public void everyMonthOccurrenceSameEndDateAsStartDate() {
		occurrence = new RecurringTimeExpression(new SameDateOccurrence(),
													new EventRecurrence(startDate, new MonthlyPeriodLength(), 1, noEndDate));

		assertTrue(occurrence.isRecurringOn(startDate));
	}

	@Test
	public void everyMonthOccurrence() {
		occurrence = new RecurringTimeExpression(new SameDateOccurrence(),
													new EventRecurrence(startDate, new MonthlyPeriodLength(), 1, noEndDate));

		assertTrue(occurrence.isRecurringOn(startDate.plusMonths(1)));
	}

	@Test
	public void everyTwoMonthsOccurrence() {
		occurrence = new RecurringTimeExpression(new SameDateOccurrence(),
													new EventRecurrence(startDate, new MonthlyPeriodLength(), 2, noEndDate));

		assertFalse(occurrence.isRecurringOn(startDate.plusMonths(1)));
		assertTrue(occurrence.isRecurringOn(startDate.plusMonths(2)));
	}


	@Test
	public void everyFirstFriday() {
		LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);

		occurrence = new RecurringTimeExpression(new DayOfWeekInMonthOccurrence(1, DayOfWeek.FRIDAY),
													new EventRecurrence(firstFridayOfJanuary2012, new MonthlyPeriodLength(), 1, noEndDate));

		assertTrue(occurrence.isRecurringOn(firstFridayOfJanuary2012)); // first friday of january
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(1)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(2)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(3)));
		assertTrue(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(4))); // first friday of february
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(5)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(6)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(7)));
		assertTrue(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(8))); // first friday of march
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(9)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(10)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(11)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(12)));
		assertTrue(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(13))); // first friday of april
	}

	@Test
	public void theFirstFridayEveryTwoMonths() {
		LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);

		occurrence = new RecurringTimeExpression(new DayOfWeekInMonthOccurrence(1, DayOfWeek.FRIDAY),
														new EventRecurrence(firstFridayOfJanuary2012, new MonthlyPeriodLength(), 2, noEndDate));

		assertTrue(occurrence.isRecurringOn(firstFridayOfJanuary2012)); // first friday of january
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(1)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(2)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(3)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(4))); // first friday of february
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(5)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(6)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(7)));
		assertTrue(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(8))); // first friday of march
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(9)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(10)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(11)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(12)));
		assertFalse(occurrence.isRecurringOn(firstFridayOfJanuary2012.plusWeeks(13))); // first friday of april
	}

	@Test
	public void every8thOfMonth() {
		LocalDate january8th = LocalDate.of(2012, 1, 8);

		occurrence = new RecurringTimeExpression(new DayOfMonthOccurrence(8),
														new EventRecurrence(january8th, new MonthlyPeriodLength(), 1, noEndDate));

		assertTrue(occurrence.isRecurringOn(january8th));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(1)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(2)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(3)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(4)));
		assertTrue(occurrence.isRecurringOn(january8th.plusMonths(1)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(5)));
		assertTrue(occurrence.isRecurringOn(january8th.plusMonths(2)));
		assertTrue(occurrence.isRecurringOn(LocalDate.of(2012, 4, 8)));
		assertFalse(occurrence.isRecurringOn(LocalDate.of(2012, 4, 10)));
	}

	@Test
	public void on8thOfMonthEveryTwoMonths() {
		LocalDate january8th = LocalDate.of(2012, 1, 8);

		occurrence = new RecurringTimeExpression(new DayOfMonthOccurrence(8),
													new EventRecurrence(january8th, new MonthlyPeriodLength(), 2, noEndDate));

		assertTrue(occurrence.isRecurringOn(january8th));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(1)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(2)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(3)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(4)));
		assertFalse(occurrence.isRecurringOn(january8th.plusMonths(1)));
		assertFalse(occurrence.isRecurringOn(january8th.plusWeeks(5)));
		assertTrue(occurrence.isRecurringOn(january8th.plusMonths(2)));
		assertFalse(occurrence.isRecurringOn(LocalDate.of(2012, 4, 8)));
		assertTrue(occurrence.isRecurringOn(LocalDate.of(2012, 5, 8)));
	}


}
