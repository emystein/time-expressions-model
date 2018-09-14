import java.time.LocalDate;

public interface StepCommand {
	LocalDate execute(LocalDate date, int step);
}
