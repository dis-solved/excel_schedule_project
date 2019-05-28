package excel_schedule;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ScheduleApp {
    public static void main(String[] args) throws IOException {
        String scheduleTxtFile = "schedule.txt";

        ScheduleReader scheduleReader = new ScheduleReader();
        scheduleReader.read(Paths.get(scheduleTxtFile));
        CourseInformation course = scheduleReader.getCourse();
        List<ScheduleLesson> schedule = scheduleReader.getSchedules();

        LessonGenerator lessonGenerator = new LessonGenerator(course.getTotalHours(),course.getStartDate());
        List<Lesson> lessons = lessonGenerator.generateLessons(schedule);

        ScheduleExcelGenerator excelGenerator = new ScheduleExcelGenerator();
        excelGenerator.addGeneralSection(course);
        for (Lesson lesson: lessons){
            excelGenerator.addLesson(lesson);
        }

        excelGenerator.generate(Paths.get("Schedule.xlsx"));
    }

//    private static List<Lesson> generateLessons(){
//        return IntStream.range(1,5)
//                .mapToObj(ScheduleApp::generateLesson)
//                .collect(Collectors.toList());
//    }
//
//    private static Lesson generateLesson(int i){
//        return new Lesson(
//                LocalTime.of(18,0),
//                LocalTime.of(20,0),
//                LocalDate.now().plusDays(i)
//        );
//    }
}
