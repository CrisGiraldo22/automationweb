package com.airbn.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import static com.airbn.UI.FiltrosServiciosUI.BTN_FILTROS;
import static com.airbn.UI.FiltrosServiciosUI.FILTRO_PRECIO_MAXIMO;
import static com.airbn.UI.ServiciosAlojamientoUI.SCROLL_IFRAME_FILTRO;
import static java.lang.String.valueOf;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PrecioMaximo implements Interaction {
    private static int precioMaximo;

    public PrecioMaximo(int precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(BTN_FILTROS),
                Click.on(FILTRO_PRECIO_MAXIMO),
                SendKeys.of(Keys.CONTROL,"a").into(FILTRO_PRECIO_MAXIMO),
                SendKeys.of(Keys.DELETE).into(FILTRO_PRECIO_MAXIMO),
                SendKeys.of(valueOf(precioMaximo)).into(FILTRO_PRECIO_MAXIMO),
                WaitUntil.the(SCROLL_IFRAME_FILTRO, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static PrecioMaximo botonFiltrar(int precioMaximo){
        return instrumented(PrecioMaximo.class, precioMaximo);
    }
}
