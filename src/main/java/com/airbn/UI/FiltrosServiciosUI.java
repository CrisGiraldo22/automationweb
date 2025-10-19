package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FiltrosServiciosUI {
    public static Target BTN_MENSAJE_INFO= Target.the("Mensaje de información en pantalla para aceptar").located(By.xpath("//button[contains(text(),'Entendido')]"));
    public static Target FILTRO_PRECIO_MAXIMO = Target.the("Establecer precio maximo").located(By.xpath("//input[@id='price_filter_max']"));
    public static Target BTN_FILTROS = Target.the("Botón de filtros").located(By.xpath("//button[@data-testid='category-bar-filter-button']"));



}
