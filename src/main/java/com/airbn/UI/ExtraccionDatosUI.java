package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ExtraccionDatosUI {
    public static final Target PRIMER_RESULTADO_BUSQUEDA = Target.the("primer resultado de la busqueda de alojamiento").located(
            By.xpath("(//div[@data-testid='card-container']//a)[1]"));
    public static final Target TITULO_ALOJAMIENTO = Target.the("Titulo del alojamiento").located(By.xpath("//div[@class='taxdin1 atm_c8_1nvkso5 atm_g3_gtd3qd atm_cs_1ho43yb atm_w4_1hnarqo atm_9s_1nu9bjl dir dir-ltr']//h1"));
    public static final Target CLICK_PRECIO = Target.the("precio del alojamiento").located(By.xpath("(//span[@class='umuerxh atm_7l_1dmvgf5 atm_cs_bs05t3 atm_rd_us8791 atm_cs_l3jtxx__1v156lz dir dir-ltr'])[2]"));
    public static final Target PRECIO_ALOJAMIENTO = Target.the("precio del alojamiento").located(By.xpath("//span[@class='p6airmr atm_vv_1q9ccgz dir dir-ltr']"));
    public static final Target ANFITRION = Target.the("Anfitrion del alojamiento").located(By.xpath("//div[@class='t1lpv951 atm_c8_3w7ag0 atm_g3_1emqlh9 atm_fr_helst atm_cs_1mexzig dir dir-ltr']"));
    public static final Target MENSAJE_TRADUCCION = Target.the("Anfitrion del alojamiento").located(By.xpath("(//span[@class='i12d8jnr atm_mk_h2mmj6 dir dir-ltr'])[3]"));
}
