package com.airbn.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import static com.airbn.UI.FiltrosServiciosUI.BTN_FILTROS;
import static com.airbn.UI.FiltrosServiciosUI.FILTRO_PRECIO_MAXIMO;
import static java.lang.String.valueOf;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BotonFiltrar implements Interaction {
    private static int precioMaximo;

    public BotonFiltrar(int precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(BTN_FILTROS),
                Click.on(FILTRO_PRECIO_MAXIMO),
                SendKeys.of(Keys.DELETE).into(FILTRO_PRECIO_MAXIMO),
                SendKeys.of(valueOf(precioMaximo)).into(FILTRO_PRECIO_MAXIMO)
        );
    }

    public static BotonFiltrar botonFiltrar(int precioMaximo){
        return instrumented(BotonFiltrar.class, precioMaximo);
    }
}
