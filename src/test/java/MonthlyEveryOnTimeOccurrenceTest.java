import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class MonthlyEveryOnTimeOccurrenceTest {
	LocalDate startDate = LocalDate.of(2018, 9, 1);

	@Test
	public void everyMonthOccurrenceSameEndDateAsStartDate() {
		TimeOccurrence occurrence = new TimeOccurrence(startDate, new SpecificDatePoint(), new MonthlyStep(1));

		assertTrue(occurrence.matches(startDate));
	}

	@Test
	public void everyMonthOccurrence() {
		TimeOccurrence occurrence = new TimeOccurrence(startDate, new SpecificDatePoint(), new MonthlyStep(1));

		assertTrue(occurrence.matches(startDate.plusMonths(1)));
	}

	@Test
	public void everyTwoMonthsOccurrence() {
		TimeOccurrence occurrence = new TimeOccurrence(startDate, new SpecificDatePoint(), new MonthlyStep(2));

		assertFalse(occurrence.matches(startDate.plusMonths(1)));
		assertTrue(occurrence.matches(startDate.plusMonths(2)));
	}


	@Test
	public void everyFirstFriday() {
		LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);

		TimeOccurrence occurrence = new TimeOccurrence(firstFridayOfJanuary2012, new DayOfWeekInMonthPoint(1, DayOfWeek.FRIDAY), new MonthlyStep(1));

		assertTrue(occurrence.matches(firstFridayOfJanuary2012)); // first friday of january
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(1)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(2)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(3)));
		assertTrue(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(4))); // first friday of february
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(5)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(6)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(7)));
		assertTrue(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(8))); // first friday of march
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(9)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(10)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(11)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(12)));
		assertTrue(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(13))); // first friday of april
	}

	@Test
	public void theFirstFridayEveryTwoMonths() {
		LocalDate firstFridayOfJanuary2012 = LocalDate.of(2012, 1, 6);

		TimeOccurrence occurrence = new TimeOccurrence(firstFridayOfJanuary2012, new DayOfWeekInMonthPoint(1, DayOfWeek.FRIDAY), new MonthlyStep(2));

		assertTrue(occurrence.matches(firstFridayOfJanuary2012)); // first friday of january
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(1)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(2)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(3)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(4))); // first friday of february
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(5)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(6)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(7)));
		assertTrue(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(8))); // first friday of march
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(9)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(10)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(11)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(12)));
		assertFalse(occurrence.matches(firstFridayOfJanuary2012.plusWeeks(13))); // first friday of april
	}

	@Test
	public void every8thOfMonth() {
		LocalDate january8th = LocalDate.of(2012, 1, 8);

		TimeOccurrence occurrence = new TimeOccurrence(january8th, new DayOfMonthPoint(8), new MonthlyStep(1));

		assertTrue(occurrence.matches(january8th));
		assertFalse(occurrence.matches(january8th.plusWeeks(1)));
		assertFalse(occurrence.matches(january8th.plusWeeks(2)));
		assertFalse(occurrence.matches(january8th.plusWeeks(3)));
		assertFalse(occurrence.matches(january8th.plusWeeks(4)));
		assertTrue(occurrence.matches(january8th.plusMonths(1)));
		assertFalse(occurrence.matches(january8th.plusWeeks(5)));
		assertTrue(occurrence.matches(january8th.plusMonths(2)));
		assertTrue(occurrence.matches(LocalDate.of(2012, 4, 8)));
		assertFalse(occurrence.matches(LocalDate.of(2012, 4, 10)));
	}

	@Test
	public void on8thOfMonthEveryTwoMonths() {
		LocalDate january8th = LocalDate.of(2012, 1, 8);

		TimeOccurrence occurrence = new TimeOccurrence(january8th, new DayOfMonthPoint(8), new MonthlyStep(2));

		assertTrue(occurrence.matches(january8th));
		assertFalse(occurrence.matches(january8th.plusWeeks(1)));
		assertFalse(occurrence.matches(january8th.plusWeeks(2)));
		assertFalse(occurrence.matches(january8th.plusWeeks(3)));
		assertFalse(occurrence.matches(january8th.plusWeeks(4)));
		assertFalse(occurrence.matches(january8th.plusMonths(1)));
		assertFalse(occurrence.matches(january8th.plusWeeks(5)));
		assertTrue(occurrence.matches(january8th.plusMonths(2)));
		assertFalse(occurrence.matches(LocalDate.of(2012, 4, 8)));
		assertTrue(occurrence.matches(LocalDate.of(2012, 5, 8)));
	}
}
