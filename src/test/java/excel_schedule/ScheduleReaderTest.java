package excel_schedule;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleReaderTest {
    @Test
    public void shouldReadScheduleCorrectly() throws IOException {
        ScheduleReader scheduleReader = new ScheduleReader();
        scheduleReader.read(Paths.get("sample.txt"));

        Assert.assertThat(scheduleReader.getCourse().getName(), Matchers.equalTo("Sample"));
        Assert.assertThat(scheduleReader.getCourse().getTotalHours(), Matchers.is(777.0));
        Assert.assertThat(scheduleReader.getCourse().getStartDate(),
                Matchers.is(LocalDate.of(2019, 7, 1)));
        Assert.assertThat(scheduleReader.getSchedules(), Matchers.hasSize(3));
        Assert.assertThat(scheduleReader.getSchedules().get(1).getDay(), Matchers.is(DayOfWeek.WEDNESDAY));
        Assert.assertThat(scheduleReader.getSchedules().get(0).getFrom(), Matchers.equalTo(LocalTime.of(18, 0)));
        Assert.assertThat(scheduleReader.getSchedules().get(2).getTo(), Matchers.equalTo(LocalTime.of(19, 0)));
    }
}
