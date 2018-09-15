import java.time.LocalDate;

public class NonRecurringTimeExpressionBuilder {
	public TimeExpression on(LocalDate date) {
		return new NonRecurringTimeExpression(date);
	}
}
