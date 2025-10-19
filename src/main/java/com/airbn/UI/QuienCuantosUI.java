package com.airbn.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class QuienCuantosUI {

    public static final Target BTN_QUIEN_CUANTOS = Target.the("Ingresar quien y cuantos ingresaran al alojamiento").located(By.xpath("//div[text()='¿Cuántos?']"));
    public static final Target BTN_MAS_ADULTOS = Target.the("Ingresar más cantidad de adultos").located(By.xpath("(//button[@data-testid='stepper-adults-increase-button'])[1]"));
    public static final Target BTN_MAS_NINOS = Target.the("Ingresar más cantidad de niños").located(By.xpath("(//button[@data-testid='stepper-children-increase-button'])[1]"));
    public static final Target BTN_MAS_MASCOTAS = Target.the("Ingresar más cantidad de mascotas").located(By.xpath("(//button[@data-testid='stepper-pets-increase-button'])[1]"));
    public static final Target BTN_BUSCAR = Target.the("Botón de buscar").located(By.xpath("//button[@data-testid='structured-search-input-search-button']"));

}
