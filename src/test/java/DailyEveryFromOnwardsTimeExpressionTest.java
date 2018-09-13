import java.time.LocalDate;
import junit.framework.TestCase;

public class DailyEveryFromOnwardsTimeExpressionTest extends TestCase {
	public void testRecursEveryEightDays() {
		int eightDays = 8; // you can change the Int type by the one you make up
		LocalDate today = LocalDate.now();

		TimeExpression everyTwoDaysFromTodayToTheNextSevenDaysTimeExp =
				TimeExpression
						.dailyEveryFromOnwards(
								eightDays,
								today
						);

		assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(1)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(2)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(3)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(4)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(5)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(6)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(7)));
		assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(8)));
		assertFalse(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(9)));
		assertTrue(everyTwoDaysFromTodayToTheNextSevenDaysTimeExp.isRecurringOn(today.plusDays(16)));
	}
}
