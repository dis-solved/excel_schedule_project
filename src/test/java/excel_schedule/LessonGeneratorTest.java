package excel_schedule;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class LessonGeneratorTest {
    @Test
    public void shouldGenerateCorrectLesson() {
        int hours = 9;
        LocalDate start = LocalDate.of(2019, 6, 1);
        List<ScheduleLesson> onceAWeek = Arrays.asList(new ScheduleLesson(DayOfWeek.MONDAY, LocalTime.of(18, 30), LocalTime.of(20, 0)));

        LessonGenerator lessonGenerator = new LessonGenerator(hours, start);
        List<Lesson> generatedLessons = lessonGenerator.generateLessons(onceAWeek);

        Assert.assertThat(generatedLessons, Matchers.hasSize(6));

        Assert.assertThat(generatedLessons, Matchers.hasItem(new Lesson(
                LocalTime.of(18, 30),
                LocalTime.of(20, 00),
                LocalDate.of(2019, 6, 3)))
        );
        Assert.assertThat(generatedLessons.get(2), Matchers.equalTo(new Lesson(
                LocalTime.of(18, 30),
                LocalTime.of(20, 0),
                LocalDate.of(2019, 6, 17)))
        );
    }
}
