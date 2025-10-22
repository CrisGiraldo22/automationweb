package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ExtraccionDatosUI {
    public static final Target PRIMER_RESULTADO_BUSQUEDA = Target.the("primer resultado de la busqueda de alojamiento").located(
            By.xpath("//div//div//a[3]"));
    public static final Target TITULO_ALOJAMIENTO = Target.the("Titulo del alojamiento").located(By.xpath("//section//div//h1"));
    public static final Target CLICK_PRECIO = Target.the("Botón precio del alojamiento").located(By.xpath("(//button//span[contains(text(),'$')])[2]"));
    public static final Target PRECIO_ALOJAMIENTO = Target.the("precio del alojamiento").located(By.xpath("(//div//section//div//div//span[contains(text(),'COP')])[4]"));
    public static final Target ANFITRION = Target.the("Anfitrion del alojamiento").located(By.xpath("//div[@class='t1lpv951 atm_c8_3w7ag0 atm_g3_1emqlh9 atm_fr_helst atm_cs_1mexzig dir dir-ltr']"));
    public static final Target MENSAJE_TRADUCCION = Target.the("Anfitrion del alojamiento").located(By.xpath("(//span[@class='i12d8jnr atm_mk_h2mmj6 dir dir-ltr'])[3]"));
}
