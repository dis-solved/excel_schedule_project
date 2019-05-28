package excel_schedule;

import java.time.*;


public class Lesson {
    private LocalTime from;
    private LocalTime to;
    private LocalDate date;

    public Lesson(LocalTime from, LocalTime to, LocalDate date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public LocalTime getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }
}
