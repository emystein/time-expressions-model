import java.time.LocalDate;

public interface DateStep {
	LocalDate next(LocalDate startDate, LocalDate date);
}
