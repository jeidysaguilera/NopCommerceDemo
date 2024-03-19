package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.PoweredByLnkPage;

public class PoweredBySteps {

    PoweredByLnkPage power;
    WebDriver driver;

    @Given("voy en la pagina de NoCommerce")
    public void entro_en_la_pagina_de_no_commerce() {
        power=new PoweredByLnkPage(driver);
        driver=power.ChromeConection();
        power.navigateToComputerPage();

    }

    @When("voy al link nopCommerce")
    public void voy_al_link_nop_commerce() {
       System.out.println("link");
        power.goToLinknoCommerce();
    }

    @Then("se abre una nueva ventana en el navegador")
    public void se_abre_una_nueva_ventana_en_el_navegador() {
        System.out.println("El titulo de la ventana es " + power.VerificarTitulo() );
        power.closeSecondsWindow();
        System.out.println("Se cierra la ventana de windows " );
    }
}
