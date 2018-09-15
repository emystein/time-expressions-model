public class TimeExpressionBuilder {
	public static NonRecurringTimeExpressionBuilder once() {
		return new NonRecurringTimeExpressionBuilder();
	}

	public static RecurringTimeExpressionBuilder recurring() {
		return new RecurringTimeExpressionBuilder();
	}
}
