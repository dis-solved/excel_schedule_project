package excel_schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class ScheduleLesson {
    private DayOfWeek day;
    private LocalTime from;
    private LocalTime to;

    public ScheduleLesson(DayOfWeek day, LocalTime from, LocalTime to) {
        this.day = day;
        this.from = from;
        this.to = to;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "ScheduleLesson{" +
                "day=" + day +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}