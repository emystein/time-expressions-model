import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NonRecurringTimeExpression extends TimeExpression {
	private final LocalDate checkDate;

	public boolean isRecurringOn(LocalDate date) {
		return date.isEqual(checkDate);
	}
}
