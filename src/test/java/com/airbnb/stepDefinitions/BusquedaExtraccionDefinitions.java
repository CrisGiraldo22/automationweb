package com.airbnb.stepDefinitions;


import com.airbn.task.AbrirNavegadorTask;
import com.airbn.task.BuscarPorFechaTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class BusquedaExtraccionDefinitions {
    @Before
    public void ConfigurarEscenario(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentra en la pagina principal de Airbnb")
    public void queElUsuarioSeEncuentraEnLaPaginaPrincipalDeAirbnb() {
        setTheStage(new OnlineCast());
        OnStage.theActorCalled("Navegar a la pagina airbnb").attemptsTo(AbrirNavegadorTask.openPage());
    }

    @Cuando("el usuario ingresa el destino {string} con la cantidad de días {int} para la estadia")
    public void elUsuarioIngresaElDestinoConLaCantidadDeDíasParaLaEstadia(String destino, int cantidadDias) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarPorFechaTask.conDuracionDeDias(destino,cantidadDias)

        );
    }
}
