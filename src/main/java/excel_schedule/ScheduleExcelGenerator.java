package excel_schedule;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

public class ScheduleExcelGenerator {
    Workbook workbook;
    Sheet scheduleSheet;
    int lessons = 0;

    ScheduleExcelGenerator(){
        workbook = new XSSFWorkbook();
        scheduleSheet = workbook.createSheet("Schedule");
    }

    public void addGeneralSection(CourseInformation courseInformation){
                scheduleSheet.createRow(0).createCell(0).setCellValue(courseInformation.getName());
                scheduleSheet.createRow(1).createCell(0).setCellValue(courseInformation.getTotalHours());
    }

    public void addLesson(Lesson lesson){
        int rowNum = 2 + lessons + 1;

        Row row = scheduleSheet.createRow(rowNum);
        Cell date = row.createCell(0);
        date.setCellValue(lesson.getDate().format(DateTimeFormatter.ISO_DATE));

        Cell timeFrom = row.createCell(1);
        timeFrom.setCellValue(lesson.getFrom().format(DateTimeFormatter.ofPattern("HH:mm")));

        Cell timeTo = row.createCell(2);
        timeTo.setCellValue(lesson.getTo().format(DateTimeFormatter.ofPattern("HH:mm")));

        lessons++;
    }

    public void generate (Path target) throws IOException{
        workbook.write(Files.newOutputStream(target));
    }
}
