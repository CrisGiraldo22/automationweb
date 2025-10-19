package com.airbn.task;

import com.airbn.utils.VariablesExtraccionDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirDatosExcelTask implements Task {
    private final String rutaCompletaArchivoExcel;

    public EscribirDatosExcelTask(String rutaCompletaArchivoExcel) {
        this.rutaCompletaArchivoExcel = rutaCompletaArchivoExcel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        @SuppressWarnings("unchecked")
        Map<String, String> datos = actor.recall(VariablesExtraccionDatos.DATOS_DEL_ALOJAMIENTO.name());

        if (datos == null || datos.isEmpty()) {
            throw new RuntimeException("Error: La sesión no contiene datos para exportar.");
        }

        escribirDatosAExcel(datos, rutaCompletaArchivoExcel);
    }

    private void escribirDatosAExcel(Map<String, String> datos, String rutaArchivo) {

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Datos de Alojamiento");

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);
            String[] headers = {"Campo", "Valor Extraído"};

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Map.Entry<String, String> entry : datos.entrySet()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo)) {
                workbook.write(fileOut);
                System.out.println("🎉 Exportación exitosa. Archivo creado en: " + rutaArchivo);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al crear o escribir el archivo Excel en: " + rutaArchivo, e);
        }
    }

    public static EscribirDatosExcelTask escribirDatos(String rutaCompletaArchivoExcel) {
        return instrumented(EscribirDatosExcelTask.class, rutaCompletaArchivoExcel);
    }
}