package excel_schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class LessonGenerator {
    private double totalHours;
    private LocalDate startDate;

    public LessonGenerator(double totalHours, LocalDate startDate) {
        this.totalHours = totalHours;
        this.startDate = startDate;
    }

    public List<Lesson> generateLessons(List<ScheduleLesson> schedule) {
        List<Lesson> lessons = new ArrayList<>();
        int i = 0;
        double plannedHours = 0;

        while (plannedHours < totalHours) {
            lessons.add(new Lesson(
                    schedule.get(i).getFrom(),
                    schedule.get(i).getTo(),
                    startDate = startDate.with(TemporalAdjusters.nextOrSame(schedule.get(i).getDay()))));
            plannedHours += (double) (Duration.between(
                    schedule.get(i).getFrom(),
                    schedule.get(i).getTo()).toMinutes()
            ) / 60;
            i++;
            startDate = startDate.plusDays(1);
            if (i == schedule.size()) {
                i = 0;
            }
        }
        return lessons;
    }
}
