import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OnSpecificDateTimeExpression extends TimeExpression {
	private final LocalDate checkDate;

	public boolean isRecurringOn(LocalDate date) {
		return date.isEqual(checkDate);
	}
}
