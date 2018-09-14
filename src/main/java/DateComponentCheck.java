import java.time.LocalDate;

public interface DateComponentCheck {
	boolean matches(LocalDate date, LocalDate checkDate);
}
