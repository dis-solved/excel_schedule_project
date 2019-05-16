package excel_schedule;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.*;
import java.util.Calendar;

public class App
{
    public static void main(String[] args) throws IOException {
        Workbook sample = new XSSFWorkbook();

        Sheet sheet1 = sample.createSheet("new sheet");
        Sheet sheet2 = sample.createSheet("same sheet");
        LocalDate now = LocalDate.now();

        Row row0 = sheet1.createRow(0);
        row0.createCell(0).setCellValue(String.valueOf(now));
        row0.createCell(1).setCellValue(1.1);
        row0.createCell(2).setCellValue(Calendar.getInstance());
        row0.createCell(3).setCellValue("a string");
        row0.createCell(4).setCellValue(true);
        row0.createCell(5).setCellType(CellType.ERROR);

        sheet1.autoSizeColumn(0);


        try (OutputStream fileOut = new FileOutputStream("sample.xlsx")){
            sample.write(fileOut);
        }


    }
}
