package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlojamientosConFiltrosUI {
    public static Target BTN_MENSAJE_INFO= Target.the("Mensaje de información en pantalla para aceptar").located(By.xpath("//button[contains(text(),'Entendido')]"));

}
