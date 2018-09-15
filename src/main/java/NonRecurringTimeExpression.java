import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class NonRecurringTimeExpression extends TimeExpression {
	private final LocalDate checkDate;

	public boolean isRecurringOn(LocalDate date) {
		return date.isEqual(checkDate);
	}
}
