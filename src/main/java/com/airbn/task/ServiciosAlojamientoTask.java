package com.airbn.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.airbn.UI.ServiciosAlojamientoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ServiciosAlojamientoTask implements Task {
    private  String servicio1;
    private  String servicio2;
    private  String servicio3;

    public ServiciosAlojamientoTask(String servicio1, String servicio2, String servicio3) {
        this.servicio1 = servicio1;
        this.servicio2 = servicio2;
        this.servicio3= servicio3;

    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Scroll.to(SCROLL_IFRAME_FILTRO),
                WaitUntil.the(BTN_MUSTRA_MAS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MUSTRA_MAS),
                Click.on(BTN_SERVICIO.of(servicio1)),
                Click.on(BTN_SERVICIO.of(servicio2)),
                Click.on(BTN_SERVICIO.of(servicio3)),
                Click.on(BTN_MOSTRAR_LUGARES)

        );
    }
    public static ServiciosAlojamientoTask serviciosAlojamientoTask(String servicio1, String servicio2, String servicio3){
        return instrumented(ServiciosAlojamientoTask.class, servicio1, servicio2, servicio3);
    }
}
