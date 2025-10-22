package com.airbn.task;

import com.airbn.utils.VariablesExtraccionDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirDatosExcelTask implements Task {
    private final String rutaCompletaArchivoExcel;

    private static final String TITULO = "Título del Alojamiento";
    private static final String ANFITRION = "Anfitrión";
    private static final String PRECIO = "Precio";
    private static final String SHEET_NAME = "Datos de Alojamiento";
    private static final String[] HEADERS = {"TITULO ALOJAMIENTO", "ANFITRION DEL ALOJAMIENTO", "PRECIO DEL ALOJAMIENTO"};


    public EscribirDatosExcelTask(String rutaCompletaArchivoExcel) {
        this.rutaCompletaArchivoExcel = rutaCompletaArchivoExcel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        @SuppressWarnings("datos")
        Map<String, String> datos = actor.recall(VariablesExtraccionDatos.DATOS_DEL_ALOJAMIENTO.name());

        if (datos == null || datos.isEmpty()) {
            System.err.println("Advertencia: La sesión no contiene datos para exportar.");
            return;
        }

        escribirDatosAExcel(datos, rutaCompletaArchivoExcel);
    }

    private void escribirDatosAExcel(Map<String, String> datos, String rutaArchivo) {
        Workbook workbook = null;
        Sheet sheet;
        int rowNum;
        File file = new File(rutaArchivo);

        try {
            if (file.exists() && file.length() > 0) {
                try (FileInputStream fileIn = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fileIn);
                }
                sheet = workbook.getSheet(SHEET_NAME);
                if (sheet == null) {
                    sheet = workbook.createSheet(SHEET_NAME);
                    rowNum = 0;
                } else {
                    rowNum = sheet.getLastRowNum() + 1;
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(SHEET_NAME);
                rowNum = 0;
            }

            if (rowNum == 0) {
                CellStyle headerStyle = workbook.createCellStyle();
                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerStyle.setFont(headerFont);

                Row headerRow = sheet.createRow(0);

                for (int i = 0; i < HEADERS.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(HEADERS[i]);
                    cell.setCellStyle(headerStyle);
                }
                rowNum = 1;
            }

            String titulo = datos.getOrDefault(TITULO, "N/A");
            String anfitrion = datos.getOrDefault(ANFITRION, "N/A");
            String precio = datos.getOrDefault(PRECIO, "N/A");

            Row dataRow = sheet.createRow(rowNum);

            dataRow.createCell(0).setCellValue(titulo);

            dataRow.createCell(1).setCellValue(anfitrion);

            dataRow.createCell(2).setCellValue(precio);

            if (rowNum == 1) {
                for (int i = 0; i < HEADERS.length; i++) {
                    sheet.autoSizeColumn(i);
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo)) {
                workbook.write(fileOut);
                System.out.println(" Exportación exitosa. Archivo creado/actualizado. Fila de datos: " + rowNum + ". Ruta: " +
                        rutaArchivo);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al manejar o escribir el archivo Excel en: " + rutaArchivo, e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el libro: " + e.getMessage());
                }
            }
        }
    }

    public static EscribirDatosExcelTask escribirDatos(String rutaCompletaArchivoExcel) {
        return instrumented(EscribirDatosExcelTask.class, rutaCompletaArchivoExcel);
    }
}
