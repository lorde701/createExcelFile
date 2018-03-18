import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Main {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);
        return style;
    }

    public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Данные");

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 13));

        int rowNum = 0;
        Cell cell;
        Row row;
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rowNum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Персональные данные");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Место проживания");
        cell.setCellStyle(style);

        rowNum++;
        row = sheet.createRow(rowNum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Фамилия");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Имя");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Отчество");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Возраст");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Пол");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Дата рождения");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Место рождения");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Почтовый индекс");
        cell.setCellStyle(style);

        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Страна");
        cell.setCellStyle(style);

        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("Область");
        cell.setCellStyle(style);

        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("Город");
        cell.setCellStyle(style);

        cell = row.createCell(11, CellType.STRING);
        cell.setCellValue("Улица");
        cell.setCellStyle(style);

        cell = row.createCell(12, CellType.STRING);
        cell.setCellValue("Дом");
        cell.setCellStyle(style);

        cell = row.createCell(13, CellType.STRING);
        cell.setCellValue("Квартира");
        cell.setCellStyle(style);

        PersonData personData;
        ResidencePlace residencePlace;

        for (int i = 0; i < Math.random() * 30; i++) {
            rowNum++;
            row = sheet.createRow(rowNum);

            personData = new PersonData();
            residencePlace = new ResidencePlace();

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(personData.getLastName());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(personData.getName());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(personData.getPatronymic());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(personData.getAge());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(personData.getGender());

            cell = row.createCell(5, CellType.STRING);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(personData.getBirthDate());
            cell.setCellValue(String.format("%02d-%02d-%4d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(personData.getBirthPlace());

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue(residencePlace.getPostCode());

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(residencePlace.getCountry());

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue(residencePlace.getRegion());

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue(residencePlace.getCity());

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue(residencePlace.getStreet());

            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue(residencePlace.getHouse());

            cell = row.createCell(13, CellType.STRING);
            cell.setCellValue(residencePlace.getFlat());
        }

        for (int i = 0; i < 15; i++) {
            sheet.autoSizeColumn(i);
        }

        File file = new File("personData.xls");

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        log.print("Файл создан. Путь: " + file.getAbsolutePath());
//        System.out.println("Файл создан. Путь: " + file.getAbsolutePath());
    }
}
