import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class NonRecurringTimeExpressionBuilderTest {
	private TimeExpression actual;
	private TimeExpression expected;

	@Test
	public void buildNonRecurringTimeExpression() {
		LocalDate date = LocalDate.of(2012, 1, 1);

		actual = TimeExpressionBuilder.once().on(date);

		expected = new NonRecurringTimeExpression(date);

		assertEquals(expected, actual);
	}
}
