package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ServiciosAlojamientoUI {
    public static final Target BTN_MUSTRA_MAS = Target.the("Muestra más servicios").located(By.xpath("//button//span[contains(text(),'Muestra más')]"));
    public static final Target BTN_SERVICIO = Target.the("Botón para agregar servicio").locatedBy("//button[.//span[text()='{0}']]");
    public static final Target BTN_MOSTRAR_LUGARES = Target.the("Botón para amostrar lugares").located(By.xpath("//div[@class='p1gi2ayx atm_7l_85zwdx dir dir-ltr']//a"));
    public static final Target SCROLL_IFRAME_FILTRO = Target.the("Scroll para la pantalla de filtros").located(By.xpath("//div[@class='stiimno atm_l1_1wugsn5 atm_e2_1osqo2v dir dir-ltr']"));
    public static final Target TITULO_RESULTADO_BUSQUEDA = Target.the("Titulo del resultado de la busqueda").located(By.xpath("(//span[contains(text(),'alojamientos en')])[1]"));

}
