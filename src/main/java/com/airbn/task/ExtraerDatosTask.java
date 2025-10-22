package com.airbn.task;

import com.airbn.utils.VariablesExtraccionDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;
import java.util.Map;

import static com.airbn.UI.ExtraccionDatosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ExtraerDatosTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(PRIMER_RESULTADO_BUSQUEDA),
                Switch.toNewWindow(),
                WaitUntil.the(TITULO_ALOJAMIENTO, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(MENSAJE_TRADUCCION),
                Click.on(CLICK_PRECIO)
        );
        String titulo = Text.of(TITULO_ALOJAMIENTO).answeredBy(actor);
        String precio = Text.of(PRECIO_ALOJAMIENTO).answeredBy(actor);
        String anfitrion = Text.of(ANFITRION).answeredBy(actor);

        if (anfitrion.contains(":")) {
            String[] partes = anfitrion.split(":", 2);
            if (partes.length > 1) {
                anfitrion = partes[1].trim();
            }
        }

        Map<String, String> datosAlojamiento = new HashMap<>();
        datosAlojamiento.put("Título del Alojamiento", titulo);
        datosAlojamiento.put("Precio", precio);
        datosAlojamiento.put("Anfitrión", anfitrion);

        actor.remember(VariablesExtraccionDatos.DATOS_DEL_ALOJAMIENTO.name(), datosAlojamiento);

        System.out.println(
                "Datos extraídos del primer resultado de búsqueda con filtros del alojamiento" + datosAlojamiento);
    }

    public static ExtraerDatosTask extraerDatosTask(){
        return instrumented(ExtraerDatosTask.class);
    }
}