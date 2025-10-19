package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ServiciosAlojamientoUI {
    public static final Target BTN_MUSTRA_MAS = Target.the("Muestra más servicios").located(By.xpath("//button[./span[@class='lsqfxex atm_9s_1txwivl atm_h_1h6ojuz atm_cx_i2wt44 atm_le_idpfg4__oggzyc dir dir-ltr']]"));
    public static final Target BTN_WIFI = Target.the("Botón para agregar servicio de Wifi").located(By.xpath("//button[.//span[text()='Wifi']]"));
    public static final Target BTN_COCINA = Target.the("Botón para agregar servicio de cocina").located(By.xpath("//button[.//span[text()='Cocina']]"));
    public static final Target BTN_PARRILLA = Target.the("Botón para agregar servicio de parrilla").located(By.xpath("//button[.//span[text()='Piscina']]"));
    public static final Target BTN_MOSTRAR_LUGARES = Target.the("Botón para agregar servicio de parrilla").located(By.xpath("//div[@class='p1gi2ayx atm_7l_85zwdx dir dir-ltr']//a"));
    public static final Target SCROLL_IFRAME_FILTRO = Target.the("Scroll para la pantalla de filtros").located(By.xpath("//div[@class='stiimno atm_l1_1wugsn5 atm_e2_1osqo2v dir dir-ltr']"));
    public static final Target TITULO_RESULTADO_BUSQUEDA = Target.the("Titulo del resultado de la busqueda").located(By.xpath("//span[@data-testid='stays-page-heading']"));

}
