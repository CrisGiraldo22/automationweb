package com.airbn.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.airbn.UI.BuscarFechasUI.BTN_FECHAS;
import static com.airbn.UI.BuscarFechasUI.IMPUT_DONDE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class BuscarPorFechaTask implements Task {
    private final String destino;
    private final int cantidadDias;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public BuscarPorFechaTask(String destino,int cantidadDias) {
        this.destino = destino;
        this.cantidadDias = cantidadDias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaSalida = fechaActual.plusDays(cantidadDias);

        String fechaEntradaFormat = fechaActual.format(FORMATO_FECHA);
        String fechaSalidaFormat = fechaSalida.format(FORMATO_FECHA);

        actor.attemptsTo(
                Enter.theValue(destino).into(IMPUT_DONDE),
                SendKeys.of(Keys.ENTER).into(IMPUT_DONDE),
                WaitUntil.the(BTN_FECHAS, isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_FECHAS.of(fechaEntradaFormat).called("Día de Ingreso: " + fechaEntradaFormat)),
                Click.on(BTN_FECHAS.of(fechaSalidaFormat).called("Día de Salida: " + fechaSalidaFormat))
        );

    }

    public static BuscarPorFechaTask conDuracionDeDias(String destino,int cantidadDias) {
        return instrumented(BuscarPorFechaTask.class,destino, cantidadDias);
    }
}