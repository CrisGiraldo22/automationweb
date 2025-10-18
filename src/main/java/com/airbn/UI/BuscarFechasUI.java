package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarFechasUI {
    public static final Target IMPUT_DONDE = Target.the("Ingresar el destino").located(By.id("bigsearch-query-location-input"));
    public static final Target BTN_FECHAS = Target.the("Boton para ingresar las fechas {0}").locatedBy("(//button[@data-state--date-string='{0}'])[1]");}
