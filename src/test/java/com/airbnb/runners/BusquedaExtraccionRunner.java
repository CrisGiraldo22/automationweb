package com.airbnb.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/busqueda_extraccion.feature",
        glue ="com.airbnb.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class BusquedaExtraccionRunner {
}
