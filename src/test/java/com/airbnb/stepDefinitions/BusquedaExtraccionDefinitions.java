package com.airbnb.stepDefinitions;


import com.airbn.interactions.PrecioMaximo;
import com.airbn.questions.ReservaAlojamientoQ;
import com.airbn.task.*;
import com.airbn.utils.VariablesExtraccionDatos;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class BusquedaExtraccionDefinitions {
    @Before
    public void ConfigurarEscenario(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentra en la pagina principal de Airbnb")
    public void queElUsuarioSeEncuentraEnLaPaginaPrincipalDeAirbnb() {
        OnStage.theActorCalled("Navegar a la pagina airbnb").attemptsTo(AbrirNavegadorTask.openPage());
    }

    @Cuando("el usuario ingresa el destino {string} con la cantidad de días {int} para la estadia")
    public void elUsuarioIngresaElDestinoConLaCantidadDeDíasParaLaEstadia(String destino, int cantidadDias) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarPorFechaTask.conDuracionDeDias(destino,cantidadDias)

        );
    }

    @Y("el usuario filtra por  adultos {int}, niños {int} y mascotas {int}")
    public void elUsuarioFiltraPorAdultosNiñosYMascotas(int cantidaAdultos, int cantidadNinos, int cantidadMascotas) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                QuienCuantosTask.quienCuantosTask(cantidaAdultos, cantidadNinos, cantidadMascotas)
        );
    }

    @Y("el usuario establece el precio maximo por noche {int}")
    public void elUsuarioEstableceElPrecioMaximoPorNoche(int precioMaximo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PrecioMaximo.botonFiltrar(precioMaximo)
        );
    }

    @Y("el usuario selecciona las comodidades {string}, {string} y {string}")
    public void elUsuarioSeleccionaLasComodidadesY(String servicio1, String servicio2, String servicio3) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ServiciosAlojamientoTask.serviciosAlojamientoTask(servicio1, servicio2, servicio3)
        );
    }

    @Y("el usuario visualiza la lista de alojamientos disponibles")
    public void elUsuarioVisualizaLaListaDeAlojamientosDisponibles() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ReservaAlojamientoQ.reservaAlojamientoQ(),containsStringIgnoringCase("alojamientos en Sopetrán"))
        );
    }

    @Cuando("que el usuario ve la lista de alojamientos da click en el primer resultado")
    public void queElUsuarioVeLaListaDeAlojamientosDaClickEnElPrimerResultado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ExtraerDatosTask.extraerDatosTask()
        );
    }

   @Entonces("el ve los datos del alojamiento y extrae la información en un archivo excel {string}")
    public void elVeLosDatosDelAlojamientoYExtraeLaInformaciónEnUnArchivoExcel(String datosAlojamiento) {


        Object extractedData = OnStage.theActorInTheSpotlight().recall(VariablesExtraccionDatos.DATOS_DEL_ALOJAMIENTO.name());
        System.out.println("\n\n#########################################################");
        System.out.println("DATOS RECUPERADOS ANTES DE EXCEL: " + extractedData);
        System.out.println("#########################################################\n");

        // Si extractedData es null o {}, la siguiente línea fallará la prueba.

        String rutaCompleta = "src/test/resources/data/" + datosAlojamiento;

        OnStage.theActorInTheSpotlight().attemptsTo(
                EscribirDatosExcelTask.escribirDatos(rutaCompleta)
        );
    }
}
