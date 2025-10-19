package com.airbn.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.airbn.UI.FiltrosServiciosUI.BTN_MENSAJE_INFO;
import static com.airbn.UI.QuienCuantosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class QuienCuantosTask implements Task {

    private final int cantidadAdultos;
    private final int cantidadNinos;
    private final int cantidadMascotas;

    public QuienCuantosTask(int cantidadAdultos, int cantidadNinos, int cantidadMascotas) {
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cantidadMascotas = cantidadMascotas;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_QUIEN_CUANTOS));

        for (int i = 0; i < cantidadAdultos; i++) {
            actor.attemptsTo(Click.on(BTN_MAS_ADULTOS));
        }

        for (int i = 0; i < cantidadNinos; i++) {
            actor.attemptsTo(Click.on(BTN_MAS_NINOS));
        }

        for (int i = 0; i < cantidadMascotas; i++) {
            actor.attemptsTo(Click.on(BTN_MAS_MASCOTAS));
        }

        actor.attemptsTo(Click.on(BTN_BUSCAR),
        WaitUntil.the(BTN_MENSAJE_INFO, isVisible()).forNoMoreThan(10).seconds(),
        Click.on(BTN_MENSAJE_INFO));

    }

    public static QuienCuantosTask quienCuantosTask(int cantidadAdultos, int cantidadNinos, int cantidadMascotas) {
        return instrumented(QuienCuantosTask.class, cantidadAdultos, cantidadNinos, cantidadMascotas);
    }
}
