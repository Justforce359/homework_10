package com.justforge359;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.*;

public class ArchiveZipTest {

    String pdfFile = "sample.pdf";
    String csvFile = "addresses.csv";
    String xlsxFile = "PARFUM-demo.xlsx";

    @Test
    @DisplayName("Тест чтения PDF файла из архива")
    void pdfFileCheckInZipFile() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/Example.zip"))) {
            ZipEntry pdfEntry = zip.getEntry(pdfFile);
            try (InputStream stream = zip.getInputStream(pdfEntry)) {
                PDF pdf = new PDF(stream);
                assertTrue(pdf.text.startsWith(" A Simple PDF"));
            }
        }
    }

    @Test
    @DisplayName("Тест чтения XLSX файла из архива")
    public void xlsxFileCheckInZipFile() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/Example.zip"))) {
            ZipEntry xlsxEntry = zip.getEntry(xlsxFile);
            try (InputStream stream = zip.getInputStream(xlsxEntry)) {
                XLS xlsx = new XLS(stream);
                assertEquals("ДУШИСТЫЙ ОДЕКОЛОН КЛЕВЕРЕНС БЕЗ ЗАПАХОВ", xlsx.excel.getSheetAt(0).getRow(6).getCell(5).getStringCellValue());
            }
        }
    }

    @Test
    @DisplayName("Тест чтения CSV файла из архива")
    public void csvFileCheckInZipFile() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/Example.zip"))) {
            ZipEntry csvEntry = zip.getEntry(csvFile);
            try (InputStream stream = zip.getInputStream(csvEntry)) {
                CSVReader csvReader = new CSVReader(new InputStreamReader(stream));
                List<String[]> content = csvReader.readAll();
                assertArrayEquals(new String[]{"John", "Doe", "120 jefferson st.", "Riverside", " NJ", " 08075"}, content.get(0));

            }

        }
    }
}
