package com.airbn.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.airbn.UI.ServiciosAlojamientoUI.TITULO_RESULTADO_BUSQUEDA;

public class ReservaAlojamientoQ implements Question<String> {
    @Override
    public String answeredBy(Actor actor){
        return Text.of(TITULO_RESULTADO_BUSQUEDA).answeredBy(actor);
    }

    public static ReservaAlojamientoQ reservaAlojamientoQ(){
        return new ReservaAlojamientoQ();
    }
}
