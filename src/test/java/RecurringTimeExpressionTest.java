import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class RecurringTimeExpressionTest {
	LocalDate startDate = LocalDate.of(2018, 9, 1);

	@Test
	public void everyMonthOccurrenceSameEndDateAsStartDate() {
		RecurringTimeExpression occurrence = new RecurringTimeExpression(startDate, new SpecificDatePoint(), new DateStep(1, new MonthlyStepCommand()));

		assertTrue(occurrence.isRecurringOn(startDate));
	}

	@Test
	public void everyMonthOccurrence() {
		RecurringTimeExpression occurrence = new RecurringTimeExpression(startDate, new SpecificDatePoint(), new DateStep(1, new MonthlyStepCommand()));

		assertTrue(occurrence.isRecurringOn(startDate.plusMonths(1)));
	}

	@Test
	public void everyTwoMonthsOccurrence() {
		RecurringTimeExpression occurrence = new RecurringTimeExpression(startDate, new SpecificDatePoint(), new DateStep(2, new MonthlyStepCommand()));

		assertFalse(occurrence.isRecurringOn(startDate.plusMonths(1)));
		assertTrue(occurrence.isRecurringOn(startDate.plusMonths(2)));
	}


	@Test
	public void everyFirstFriday() {
		LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);

		RecurringTimeExpression occurrence = new RecurringTimeExpression(firstFridayOfJanuary2012, new DayOfWeekInMonthPoint(1, DayOfWeek.FRIDAY), new DateStep(1, new MonthlyStepCommand()));

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

		RecurringTimeExpression occurrence = new RecurringTimeExpression(firstFridayOfJanuary2012, new DayOfWeekInMonthPoint(1, DayOfWeek.FRIDAY), new DateStep(2, new MonthlyStepCommand()));

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

		RecurringTimeExpression occurrence = new RecurringTimeExpression(january8th, new DayOfMonthPoint(8), new DateStep(1, new MonthlyStepCommand()));

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

		RecurringTimeExpression occurrence = new RecurringTimeExpression(january8th, new DayOfMonthPoint(8), new DateStep(2, new MonthlyStepCommand()));

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
