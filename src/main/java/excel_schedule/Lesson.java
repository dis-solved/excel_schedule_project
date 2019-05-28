package excel_schedule;

import java.time.*;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(from, lesson.from) &&
                Objects.equals(to, lesson.to) &&
                Objects.equals(date, lesson.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to, date);
    }
}
